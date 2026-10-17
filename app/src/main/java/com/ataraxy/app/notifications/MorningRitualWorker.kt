package com.ataraxy.app.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ataraxy.app.MainActivity
import com.ataraxy.app.R
import com.ataraxy.app.data.preferences.UserPrefsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.firstOrNull

@HiltWorker
class MorningRitualWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted params: WorkerParameters,
    private val userPrefsRepository: UserPrefsRepository
) : CoroutineWorker(context, params) {

    companion object {
        const val CHANNEL_ID = "ataraxy_rituals"
        const val NOTIFICATION_ID = 1002
    }

    override suspend fun doWork(): Result {
        val prefs = userPrefsRepository.userPrefs.firstOrNull() ?: return Result.success()
        if (!prefs.morningRitualEnabled) return Result.success()

        ensureChannelExists()

        val contentIntent = PendingIntent.getActivity(
            context, NOTIFICATION_ID,
            Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                data = Uri.parse("ataraxy://bookend")
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val snoozeIntent = PendingIntent.getBroadcast(
            context, NOTIFICATION_ID + 100,
            Intent(NotificationActionReceiver.ACTION_SNOOZE_MORNING).apply {
                setClass(context, NotificationActionReceiver::class.java)
                putExtra(NotificationActionReceiver.EXTRA_NOTIFICATION_ID, NOTIFICATION_ID)
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Morning Ritual")
            .setContentText("Begin with intention. Your morning practice awaits.")
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(0, "Begin", contentIntent)
            .addAction(0, "Remind in 30 min", snoozeIntent)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)

        return Result.success()
    }

    private fun ensureChannelExists() {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (manager.getNotificationChannel(CHANNEL_ID) == null) {
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
}

