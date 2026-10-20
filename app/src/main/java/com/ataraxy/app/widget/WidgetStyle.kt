package com.ataraxy.app.widget

import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.ui.theme.WidgetType

enum class WidgetStyle { MATCH_APP, LIGHT, DARK, CLEAR, ACCENT }

enum class WidgetLayout { CARD, CLEAR }

data class WidgetLook(
    val layout: WidgetLayout,
    @DrawableRes val background: Int?,
    @ColorRes val quoteColor: Int,
    @ColorRes val authorColor: Int
)

data class QuoteTextSpec(val sizeSp: Float, val maxLines: Int)

fun availableStyles(sdkInt: Int): List<WidgetStyle> =
    if (sdkInt >= Build.VERSION_CODES.S) WidgetStyle.entries else WidgetStyle.entries - WidgetStyle.ACCENT

fun resolveLook(style: WidgetStyle, appTheme: AppTheme, systemDark: Boolean): WidgetLook = when (style) {
    WidgetStyle.LIGHT -> LIGHT_LOOK
    WidgetStyle.DARK -> DARK_LOOK
    WidgetStyle.CLEAR -> CLEAR_LOOK
    WidgetStyle.ACCENT -> ACCENT_LOOK
    WidgetStyle.MATCH_APP -> if (appTheme.isDark(systemDark)) DARK_LOOK else LIGHT_LOOK
}

fun quoteTextSpec(heightDp: Int): QuoteTextSpec = when {
    heightDp < WidgetType.COMPACT_BELOW_DP ->
        QuoteTextSpec(WidgetType.COMPACT_QUOTE_SP, WidgetType.COMPACT_QUOTE_LINES)
    heightDp < WidgetType.MEDIUM_BELOW_DP ->
        QuoteTextSpec(WidgetType.MEDIUM_QUOTE_SP, WidgetType.MEDIUM_QUOTE_LINES)
    else -> QuoteTextSpec(WidgetType.LARGE_QUOTE_SP, WidgetType.LARGE_QUOTE_LINES)
}

private fun AppTheme.isDark(systemDark: Boolean): Boolean = when (this) {
    AppTheme.DARK -> true
    AppTheme.LIGHT -> false
    AppTheme.SYSTEM -> systemDark
}

private val LIGHT_LOOK = WidgetLook(
    WidgetLayout.CARD, R.drawable.widget_bg_light, R.color.widget_quote_light, R.color.widget_author_light
)
private val DARK_LOOK = WidgetLook(
    WidgetLayout.CARD, R.drawable.widget_bg_dark, R.color.widget_quote_dark, R.color.widget_author_dark
)
private val CLEAR_LOOK = WidgetLook(
    WidgetLayout.CLEAR, null, R.color.widget_quote_clear, R.color.widget_author_clear
)
private val ACCENT_LOOK = WidgetLook(
    WidgetLayout.CARD, R.drawable.widget_bg_accent, R.color.widget_quote_accent, R.color.widget_author_accent
)
