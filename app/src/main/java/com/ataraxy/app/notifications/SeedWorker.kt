package com.ataraxy.app.notifications

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.ataraxy.app.data.seed.DatabaseSeeder
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class SeedWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val seeder: DatabaseSeeder
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            seeder.seed()
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

    companion object {
        private const val WORK_NAME = "seed_database"

        fun enqueue(context: Context) {
            WorkManager.getInstance(context).enqueueUniqueWork(
                WORK_NAME,
                ExistingWorkPolicy.KEEP,
                OneTimeWorkRequestBuilder<SeedWorker>().build()
            )
        }
    }
}
