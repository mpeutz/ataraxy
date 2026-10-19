package com.ataraxy.app.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.em
import com.ataraxy.app.ui.theme.CormorantGaramond

private const val MEDIUM_QUOTE_CHARS = 120
private const val LONG_QUOTE_CHARS = 200

/** How much a quote of [length] characters shrinks from the full display size, so long ones still fit. */
internal fun quoteSizeScale(length: Int): Float = when {
    length <= MEDIUM_QUOTE_CHARS -> 1f
    length <= LONG_QUOTE_CHARS -> 0.87f
    else -> 0.78f
}

/**
 * The featured quote style. Built on displaySmall so the Content Text Size setting still scales
 * it, with the line height relative to the final size.
 */
@Composable
fun quoteTextStyle(text: String): TextStyle {
    val base = MaterialTheme.typography.displaySmall
    return base.copy(
        fontFamily = CormorantGaramond,
        fontStyle = FontStyle.Italic,
        fontSize = base.fontSize * quoteSizeScale(text.length),
        lineHeight = 1.3.em
    )
}
