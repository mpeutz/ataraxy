package com.ataraxy.wear.ui.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material3.MaterialTheme

/**
 * Wraps the Wear OS Material3 system theme. Watches use their own dark/ambient theming
 * conventions — we defer to the system defaults here and layer Ataraxy's aesthetic via
 * per-screen surface colours and typography overrides.
 */
@Composable
fun WearAtaraxyTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}
