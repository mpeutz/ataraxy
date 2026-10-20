package com.ataraxy.app.lock

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.nio.file.Files
import java.time.Duration

@RunWith(RobolectricTestRunner::class)
class LockLifecycleObserverTest {

    private val ticker = FakeElapsedRealtime()
    private var changingConfigurations = false
    private lateinit var appLock: AppLock
    private lateinit var registry: LifecycleRegistry

    @Before
    fun setUp() = runBlocking {
        appLock = AppLock(tempDataStore(), FakeDeviceAuthenticator(), ticker)
        appLock.setEnabled(true)
        val owner = object : LifecycleOwner {
            override val lifecycle: Lifecycle get() = registry
        }
        registry = LifecycleRegistry.createUnsafe(owner)
        registry.addObserver(LockLifecycleObserver(appLock) { changingConfigurations })
        registry.currentState = Lifecycle.State.RESUMED
    }

    @Test
    fun configurationChange_doesNotRelock() {
        changingConfigurations = true
        registry.currentState = Lifecycle.State.CREATED
        ticker.advance(Duration.ofSeconds(120))
        registry.currentState = Lifecycle.State.RESUMED

        assertTrue(appLock.isUnlocked.value)
    }

    @Test
    fun realBackground_relocksAfter60s() {
        registry.currentState = Lifecycle.State.CREATED
        ticker.advance(Duration.ofSeconds(61))
        registry.currentState = Lifecycle.State.RESUMED

        assertFalse(appLock.isUnlocked.value)
    }

    private fun tempDataStore(): DataStore<Preferences> {
        val dir = Files.createTempDirectory("prefs").toFile()
        return PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, "lock_prefs.preferences_pb") }
        )
    }
}
