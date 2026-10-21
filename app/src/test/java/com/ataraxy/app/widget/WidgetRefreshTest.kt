package com.ataraxy.app.widget

import android.appwidget.AppWidgetManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.test.core.app.ApplicationProvider
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import androidx.work.testing.SynchronousExecutor
import androidx.work.testing.TestListenableWorkerBuilder
import androidx.work.testing.WorkManagerTestInitHelper
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.concurrent.atomic.AtomicInteger

@RunWith(RobolectricTestRunner::class)
class WidgetRefreshTest {

    private val newYork = ZoneId.of("America/New_York")
    private val context: Context = ApplicationProvider.getApplicationContext()
    private lateinit var scheduler: WidgetRefreshScheduler
    private var widgetsExist = true

    @Before
    fun setUp() {
        WorkManagerTestInitHelper.initializeTestWorkManager(
            context,
            Configuration.Builder().setExecutor(SynchronousExecutor()).build()
        )
        scheduler = WidgetRefreshScheduler(context) { widgetsExist }
    }

    private fun at(date: LocalDate, time: LocalTime) = ZonedDateTime.of(date, time, newYork)

    private fun pendingWork() =
        WorkManager.getInstance(context).getWorkInfosForUniqueWork("quote_widget_midnight").get()
            .filter { it.state == WorkInfo.State.ENQUEUED }

    @Test
    fun delay_isToJustAfterNextLocalMidnight() {
        val day = LocalDate.of(2026, 10, 20)
        assertEquals(Duration.ofSeconds(90), delayUntilNextMidnight(at(day, LocalTime.of(23, 59))))
        assertEquals(Duration.ofSeconds(20), delayUntilNextMidnight(at(day, LocalTime.of(0, 0, 10))))
        assertEquals(Duration.ofHours(24), delayUntilNextMidnight(at(day, LocalTime.of(0, 0, 30))))
    }

    @Test
    fun delay_honorsDstDay() {
        val springForward = LocalDate.of(2026, 3, 8)
        val fromMidnight = delayUntilNextMidnight(at(springForward, LocalTime.of(0, 0, 30)))
        assertEquals(Duration.ofHours(23), fromMidnight)
        val fromEvening = delayUntilNextMidnight(at(springForward.minusDays(1), LocalTime.of(23, 0)))
        assertEquals(Duration.ofSeconds(3_630), fromEvening)
    }

    @Test
    fun scheduleNext_replacesPendingWork() {
        scheduler.scheduleNext()
        val first = pendingWork().single().id
        scheduler.scheduleNext()
        val second = pendingWork().single().id
        assertFalse(first == second)
    }

    @Test
    fun cancel_removesPendingWork() {
        scheduler.scheduleNext()
        scheduler.cancel()
        assertTrue(pendingWork().isEmpty())
    }

    @Test
    fun ensureScheduled_keepsPendingWork() {
        scheduler.scheduleNext()
        val first = pendingWork().single().id
        scheduler.ensureScheduled()
        assertEquals(first, pendingWork().single().id)
    }

    @Test
    fun ensureScheduled_withNothingPending_schedules() {
        scheduler.ensureScheduled()
        assertEquals(1, pendingWork().size)
    }

    @Test
    fun ensureScheduled_withoutWidgets_doesNothing() {
        widgetsExist = false
        scheduler.ensureScheduled()
        assertTrue(pendingWork().isEmpty())
    }

    @Test
    fun refresh_withoutWidgets_cancelsTheChain() {
        scheduler.scheduleNext()
        widgetsExist = false

        runBlocking { refreshAndReschedule(WidgetUpdater { }, scheduler) }

        assertTrue(pendingWork().isEmpty())
    }

    @Test
    fun timeZoneChange_withoutWidgets_schedulesNothing() {
        widgetsExist = false
        val updates = AtomicInteger()

        receive(Intent(Intent.ACTION_TIMEZONE_CHANGED), updates)

        awaitCondition { updates.get() == 1 }
        Thread.sleep(100)
        assertTrue(pendingWork().isEmpty())
    }

    @Test
    fun timeZoneChange_rerendersAndReschedules() {
        val updates = AtomicInteger()

        receive(Intent(Intent.ACTION_TIMEZONE_CHANGED), updates)

        awaitCondition { updates.get() == 1 && pendingWork().size == 1 }
    }

