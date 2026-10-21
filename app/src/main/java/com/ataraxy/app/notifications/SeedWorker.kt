package com.ataraxy.app.notifications

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.ataraxy.app.data.seed.DatabaseSeeder
import com.ataraxy.app.widget.WidgetRefreshScheduler
import com.ataraxy.app.widget.WidgetUpdater
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class SeedWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val seeder: DatabaseSeeder,
    private val widgets: WidgetUpdater,
    private val widgetRefresh: WidgetRefreshScheduler
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        try {
            seeder.seed()
        } catch (e: Exception) {
            return Result.retry()
        }
        refreshWidgets()
        return Result.success()
    }

    /** Replaces "Open Ataraxy to begin." with today's quote and restarts a midnight chain lost to a clear-data. */
    private suspend fun refreshWidgets() {
        widgets.updateAll()
        widgetRefresh.ensureScheduled()
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
