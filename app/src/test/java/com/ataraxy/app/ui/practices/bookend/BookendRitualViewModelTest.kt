package com.ataraxy.app.ui.practices.bookend

import androidx.lifecycle.SavedStateHandle
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.domain.model.AppTheme
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
import com.ataraxy.app.testing.testUserPrefs

@RunWith(RobolectricTestRunner::class)
class BookendRitualViewModelTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var prefs: UserPrefsRepository
    private lateinit var viewModel: BookendRitualViewModel

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        prefs = testUserPrefs()
        viewModel = viewModel(SavedStateHandle())
    }

    private fun viewModel(handle: SavedStateHandle) =
        BookendRitualViewModel(handle, JournalRepository(db.journalDao()), prefs).also { vm ->
            awaitMain { !vm.uiState.value.isLoading }
        }

    @After
    fun tearDown() = db.close()

    @Test
    fun chosenSession_survivesLaterPreferenceChanges() {
        val detected = viewModel.uiState.value.session
        val chosen = if (detected == RitualSession.EVENING) RitualSession.MORNING else RitualSession.EVENING
        viewModel.setSession(chosen)

        runBlocking {
            prefs.setTheme(AppTheme.DARK)
            prefs.userPrefs.first { it.theme == AppTheme.DARK }
        }
        settleMain()

        assertEquals(chosen, viewModel.uiState.value.session)
    }

    @Test
    fun sessionAndAnswers_areRestoredFromSavedState() {
        val prompt = BookendRitualViewModel.EVENING_PROMPTS.first()
        val handle = SavedStateHandle()
        val first = viewModel(handle)
        first.setSession(RitualSession.EVENING)
        first.updateAnswer(prompt, "Kept my temper")
        settleMain()

        val restored = viewModel(handle)

        assertEquals(RitualSession.EVENING, restored.uiState.value.session)
        assertEquals("Kept my temper", restored.uiState.value.answers[prompt])
    }
}
