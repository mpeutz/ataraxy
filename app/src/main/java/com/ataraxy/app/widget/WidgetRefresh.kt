package com.ataraxy.app.widget

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.ataraxy.app.notifications.delayUntilNext
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalTime
import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

private const val WORK_NAME = "quote_widget_midnight"
private const val LOG_TAG = "QuoteWidget"
private val JUST_AFTER_MIDNIGHT = LocalTime.of(0, 0, 30)

/** Time until the next local 00:00:30 after [now], in real elapsed time so DST days are honored. */
internal fun delayUntilNextMidnight(now: ZonedDateTime): Duration = delayUntilNext(JUST_AFTER_MIDNIGHT, now)

@Singleton
class WidgetRefreshScheduler internal constructor(
    private val context: Context,
    private val hasWidgets: () -> Boolean
) {
    @Inject constructor(@ApplicationContext context: Context) : this(context, { quoteWidgetIds(context).isNotEmpty() })

    fun scheduleNext() = enqueue(ExistingWorkPolicy.REPLACE)

    /** Restarts a chain lost to a first launch or a clear-data, without moving one already pending. */
    fun ensureScheduled() {
        if (hasWidgets()) enqueue(ExistingWorkPolicy.KEEP)
    }

    /** Arms the next midnight run while widgets exist, and ends the chain once none are left. */
    fun scheduleNextOrCancel() {
        if (hasWidgets()) scheduleNext() else cancel()
    }

    fun cancel() {
        WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
    }

    private fun enqueue(policy: ExistingWorkPolicy) {
        val request = OneTimeWorkRequestBuilder<MidnightWidgetWorker>()
            .setInitialDelay(delayUntilNextMidnight(ZonedDateTime.now()).toMillis(), TimeUnit.MILLISECONDS)
            .build()
        WorkManager.getInstance(context).enqueueUniqueWork(WORK_NAME, policy, request)
    }
}

@HiltWorker
class MidnightWidgetWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val updater: WidgetUpdater,
    private val scheduler: WidgetRefreshScheduler
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        refreshAndReschedule(updater, scheduler)
        return Result.success()
    }
}

/** Reschedules even when the update fails or times out, so the daily chain never breaks while widgets exist. */
internal suspend fun refreshAndReschedule(updater: WidgetUpdater, scheduler: WidgetRefreshScheduler) {
    try {
        withUpdateTimeout { updater.updateAll() }
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Log.w(LOG_TAG, "Could not refresh widgets", e)
    } finally {
        scheduler.scheduleNextOrCancel()
    }
}

/** The clock receiver is off in the manifest and runs only while at least one widget is placed. */
internal fun setClockReceiverEnabled(context: Context, enabled: Boolean) {
    val receiver = ComponentName(context, TimeChangeReceiver::class.java)
    val state = if (enabled) PackageManager.COMPONENT_ENABLED_STATE_ENABLED else PackageManager.COMPONENT_ENABLED_STATE_DISABLED
    if (context.packageManager.getComponentEnabledSetting(receiver) == state) return
    context.packageManager.setComponentEnabledSetting(receiver, state, PackageManager.DONT_KILL_APP)
}

internal fun isClockChange(action: String?): Boolean =
    action == Intent.ACTION_TIME_CHANGED || action == Intent.ACTION_TIMEZONE_CHANGED

@AndroidEntryPoint
class TimeChangeReceiver : BroadcastReceiver() {

    @Inject lateinit var updater: WidgetUpdater
    @Inject lateinit var scheduler: WidgetRefreshScheduler

    override fun onReceive(context: Context, intent: Intent) {
        handleClockChange(intent, updater, scheduler)
    }
}

internal fun BroadcastReceiver.handleClockChange(
    intent: Intent,
    updater: WidgetUpdater,
    scheduler: WidgetRefreshScheduler
) {
    if (!isClockChange(intent.action)) return
    launchBounded { refreshAndReschedule(updater, scheduler) }
}

/** Runs [block] off the main thread under the broadcast's time budget, then releases the broadcast. */
internal fun BroadcastReceiver.launchBounded(block: suspend () -> Unit) {
    val pending = goAsync()
    CoroutineScope(SupervisorJob() + Dispatchers.Default).launch {
        try {
            withUpdateTimeout(block = block)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.w(LOG_TAG, "Widget broadcast failed", e)
        } finally {
            pending?.finish()
        }
    }
}
