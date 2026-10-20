package com.ataraxy.app.ui.lock

import android.view.WindowManager
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier

/**
 * Shows [content] only while [isUnlocked]. Locked, it draws just the theme background and asks
 * once per lock state for the unlock; a refusal calls [onCancel]. The prompt runs in this
 * composition's scope, so a recreated activity cancels it and the route asks again.
 */
@Composable
fun LockedRoute(
    isUnlocked: Boolean,
    onUnlockRequest: suspend () -> Boolean,
    onUnlocked: () -> Unit,
    onCancel: () -> Unit,
    content: @Composable () -> Unit
) {
    val currentRequest by rememberUpdatedState(onUnlockRequest)
    val currentUnlocked by rememberUpdatedState(onUnlocked)
    val currentCancel by rememberUpdatedState(onCancel)

    SecureWindow()

    if (isUnlocked) {
        content()
        return
    }

    LaunchedEffect(Unit) {
        if (currentRequest()) currentUnlocked() else currentCancel()
    }
    Box(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background))
}

@Composable
private fun SecureWindow() {
    val window = LocalActivity.current?.window ?: return
    DisposableEffect(window) {
        val alreadySecure = window.attributes.flags and WindowManager.LayoutParams.FLAG_SECURE != 0
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        onDispose {
            if (!alreadySecure) window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
        }
    }
}
