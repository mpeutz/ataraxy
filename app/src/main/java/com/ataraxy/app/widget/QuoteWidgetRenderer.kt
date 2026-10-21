package com.ataraxy.app.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.RemoteViews
import com.ataraxy.app.MainActivity
import com.ataraxy.app.R
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.ui.theme.WidgetType
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withTimeoutOrNull
import java.time.LocalDate
import javax.inject.Inject

private const val DEFAULT_HEIGHT_DP = 110
internal const val UPDATE_TIMEOUT_MS = 8_000L
private const val LOG_TAG = "QuoteWidget"
private const val HOME_LINK = "ataraxy://home"

fun quoteWidgetIds(context: Context): IntArray =
    AppWidgetManager.getInstance(context)
        .getAppWidgetIds(ComponentName(context, QuoteWidgetProvider::class.java))

fun interface WidgetUpdater {
    suspend fun updateAll()
}

class QuoteWidgetRenderer @Inject constructor(
    @ApplicationContext private val context: Context,
    private val quotes: QuoteRepository,
    private val prefs: UserPrefsRepository,
    private val styles: WidgetStyleStore
) : WidgetUpdater {

    suspend fun render(appWidgetId: Int, heightDp: Int): RemoteViews {
        val look = resolveLook(styles.get(appWidgetId), prefs.userPrefs.first().theme)
        val quote = quotes.getDailyQuote(LocalDate.now()).first()
        val quoteText = quote?.text ?: context.getString(R.string.widget_empty)
        val author = quote?.let { "— ${it.authorName.uppercase()}" }.orEmpty()
        val spec = quoteTextSpec(heightDp)

        return RemoteViews(context.packageName, look.layoutRes).apply {
            setTextViewText(R.id.widget_quote, quoteText)
            setTextViewTextSize(R.id.widget_quote, TypedValue.COMPLEX_UNIT_SP, spec.sizeSp)
            setInt(R.id.widget_quote, "setMaxLines", spec.maxLines)
            setTextViewText(R.id.widget_author, author)
            setViewVisibility(R.id.widget_author, if (author.isEmpty()) View.GONE else View.VISIBLE)
            setTextViewTextSize(R.id.widget_author, TypedValue.COMPLEX_UNIT_SP, WidgetType.AUTHOR_SP)
            setContentDescription(R.id.widget_root, listOf(quoteText, author).filter { it.isNotEmpty() }.joinToString(". "))
            setOnClickPendingIntent(R.id.widget_root, openHomeIntent())
        }
    }

    override suspend fun updateAll() = guardedUpdate {
        val manager = AppWidgetManager.getInstance(context)
        updateEach(
            ids = quoteWidgetIds(context),
            render = { id -> render(id, heightOf(manager, id)) },
            push = manager::updateAppWidget
        )
    }

    private fun openHomeIntent(): PendingIntent {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(HOME_LINK), context, MainActivity::class.java)
        return PendingIntent.getActivity(
            context, 0, intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
    }
}

fun heightOf(manager: AppWidgetManager, appWidgetId: Int): Int =
    manager.getAppWidgetOptions(appWidgetId)
        .getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT)
        .takeIf { it > 0 } ?: DEFAULT_HEIGHT_DP

/** Renders and pushes each id on its own, so one failing widget keeps its old views and the rest still update. */
internal suspend fun updateEach(
    ids: IntArray,
    render: suspend (Int) -> RemoteViews,
    push: (Int, RemoteViews) -> Unit
) {
    ids.forEach { id ->
        try {
            push(id, render(id))
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.w(LOG_TAG, "Could not update widget $id", e)
        }
    }
}

/** Gives up quietly once a broadcast's ~10 s budget is nearly spent. */
internal suspend fun withUpdateTimeout(timeoutMs: Long = UPDATE_TIMEOUT_MS, block: suspend () -> Unit) {
    val finished = withTimeoutOrNull(timeoutMs) { block() }
    if (finished == null) Log.w(LOG_TAG, "Widget update timed out after $timeoutMs ms")
}

/** Bounds [block] and swallows its failures, so callers such as a ViewModel scope never see a throw. */
internal suspend fun guardedUpdate(block: suspend () -> Unit) {
    try {
        withUpdateTimeout(block = block)
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Log.w(LOG_TAG, "Could not update widgets", e)
    }
}
