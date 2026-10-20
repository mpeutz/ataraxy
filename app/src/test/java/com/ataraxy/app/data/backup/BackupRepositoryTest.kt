package com.ataraxy.app.data.backup

import android.database.sqlite.SQLiteConstraintException
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.AuthorEntity
import com.ataraxy.app.data.local.entity.BookmarkEntity
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.QuoteEntity
import com.ataraxy.app.data.local.entity.ReflectionEntity
import com.ataraxy.app.data.local.entity.ReflectionNoteEntity
import com.ataraxy.app.data.local.entity.ReflectionWithNotes
import com.ataraxy.app.data.local.entity.SosEventEntity
import com.ataraxy.app.data.local.entity.VirtueEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.domain.model.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.nio.file.Files

@RunWith(RobolectricTestRunner::class)
class BackupRepositoryTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var dataStore: DataStore<Preferences>
    private lateinit var prefs: UserPrefsRepository
    private lateinit var repository: BackupRepository

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        dataStore = tempDataStore()
        prefs = UserPrefsRepository(dataStore)
        repository = BackupRepository(db, dataStore)
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun snapshot_includesAllPrivateTablesAndPrefs() = runBlocking {
        seedPrivateData()
        prefs.setTheme(AppTheme.DARK)
        prefs.setBirthYear(1980)

        val snapshot = repository.snapshot()

        assertEquals(listOf(entry(7, "first")), snapshot.journalEntries)
        assertEquals(listOf(reflection(3, "worry", 11)), snapshot.reflections)
        assertEquals(listOf(BookmarkEntity("q1", "2026-10-01")), snapshot.bookmarks)
        assertEquals(listOf(SosEventEntity(5, "anger", "q1", "2026-10-02")), snapshot.sosEvents)
        assertEquals(PrefValue.StringValue("DARK"), snapshot.preferences["theme"])
        assertEquals(PrefValue.IntValue(1980), snapshot.preferences["birth_year"])
    }

    @Test
    fun replaceAll_leavesSeededContentAlone() = runBlocking {
        db.authorDao().insertAuthors(listOf(AuthorEntity("a1", "Seneca", "", "", "")))
        db.virtueDao().insertVirtues(listOf(VirtueEntity("v1", "Wisdom", "", "", "", "")))
        db.quoteDao().insertQuotes(listOf(QuoteEntity("q1", "text", "a1", "", "v1", null)))

        repository.replaceAll(emptySnapshot())

        assertEquals(1, db.quoteDao().count())
        assertEquals(1, db.virtueDao().count())
    }

    @Test
    fun replaceAll_replacesEverything() = runBlocking {
        seedPrivateData()
        prefs.setTheme(AppTheme.DARK)
        val incoming = BackupSnapshot(
            journalEntries = listOf(entry(20, "restored")),
            reflections = listOf(reflection(30, "restored worry", 40)),
            bookmarks = listOf(BookmarkEntity("q9", "2026-09-01")),
            sosEvents = listOf(SosEventEntity(50, "fear", "q9", "2026-09-02")),
            preferences = mapOf("birth_year" to PrefValue.IntValue(1975))
        )

        repository.replaceAll(incoming)

        val restored = repository.snapshot()
        assertEquals(incoming.journalEntries, restored.journalEntries)
        assertEquals(incoming.reflections, restored.reflections)
        assertEquals(incoming.bookmarks, restored.bookmarks)
        assertEquals(incoming.sosEvents, restored.sosEvents)
        assertEquals(incoming.preferences, restored.preferences)
    }

    @Test
    fun replaceAll_keepsUnknownPrefKeys() = runBlocking {
        val incoming = emptySnapshot().copy(
            preferences = mapOf("future_key" to PrefValue.StringValue("x"))
        )

        repository.replaceAll(incoming)

        assertEquals("x", dataStore.data.first()[stringPreferencesKey("future_key")])
    }

    @Test
    fun replaceAll_isAllOrNothingForTheDatabase() = runBlocking {
        seedPrivateData()
        val broken = emptySnapshot().copy(
            journalEntries = listOf(entry(1, "a"), entry(1, "b"))
        )

        assertThrows(SQLiteConstraintException::class.java) {
            runBlocking { repository.replaceAll(broken) }
        }

        assertEquals(listOf(entry(7, "first")), repository.snapshot().journalEntries)
        assertTrue(repository.snapshot().reflections.isNotEmpty())
    }

    private suspend fun seedPrivateData() {
        db.backupDao().insertJournalEntries(listOf(entry(7, "first")))
        val withNotes = reflection(3, "worry", 11)
        db.backupDao().insertReflections(listOf(withNotes.reflection))
        db.backupDao().insertReflectionNotes(withNotes.notes)
        db.backupDao().insertBookmarks(listOf(BookmarkEntity("q1", "2026-10-01")))
        db.backupDao().insertSosEvents(listOf(SosEventEntity(5, "anger", "q1", "2026-10-02")))
    }

    private fun entry(id: Long, content: String) = JournalEntryEntity(
        id = id, createdAt = "2026-10-01T08:00", updatedAt = "2026-10-01T08:00",
        content = content, promptText = "prompt", linkedQuoteId = null, virtueId = null
    )

    private fun reflection(id: Long, worry: String, noteId: Long) = ReflectionWithNotes(
        reflection = ReflectionEntity(id = id, worry = worry, createdAt = "2026-10-01T09:00"),
        notes = listOf(ReflectionNoteEntity(noteId, id, "a note", "2026-10-01T10:00"))
    )

    private fun emptySnapshot() = BackupSnapshot(emptyList(), emptyList(), emptyList(), emptyList(), emptyMap())

    private fun tempDataStore(): DataStore<Preferences> {
        val dir = Files.createTempDirectory("prefs").toFile()
        return PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, "user_prefs.preferences_pb") }
        )
    }
}
