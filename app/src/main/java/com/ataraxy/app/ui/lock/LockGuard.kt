package com.ataraxy.app.ui.lock

import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.FragmentActivity
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.ataraxy.app.R
import kotlinx.coroutines.launch

/**
 * Returns a wrapper for data actions: with App Lock on it asks for the unlock every time and runs
 * the action only on success; with it off the action runs directly.
 */
@Composable
fun rememberLockGuard(): (action: () -> Unit) -> Unit {
    val lock: LockViewModel = hiltViewModel()
    val activity = LocalActivity.current as? FragmentActivity
    val title = stringResource(R.string.lock_prompt_confirm_title)
    val enabled by lock.appLock.enabled.collectAsState()
    val scope = rememberCoroutineScope()
    val currentActivity by rememberUpdatedState(activity)
    val currentTitle by rememberUpdatedState(title)
    val currentEnabled by rememberUpdatedState(enabled)
    return remember(lock, scope) {
        { action ->
            if (!currentEnabled) {
                action()
            } else {
                scope.launch {
                    val host = currentActivity
                    if (host != null && lock.authenticator.authenticate(host, currentTitle)) action()
                }
            }
        }
    }
}
