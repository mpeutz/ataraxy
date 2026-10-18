package com.ataraxy.app.notifications

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class EveningRitualWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val ritualNotifier: RitualNotifier
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        ritualNotifier.notifyIfDue(RitualType.EVENING)
        return Result.success()
    }
}
