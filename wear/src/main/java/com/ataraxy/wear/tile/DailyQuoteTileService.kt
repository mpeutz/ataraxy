package com.ataraxy.wear.tile

import android.content.ComponentName
import android.content.Context
import androidx.wear.protolayout.ActionBuilders
import androidx.wear.protolayout.ColorBuilders.argb
import androidx.wear.protolayout.DimensionBuilders.dp
import androidx.wear.protolayout.DimensionBuilders.sp
import androidx.wear.protolayout.LayoutElementBuilders.Box
import androidx.wear.protolayout.LayoutElementBuilders.Column
import androidx.wear.protolayout.LayoutElementBuilders.FontStyle
import androidx.wear.protolayout.LayoutElementBuilders.LayoutElement
import androidx.wear.protolayout.LayoutElementBuilders.Spacer
import androidx.wear.protolayout.LayoutElementBuilders.Text
import androidx.wear.protolayout.ModifiersBuilders.Background
import androidx.wear.protolayout.ModifiersBuilders.Clickable
import androidx.wear.protolayout.ModifiersBuilders.Modifiers
import androidx.wear.protolayout.ModifiersBuilders.Padding
import androidx.wear.protolayout.ResourceBuilders
import androidx.wear.protolayout.TimelineBuilders
import androidx.wear.tiles.RequestBuilders
import androidx.wear.tiles.TileBuilders
import androidx.wear.tiles.TileService
import com.ataraxy.wear.WearMainActivity
import com.ataraxy.wear.data.WearQuoteStore
import com.ataraxy.wear.domain.ReceivedQuote
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

/**
 * Wear OS Tile that displays the daily Stoic quote (first 60 chars) and author.
 * Tapping the tile opens WearMainActivity.
 * Refreshed automatically by WearDataListenerService when a new quote arrives from the phone.
 */
class DailyQuoteTileService : TileService() {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface TileEntryPoint {
        fun wearQuoteStore(): WearQuoteStore
    }

    companion object {
        private const val RESOURCES_VERSION = "1"
        private const val STONE_COLOR = 0xFF1C1A17.toInt()
        private const val CREAM_COLOR = 0xFFF5F0E8.toInt()
        private const val CREAM_MUTED_COLOR = 0xFFCBC4B3.toInt()
    }

    override fun onTileRequest(
        requestParams: RequestBuilders.TileRequest
    ): ListenableFuture<TileBuilders.Tile> {
        val quote = runBlocking {
            EntryPointAccessors.fromApplication(applicationContext, TileEntryPoint::class.java)
                .wearQuoteStore()
                .quote
                .firstOrNull()
        }
        return Futures.immediateFuture(buildTile(applicationContext, quote))
    }

    override fun onTileResourcesRequest(
        requestParams: RequestBuilders.ResourcesRequest
    ): ListenableFuture<ResourceBuilders.Resources> =
        Futures.immediateFuture(
            ResourceBuilders.Resources.Builder()
                .setVersion(RESOURCES_VERSION)
                .build()
        )

    private fun buildTile(context: Context, quote: ReceivedQuote?): TileBuilders.Tile =
        TileBuilders.Tile.Builder()
            .setResourcesVersion(RESOURCES_VERSION)
            .setTileTimeline(buildTimeline(context, quote))
            .build()

    private fun buildTimeline(context: Context, quote: ReceivedQuote?): TimelineBuilders.Timeline =
        TimelineBuilders.Timeline.Builder()
            .addTimelineEntry(
                TimelineBuilders.TimelineEntry.Builder()
                    .setLayout(
                        androidx.wear.protolayout.LayoutElementBuilders.Layout.Builder()
                            .setRoot(buildRoot(context, quote))
                            .build()
                    )
                    .build()
            )
            .build()

    private fun buildRoot(context: Context, quote: ReceivedQuote?): LayoutElement {
        val launchAction = ActionBuilders.LaunchAction.Builder()
            .setAndroidActivity(
                ActionBuilders.AndroidActivity.Builder()
                    .setClassName(WearMainActivity::class.java.name)
                    .setPackageName(context.packageName)
                    .build()
            )
            .build()

        val clickable = Clickable.Builder()
            .setOnClick(launchAction)
            .build()

        val quoteText = if (quote != null) {
            val truncated = if (quote.text.length > 60) quote.text.take(60) + "…" else quote.text
            "\u201c$truncated\u201d"
        } else {
            "Open Ataraxy on your phone to receive today\u2019s quote."
        }

        val authorText = quote?.let { "\u2014 ${it.authorName.uppercase()}" } ?: ""

        return Box.Builder()
            .setModifiers(
                Modifiers.Builder()
                    .setBackground(
                        Background.Builder().setColor(argb(STONE_COLOR)).build()
                    )
                    .setClickable(clickable)
                    .setPadding(
                        Padding.Builder()
                            .setAll(dp(12f))
                            .build()
                    )
                    .build()
            )
            .addContent(
                Column.Builder()
                    .addContent(
                        Text.Builder()
                            .setText(
                                androidx.wear.protolayout.TypeBuilders.StringProp.Builder(quoteText)
                                    .build()
                            )
                            .setFontStyle(
                                FontStyle.Builder()
                                    .setItalic(
                                        androidx.wear.protolayout.TypeBuilders.BoolProp.Builder(true)
                                            .build()
                                    )
                                    .setSize(sp(14f))
                                    .setColor(argb(CREAM_COLOR))
                                    .build()
                            )
                            .setMaxLines(
                                androidx.wear.protolayout.TypeBuilders.Int32Prop.Builder().setValue(4).build()
                            )
                            .build()
                    )
                    .addContent(Spacer.Builder().setHeight(dp(6f)).build())
                    .addContent(
                        Text.Builder()
                            .setText(
                                androidx.wear.protolayout.TypeBuilders.StringProp.Builder(authorText)
                                    .build()
                            )
                            .setFontStyle(
                                FontStyle.Builder()
                                    .setSize(sp(11f))
                                    .setColor(argb(CREAM_MUTED_COLOR))
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .build()
    }
}
