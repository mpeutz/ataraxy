package com.ataraxy.app.data.backup

import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.domain.model.UserPrefs
import com.ataraxy.app.notifications.NotificationScheduler
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import java.io.IOException
import java.time.Instant
import javax.inject.Inject

data class BackupPreview(
    val createdAt: Instant,
    val journalEntryCount: Int,
    val reflectionCount: Int
)

enum class RestoreProblem { NOT_A_BACKUP, NEWER_VERSION, NO_ACCESS }

class RestoreException(val problem: RestoreProblem) : Exception("Cannot restore: $problem")

fun interface Rescheduler {
    suspend fun reschedule(prefs: UserPrefs)
}

class NotificationRescheduler @Inject constructor(
    private val scheduler: NotificationScheduler
) : Rescheduler {
    override suspend fun reschedule(prefs: UserPrefs) = scheduler.ensureScheduled(prefs)
}

class RestoreBackup @Inject constructor(
    private val documents: BackupDocuments,
    private val repository: BackupRepository,
    private val userPrefs: UserPrefsRepository,
    private val rescheduler: Rescheduler,
    private val lock: BackupLock
) {

    suspend fun preview(uri: String): Result<BackupPreview> = load(uri).map { file ->
        BackupPreview(
            createdAt = file.createdAt,
            journalEntryCount = file.snapshot.journalEntries.size,
            reflectionCount = file.snapshot.reflections.size
        )
    }

    suspend fun restore(uri: String): Result<Unit> = lock.withLock { restoreLocked(uri) }

    private suspend fun restoreLocked(uri: String): Result<Unit> {
        val file = load(uri).getOrElse { return Result.failure(it) }
        return try {
            repository.replaceAll(file.snapshot)
            rescheduler.reschedule(userPrefs.userPrefs.first())
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private suspend fun load(uri: String): Result<BackupFile> {
        val text = try {
            documents.read(uri)
        } catch (e: CancellationException) {
            throw e
        } catch (e: BackupTooLargeException) {
            return failure(RestoreProblem.NOT_A_BACKUP)
        } catch (e: SecurityException) {
            return failure(RestoreProblem.NO_ACCESS)
        } catch (e: IOException) {
            return failure(RestoreProblem.NO_ACCESS)
        }
        return try {
            Result.success(withContext(Dispatchers.Default) { BackupCodec.decode(text) })
        } catch (e: BackupFormatException) {
            failure(
                when (e.reason) {
                    BackupFormatException.Reason.NEWER_VERSION -> RestoreProblem.NEWER_VERSION
                    BackupFormatException.Reason.NOT_A_BACKUP -> RestoreProblem.NOT_A_BACKUP
                }
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            failure(RestoreProblem.NOT_A_BACKUP)
        } catch (e: StackOverflowError) {
            failure(RestoreProblem.NOT_A_BACKUP)
        }
    }

    private fun failure(problem: RestoreProblem): Result<BackupFile> =
        Result.failure(RestoreException(problem))
}
