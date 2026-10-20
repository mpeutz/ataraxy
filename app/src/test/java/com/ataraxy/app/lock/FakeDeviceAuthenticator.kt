package com.ataraxy.app.lock

import androidx.fragment.app.FragmentActivity

class FakeDeviceAuthenticator(
    var secure: Boolean = true,
    var result: Boolean = true
) : DeviceAuthenticator {

    val titles = mutableListOf<String>()

    override fun isDeviceSecure(): Boolean = secure

    override suspend fun authenticate(activity: FragmentActivity, title: String): Boolean {
        titles += title
        return result
    }
}
