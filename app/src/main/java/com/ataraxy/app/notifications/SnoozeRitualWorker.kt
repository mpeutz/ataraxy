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
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.ataraxy.app.MainActivity
import com.ataraxy.app.R
import com.ataraxy.app.data.preferences.UserPrefsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.firstOrNull
import java.util.concurrent.TimeUnit

@HiltWorker
class SnoozeRitualWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted params: WorkerParameters,
    private val userPrefsRepository: UserPrefsRepository
) : CoroutineWorker(context, params) {

    companion object {
        private const val INPUT_TYPE = "ritual_type"

        fun enqueue(context: Context, type: String, delayMinutes: Long) {
            val data = Data.Builder().putString(INPUT_TYPE, type).build()
            val request = OneTimeWorkRequestBuilder<SnoozeRitualWorker>()
                .setInputData(data)
                .setInitialDelay(delayMinutes, TimeUnit.MINUTES)
                .build()
            WorkManager.getInstance(context).enqueue(request)
        }
    }

    override suspend fun doWork(): Result {
        val type = inputData.getString(INPUT_TYPE) ?: return Result.success()
        val prefs = userPrefsRepository.userPrefs.firstOrNull() ?: return Result.success()

        val isMorning = type == "morning"
        if (isMorning && !prefs.morningRitualEnabled) return Result.success()
        if (!isMorning && !prefs.eveningRitualEnabled) return Result.success()

        val channelId = MorningRitualWorker.CHANNEL_ID   // both share the same channel
        val notifId = if (isMorning) MorningRitualWorker.NOTIFICATION_ID else EveningRitualWorker.NOTIFICATION_ID
        val title = if (isMorning) "Morning Ritual" else "Evening Ritual"
        val body = if (isMorning)
            "Begin with intention. Your morning practice awaits."
        else
            "Reflect before rest. Your evening practice awaits."
        val snoozeMins = if (isMorning) 30 else 60

        ensureChannelExists(channelId)

        val contentIntent = PendingIntent.getActivity(
            context, notifId,
            Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                data = Uri.parse("ataraxy://bookend")
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val snoozeAction = buildSnoozeAction(context, type, snoozeMins, notifId)

        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(body)
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(snoozeAction)
            .build()

        (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
            .notify(notifId, notification)

        return Result.success()
    }

    private fun ensureChannelExists(channelId: String) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (manager.getNotificationChannel(channelId) == null) {
            val channel = NotificationChannel(
                channelId,
                context.getString(R.string.ritual_channel_name),
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = context.getString(R.string.ritual_channel_description)
            }
            manager.createNotificationChannel(channel)
        }
    }

    private fun buildSnoozeAction(
        context: Context,
        type: String,
        snoozeMins: Int,
        notifId: Int
    ): NotificationCompat.Action {
        val action = if (type == "morning")
            NotificationActionReceiver.ACTION_SNOOZE_MORNING
        else
            NotificationActionReceiver.ACTION_SNOOZE_EVENING

        val snoozeIntent = PendingIntent.getBroadcast(
            context, notifId + 100,
            Intent(action).apply {
                setClass(context, NotificationActionReceiver::class.java)
                putExtra(NotificationActionReceiver.EXTRA_NOTIFICATION_ID, notifId)
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        return NotificationCompat.Action(0, "Remind in $snoozeMins min", snoozeIntent)
    }
}
