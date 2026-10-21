package com.ataraxy.app.ui.entry

import androidx.lifecycle.SavedStateHandle
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.AuthorEntity
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.QuoteEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.testing.awaitMain
import com.ataraxy.app.ui.navigation.LOCKED_ROUTES
import com.ataraxy.app.ui.navigation.Screen
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class EntryViewModelTest {

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
    fun practiceEntry_showsItAndItsLinkedQuote() {
        val id = insert("2026-09-20T08:00:00", "What weighs on you?", "Too much work", linkedQuoteId = "q1")

        val vm = viewModel(id)
        awaitMain { vm.state.value is EntryUiState.Shown }

        val shown = vm.state.value as EntryUiState.Shown
        assertEquals(listOf("Too much work"), shown.session.entries.map { it.content })
        assertEquals("Quote one", shown.quote?.text)
        assertEquals("Marcus Aurelius", shown.quote?.authorName)
    }

    @Test
    fun ritualAnswer_showsTheWholeSessionInOrder() {
        val first = insert("2026-09-20T07:00:00", "Intention?", "Be patient", ritualType = "morning")
        val second = insert("2026-09-20T07:00:00", "Obstacle?", "Traffic", ritualType = "morning")
        insert("2026-09-20T21:00:00", "Review?", "Fine", ritualType = "evening")

        val vm = viewModel(second)
        awaitMain { vm.state.value is EntryUiState.Shown }

        val shown = vm.state.value as EntryUiState.Shown
        assertEquals(listOf(first, second), shown.session.entries.map { it.id })
        assertNull(shown.quote)
    }

    @Test
    fun deletedEntry_showsMissing() {
        val id = insert("2026-09-20T08:00:00", "Prompt", "Text")
        val vm = viewModel(id)
        awaitMain { vm.state.value is EntryUiState.Shown }

        runBlocking { db.journalDao().deleteAll() }

        awaitMain { vm.state.value is EntryUiState.Missing }
        assertTrue(vm.state.value is EntryUiState.Missing)
    }

    @Test
    fun lockedRoutes_includeTheEntryView() {
        assertTrue(Screen.Entry.ROUTE in LOCKED_ROUTES)
    }

    private fun viewModel(id: Long) = EntryViewModel(
        SavedStateHandle(mapOf("entryId" to id)),
        JournalRepository(db.journalDao()),
        QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao())
    )

    private fun insert(
        createdAt: String,
        prompt: String,
        content: String,
        linkedQuoteId: String? = null,
        ritualType: String? = null
    ): Long = runBlocking {
        db.journalDao().upsert(JournalEntryEntity(0, createdAt, createdAt, content, prompt, linkedQuoteId, null, ritualType))
    }
}
