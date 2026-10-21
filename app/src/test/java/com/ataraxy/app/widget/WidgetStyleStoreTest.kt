package com.ataraxy.app.widget

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File
import java.nio.file.Files

class WidgetStyleStoreTest {

    private fun newStore(): WidgetStyleStore {
        val dir = Files.createTempDirectory("widget").toFile()
        val dataStore = PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, "widget_prefs.preferences_pb") }
        )
        return WidgetStyleStore(dataStore)
    }

    @Test fun store_defaultsToMatchApp_andRemovesDeleted() = runBlocking {
        val store = newStore()
        assertEquals(WidgetStyle.MATCH_APP, store.get(7))

        assertFalse(store.has(7))
        store.set(7, WidgetStyle.DARK)
        assertTrue(store.has(7))
        store.set(8, WidgetStyle.CLEAR)
        assertEquals(WidgetStyle.DARK, store.get(7))
        assertEquals(WidgetStyle.CLEAR, store.get(8))

        store.remove(intArrayOf(7))
        assertEquals(WidgetStyle.MATCH_APP, store.get(7))
        assertEquals(WidgetStyle.CLEAR, store.get(8))
    }
}
