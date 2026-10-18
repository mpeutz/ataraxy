package com.ataraxy.app.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ataraxy.app.R
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.NotificationStyle
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.firstOrNull
import java.time.LocalTime

/** Titles the daily quote for the part of the day it is scheduled in. */
@StringRes
internal fun contemplationTitle(time: LocalTime): Int = when (time.hour) {
    in 5..11 -> R.string.notification_title_morning
    in 12..16 -> R.string.notification_title_afternoon
    else -> R.string.notification_title_evening
}

@HiltWorker
class DailyQuoteWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted params: WorkerParameters,
    private val quoteRepository: QuoteRepository,
    private val userPrefsRepository: UserPrefsRepository
) : CoroutineWorker(context, params) {

    companion object {
        const val CHANNEL_ID = "ataraxy_daily"
        const val NOTIFICATION_ID = 1001
    }

    override suspend fun doWork(): Result {
        val prefs = userPrefsRepository.userPrefs.firstOrNull() ?: return Result.success()
        if (!prefs.notificationsEnabled) return Result.success()

        ensureChannelExists()

        val quote = quoteRepository.getDailyQuote().firstOrNull() ?: return Result.success()

        val contentText = when (prefs.notificationStyle) {
            NotificationStyle.MINIMALIST -> {
                val truncated = if (quote.text.length > 80) quote.text.take(80) + "…" else quote.text
                "\"$truncated\""
            }
            NotificationStyle.DIRECT_ADDRESS -> {
                val firstLine = quote.text.lines().firstOrNull() ?: quote.text
                "${quote.authorName}: \"$firstLine\""
            }
        }

        val intent = openAppIntent(context, "ataraxy://practice/${quote.id}".toUri())
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Bookmark action — silently saves to bookmarks via BroadcastReceiver
        val bookmarkIntent = PendingIntent.getBroadcast(
            context, NOTIFICATION_ID + 1,
            Intent(NotificationActionReceiver.ACTION_BOOKMARK).apply {
                setClass(context, NotificationActionReceiver::class.java)
                putExtra(NotificationActionReceiver.EXTRA_QUOTE_ID, quote.id)
                putExtra(NotificationActionReceiver.EXTRA_NOTIFICATION_ID, NOTIFICATION_ID)
            },
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Reflect action — opens the practice screen for this quote
        val reflectIntent = PendingIntent.getActivity(
            context, NOTIFICATION_ID + 2,
            openAppIntent(context, "ataraxy://practice/${quote.id}".toUri()),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(context.getString(contemplationTitle(prefs.notificationTime)))
            .setContentText(contentText)
            .setStyle(NotificationCompat.BigTextStyle().bigText(contentText))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(0, context.getString(R.string.bookmark), bookmarkIntent)
            .addAction(0, context.getString(R.string.notification_action_reflect), reflectIntent)
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
                context.getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = context.getString(R.string.notification_channel_description)
            }
            manager.createNotificationChannel(channel)
        }
    }
}
