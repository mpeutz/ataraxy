package com.ataraxy.app.notifications

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ListenableWorker
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.ataraxy.app.domain.model.UserPrefs
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import java.time.Duration
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.abs

private const val MINUTES_PER_DAY = 24 * 60
private const val SCHEDULE_TOLERANCE_MINUTES = 15

/** Time until [time] next occurs after [now], using real elapsed time so DST changes are honored. */
internal fun delayUntilNext(time: LocalTime, now: ZonedDateTime): Duration {
    var next = now.with(time)
    if (!next.isAfter(now)) next = now.toLocalDate().plusDays(1).atTime(time).atZone(now.zone)
    return Duration.between(now, next)
}

/**
 * Whether a run planned for [nextRunMillis] lands on [time] in [zone], within a small tolerance.
 * Only the time of day is compared, so a run that is already due today still counts as on schedule.
 */
internal fun isOnSchedule(nextRunMillis: Long, time: LocalTime, zone: ZoneId): Boolean {
    val planned = Instant.ofEpochMilli(nextRunMillis).atZone(zone).toLocalTime()
    val diff = abs(planned.toSecondOfDay() / 60 - time.toSecondOfDay() / 60)
    return minOf(diff, MINUTES_PER_DAY - diff) <= SCHEDULE_TOLERANCE_MINUTES
}

@Singleton
class NotificationScheduler @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private const val DAILY_QUOTE_WORK = "daily_quote_notification"
        private const val MORNING_RITUAL_WORK = "morning_ritual_notification"
        private const val EVENING_RITUAL_WORK = "evening_ritual_notification"
    }

    private val workManager get() = WorkManager.getInstance(context)

    /**
     * Brings scheduled work in line with [prefs] without disturbing jobs that are already on time,
     * so opening the app never cancels a notification that is about to fire.
     */
    suspend fun ensureScheduled(prefs: UserPrefs) {
        ensure(DAILY_QUOTE_WORK, DailyQuoteWorker::class.java, prefs.notificationsEnabled, prefs.notificationTime)
        ensure(MORNING_RITUAL_WORK, MorningRitualWorker::class.java, prefs.morningRitualEnabled, prefs.morningRitualTime)
        ensure(EVENING_RITUAL_WORK, EveningRitualWorker::class.java, prefs.eveningRitualEnabled, prefs.eveningRitualTime)
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

    fun cancel() = workManager.cancelUniqueWork(DAILY_QUOTE_WORK)

    fun cancelMorningRitual() = workManager.cancelUniqueWork(MORNING_RITUAL_WORK)

    fun cancelEveningRitual() = workManager.cancelUniqueWork(EVENING_RITUAL_WORK)

    fun cancelAll() {
        cancel()
        cancelMorningRitual()
        cancelEveningRitual()
    }

    private suspend fun <W : ListenableWorker> ensure(
        name: String,
        workerClass: Class<W>,
        enabled: Boolean,
        time: LocalTime
    ) {
        if (!enabled) {
            workManager.cancelUniqueWork(name)
            return
        }
        val pending = workManager.getWorkInfosForUniqueWorkFlow(name).first()
            .firstOrNull { it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING }
        if (pending != null && isOnSchedule(pending.nextScheduleTimeMillis, time, ZoneId.systemDefault())) return
        enqueuePeriodicWork(name, workerClass, time)
    }

    private fun <W : ListenableWorker> enqueuePeriodicWork(
        name: String,
        workerClass: Class<W>,
        time: LocalTime
    ) {
        val initialDelay = delayUntilNext(time, ZonedDateTime.now())

        val request = PeriodicWorkRequest.Builder(workerClass, 1, TimeUnit.DAYS)
            .setInitialDelay(initialDelay.toMillis(), TimeUnit.MILLISECONDS)
            .build()

        workManager.enqueueUniquePeriodicWork(
            name,
            ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE,
            request
        )
    }
}
