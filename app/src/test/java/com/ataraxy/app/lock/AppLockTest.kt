package com.ataraxy.app.lock

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.ataraxy.app.data.backup.BackupRepository
import com.ataraxy.app.data.backup.BackupSnapshot
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.nio.file.Files
import java.time.Clock
import java.time.Duration

@RunWith(RobolectricTestRunner::class)
class AppLockTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var lockStore: DataStore<Preferences>
    private val authenticator = FakeDeviceAuthenticator()
    private val ticker = FakeElapsedRealtime()

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        lockStore = tempDataStore("lock_prefs.preferences_pb")
    }

    @After
    fun tearDown() = db.close()

    private fun newLock() = AppLock(lockStore, authenticator, ticker)

    @Test
    fun offByDefault_andAlwaysUnlocked() {
        val lock = newLock()

        assertFalse(lock.enabled.value)
        assertTrue(lock.isUnlocked.value)
    }

    @Test
    fun turnOn_marksUnlocked_coldStartIsLocked() = runBlocking {
        val lock = newLock()

        lock.setEnabled(true)

        assertTrue(lock.enabled.value)
        assertTrue(lock.isUnlocked.value)
        val coldStart = newLock()
        assertTrue(coldStart.enabled.value)
        assertFalse(coldStart.isUnlocked.value)
    }

    @Test
    fun background59s_staysUnlocked() = runBlocking {
        val lock = newLock().also { it.setEnabled(true) }

        lock.onBackgrounded()
        ticker.advance(Duration.ofSeconds(59))
        lock.onForegrounded()

        assertTrue(lock.isUnlocked.value)
    }

    @Test
    fun background60s_relocks() = runBlocking {
        val lock = newLock().also { it.setEnabled(true) }

        lock.onBackgrounded()
        ticker.advance(Duration.ofSeconds(60))
        lock.onForegrounded()

        assertFalse(lock.isUnlocked.value)
        lock.markUnlocked()
        assertTrue(lock.isUnlocked.value)
    }

    @Test
    fun relockTimer_ignoresTheWallClock() = runBlocking {
        val usesWallClock = AppLock::class.java.constructors.any { Clock::class.java in it.parameterTypes }
        val lock = newLock().also { it.setEnabled(true) }

        lock.onBackgrounded()
        ticker.advance(Duration.ofSeconds(60))
        lock.onForegrounded()

        assertFalse(usesWallClock)
        assertFalse(lock.isUnlocked.value)
    }

    @Test
    fun turnOff_isAlwaysUnlocked() = runBlocking {
        val lock = newLock().also { it.setEnabled(true) }
        lock.onBackgrounded()
        ticker.advance(Duration.ofMinutes(5))
        lock.onForegrounded()

        lock.setEnabled(false)

        assertFalse(lock.enabled.value)
        assertTrue(lock.isUnlocked.value)
    }

    @Test
    fun deviceNotSecure_lockReportsDisabled() = runBlocking {
        newLock().setEnabled(true)
        authenticator.secure = false

        val lock = newLock()

        assertFalse(lock.enabled.value)
        assertTrue(lock.isUnlocked.value)
        assertFalse(lock.isAvailable())
    }

    @Test
    fun lockFlag_isNotInUserPrefsOrBackups() = runBlocking {
        val lock = newLock()
        lock.setEnabled(true)
        val userPrefs = tempDataStore("user_prefs.preferences_pb")
        val repository = BackupRepository(db, userPrefs)

        val snapshot = repository.snapshot()
        repository.replaceAll(BackupSnapshot(emptyList(), emptyList(), emptyList(), emptyList(), emptyMap()))

        assertFalse(snapshot.preferences.containsKey("app_lock_enabled"))
        assertTrue(newLock().enabled.value)
    }

    @Test
    fun corruptLockFile_failsClosedWithoutCrashing() {
        val dir = Files.createTempDirectory("prefs").toFile()
        val file = File(dir, "lock_prefs.preferences_pb").apply { writeBytes(byteArrayOf(1, 2, 3, 120, 99, 42)) }
        val store = PreferenceDataStoreFactory.create(
            corruptionHandler = AppLock.corruptionHandler(),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { file }
        )

        val lock = AppLock(store, authenticator, ticker)

        assertTrue(lock.enabled.value)
        assertFalse(lock.isUnlocked.value)
    }

    private fun tempDataStore(fileName: String): DataStore<Preferences> {
        val dir = Files.createTempDirectory("prefs").toFile()
        return PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, fileName) }
        )
    }
}
