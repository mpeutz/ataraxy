package com.ataraxy.app.ui.lock

import android.view.Window
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
import java.util.WeakHashMap

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
        SecureWindows.acquire(window)
        onDispose { SecureWindows.release(window) }
    }
}

/** Counts locked routes per window, so one route leaving mid-crossfade can't clear another's flag. */
internal object SecureWindows {
    private val holds = WeakHashMap<Window, Int>()

    fun acquire(window: Window) {
        val count = holds[window] ?: 0
        holds[window] = count + 1
        if (count == 0) window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }

    fun release(window: Window) {
        val count = (holds[window] ?: 0) - 1
        if (count > 0) {
            holds[window] = count
            return
        }
        holds.remove(window)
        window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }
}
