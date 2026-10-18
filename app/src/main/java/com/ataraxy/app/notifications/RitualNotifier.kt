package com.ataraxy.app.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import com.ataraxy.app.R
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.JournalRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject
import javax.inject.Singleton

/** Posts morning and evening ritual reminders for the scheduled and snoozed workers. */
@Singleton
class RitualNotifier @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userPrefsRepository: UserPrefsRepository,
    private val journalRepository: JournalRepository
) {
    companion object {
        private const val CHANNEL_ID = "ataraxy_rituals"
        private const val SNOOZE_REQUEST_OFFSET = 100
    }

    /** Posts the reminder unless the ritual is disabled or already done today. */
    suspend fun notifyIfDue(type: RitualType) {
        val prefs = userPrefsRepository.userPrefs.firstOrNull() ?: return
        if (!type.isEnabled(prefs)) return
        if (journalRepository.hasCompletedRitualToday(type.name)) return

        val manager = context.getSystemService(NotificationManager::class.java)
        ensureChannelExists(manager)
        manager.notify(type.notificationId, buildNotification(type))
    }

    private fun buildNotification(type: RitualType): Notification {
        val beginIntent = PendingIntent.getActivity(
            context, type.notificationId,
            openAppIntent(context, "ataraxy://bookend".toUri()),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val snoozeIntent = PendingIntent.getBroadcast(
            context, type.notificationId + SNOOZE_REQUEST_OFFSET,
            Intent(type.snoozeAction).apply {
                setClass(context, NotificationActionReceiver::class.java)
                putExtra(NotificationActionReceiver.EXTRA_NOTIFICATION_ID, type.notificationId)
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        return NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(context.getString(type.title))
            .setContentText(context.getString(type.body))
            .setContentIntent(beginIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(0, context.getString(R.string.ritual_begin), beginIntent)
            .addAction(0, context.getString(type.snoozeLabel), snoozeIntent)
            .build()
    }

    private fun ensureChannelExists(manager: NotificationManager) {
        if (manager.getNotificationChannel(CHANNEL_ID) != null) return
        val channel = NotificationChannel(
            CHANNEL_ID,
            context.getString(R.string.ritual_channel_name),
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = context.getString(R.string.ritual_channel_description)
        }
        manager.createNotificationChannel(channel)
    }
}
