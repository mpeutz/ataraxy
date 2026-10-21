package com.ataraxy.app.data.backup

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.work.Configuration
import androidx.work.WorkManager
import androidx.work.testing.SynchronousExecutor
import androidx.work.testing.WorkManagerTestInitHelper
import com.ataraxy.app.domain.model.UserPrefs
import com.ataraxy.app.notifications.NotificationScheduler
import com.ataraxy.app.widget.WidgetUpdater
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class NotificationReschedulerTest {

    @Test
    fun reschedule_ensuresNotificationsThenUpdatesWidgets() = runBlocking {
        val context = ApplicationProvider.getApplicationContext<Context>()
        WorkManagerTestInitHelper.initializeTestWorkManager(
            context,
            Configuration.Builder().setExecutor(SynchronousExecutor()).build()
        )
        val events = mutableListOf<String>()
        val updater = WidgetUpdater {
            val scheduled = WorkManager.getInstance(context)
                .getWorkInfosForUniqueWork("daily_quote_notification").get().size
            events += "widgets after $scheduled scheduled"
        }

        NotificationRescheduler(NotificationScheduler(context), updater).reschedule(UserPrefs())

        assertEquals(listOf("widgets after 1 scheduled"), events)
    }
}
