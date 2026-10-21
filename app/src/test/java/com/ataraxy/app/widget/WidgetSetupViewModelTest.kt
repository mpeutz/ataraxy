package com.ataraxy.app.widget

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.core.DataStore
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.QuoteRepository
import android.appwidget.AppWidgetProviderInfo
import android.content.ComponentName
import com.ataraxy.app.testing.awaitMain
import com.ataraxy.app.testing.settleMain
import com.ataraxy.app.testing.testUserPrefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.nio.file.Files

@RunWith(RobolectricTestRunner::class)
class WidgetSetupViewModelTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var store: WidgetStyleStore
    private var updates = 0

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        val dir = Files.createTempDirectory("widget").toFile()
        val dataStore: DataStore<Preferences> = PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, "widget_prefs.preferences_pb") }
        )
        store = WidgetStyleStore(dataStore)
        updates = 0
    }

    @After
    fun tearDown() = db.close()

    private fun viewModel() = WidgetSetupViewModel(
        store = store,
        updater = { updates++ },
        quotes = QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao()),
        prefs = testUserPrefs()
    )

    @Test fun defaultsToMatchApp_andListsAccentOnlyOn31() {
        val viewModel = viewModel()
        viewModel.load(3)
        awaitMain { viewModel.loaded.value }

        assertEquals(WidgetStyle.MATCH_APP, viewModel.selected.value)
        assertFalse(viewModel.alreadyAdded.value)
        assertTrue(WidgetStyle.ACCENT in viewModel.styles)
        assertFalse(WidgetStyle.ACCENT in availableStyles(30))
    }

    @Test fun select_thenSave_storesStyleForThatWidget() {
        val viewModel = viewModel()
        viewModel.load(4)
        awaitMain { viewModel.loaded.value }
        viewModel.select(WidgetStyle.CLEAR)
        viewModel.save(4)
        awaitMain { viewModel.saved.value }

        runBlocking {
            assertEquals(WidgetStyle.CLEAR, store.get(4))
            assertEquals(WidgetStyle.MATCH_APP, store.get(5))
        }
        assertEquals(1, updates)
    }

    @Test fun concurrentSaves_storeAndUpdateOnce() {
        val viewModel = viewModel()
        viewModel.load(4)
        awaitMain { viewModel.loaded.value }
        viewModel.select(WidgetStyle.DARK)
        viewModel.save(4)
        viewModel.save(4)
        awaitMain { viewModel.saved.value }
        settleMain()

        assertEquals(1, updates)
        assertTrue(viewModel.saving.value)
    }

    @Test fun selectingBeforeLoad_isIgnored() {
        val viewModel = viewModel()
        viewModel.select(WidgetStyle.CLEAR)

        assertEquals(WidgetStyle.MATCH_APP, viewModel.selected.value)
    }

    @Test fun isOurWidget_acceptsOnlyOurProvider() {
        val ours = AppWidgetProviderInfo().apply {
            provider = ComponentName("com.ataraxy.app", QuoteWidgetProvider::class.java.name)
        }
        val other = AppWidgetProviderInfo().apply { provider = ComponentName("com.other", "com.other.Provider") }

        assertFalse(isOurWidget(null, QuoteWidgetProvider::class.java))
        assertFalse(isOurWidget(other, QuoteWidgetProvider::class.java))
        assertTrue(isOurWidget(ours, QuoteWidgetProvider::class.java))
    }

    @Test fun reopening_showsTheStoredStyle() {
        runBlocking { store.set(6, WidgetStyle.DARK) }
        val viewModel = viewModel()
        viewModel.load(6)
        awaitMain { viewModel.loaded.value }

        assertEquals(WidgetStyle.DARK, viewModel.selected.value)
        assertTrue(viewModel.alreadyAdded.value)
    }

    @Test fun reopening_withDefaultStored_countsAsAdded() {
        runBlocking { store.set(6, WidgetStyle.MATCH_APP) }
        val viewModel = viewModel()
        viewModel.load(6)
        awaitMain { viewModel.loaded.value }

        assertTrue(viewModel.alreadyAdded.value)
    }

    @Test fun cancel_storesNothing() = runBlocking {
        val viewModel = viewModel()
        viewModel.select(WidgetStyle.LIGHT)

        assertEquals(WidgetStyle.MATCH_APP, store.get(9))
        assertFalse(store.has(9))
        assertEquals(0, updates)
    }
}
