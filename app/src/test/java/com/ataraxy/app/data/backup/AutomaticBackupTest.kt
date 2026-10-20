package com.ataraxy.app.data.backup

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.ReflectionEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Files
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset

@RunWith(RobolectricTestRunner::class)
class AutomaticBackupTest {

    private val target = "content://docs/ataraxy-backup.json"
    private val now = Instant.parse("2026-10-20T08:00:00Z")

    private lateinit var db: AtaraxyDatabase
    private lateinit var repository: BackupRepository
    private lateinit var documents: FakeBackupDocuments
    private lateinit var settings: BackupSettingsRepository
    private lateinit var backup: AutomaticBackup

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        repository = BackupRepository(db, tempDataStore("user_prefs"))
        documents = FakeBackupDocuments()
        settings = BackupSettingsRepository(tempDataStore("backup_prefs"))
        backup = AutomaticBackup(repository, documents, settings, { 42L }, Clock.fixed(now, ZoneOffset.UTC))
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun run_withoutTarget_isDisabled() = runBlocking {
        assertEquals(BackupRunResult.DISABLED, backup.run())
        assertEquals(0, documents.writeCount)
    }

    @Test
    fun run_firstTime_writesBackupAndRecordsSuccess() = runBlocking {
        settings.setTarget(target)
        db.journalDao().upsert(entry(1, "first"))

        assertEquals(BackupRunResult.WRITTEN, backup.run())

        val written = BackupCodec.decode(documents.files.getValue(target))
        assertEquals(repository.snapshot(), written.snapshot)
        assertEquals(42L, written.appVersionCode)
        val state = settings.settings.first()
        assertEquals(now, state.lastSuccessAt)
        assertNotNull(state.lastWrittenHash)
        assertNull(state.failure)
    }

    @Test
    fun run_twiceWithoutChanges_writesOnce() = runBlocking {
        settings.setTarget(target)
        db.journalDao().upsert(entry(1, "first"))

        backup.run()
        assertEquals(BackupRunResult.UNCHANGED, backup.run())
        assertEquals(1, documents.writeCount)
    }

    @Test
    fun run_afterChange_writesAgain() = runBlocking {
        settings.setTarget(target)
        db.journalDao().upsert(entry(1, "first"))
        backup.run()

        db.journalDao().upsert(entry(2, "second"))

        assertEquals(BackupRunResult.WRITTEN, backup.run())
        assertEquals(2, documents.writeCount)
    }

    @Test
    fun run_emptyInstall_doesNotOverwriteExistingBackup() = runBlocking {
        val existing = BackupCodec.encode(
            BackupSnapshot(listOf(entry(1, "a"), entry(2, "b"), entry(3, "c")), emptyList(), emptyList(), emptyList(), emptyMap()),
            now,
            1L
        )
        documents.files[target] = existing
        settings.setTarget(target)

        assertEquals(BackupRunResult.BLOCKED_EXISTING_BACKUP, backup.run())

        assertEquals(existing, documents.files.getValue(target))
        assertEquals(0, documents.writeCount)
        assertEquals(BackupFailure.EXISTING_BACKUP, settings.settings.first().failure)
    }

    @Test
    fun run_afterThisInstallWrote_emptyJournalDoesOverwrite() = runBlocking {
        settings.setTarget(target)
        db.journalDao().upsert(entry(1, "first"))
        db.reflectionDao().insert(ReflectionEntity(id = 1, worry = "w", createdAt = "2026-10-01T09:00"))
        backup.run()

        db.journalDao().deleteAll()
        db.reflectionDao().deleteAll()

        assertEquals(BackupRunResult.WRITTEN, backup.run())
        assertEquals(false, BackupCodec.decode(documents.files.getValue(target)).snapshot.hasPrivateData)
    }

    @Test
    fun run_whenAccessLost_recordsNoAccess() = runBlocking {
        settings.setTarget(target)
        db.journalDao().upsert(entry(1, "first"))

        documents.failWith = SecurityException("revoked")
        assertEquals(BackupRunResult.FAILED, backup.run())
        assertEquals(BackupFailure.NO_ACCESS, settings.settings.first().failure)

        settings.setTarget(target)
        documents.failWith = FileNotFoundException("gone")
        assertEquals(BackupRunResult.FAILED, backup.run())
        assertEquals(BackupFailure.NO_ACCESS, settings.settings.first().failure)
    }

    @Test
    fun setTarget_clearsHashAndFailure() = runBlocking {
        settings.setTarget(target)
        settings.recordSuccess(now, "abc")
        settings.recordFailure(BackupFailure.UNKNOWN)

        settings.setTarget("content://docs/other.json")

        assertEquals(BackupSettings(targetUri = "content://docs/other.json"), settings.settings.first())
    }

    private fun entry(id: Long, content: String) = JournalEntryEntity(
        id = id, createdAt = "2026-10-01T08:00", updatedAt = "2026-10-01T08:00",
        content = content, promptText = "prompt", linkedQuoteId = null, virtueId = null
    )

    private fun tempDataStore(name: String): DataStore<Preferences> {
        val dir = Files.createTempDirectory("prefs").toFile()
        return PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, "$name.preferences_pb") }
        )
    }
}
