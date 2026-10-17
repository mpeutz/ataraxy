package com.ataraxy.wear.data

import android.content.Context
import androidx.wear.tiles.TileService
import com.ataraxy.wear.tile.DailyQuoteTileService
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataEventBuffer
import com.google.android.gms.wearable.DataMapItem
import com.google.android.gms.wearable.WearableListenerService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * Listens for DATA_CHANGED events on the /daily-quote path pushed by the phone app.
 * Persists the quote to WearQuoteStore and triggers a tile refresh.
 *
 * Uses EntryPointAccessors instead of @AndroidEntryPoint because WearableListenerService
 * is instantiated by the Wearable API, not by the normal Android lifecycle.
 */
class WearDataListenerService : WearableListenerService() {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface WearDataEntryPoint {
        fun wearQuoteStore(): WearQuoteStore
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun onDataChanged(dataEvents: DataEventBuffer) {
        val entryPoint = EntryPointAccessors.fromApplication(
            applicationContext,
            WearDataEntryPoint::class.java
        )
        val store = entryPoint.wearQuoteStore()

        dataEvents.forEach { event ->
            if (event.type == DataEvent.TYPE_CHANGED &&
                event.dataItem.uri.path == "/daily-quote"
            ) {
                val dataMap = DataMapItem.fromDataItem(event.dataItem).dataMap
                val quoteText = dataMap.getString("quoteText") ?: return@forEach
                val authorName = dataMap.getString("authorName") ?: return@forEach
                val quoteId = dataMap.getString("quoteId") ?: return@forEach

                serviceScope.launch {
                    store.save(id = quoteId, text = quoteText, authorName = authorName)
                    requestTileRefresh(applicationContext)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    private fun requestTileRefresh(context: Context) {
        // Fire-and-forget: request a tile update; ListenableFuture result is not critical
        TileService.getUpdater(context)
            .requestUpdate(DailyQuoteTileService::class.java)
    }
}
