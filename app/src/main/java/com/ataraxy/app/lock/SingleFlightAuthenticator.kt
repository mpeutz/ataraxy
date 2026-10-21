package com.ataraxy.app.lock

import androidx.fragment.app.FragmentActivity
import java.util.concurrent.atomic.AtomicBoolean

/** Shows one unlock prompt at a time: a request made while one is pending is refused. */
class SingleFlightAuthenticator(private val delegate: DeviceAuthenticator) : DeviceAuthenticator {

    private val pending = AtomicBoolean(false)

    override fun isDeviceSecure(): Boolean = delegate.isDeviceSecure()

    override suspend fun authenticate(activity: FragmentActivity, title: String): Boolean {
        if (!pending.compareAndSet(false, true)) return false
        try {
            return delegate.authenticate(activity, title)
        } finally {
            pending.set(false)
        }
    }
}
