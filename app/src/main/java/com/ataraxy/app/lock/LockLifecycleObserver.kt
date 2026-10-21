package com.ataraxy.app.lock

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/** Feeds foreground and background transitions to [AppLock], ignoring rotation-style restarts. */
class LockLifecycleObserver(
    private val appLock: AppLock,
    private val isChangingConfigurations: () -> Boolean
) : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) = appLock.onForegrounded()

    override fun onStop(owner: LifecycleOwner) {
        if (isChangingConfigurations()) return
        appLock.onBackgrounded()
    }
}
