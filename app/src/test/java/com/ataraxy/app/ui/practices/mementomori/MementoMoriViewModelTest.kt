package com.ataraxy.app.ui.practices.mementomori

import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.QuoteRepository
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
class MementoMoriViewModelTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var prefs: UserPrefsRepository
    private lateinit var viewModel: MementoMoriViewModel

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        prefs = testUserPrefs()
        viewModel = MementoMoriViewModel(prefs, QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao()))
        awaitMain { !viewModel.uiState.value.isLoading }
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun typedBirthYear_isNotOverwrittenByLaterPreferenceChanges() {
        viewModel.updateBirthYearInput("19")

        runBlocking {
            prefs.setTheme(AppTheme.DARK)
            prefs.userPrefs.first { it.theme == AppTheme.DARK }
        }
        settleMain()

        assertEquals("19", viewModel.uiState.value.birthYearInput)
    }
}
