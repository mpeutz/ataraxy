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
    private val clock: Clock
) {
    suspend fun run(): BackupRunResult {
        val current = settings.settings.first()
        val target = current.targetUri ?: return BackupRunResult.DISABLED
        return try {
            val snapshot = repository.snapshot()
            val hash = BackupCodec.contentHash(snapshot)
            when {
                hash == current.lastWrittenHash -> BackupRunResult.UNCHANGED
                current.lastWrittenHash == null && !snapshot.hasPrivateData && targetHoldsPrivateData(target) -> {
                    settings.recordFailure(BackupFailure.EXISTING_BACKUP)
                    BackupRunResult.BLOCKED_EXISTING_BACKUP
                }
                else -> {
                    val now = clock.instant()
                    documents.write(target, BackupCodec.encode(snapshot, now, appVersion.code()))
                    settings.recordSuccess(now, hash)
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
        }
    }
}

@Singleton
class AutomaticBackupController @Inject constructor(
    @ApplicationContext private val context: Context,
    private val documents: BackupDocuments,
    private val settings: BackupSettingsRepository
) {
    private val workManager get() = WorkManager.getInstance(context)

    suspend fun enable(uri: String): Boolean {
        if (!documents.persist(uri)) return false
        settings.setTarget(uri)
        enqueuePeriodic()
        workManager.enqueueUniqueWork(
            RUN_NOW_WORK,
            ExistingWorkPolicy.REPLACE,
            OneTimeWorkRequestBuilder<AutoBackupWorker>().build()
        )
        return true
    }

    suspend fun disable() {
        workManager.cancelUniqueWork(PERIODIC_WORK)
        workManager.cancelUniqueWork(RUN_NOW_WORK)
        settings.settings.first().targetUri?.let(documents::release)
        settings.setTarget(null)
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

    private companion object {
        const val PERIODIC_WORK = "automatic_backup"
        const val RUN_NOW_WORK = "automatic_backup_now"
    }
}
