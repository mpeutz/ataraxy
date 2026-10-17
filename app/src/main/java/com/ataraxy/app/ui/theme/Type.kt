package com.ataraxy.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.ContentTextSize

val CormorantGaramond = FontFamily(
    Font(R.font.cormorant_garamond_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(R.font.cormorant_garamond_italic,  weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.cormorant_garamond_medium,  weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(R.font.cormorant_garamond_semibold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(R.font.cormorant_garamond_bold,    weight = FontWeight.Bold,   style = FontStyle.Normal),
)

val Jost = FontFamily(
    Font(R.font.jost_light,    weight = FontWeight.Light,    style = FontStyle.Normal),
    Font(R.font.jost_regular,  weight = FontWeight.Normal,   style = FontStyle.Normal),
    Font(R.font.jost_medium,   weight = FontWeight.Medium,   style = FontStyle.Normal),
    Font(R.font.jost_semibold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
)

private val BaseAtaraxyTypography = Typography(
    // Display — large quote text
    displayLarge = TextStyle(
        fontFamily = CormorantGaramond,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 48.sp,
        lineHeight = 62.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = CormorantGaramond,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 38.sp,
        lineHeight = 50.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = CormorantGaramond,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 30.sp,
        lineHeight = 42.sp,
    ),
    // Headline — virtue names, screen titles
    headlineLarge = TextStyle(
        fontFamily = CormorantGaramond,
        fontWeight = FontWeight.Bold,
        fontSize = 56.sp,
        lineHeight = 64.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = CormorantGaramond,
        fontWeight = FontWeight.SemiBold,
        fontSize = 42.sp,
        lineHeight = 52.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = CormorantGaramond,
        fontWeight = FontWeight.SemiBold,
        fontSize = 34.sp,
        lineHeight = 44.sp,
    ),
    // Title — section headers, card titles (Jost)
    titleLarge = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.3.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.2.sp,
    ),
    // Body — prose, descriptions
    bodyLarge = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 26.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 22.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 18.sp,
    ),
    // Label — ALL-CAPS labels, badges
    labelLarge = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        letterSpacing = 2.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        letterSpacing = 2.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 1.5.sp,
    ),
)

fun ataraxyTypography(contentTextSize: ContentTextSize): Typography {
    val scale = contentTextSize.scaleFactor
    return BaseAtaraxyTypography.copy(
        // Quotes render in the display styles, so they must follow the content size too.
        displayLarge = BaseAtaraxyTypography.displayLarge.scaled(scale),
        displayMedium = BaseAtaraxyTypography.displayMedium.scaled(scale),
        displaySmall = BaseAtaraxyTypography.displaySmall.scaled(scale),
        titleLarge = BaseAtaraxyTypography.titleLarge.scaled(scale),
        titleMedium = BaseAtaraxyTypography.titleMedium.scaled(scale),
        titleSmall = BaseAtaraxyTypography.titleSmall.scaled(scale),
        bodyLarge = BaseAtaraxyTypography.bodyLarge.scaled(scale),
        bodyMedium = BaseAtaraxyTypography.bodyMedium.scaled(scale),
        bodySmall = BaseAtaraxyTypography.bodySmall.scaled(scale)
    )
}

private fun TextStyle.scaled(scale: Float): TextStyle {
    if (scale == 1.0f) return this
    return copy(
        fontSize = fontSize * scale,
        lineHeight = lineHeight * scale
    )
}
