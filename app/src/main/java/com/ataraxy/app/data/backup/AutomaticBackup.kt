package com.ataraxy.app.data.backup

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.first
import java.io.FileNotFoundException
import java.io.IOException
import java.time.Clock
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

fun interface AppVersion {
    fun code(): Long
}

enum class BackupRunResult { DISABLED, UNCHANGED, WRITTEN, BLOCKED_EXISTING_BACKUP, FAILED }

class AutomaticBackup @Inject constructor(
    private val repository: BackupRepository,
    private val documents: BackupDocuments,
    private val settings: BackupSettingsRepository,
    private val appVersion: AppVersion,
    private val clock: Clock,
    private val lock: BackupLock
) {
    suspend fun run(): BackupRunResult = lock.withLock {
        val current = settings.settings.first()
        val target = current.targetUri ?: return@withLock BackupRunResult.DISABLED
        if (current.blockedTarget == target) return@withLock BackupRunResult.BLOCKED_EXISTING_BACKUP
        try {
            val snapshot = repository.snapshot()
            val hash = BackupCodec.contentHash(snapshot)
            when {
                hash == current.lastWrittenHash -> BackupRunResult.UNCHANGED
                current.overwriteConsent != target && current.lastWrittenHash == null && !snapshot.hasPrivateData &&
                    targetHoldsPrivateData(target) -> {
                    settings.recordBlocked(target)
                    BackupRunResult.BLOCKED_EXISTING_BACKUP
                }
                else -> {
                    val now = clock.instant()
                    documents.write(target, BackupCodec.encode(snapshot, now, appVersion.code()))
                    settings.recordSuccess(target, now, hash)
                    BackupRunResult.WRITTEN
                }
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: SecurityException) {
            fail(BackupFailure.NO_ACCESS)
        } catch (e: FileNotFoundException) {
            fail(BackupFailure.NO_ACCESS)
        } catch (e: Exception) {
            fail(BackupFailure.UNKNOWN)
        }
    }

    private suspend fun fail(failure: BackupFailure): BackupRunResult {
        settings.recordFailure(failure)
        return BackupRunResult.FAILED
    }

    /** An empty or non-backup file counts as no data; any other read failure ends the run. */
    private suspend fun targetHoldsPrivateData(target: String): Boolean {
        val text = documents.read(target)
        if (text.isBlank()) return false
        return try {
            BackupCodec.decode(text).snapshot.hasPrivateData
        } catch (e: BackupFormatException) {
            false
        } catch (e: StackOverflowError) {
            throw IOException("Backup file is nested too deeply", e)
        }
    }
}

@Singleton
class AutomaticBackupController @Inject constructor(
    @ApplicationContext private val context: Context,
    private val documents: BackupDocuments,
    private val settings: BackupSettingsRepository,
    private val lock: BackupLock
) {
    private val workManager get() = WorkManager.getInstance(context)

    suspend fun enable(uri: String): Boolean {
        val enabled = lock.withLock {
            if (!documents.persist(uri)) return@withLock false
            val previous = settings.settings.first().targetUri
            if (previous != null && previous != uri) documents.release(previous)
            settings.setTarget(uri)
            true
        }
        if (!enabled) return false
        enqueuePeriodic()
        runNow()
        return true
    }

    suspend fun disable() {
        workManager.cancelUniqueWork(PERIODIC_WORK)
        workManager.cancelUniqueWork(RUN_NOW_WORK)
        lock.withLock {
            settings.settings.first().targetUri?.let(documents::release)
            settings.setTarget(null)
        }
    }

    /** The user chose to overwrite the backup automatic backup refused to replace. */
    suspend fun replaceBlockedBackup() {
        val replaced = lock.withLock {
            val current = settings.settings.first()
            val target = current.targetUri
            if (target == null || current.failure != BackupFailure.EXISTING_BACKUP) return@withLock false
            settings.grantOverwrite(target)
            settings.clearBlock()
            true
        }
        if (replaced) runNow()
    }

    suspend fun ensureScheduled() {
        if (settings.settings.first().targetUri == null) return
        enqueuePeriodic()
    }

    private fun enqueuePeriodic() {
        workManager.enqueueUniquePeriodicWork(
            PERIODIC_WORK,
            ExistingPeriodicWorkPolicy.KEEP,
            PeriodicWorkRequestBuilder<AutoBackupWorker>(1, TimeUnit.DAYS).build()
        )
    }

    private fun runNow() {
        workManager.enqueueUniqueWork(
            RUN_NOW_WORK,
            ExistingWorkPolicy.REPLACE,
            OneTimeWorkRequestBuilder<AutoBackupWorker>().build()
        )
    }

    private companion object {
        const val PERIODIC_WORK = "automatic_backup"
        const val RUN_NOW_WORK = "automatic_backup_now"
    }
}
