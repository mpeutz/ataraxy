package com.ataraxy.app.ui.theme

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class QuoteTextStyleTest {

    @Test
    fun shortQuotes_keepFullSize() {
        assertEquals(1f, quoteSizeScale(length = 80))
        assertEquals(1f, quoteSizeScale(length = 120))
    }

    @Test
    fun longerQuotes_stepDown() {
        assertTrue(quoteSizeScale(length = 121) < 1f)
        assertTrue(quoteSizeScale(length = 201) < quoteSizeScale(length = 200))
    }

    @Test
    fun cardQuotes_areSmallerThanFeaturedAtEveryLength() {
        (0..400 step 10).forEach { length ->
            assertTrue(quoteSizeScale(length, QuoteSize.CARD) < quoteSizeScale(length, QuoteSize.FEATURED))
        }
    }

    @Test
    fun scale_neverGrowsWithLength() {
        val scales = (0..400 step 10).map(::quoteSizeScale)

        assertEquals(scales.sortedDescending(), scales)
    }
}
