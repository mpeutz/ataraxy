package com.ataraxy.app.lock

import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SingleFlightAuthenticatorTest {

    private val activity: FragmentActivity = Robolectric.buildActivity(FragmentActivity::class.java).get()

    private class GatedAuthenticator : DeviceAuthenticator {
        var gate = CompletableDeferred<Boolean>()
        var calls = 0

        override fun isDeviceSecure() = true

        override suspend fun authenticate(activity: FragmentActivity, title: String): Boolean {
            calls++
            return gate.await()
        }
    }

    @Test
    fun secondCallWhilePending_returnsFalse_withoutCallingDelegate() = runBlocking {
        val delegate = GatedAuthenticator()
        val authenticator = SingleFlightAuthenticator(delegate)
        val first = async(start = CoroutineStart.UNDISPATCHED) { authenticator.authenticate(activity, "t") }

        assertFalse(authenticator.authenticate(activity, "t"))
        delegate.gate.complete(true)

        assertTrue(first.await())
        assertEquals(1, delegate.calls)
    }

    @Test
    fun afterFirstCompletes_newCallGoesThrough() = runBlocking {
        val delegate = GatedAuthenticator().apply { gate.complete(true) }
        val authenticator = SingleFlightAuthenticator(delegate)

        assertTrue(authenticator.authenticate(activity, "t"))
        assertTrue(authenticator.authenticate(activity, "t"))
        assertEquals(2, delegate.calls)
    }

    @Test
    fun cancellingFirstCall_releasesTheSlot() = runBlocking {
        val delegate = GatedAuthenticator()
        val authenticator = SingleFlightAuthenticator(delegate)
        val first = async(start = CoroutineStart.UNDISPATCHED) { authenticator.authenticate(activity, "t") }
        first.cancel(CancellationException())
        runCatching { first.await() }

        delegate.gate = CompletableDeferred(true)

        assertTrue(authenticator.authenticate(activity, "t"))
        assertEquals(2, delegate.calls)
    }
}
