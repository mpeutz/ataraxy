package com.ataraxy.app.wear

import android.content.Context
import com.ataraxy.app.domain.model.Quote
import com.google.android.gms.wearable.PutDataMapRequest
import com.google.android.gms.wearable.Wearable
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WearSyncManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        const val PATH_DAILY_QUOTE = "/daily-quote"
        const val KEY_QUOTE_TEXT = "quoteText"
        const val KEY_AUTHOR_NAME = "authorName"
        const val KEY_QUOTE_ID = "quoteId"
    }

    suspend fun syncDailyQuote(quote: Quote) {
        try {
            val request = PutDataMapRequest.create(PATH_DAILY_QUOTE).apply {
                dataMap.putString(KEY_QUOTE_TEXT, quote.text)
                dataMap.putString(KEY_AUTHOR_NAME, quote.authorName)
                dataMap.putString(KEY_QUOTE_ID, quote.id)
            }.asPutDataRequest().setUrgent()
            Wearable.getDataClient(context).putDataItem(request).await()
        } catch (_: Exception) {
            // Wearable unavailable or not paired — fail silently, notification was already posted
        }
    }
}
