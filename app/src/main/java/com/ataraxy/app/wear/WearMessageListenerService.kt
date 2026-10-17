package com.ataraxy.app.wear

import com.ataraxy.app.data.local.dao.BookmarkDao
import com.ataraxy.app.data.local.entity.BookmarkEntity
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.WearableListenerService
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.time.LocalDateTime

/**
 * Receives bookmark and virtue-focus messages sent from the paired Wear OS app.
 * Uses EntryPointAccessors rather than @AndroidEntryPoint because WearableListenerService
 * is instantiated directly by the Wearable API, bypassing normal Hilt injection.
 */
class WearMessageListenerService : WearableListenerService() {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface WearListenerEntryPoint {
        fun bookmarkDao(): BookmarkDao
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    companion object {
        const val PATH_BOOKMARK = "/bookmark"
        const val PATH_VIRTUE_FOCUS = "/virtue-focus"
        const val PATH_OPEN_APP = "/open-app"
    }

    override fun onMessageReceived(messageEvent: MessageEvent) {
        when (messageEvent.path) {
            PATH_BOOKMARK -> {
                val quoteId = String(messageEvent.data)
                serviceScope.launch {
                    val entryPoint = EntryPointAccessors.fromApplication(
                        applicationContext,
                        WearListenerEntryPoint::class.java
                    )
                    entryPoint.bookmarkDao().insert(
                        BookmarkEntity(quoteId = quoteId, savedAt = LocalDateTime.now().toString())
                    )
                }
            }
            PATH_OPEN_APP -> {
                val intent = applicationContext.packageManager
                    .getLaunchIntentForPackage(applicationContext.packageName)
                    ?.apply { flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK }
                if (intent != null) applicationContext.startActivity(intent)
            }
            PATH_VIRTUE_FOCUS -> {
                // Virtue ID received for future analytics / streak tracking
                // val virtueId = String(messageEvent.data)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }
}
