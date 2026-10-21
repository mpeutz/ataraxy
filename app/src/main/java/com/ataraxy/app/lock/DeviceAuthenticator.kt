package com.ataraxy.app.lock

import androidx.fragment.app.FragmentActivity

interface DeviceAuthenticator {
    fun isDeviceSecure(): Boolean

    /** True when unlocked; false when cancelled, failed or unavailable. */
    suspend fun authenticate(activity: FragmentActivity, title: String): Boolean
}
