package com.ataraxy.app.data.backup

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.ReflectionEntity
import com.ataraxy.app.data.local.entity.ReflectionNoteEntity
import com.ataraxy.app.data.local.entity.ReflectionWithNotes
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.domain.model.UserPrefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.time.Instant
import java.time.LocalTime

@RunWith(RobolectricTestRunner::class)
class RestoreBackupTest {

    private val uri = "content://docs/ataraxy-backup.json"
    private val createdAt = Instant.parse("2026-10-20T08:00:00Z")

    private lateinit var db: AtaraxyDatabase
    private lateinit var repository: BackupRepository
    private lateinit var prefs: UserPrefsRepository
    private lateinit var documents: FakeBackupDocuments
    private val rescheduled = mutableListOf<UserPrefs>()
    private lateinit var restore: RestoreBackup

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        val dataStore = tempDataStore()
        repository = BackupRepository(db, dataStore)
        prefs = UserPrefsRepository(dataStore)
        documents = FakeBackupDocuments()
        restore = RestoreBackup(documents, repository, prefs, { rescheduled += it }, BackupLock())
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun preview_countsEntriesAndReflections() = runBlocking {
        documents.files[uri] = encodedBackup()

        val preview = restore.preview(uri).getOrThrow()

        assertEquals(BackupPreview(createdAt, journalEntryCount = 4, reflectionCount = 1), preview)
    }

    @Test
    fun restore_replacesDataAndReschedules() = runBlocking {
        seedLocal()
        documents.files[uri] = encodedBackup()

        restore.restore(uri).getOrThrow()

        val restored = repository.snapshot()
        assertEquals(backupSnapshot().journalEntries, restored.journalEntries)
        assertEquals(backupSnapshot().reflections, restored.reflections)
        assertEquals(backupSnapshot().preferences, restored.preferences)
        assertEquals(1, rescheduled.size)
        assertEquals(LocalTime.of(6, 30), rescheduled.single().morningRitualTime)
    }

    @Test
    fun restore_badFile_changesNothing() = runBlocking {
        val before = seedLocal()
        val texts = listOf(
            "not json",
            encodedBackup().let { it.take(it.length / 2) },
            "Ataraxy journal export\n\n2026-10-01  A thought about the day."
        )

        texts.forEach { text ->
            documents.files[uri] = text
            assertProblem(RestoreProblem.NOT_A_BACKUP, restore.restore(uri))
            assertProblem(RestoreProblem.NOT_A_BACKUP, restore.preview(uri))
        }

        assertEquals(before, repository.snapshot())
        assertTrue(rescheduled.isEmpty())
    }

    @Test
    fun restore_oddButParseableFile_isNotABackup() = runBlocking {
        val before = seedLocal()
        documents.files[uri] = encodedBackup().replace("\"createdAt\":\"2026-10-20T08:00:00Z\"", "\"createdAt\":5")

        assertProblem(RestoreProblem.NOT_A_BACKUP, restore.restore(uri))

        assertEquals(before, repository.snapshot())
        assertTrue(rescheduled.isEmpty())
    }

    @Test
    fun restore_newerVersion_changesNothing() = runBlocking {
        val before = seedLocal()
        documents.files[uri] = encodedBackup().replace("\"formatVersion\":1", "\"formatVersion\":99")

        assertProblem(RestoreProblem.NEWER_VERSION, restore.restore(uri))

        assertEquals(before, repository.snapshot())
        assertTrue(rescheduled.isEmpty())
    }

    @Test
    fun restore_unreadableFile_reportsNoAccess() = runBlocking {
        documents.failReadWith = SecurityException("revoked")
        assertProblem(RestoreProblem.NO_ACCESS, restore.restore(uri))

        documents.failReadWith = IOException("gone")
        assertProblem(RestoreProblem.NO_ACCESS, restore.preview(uri))
    }

    @Test
    fun restore_missingFile_reportsNoAccess() = runBlocking {
        assertProblem(RestoreProblem.NO_ACCESS, restore.restore(uri))
        assertProblem(RestoreProblem.NO_ACCESS, restore.preview(uri))
    }

    @Test
    fun restore_deeplyNestedFile_isNotABackup() = runBlocking {
        val before = seedLocal()
        documents.files[uri] = "[".repeat(100_000)

        assertProblem(RestoreProblem.NOT_A_BACKUP, restore.restore(uri))
        assertProblem(RestoreProblem.NOT_A_BACKUP, restore.preview(uri))

        assertEquals(before, repository.snapshot())
    }

    @Test
    fun restore_tooLargeFile_isNotABackup() = runBlocking {
        val before = seedLocal()
        documents.failReadWith = BackupTooLargeException()

        assertProblem(RestoreProblem.NOT_A_BACKUP, restore.restore(uri))
        assertProblem(RestoreProblem.NOT_A_BACKUP, restore.preview(uri))

        assertEquals(before, repository.snapshot())
    }

    private fun assertProblem(expected: RestoreProblem, result: Result<*>) {
        val error = result.exceptionOrNull() as? RestoreException
        assertEquals(expected, error?.problem)
    }

    private suspend fun seedLocal(): BackupSnapshot {
        db.journalDao().upsert(entry(99, "local", "2026-09-01T08:00"))
        prefs.setTheme(AppTheme.DARK)
        return repository.snapshot()
    }

    private fun encodedBackup() = BackupCodec.encode(backupSnapshot(), createdAt, 7L)

    private fun backupSnapshot() = BackupSnapshot(
        journalEntries = listOf(
            entry(1, "practice", "2026-10-01T08:00"),
            entry(2, "a", "2026-10-02T21:00", "EVENING"),
            entry(3, "b", "2026-10-02T21:00", "EVENING"),
            entry(4, "c", "2026-10-02T21:00", "EVENING")
        ),
        reflections = listOf(
            ReflectionWithNotes(
                ReflectionEntity(id = 1, worry = "w", createdAt = "2026-10-01T09:00"),
                listOf(ReflectionNoteEntity(id = 1, reflectionId = 1, text = "n", createdAt = "2026-10-01T09:05"))
            )
        ),
        bookmarks = emptyList(),
        sosEvents = emptyList(),
        preferences = mapOf(
            "morning_ritual_hour" to PrefValue.IntValue(6),
            "morning_ritual_minute" to PrefValue.IntValue(30)
        )
    )

    private fun entry(id: Long, content: String, createdAt: String, ritualType: String? = null) =
        JournalEntryEntity(
            id = id, createdAt = createdAt, updatedAt = createdAt, content = content,
            promptText = "prompt", linkedQuoteId = null, virtueId = null, ritualType = ritualType
        )

    private fun tempDataStore(): DataStore<Preferences> {
        val dir = Files.createTempDirectory("prefs").toFile()
        return PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, "user_prefs.preferences_pb") }
        )
    }
}
