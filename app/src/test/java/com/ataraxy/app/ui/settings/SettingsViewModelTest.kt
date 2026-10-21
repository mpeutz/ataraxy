package com.ataraxy.app.ui.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.test.core.app.ApplicationProvider
import androidx.work.Configuration
import androidx.work.impl.WorkManagerImpl
import androidx.work.testing.SynchronousExecutor
import androidx.work.testing.WorkManagerTestInitHelper
import com.ataraxy.app.data.backup.AutomaticBackupController
import com.ataraxy.app.data.backup.BackupDocuments
import com.ataraxy.app.data.backup.BackupLock
import com.ataraxy.app.data.backup.BackupSettingsRepository
import com.ataraxy.app.data.backup.FakeBackupDocuments
import com.ataraxy.app.data.export.DownloadsWriter
import com.ataraxy.app.data.export.JournalExporter
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.data.repository.SosRepository
import com.ataraxy.app.lock.AppLock
import com.ataraxy.app.lock.FakeDeviceAuthenticator
import com.ataraxy.app.lock.FakeElapsedRealtime
import com.ataraxy.app.notifications.NotificationScheduler
import com.ataraxy.app.testing.awaitMain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.nio.file.Files

@RunWith(RobolectricTestRunner::class)
class SettingsViewModelTest {

    private val uri = "content://docs/ataraxy-backup.json"

    private lateinit var db: AtaraxyDatabase
    private lateinit var settings: BackupSettingsRepository
    private lateinit var lockStore: DataStore<Preferences>
    private lateinit var appLock: AppLock
    private lateinit var viewModel: SettingsViewModel
    private var journalEntriesWhenReleased: Int? = null
    private var lockEnabledWhenPrefsFirstWritten: Boolean? = null

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        WorkManagerTestInitHelper.initializeTestWorkManager(
            context,
            Configuration.Builder().setExecutor(SynchronousExecutor()).build()
        )
        db = inMemoryDatabase()
        settings = BackupSettingsRepository(tempDataStore("backup_prefs"))
        val fake = FakeBackupDocuments()
        val documents = object : BackupDocuments by fake {
            override fun release(uri: String) {
                journalEntriesWhenReleased = runBlocking { db.backupDao().journalEntries().size }
                fake.release(uri)
            }
        }
        val journal = JournalRepository(db.journalDao())
        val reflections = ReflectionRepository(db.reflectionDao())
        lockStore = tempDataStore("lock_prefs")
        appLock = AppLock(lockStore, FakeDeviceAuthenticator(), FakeElapsedRealtime())
        viewModel = SettingsViewModel(
            UserPrefsRepository(recordingLockOnWrite(tempDataStore("user_prefs"))),
            journal,
            NotificationScheduler(context),
            reflections,
            SosRepository(db.sosEventDao(), QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao())),
            JournalExporter(journal, reflections, object : DownloadsWriter {
                override suspend fun writeText(fileName: String, text: String) = Unit
            }),
            AutomaticBackupController(context, documents, settings, BackupLock()),
            appLock
        )
    }

    @After
    fun tearDown() {
        db.close()
        WorkManagerImpl.getInstance(ApplicationProvider.getApplicationContext()).workDatabase.close()
    }

    @Test
    fun deactivate_turnsOffAutomaticBackupBeforeDeletingAnything() {
        runBlocking {
            settings.setTarget(uri)
            db.journalDao().upsert(entry())
        }

        viewModel.deactivate()
        awaitMain { runBlocking { db.backupDao().journalEntries().isEmpty() } }

        assertEquals(1, journalEntriesWhenReleased)
        assertNull(runBlocking { settings.settings.first().targetUri })
    }

    @Test
    fun deactivate_turnsOffAppLock() {
        runBlocking { appLock.setEnabled(true) }

        viewModel.deactivate()
        awaitMain { !appLock.enabled.value }

        assertFalse(AppLock(lockStore, FakeDeviceAuthenticator(), FakeElapsedRealtime()).enabled.value)
    }

    @Test
    fun deactivate_turnsOffAppLockBeforeClearingPrefs() {
        runBlocking { appLock.setEnabled(true) }

        viewModel.deactivate()
        awaitMain { lockEnabledWhenPrefsFirstWritten != null }

        assertEquals(false, lockEnabledWhenPrefsFirstWritten)
    }

    private fun recordingLockOnWrite(delegate: DataStore<Preferences>) = object : DataStore<Preferences> {
        override val data = delegate.data

        override suspend fun updateData(transform: suspend (t: Preferences) -> Preferences): Preferences {
            if (lockEnabledWhenPrefsFirstWritten == null) lockEnabledWhenPrefsFirstWritten = appLock.enabled.value
            return delegate.updateData(transform)
        }
    }

    private fun entry() = JournalEntryEntity(
        id = 1, createdAt = "2026-10-01T08:00", updatedAt = "2026-10-01T08:00", content = "keep me",
        promptText = "prompt", linkedQuoteId = null, virtueId = null, ritualType = null
    )

    private fun tempDataStore(name: String): DataStore<Preferences> {
        val dir = Files.createTempDirectory("prefs").toFile()
        return PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, "$name.preferences_pb") }
        )
    }
}
