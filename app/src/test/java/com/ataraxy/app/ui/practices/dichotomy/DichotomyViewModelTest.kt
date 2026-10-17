package com.ataraxy.app.ui.practices.dichotomy

import androidx.lifecycle.SavedStateHandle
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.ControlItemRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.testing.settleMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DichotomyViewModelTest {

    private lateinit var db: AtaraxyDatabase

    @Before
    fun setUp() {
        db = inMemoryDatabase()
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun drafts_areRestoredFromSavedState() {
        val handle = SavedStateHandle()
        val first = viewModel(handle)
        first.updateInputText("The traffic")
        first.promptActionStep(7)
        first.updateActionStepText("Leave earlier")
        settleMain()

        val restored = viewModel(handle).uiState.value

        assertEquals("The traffic", restored.inputText)
        assertEquals(7L, restored.actionStepPromptItemId)
        assertEquals("Leave earlier", restored.actionStepText)
    }

    private fun viewModel(handle: SavedStateHandle) = DichotomyViewModel(
        handle,
        ControlItemRepository(db.controlItemDao()),
        QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao())
    )
}