    @Test
    fun timeSet_rerendersAndReschedules() {
        val updates = AtomicInteger()

        receive(Intent(Intent.ACTION_TIME_CHANGED), updates)

        awaitCondition { updates.get() == 1 && pendingWork().size == 1 }
    }

    @Test
    fun unrelatedAction_doesNothing() {
        val updates = AtomicInteger()

        receive(Intent(Intent.ACTION_BOOT_COMPLETED), updates)
        Thread.sleep(300)

        assertEquals(0, updates.get())
        assertTrue(pendingWork().isEmpty())
    }

    @Test
    fun worker_withoutWidgets_succeedsWithoutScheduling() {
        widgetsExist = false
        val worker = TestListenableWorkerBuilder<MidnightWidgetWorker>(context)
            .setWorkerFactory(workerFactory(WidgetUpdater { }))
            .build()

        val result = runBlocking { worker.doWork() }

        assertEquals(ListenableWorker.Result.success(), result)
        assertTrue(pendingWork().isEmpty())
    }

    @Test
    fun manifest_declaresClockReceiverDisabled() {
        val info = context.packageManager.getReceiverInfo(clockReceiver, PackageManager.MATCH_DISABLED_COMPONENTS)
        assertFalse(info.enabled)
    }

    @Test
    fun firstWidget_enablesClockReceiverAndSchedules() {
        provider().onEnabled(context)

        assertEquals(PackageManager.COMPONENT_ENABLED_STATE_ENABLED, clockReceiverState())
        assertEquals(1, pendingWork().size)
    }

    @Test
    fun lastWidgetRemoved_disablesClockReceiverAndCancels() {
        val provider = provider()
        provider.onEnabled(context)

        provider.onDisabled(context)

        assertEquals(PackageManager.COMPONENT_ENABLED_STATE_DISABLED, clockReceiverState())
        assertTrue(pendingWork().isEmpty())
    }

    @Test
    fun widgetUpdate_ensuresTheChainIsScheduled() {
        provider().onUpdate(context, AppWidgetManager.getInstance(context), intArrayOf())

        awaitCondition { pendingWork().size == 1 }
    }

    @Test
    fun widgetUpdate_enablesClockReceiverForWidgetsPlacedBeforeAnUpgrade() {
        provider().onUpdate(context, AppWidgetManager.getInstance(context), intArrayOf())

        assertEquals(PackageManager.COMPONENT_ENABLED_STATE_ENABLED, clockReceiverState())
    }

    private val clockReceiver get() = ComponentName(context, TimeChangeReceiver::class.java)

    private fun clockReceiverState() = context.packageManager.getComponentEnabledSetting(clockReceiver)

    private fun provider() = QuoteWidgetProvider().also { it.scheduler = scheduler }

    private fun workerFactory(updater: WidgetUpdater) = object : WorkerFactory() {
        override fun createWorker(
            appContext: Context,
            workerClassName: String,
            workerParameters: WorkerParameters
        ): ListenableWorker = MidnightWidgetWorker(appContext, workerParameters, updater, scheduler)
    }

    private fun receive(intent: Intent, updates: AtomicInteger) {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) = Unit
        }
        receiver.handleClockChange(intent, WidgetUpdater { updates.incrementAndGet() }, scheduler)
    }

    private fun awaitCondition(timeoutMs: Long = 5_000, condition: () -> Boolean) {
        val deadline = System.currentTimeMillis() + timeoutMs
        while (!condition()) {
            check(System.currentTimeMillis() < deadline) { "Condition not met within ${timeoutMs}ms" }
            Thread.sleep(10)
        }
    }

    @Test
    fun failingUpdate_stillReschedules() {
        val updater = WidgetUpdater { error("boom") }

        runBlocking { refreshAndReschedule(updater, scheduler) }

        assertEquals(1, pendingWork().size)
    }

    @Test
    fun worker_updatesThenSchedulesNextAndSucceeds() {
        var updates = 0
        val updater = WidgetUpdater { updates++ }
        val worker = TestListenableWorkerBuilder<MidnightWidgetWorker>(context)
            .setWorkerFactory(workerFactory(updater))
            .build()

        val result = runBlocking { worker.doWork() }

        assertEquals(ListenableWorker.Result.success(), result)
        assertEquals(1, updates)
        assertEquals(1, pendingWork().size)
    }
}
