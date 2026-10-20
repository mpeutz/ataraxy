package com.ataraxy.app.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.util.TypedValue
import android.widget.RemoteViews
import androidx.core.content.ContextCompat
import com.ataraxy.app.MainActivity
import com.ataraxy.app.R
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.ui.theme.WidgetType
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import java.time.LocalDate
import javax.inject.Inject

private const val DEFAULT_HEIGHT_DP = 110
private const val HOME_LINK = "ataraxy://home"

fun quoteWidgetIds(context: Context): IntArray =
    AppWidgetManager.getInstance(context)
        .getAppWidgetIds(ComponentName(context, QuoteWidgetProvider::class.java))

class QuoteWidgetRenderer @Inject constructor(
    @ApplicationContext private val context: Context,
    private val quotes: QuoteRepository,
    private val prefs: UserPrefsRepository,
    private val styles: WidgetStyleStore
) {

    suspend fun render(appWidgetId: Int, heightDp: Int): RemoteViews {
        val look = resolveLook(styles.get(appWidgetId), prefs.userPrefs.first().theme, isSystemDark())
        val layoutId = when (look.layout) {
            WidgetLayout.CARD -> R.layout.widget_quote_card
            WidgetLayout.CLEAR -> R.layout.widget_quote_clear
        }
        val quote = quotes.getDailyQuote(LocalDate.now()).first()
        val quoteText = quote?.text ?: context.getString(R.string.widget_empty)
        val author = quote?.let { "— ${it.authorName.uppercase()}" }.orEmpty()
        val spec = quoteTextSpec(heightDp)

        return RemoteViews(context.packageName, layoutId).apply {
            look.background?.let { setInt(R.id.widget_root, "setBackgroundResource", it) }
            setTextViewText(R.id.widget_quote, quoteText)
            setTextColor(R.id.widget_quote, ContextCompat.getColor(context, look.quoteColor))
            setTextViewTextSize(R.id.widget_quote, TypedValue.COMPLEX_UNIT_SP, spec.sizeSp)
            setInt(R.id.widget_quote, "setMaxLines", spec.maxLines)
            setTextViewText(R.id.widget_author, author)
            setTextColor(R.id.widget_author, ContextCompat.getColor(context, look.authorColor))
            setTextViewTextSize(R.id.widget_author, TypedValue.COMPLEX_UNIT_SP, WidgetType.AUTHOR_SP)
            setContentDescription(R.id.widget_root, listOf(quoteText, author).filter { it.isNotEmpty() }.joinToString(". "))
            setOnClickPendingIntent(R.id.widget_root, openHomeIntent())
        }
    }

    suspend fun updateAll() {
        val manager = AppWidgetManager.getInstance(context)
        quoteWidgetIds(context).forEach { id ->
            manager.updateAppWidget(id, render(id, heightOf(manager, id)))
        }
    }

    private fun isSystemDark(): Boolean =
        context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

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
