package com.ataraxy.app.ui.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.fragment.app.FragmentActivity
import com.ataraxy.app.lock.AppLock
import com.ataraxy.app.lock.FakeDeviceAuthenticator
import com.ataraxy.app.lock.SingleFlightAuthenticator
import com.ataraxy.app.lock.DeviceAuthenticator
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import com.ataraxy.app.testing.awaitMain
import com.ataraxy.app.testing.settleMain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.nio.file.Files
import java.time.Clock

@RunWith(RobolectricTestRunner::class)
class AppLockViewModelTest {

    private val authenticator = FakeDeviceAuthenticator()
    private val activity: FragmentActivity = Robolectric.buildActivity(FragmentActivity::class.java).get()

    private fun newViewModel(): AppLockViewModel {
        val appLock = AppLock(tempDataStore(), authenticator, Clock.systemUTC())
        return AppLockViewModel(appLock, authenticator)
    }

    @Test
    fun turnOn_asksForUnlock_thenEnables() = runBlocking {
        val viewModel = newViewModel()

        viewModel.toggle(activity, "Confirm")
        awaitMain { viewModel.state.value.enabled }

        assertEquals(listOf("Confirm"), authenticator.titles)
        assertTrue(viewModel.state.value.enabled)
    }

    @Test
    fun turnOn_unlockFails_staysOff() = runBlocking {
        authenticator.result = false
        val viewModel = newViewModel()

        viewModel.toggle(activity, "Confirm")
        settleMain()

        assertEquals(1, authenticator.titles.size)
        assertFalse(viewModel.state.value.enabled)
    }

    @Test
    fun turnOff_asksForUnlock_unlockFails_staysOn() = runBlocking {
        val viewModel = newViewModel()
        viewModel.toggle(activity, "Confirm")
        awaitMain { viewModel.state.value.enabled }
        authenticator.result = false

        viewModel.toggle(activity, "Confirm")
        settleMain()

        assertEquals(2, authenticator.titles.size)
        assertTrue(viewModel.state.value.enabled)
    }

    @Test
    fun turnOff_asksForUnlock_thenDisables() = runBlocking {
        val viewModel = newViewModel()
        viewModel.toggle(activity, "Confirm")
        awaitMain { viewModel.state.value.enabled }

        viewModel.toggle(activity, "Confirm")
        awaitMain { !viewModel.state.value.enabled }

        assertEquals(2, authenticator.titles.size)
        assertFalse(viewModel.state.value.enabled)
    }

    @Test
    fun unavailable_toggleDoesNothing() = runBlocking {
        authenticator.secure = false
        val viewModel = newViewModel()

        viewModel.toggle(activity, "Confirm")
        settleMain()

        assertFalse(viewModel.state.value.available)
        assertTrue(authenticator.titles.isEmpty())
        assertFalse(viewModel.state.value.enabled)
    }

    @Test
    fun concurrentToggles_oneSuccess_endsOn() = runBlocking {
        val gate = CompletableDeferred<Boolean>()
        val gated = object : DeviceAuthenticator {
            override fun isDeviceSecure() = true
            override suspend fun authenticate(activity: FragmentActivity, title: String) = gate.await()
        }
        val single = SingleFlightAuthenticator(gated)
        val viewModel = AppLockViewModel(AppLock(tempDataStore(), single, Clock.systemUTC()), single)

        val first = async(start = CoroutineStart.UNDISPATCHED) { viewModel.toggle(activity, "Confirm") }
        val second = async(start = CoroutineStart.UNDISPATCHED) { viewModel.toggle(activity, "Confirm") }
        gate.complete(true)
        first.await()
        second.await()
        awaitMain { viewModel.state.value.enabled }
        settleMain()

        assertTrue(viewModel.state.value.enabled)
    }

    private fun tempDataStore(): DataStore<Preferences> {
        val dir = Files.createTempDirectory("prefs").toFile()
        return PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, "lock_prefs.preferences_pb") }
        )
    }
}
