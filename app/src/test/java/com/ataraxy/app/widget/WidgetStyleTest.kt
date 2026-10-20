package com.ataraxy.app.widget

import com.ataraxy.app.R
import com.ataraxy.app.domain.model.AppTheme
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WidgetStyleTest {

    private val light = resolveLook(WidgetStyle.LIGHT, AppTheme.SYSTEM)
    private val dark = resolveLook(WidgetStyle.DARK, AppTheme.SYSTEM)

    @Test fun accentHiddenBelowAndroid12() {
        assertFalse(WidgetStyle.ACCENT in availableStyles(30))
        assertTrue(WidgetStyle.ACCENT in availableStyles(31))
    }

    @Test fun matchApp_followsAppTheme() {
        assertEquals(light, resolveLook(WidgetStyle.MATCH_APP, AppTheme.LIGHT))
        assertEquals(dark, resolveLook(WidgetStyle.MATCH_APP, AppTheme.DARK))
    }

    @Test fun matchApp_systemTheme_usesFollowLayout() {
        val look = resolveLook(WidgetStyle.MATCH_APP, AppTheme.SYSTEM)
        assertEquals(R.layout.widget_quote_card_follow, look.layoutRes)
        assertEquals(R.layout.widget_quote_card_light, light.layoutRes)
        assertEquals(R.layout.widget_quote_card_dark, dark.layoutRes)
    }

    @Test fun clear_usesClearLayoutWithoutBackground() {
        val look = resolveLook(WidgetStyle.CLEAR, AppTheme.LIGHT)
        assertEquals(WidgetLayout.CLEAR, look.layout)
        assertNull(look.background)
        assertEquals(WidgetLayout.CARD, light.layout)
        assertEquals(R.drawable.widget_bg_light, light.background)
    }

    @Test fun textSpec_shrinksWithHeight() {
        assertEquals(QuoteTextSpec(14f, 2), quoteTextSpec(90))
        assertEquals(QuoteTextSpec(16f, 4), quoteTextSpec(150))
        assertEquals(QuoteTextSpec(18f, 7), quoteTextSpec(250))
    }
}
