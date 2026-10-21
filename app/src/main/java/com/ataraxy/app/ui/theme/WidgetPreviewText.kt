package com.ataraxy.app.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/** Stand-in wallpaper behind the Clear style's preview, so its white text stays readable. */
val WidgetPreviewWallpaper = Color(0xFF7A7F87)

/** Matches the Clear widget's text shadow (`#80000000`, radius 6, dy 1). */
private val ClearShadow = Shadow(Color(0x80000000), Offset(0f, 1f), 6f)

/**
 * Compose copies of the widget's RemoteViews text, for the setup screen's live preview: the system
 * serif italic quote and the tracked sans-serif-medium author line.
 */
object WidgetPreviewText {

    fun quote(sizeSp: Float, color: Color, clear: Boolean): TextStyle = TextStyle(
        fontFamily = FontFamily.Serif,
        fontStyle = FontStyle.Italic,
        fontSize = sizeSp.sp,
        color = color,
        shadow = shadowFor(clear)
    )

    @Composable
    @ReadOnlyComposable
    fun author(color: Color, clear: Boolean): TextStyle = AtaraxyText.meta.copy(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = WidgetType.AUTHOR_SP.sp,
        letterSpacing = 0.2.em,
        color = color,
        shadow = shadowFor(clear)
    )

    private fun shadowFor(clear: Boolean): Shadow? = if (clear) ClearShadow else null
}
