package com.ataraxy.app.notifications

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ListenableWorker
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.ataraxy.app.domain.model.UserPrefs
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationScheduler @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private const val DAILY_QUOTE_WORK = "daily_quote_notification"
        private const val MORNING_RITUAL_WORK = "morning_ritual_notification"
        private const val EVENING_RITUAL_WORK = "evening_ritual_notification"
        private val DEFAULT_DAILY_TIME = LocalTime.of(7, 0)
        private val DEFAULT_MORNING_TIME = LocalTime.of(7, 0)
        private val DEFAULT_EVENING_TIME = LocalTime.of(21, 0)
    }

    fun scheduleDefault() {
        schedule(DEFAULT_DAILY_TIME)
        scheduleMorningRitual(DEFAULT_MORNING_TIME)
        scheduleEveningRitual(DEFAULT_EVENING_TIME)
    }

    fun scheduleAll(prefs: UserPrefs) {
        if (prefs.notificationsEnabled) schedule(prefs.notificationTime) else cancel()
        if (prefs.morningRitualEnabled) scheduleMorningRitual(prefs.morningRitualTime) else cancelMorningRitual()
        if (prefs.eveningRitualEnabled) scheduleEveningRitual(prefs.eveningRitualTime) else cancelEveningRitual()
    }

    fun schedule(time: LocalTime) {
        enqueuePeriodicWork(DAILY_QUOTE_WORK, DailyQuoteWorker::class.java, time)
    }

    fun scheduleMorningRitual(time: LocalTime) {
        enqueuePeriodicWork(MORNING_RITUAL_WORK, MorningRitualWorker::class.java, time)
    }

    fun scheduleEveningRitual(time: LocalTime) {
        enqueuePeriodicWork(EVENING_RITUAL_WORK, EveningRitualWorker::class.java, time)
    }

    fun cancel() = WorkManager.getInstance(context).cancelUniqueWork(DAILY_QUOTE_WORK)

    fun cancelMorningRitual() = WorkManager.getInstance(context).cancelUniqueWork(MORNING_RITUAL_WORK)

    fun cancelEveningRitual() = WorkManager.getInstance(context).cancelUniqueWork(EVENING_RITUAL_WORK)

    fun cancelAll() {
        cancel()
        cancelMorningRitual()
        cancelEveningRitual()
    }

    private fun <W : ListenableWorker> enqueuePeriodicWork(
        name: String,
        workerClass: Class<W>,
        time: LocalTime
    ) {
        val now = LocalDateTime.now()
        var next = now.toLocalDate().atTime(time)
        if (!next.isAfter(now)) next = next.plusDays(1)

        val initialDelay = java.time.Duration.between(now, next).toMinutes()

        val request = PeriodicWorkRequest.Builder(workerClass, 1, TimeUnit.DAYS)
            .setInitialDelay(initialDelay, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            name,
            ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE,
            request
        )
    }
}

