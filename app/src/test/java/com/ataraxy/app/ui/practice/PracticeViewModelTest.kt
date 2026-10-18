package com.ataraxy.app.ui.practice

import androidx.lifecycle.SavedStateHandle
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.AuthorEntity
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.QuoteEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.testing.awaitMain
import com.ataraxy.app.testing.settleMain
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.LocalDateTime

@RunWith(RobolectricTestRunner::class)
class PracticeViewModelTest {

    private lateinit var db: AtaraxyDatabase

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        runBlocking {
            db.authorDao().insertAuthors(listOf(AuthorEntity("marcus", "Marcus Aurelius", "", "", "")))
            db.quoteDao().insertQuotes(listOf(QuoteEntity("q1", "Quote one", "marcus", "Meditations", "WISDOM", 1)))
        }
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun editMode_prefillsDraftWithEntryContent() {
        val id = insertEntry("original")

        val viewModel = viewModel(SavedStateHandle(mapOf("entryId" to id)))

        awaitMain { viewModel.draft.value == "original" }
    }

    @Test
    fun editMode_keepsRestoredDraftInsteadOfEntryContent() {
        val id = insertEntry("original")

        val viewModel = viewModel(SavedStateHandle(mapOf("entryId" to id, "draft" to "edited")))
        settleMain()

        assertEquals("edited", viewModel.draft.value)
    }

    @Test
    fun savingEditedEntry_updatesItInPlace() {
        val id = insertEntry("original")
        val viewModel = viewModel(SavedStateHandle(mapOf("entryId" to id)))
        awaitMain { viewModel.draft.value == "original" }

        viewModel.updateDraft("revised")
        viewModel.saveEntry()
        awaitMain { viewModel.saveSuccess.value }

        val saved = runBlocking { db.journalDao().getAllEntries().first() }
        assertEquals(listOf(id to "revised"), saved.map { it.id to it.content })
    }

    @Test
    fun quoteArgument_loadsThatQuote() {
        val viewModel = viewModel(SavedStateHandle(mapOf("quoteId" to "q1")))

        awaitMain { viewModel.quote.value?.id == "q1" }
    }

    @Test
    fun savingNewEntry_storesItAndClearsDraft() {
        val viewModel = viewModel(SavedStateHandle())
        viewModel.updateDraft("A new reflection")

        viewModel.saveEntry()
        awaitMain { viewModel.saveSuccess.value }

        val saved = runBlocking { db.journalDao().getAllEntries().first() }
        assertEquals(listOf("A new reflection"), saved.map { it.content })
        assertEquals("", viewModel.draft.value)
    }

    private fun viewModel(handle: SavedStateHandle) = PracticeViewModel(
        handle,
        QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao()),
        JournalRepository(db.journalDao())
    )

    private fun insertEntry(content: String): Long = runBlocking {
        val now = LocalDateTime.now().toString()
        db.journalDao().upsert(JournalEntryEntity(0, now, now, content, "", null, null))
    }
}
