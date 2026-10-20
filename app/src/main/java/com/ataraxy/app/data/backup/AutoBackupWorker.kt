package com.ataraxy.app.data.backup

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class AutoBackupWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val automaticBackup: AutomaticBackup
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        automaticBackup.run(overwriteExisting = inputData.getBoolean(OVERWRITE_EXISTING, false))
        return Result.success()
    }

    companion object {
        const val OVERWRITE_EXISTING = "overwrite_existing"
    }
}
