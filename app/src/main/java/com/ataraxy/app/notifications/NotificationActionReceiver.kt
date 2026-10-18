package com.ataraxy.app.notifications

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ataraxy.app.data.repository.QuoteRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NotificationActionReceiver : BroadcastReceiver() {

    @Inject lateinit var quoteRepository: QuoteRepository

    companion object {
        const val ACTION_BOOKMARK = "com.ataraxy.app.ACTION_BOOKMARK_QUOTE"
        const val ACTION_SNOOZE_MORNING = "com.ataraxy.app.ACTION_SNOOZE_MORNING"
        const val ACTION_SNOOZE_EVENING = "com.ataraxy.app.ACTION_SNOOZE_EVENING"
        const val EXTRA_QUOTE_ID = "extra_quote_id"
        const val EXTRA_NOTIFICATION_ID = "extra_notification_id"
    }

    override fun onReceive(context: Context, intent: Intent) {
        val notificationId = intent.getIntExtra(EXTRA_NOTIFICATION_ID, -1)

        fun dismiss() {
            if (notificationId != -1) {
                (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                    .cancel(notificationId)
            }
        }

        when (intent.action) {
            ACTION_BOOKMARK -> {
                val quoteId = intent.getStringExtra(EXTRA_QUOTE_ID) ?: return
                val pending = goAsync()
                CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
                    try {
                        quoteRepository.addBookmark(quoteId)
                    } finally {
                        pending.finish()
                    }
                }
                dismiss()
            }

            ACTION_SNOOZE_MORNING -> {
                SnoozeRitualWorker.enqueue(context, RitualType.MORNING)
                dismiss()
            }

            ACTION_SNOOZE_EVENING -> {
                SnoozeRitualWorker.enqueue(context, RitualType.EVENING)
                dismiss()
            }
        }
    }
}
