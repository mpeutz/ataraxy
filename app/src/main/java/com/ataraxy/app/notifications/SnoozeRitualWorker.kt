package com.ataraxy.app.notifications

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.util.concurrent.TimeUnit

@HiltWorker
class SnoozeRitualWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val ritualNotifier: RitualNotifier
) : CoroutineWorker(context, params) {

    companion object {
        private const val INPUT_TYPE = "ritual_type"

        fun enqueue(context: Context, type: RitualType) {
            val data = Data.Builder().putString(INPUT_TYPE, type.name).build()
            val request = OneTimeWorkRequestBuilder<SnoozeRitualWorker>()
                .setInputData(data)
                .setInitialDelay(type.snoozeMinutes, TimeUnit.MINUTES)
                .build()
            WorkManager.getInstance(context).enqueue(request)
        }
    }

    override suspend fun doWork(): Result {
        val type = RitualType.fromInput(inputData.getString(INPUT_TYPE)) ?: return Result.success()
        ritualNotifier.notifyIfDue(type)
        return Result.success()
    }
}
