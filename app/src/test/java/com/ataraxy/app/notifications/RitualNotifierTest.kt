package com.ataraxy.app.notifications

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.JournalRepository
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import java.time.LocalDateTime

@RunWith(RobolectricTestRunner::class)
class RitualNotifierTest {

    private lateinit var context: Context
    private lateinit var db: AtaraxyDatabase
    private lateinit var prefs: UserPrefsRepository
    private lateinit var notifier: RitualNotifier

    private val manager get() = context.getSystemService(NotificationManager::class.java)

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        db = inMemoryDatabase()
        prefs = UserPrefsRepository(context)
        runBlocking { prefs.clearAll() }
        notifier = RitualNotifier(context, prefs, JournalRepository(db.journalDao()))
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun reminder_offersBeginAndSnooze() = runBlocking {
        notifier.notifyIfDue(RitualType.EVENING)

        val notification = shadowOf(manager).getNotification(RitualType.EVENING.notificationId)
        assertEquals(listOf("Begin", "Remind in 1 hour"), notification.actions.map { it.title.toString() })
    }

    @Test
    fun reminder_isSkipped_whenRitualAlreadyCompletedToday() = runBlocking {
        val now = LocalDateTime.now().toString()
        db.journalDao().upsert(JournalEntryEntity(0, now, now, "Done", "", null, null, ritualType = "EVENING"))

        notifier.notifyIfDue(RitualType.EVENING)

        assertNull(shadowOf(manager).getNotification(RitualType.EVENING.notificationId))
    }

    @Test
    fun reminder_isSkipped_whenDisabled() = runBlocking {
        prefs.setMorningRitualEnabled(false)

        notifier.notifyIfDue(RitualType.MORNING)

        assertNull(shadowOf(manager).getNotification(RitualType.MORNING.notificationId))
    }

    @Test
    fun reminderTap_bringsBackTheRunningAppInsteadOfClearingIt() = runBlocking {
        notifier.notifyIfDue(RitualType.MORNING)

        val notification = shadowOf(manager).getNotification(RitualType.MORNING.notificationId)
        val intent = shadowOf(notification.contentIntent).savedIntent
        assertEquals("ataraxy://bookend", intent.dataString)
        assertTrue(intent.flags and Intent.FLAG_ACTIVITY_SINGLE_TOP != 0)
        assertEquals(0, intent.flags and Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }

    @Test
    fun ritualType_parsesLegacySnoozeInput() {
        assertEquals(RitualType.MORNING, RitualType.fromInput("morning"))
        assertEquals(RitualType.EVENING, RitualType.fromInput("EVENING"))
        assertNull(RitualType.fromInput("noon"))
    }
}
