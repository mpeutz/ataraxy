package com.ataraxy.app.ui.theme

import com.ataraxy.app.domain.model.ContentTextSize
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TypographyTest {

    private val base = ataraxyTypography(ContentTextSize.DEFAULT)
    private val larger = ataraxyTypography(ContentTextSize.LARGER)
    private val scale = ContentTextSize.LARGER.scaleFactor

    @Test
    fun largerTextSize_scalesQuoteStyles() {
        assertEquals(base.displaySmall.fontSize.value * scale, larger.displaySmall.fontSize.value, 0.01f)
        assertEquals(base.displayMedium.fontSize.value * scale, larger.displayMedium.fontSize.value, 0.01f)
        assertEquals(base.displayLarge.fontSize.value * scale, larger.displayLarge.fontSize.value, 0.01f)
    }

    @Test
    fun largerTextSize_scalesBodyStyles() {
        assertEquals(base.bodyLarge.fontSize.value * scale, larger.bodyLarge.fontSize.value, 0.01f)
    }
}
