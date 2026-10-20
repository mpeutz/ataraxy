package com.ataraxy.app.widget

import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.ui.theme.WidgetType

enum class WidgetStyle { MATCH_APP, LIGHT, DARK, CLEAR, ACCENT }

enum class WidgetLayout { CARD, CLEAR }

data class WidgetLook(
    val layout: WidgetLayout,
    @LayoutRes val layoutRes: Int,
    @DrawableRes val background: Int?,
    @ColorRes val quoteColor: Int,
    @ColorRes val authorColor: Int
)

data class QuoteTextSpec(val sizeSp: Float, val maxLines: Int)

fun availableStyles(sdkInt: Int): List<WidgetStyle> =
    if (sdkInt >= Build.VERSION_CODES.S) WidgetStyle.entries else WidgetStyle.entries - WidgetStyle.ACCENT

fun resolveLook(style: WidgetStyle, appTheme: AppTheme): WidgetLook = when (style) {
    WidgetStyle.LIGHT -> LIGHT_LOOK
    WidgetStyle.DARK -> DARK_LOOK
    WidgetStyle.CLEAR -> CLEAR_LOOK
    WidgetStyle.ACCENT -> ACCENT_LOOK
    WidgetStyle.MATCH_APP -> when (appTheme) {
        AppTheme.LIGHT -> LIGHT_LOOK
        AppTheme.DARK -> DARK_LOOK
        AppTheme.SYSTEM -> FOLLOW_PHONE_LOOK
    }
}

fun quoteTextSpec(heightDp: Int): QuoteTextSpec = when {
    heightDp < WidgetType.COMPACT_BELOW_DP ->
        QuoteTextSpec(WidgetType.COMPACT_QUOTE_SP, WidgetType.COMPACT_QUOTE_LINES)
    heightDp < WidgetType.MEDIUM_BELOW_DP ->
        QuoteTextSpec(WidgetType.MEDIUM_QUOTE_SP, WidgetType.MEDIUM_QUOTE_LINES)
    else -> QuoteTextSpec(WidgetType.LARGE_QUOTE_SP, WidgetType.LARGE_QUOTE_LINES)
}

private val LIGHT_LOOK = WidgetLook(
    WidgetLayout.CARD, R.layout.widget_quote_card_light, R.drawable.widget_bg_light, R.color.widget_quote_light, R.color.widget_author_light
)
private val DARK_LOOK = WidgetLook(
    WidgetLayout.CARD, R.layout.widget_quote_card_dark, R.drawable.widget_bg_dark, R.color.widget_quote_dark, R.color.widget_author_dark
)
private val CLEAR_LOOK = WidgetLook(
    WidgetLayout.CLEAR, R.layout.widget_quote_clear, null, R.color.widget_quote_clear, R.color.widget_author_clear
)
private val ACCENT_LOOK = WidgetLook(
    WidgetLayout.CARD, R.layout.widget_quote_card_accent, R.drawable.widget_bg_accent, R.color.widget_quote_accent, R.color.widget_author_accent
)

// Resolved by the launcher in its own night mode, so it follows the phone without a re-render.
private val FOLLOW_PHONE_LOOK = WidgetLook(
    WidgetLayout.CARD, R.layout.widget_quote_card_follow, R.drawable.widget_bg_follow,
    R.color.widget_quote_follow, R.color.widget_author_follow
)
