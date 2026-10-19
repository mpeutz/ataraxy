package com.ataraxy.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

private const val MEDIUM_QUOTE_CHARS = 120
private const val LONG_QUOTE_CHARS = 200

/** FEATURED is the quote a screen is about; CARD is a quote shown as context above other work. */
enum class QuoteSize(internal val scale: Float) { FEATURED(1f), CARD(0.75f) }

/** How much a quote of [length] characters shrinks from the full display size, so long ones still fit. */
internal fun quoteSizeScale(length: Int, size: QuoteSize = QuoteSize.FEATURED): Float {
    val lengthScale = when {
        length <= MEDIUM_QUOTE_CHARS -> 1f
        length <= LONG_QUOTE_CHARS -> 0.87f
        else -> 0.78f
    }
    return lengthScale * size.scale
}

/**
 * The app's text roles, taken from Home's look. Screens use these and nothing else.
 *
 * Chrome roles (tracked caps: titles, labels, meta, buttons) stay a fixed size. Content roles are
 * built on the theme's scaled styles, so they follow the Content Text Size setting, and their line
 * heights are relative to the final size.
 */
object AtaraxyText {

    // Chrome

    val screenTitle: TextStyle
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelLarge.copy(
            fontFamily = Jost, fontWeight = FontWeight.Medium, fontSize = 14.sp, letterSpacing = 4.sp
        )

    val eyebrow: TextStyle
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelMedium.copy(
            fontFamily = Jost, fontWeight = FontWeight.Medium, letterSpacing = 3.sp
        )

    val attribution: TextStyle
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelMedium.copy(
            fontFamily = Jost, fontWeight = FontWeight.Medium, letterSpacing = 2.sp
        )

    val meta: TextStyle
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelSmall.copy(
            fontFamily = Jost, letterSpacing = 1.5.sp
        )

    val button: TextStyle
        @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelLarge.copy(
            fontFamily = Jost, fontWeight = FontWeight.Medium, letterSpacing = 2.sp
        )

    // Content

    val display: TextStyle
        @Composable @ReadOnlyComposable get() = serif(MaterialTheme.typography.displaySmall, 1.33f, 1.2f)

    val heading: TextStyle
        @Composable @ReadOnlyComposable get() = serif(MaterialTheme.typography.displaySmall, 0.87f, 1.25f)

    val prompt: TextStyle
        @Composable @ReadOnlyComposable get() =
            serif(MaterialTheme.typography.displaySmall, 0.73f, 1.3f).copy(fontStyle = FontStyle.Italic)

    val reading: TextStyle
        @Composable @ReadOnlyComposable get() = serif(MaterialTheme.typography.bodyLarge, 1.2f, 1.4f)

    val figure: TextStyle
        @Composable @ReadOnlyComposable get() = serif(MaterialTheme.typography.displaySmall, 0.93f, 1.1f)

    val body: TextStyle
        @Composable @ReadOnlyComposable get() =
            MaterialTheme.typography.bodyLarge.copy(fontFamily = Jost, lineHeight = 1.6.em)

    val secondary: TextStyle
        @Composable @ReadOnlyComposable get() =
            MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost, lineHeight = 1.5.em)

    val hint: TextStyle
        @Composable @ReadOnlyComposable get() {
            val base = MaterialTheme.typography.bodyMedium
            return base.copy(
                fontFamily = Jost, fontStyle = FontStyle.Italic, fontSize = base.fontSize * 0.93f, lineHeight = 1.4.em
            )
        }

    /** A quote; long ones step down so they still fit. */
    @Composable
    @ReadOnlyComposable
    fun quote(text: String, size: QuoteSize = QuoteSize.FEATURED): TextStyle {
        val base = MaterialTheme.typography.displaySmall
        return base.copy(
            fontFamily = CormorantGaramond,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Normal,
            fontSize = base.fontSize * quoteSizeScale(text.length, size),
            lineHeight = 1.3.em
        )
    }

    private fun serif(base: TextStyle, scale: Float, lineHeight: Float): TextStyle = base.copy(
        fontFamily = CormorantGaramond,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Normal,
        fontSize = base.fontSize * scale,
        lineHeight = lineHeight.em
    )
}
