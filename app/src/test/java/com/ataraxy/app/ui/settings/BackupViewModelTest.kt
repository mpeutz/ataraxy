package com.ataraxy.app.ui.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.test.core.app.ApplicationProvider
import androidx.work.Configuration
import androidx.work.testing.SynchronousExecutor
import androidx.work.testing.WorkManagerTestInitHelper
import com.ataraxy.app.R
import com.ataraxy.app.data.backup.AutomaticBackupController
import com.ataraxy.app.data.backup.BackupCodec
import com.ataraxy.app.data.backup.BackupRepository
import com.ataraxy.app.data.backup.BackupSettingsRepository
import com.ataraxy.app.data.backup.FakeBackupDocuments
import com.ataraxy.app.data.backup.RestoreBackup
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.testing.awaitMain
import com.ataraxy.app.testing.settleMain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.nio.file.Files
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset
import java.util.Collections

@RunWith(RobolectricTestRunner::class)
class BackupViewModelTest {

    private val uri = "content://docs/ataraxy-backup.json"
    private val now = Instant.parse("2026-10-20T08:00:00Z")

    private lateinit var db: AtaraxyDatabase
    private lateinit var backupRepository: BackupRepository
    private lateinit var documents: FakeBackupDocuments
    private lateinit var settings: BackupSettingsRepository
    private lateinit var viewModel: BackupViewModel
    private val events = Collections.synchronizedList(mutableListOf<BackupEvent>())

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        WorkManagerTestInitHelper.initializeTestWorkManager(
            context,
            Configuration.Builder().setExecutor(SynchronousExecutor()).build()
        )
        db = inMemoryDatabase()
        val userPrefsStore = tempDataStore("user_prefs")
        backupRepository = BackupRepository(db, userPrefsStore)
        documents = FakeBackupDocuments()
        settings = BackupSettingsRepository(tempDataStore("backup_prefs"))
        val restore = RestoreBackup(documents, backupRepository, UserPrefsRepository(userPrefsStore)) { }
        viewModel = BackupViewModel(
            AutomaticBackupController(context, documents, settings),
            settings,
            documents,
            backupRepository,
            restore,
            { 42L },
            Clock.fixed(now, ZoneOffset.UTC)
        )
        CoroutineScope(Dispatchers.Default + SupervisorJob()).launch { viewModel.events.collect { events += it } }
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun turnOn_enablesAndShowsPending() {
        viewModel.turnOn(uri)
        awaitMain { viewModel.state.value.enabled }

        val state = viewModel.state.value
        assertEquals("ataraxy-backup.json", state.locationName)
        assertNull(state.lastSuccessAt)
        assertNull(state.failure)
    }

    @Test
    fun turnOn_whenWriteCantBeKept_emitsFailed() {
        documents.persistResult = false

        viewModel.turnOn(uri)
        awaitMain { events.isNotEmpty() }

        assertEquals(BackupEvent.Failed(R.string.settings_backup_failed_access), events.single())
        assertFalse(viewModel.state.value.enabled)
    }

    @Test
    fun turnOff_releasesFileAndDisables() {
        viewModel.turnOn(uri)
        awaitMain { viewModel.state.value.enabled }

        viewModel.turnOff()
        awaitMain { !viewModel.state.value.enabled }

        assertEquals(listOf(uri), documents.released)
    }

    @Test
    fun previewRestore_thenConfirm_restoresAndOffersKeepUpdating() {
        runBlocking { db.journalDao().upsert(entry(1, "from backup")) }
        documents.files[uri] = BackupCodec.encode(runBlocking { backupRepository.snapshot() }, now, 7L)
        runBlocking { db.journalDao().upsert(entry(2, "added later")) }

        viewModel.previewRestore(uri)
        awaitMain { viewModel.pendingRestore.value != null }
        val pending = viewModel.pendingRestore.value!!
        assertEquals(uri, pending.uri)
        assertEquals(1, pending.preview.journalEntryCount)

        viewModel.confirmRestore()
        awaitMain { viewModel.offerKeepUpdating.value != null }

        assertEquals(uri, viewModel.offerKeepUpdating.value)
        assertEquals(listOf<BackupEvent>(BackupEvent.Restored), events.toList())
        assertNull(viewModel.pendingRestore.value)
        assertEquals(1, runBlocking { backupRepository.snapshot().journalEntries.size })
    }

    @Test
    fun previewRestore_badFile_emitsNotBackup() {
        documents.files[uri] = "not a backup"

        viewModel.previewRestore(uri)
        awaitMain { events.isNotEmpty() }

        assertEquals(BackupEvent.Failed(R.string.settings_restore_not_backup), events.single())
        assertNull(viewModel.pendingRestore.value)
    }

    @Test
    fun backUpNow_writesFileWithoutChangingAutomatic() {
        val oneOff = "content://docs/ataraxy-backup-2026-10-20.json"
        runBlocking { db.journalDao().upsert(entry(1, "keep me")) }

        viewModel.backUpNow(oneOff)
        awaitMain { events.isNotEmpty() }
        settleMain()

        assertEquals(listOf<BackupEvent>(BackupEvent.Saved), events.toList())
        val decoded = BackupCodec.decode(documents.files.getValue(oneOff))
        assertEquals(1, decoded.snapshot.journalEntries.size)
        assertEquals(now, decoded.createdAt)
        assertNull(runBlocking { settings.settings.first().targetUri })
        assertFalse(viewModel.state.value.enabled)
        assertNotNull(viewModel.manualBackupFileName())
        assertTrue(viewModel.manualBackupFileName().endsWith("2026-10-20.json"))
    }

    private fun entry(id: Long, content: String) = JournalEntryEntity(
        id = id, createdAt = "2026-10-01T08:00", updatedAt = "2026-10-01T08:00", content = content,
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
