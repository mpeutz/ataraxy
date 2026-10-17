package com.ataraxy.app.notifications

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.work.Configuration
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.testing.SynchronousExecutor
import androidx.work.testing.WorkManagerTestInitHelper
import com.ataraxy.app.domain.model.UserPrefs
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.Duration
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.UUID

@RunWith(RobolectricTestRunner::class)
class NotificationSchedulerTest {

    private val newYork = ZoneId.of("America/New_York")
    private val seven = LocalTime.of(7, 0)

    private lateinit var context: Context
    private lateinit var scheduler: NotificationScheduler

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        WorkManagerTestInitHelper.initializeTestWorkManager(
            context,
            Configuration.Builder().setExecutor(SynchronousExecutor()).build()
        )
        scheduler = NotificationScheduler(context)
    }

    @Test
    fun ensureScheduled_keepsAlreadyScheduledWork() = runBlocking {
        val prefs = UserPrefs()
        scheduler.ensureScheduled(prefs)
        val before = dailyWorkId()

        scheduler.ensureScheduled(prefs)

        assertNotNull(before)
        assertEquals(before, dailyWorkId())
    }

    @Test
    fun ensureScheduled_reschedules_whenTimeOfDayChanged() = runBlocking {
        scheduler.ensureScheduled(UserPrefs(notificationTime = seven))
        val before = dailyWorkId()

        scheduler.ensureScheduled(UserPrefs(notificationTime = LocalTime.of(9, 30)))

        assertNotEquals(before, dailyWorkId())
    }

    @Test
    fun ensureScheduled_cancelsDisabledNotifications() = runBlocking {
        scheduler.ensureScheduled(UserPrefs())

        scheduler.ensureScheduled(UserPrefs(notificationsEnabled = false))

        assertNull(dailyWorkId())
    }

    @Test
    fun delayUntilNext_isExactToTheSecond() {
        val now = ZonedDateTime.of(2026, 10, 17, 6, 59, 30, 0, newYork)

        assertEquals(Duration.ofSeconds(30), delayUntilNext(seven, now))
    }

    @Test
    fun delayUntilNext_rollsToTomorrow_atTheExactTime() {
        val now = ZonedDateTime.of(2026, 10, 17, 7, 0, 0, 0, newYork)

        assertEquals(Duration.ofHours(24), delayUntilNext(seven, now))
    }

    @Test
    fun delayUntilNext_accountsForSpringForward() {
        val nightBeforeDstStarts = ZonedDateTime.of(2026, 3, 7, 22, 0, 0, 0, newYork)

        assertEquals(Duration.ofHours(8), delayUntilNext(seven, nightBeforeDstStarts))
    }

    @Test
    fun isOnSchedule_acceptsOverdueRunAtTheChosenTime() {
        val overdueThisMorning = ZonedDateTime.of(2026, 10, 17, 7, 0, 0, 0, newYork)

        assertTrue(isOnSchedule(overdueThisMorning.toInstant().toEpochMilli(), seven, newYork))
    }

    @Test
    fun isOnSchedule_rejectsRunDriftedByDst() {
        val driftedHour = ZonedDateTime.of(2026, 11, 2, 8, 0, 0, 0, newYork)

        assertFalse(isOnSchedule(driftedHour.toInstant().toEpochMilli(), seven, newYork))
    }

    @Test
    fun isOnSchedule_toleratesSmallDifferencesAcrossMidnight() {
        val justAfterMidnight = ZonedDateTime.of(2026, 10, 18, 0, 5, 0, 0, newYork)

        assertTrue(isOnSchedule(justAfterMidnight.toInstant().toEpochMilli(), LocalTime.of(23, 55), newYork))
    }

    private fun dailyWorkId(): UUID? =
        WorkManager.getInstance(context)
            .getWorkInfosForUniqueWork("daily_quote_notification").get()
            .singleOrNull { it.state == WorkInfo.State.ENQUEUED }?.id
}
