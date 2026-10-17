package com.ataraxy.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.domain.model.ContentTextSize

private val LightColorScheme = lightColorScheme(
    primary = Ink,
    onPrimary = Cream,
    primaryContainer = CreamCard,
    onPrimaryContainer = Ink,
    secondary = InkMuted,
    onSecondary = Cream,
    secondaryContainer = CreamSurface,
    onSecondaryContainer = InkMuted,
    tertiary = InkFaint,
    onTertiary = Cream,
    background = Cream,
    onBackground = Ink,
    surface = Cream,
    onSurface = Ink,
    surfaceVariant = CreamCard,
    onSurfaceVariant = InkMuted,
    outline = CreamDivider,
    outlineVariant = CreamDivider,
    error = DestructiveRed,
    onError = Cream,
)

private val DarkColorScheme = darkColorScheme(
    primary = OffWhite,
    onPrimary = Stone,
    primaryContainer = StoneCard,
    onPrimaryContainer = OffWhite,
    secondary = OffWhiteMuted,
    onSecondary = Stone,
    secondaryContainer = StoneSurface,
    onSecondaryContainer = OffWhiteMuted,
    tertiary = OffWhiteFaint,
    onTertiary = Stone,
    background = Stone,
    onBackground = OffWhite,
    surface = Stone,
    onSurface = OffWhite,
    surfaceVariant = StoneCard,
    onSurfaceVariant = OffWhiteMuted,
    outline = StoneDivider,
    outlineVariant = StoneDivider,
    error = DestructiveRed,
    onError = Stone,
)

@Composable
fun AtaraxyTheme(
    appTheme: AppTheme = AppTheme.SYSTEM,
    contentTextSize: ContentTextSize = ContentTextSize.DEFAULT,
    content: @Composable () -> Unit
) {
    val isDark = when (appTheme) {
        AppTheme.LIGHT -> false
        AppTheme.DARK -> true
        AppTheme.SYSTEM -> isSystemInDarkTheme()
    }

    MaterialTheme(
        colorScheme = if (isDark) DarkColorScheme else LightColorScheme,
        typography = ataraxyTypography(contentTextSize),
        shapes = AtaraxyShapes,
        content = content
    )
}
