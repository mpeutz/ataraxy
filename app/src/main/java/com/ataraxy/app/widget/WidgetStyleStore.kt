package com.ataraxy.app.widget

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WidgetPrefs

class WidgetStyleStore @Inject constructor(
    @WidgetPrefs private val dataStore: DataStore<Preferences>
) {
    suspend fun get(id: Int): WidgetStyle {
        val stored = dataStore.data.first()[key(id)]
        return WidgetStyle.entries.firstOrNull { it.name == stored } ?: WidgetStyle.MATCH_APP
    }

    suspend fun has(id: Int): Boolean = dataStore.data.first().contains(key(id))

    suspend fun set(id: Int, style: WidgetStyle) {
        dataStore.edit { it[key(id)] = style.name }
    }

    suspend fun remove(ids: IntArray) {
        dataStore.edit { prefs -> ids.forEach { prefs.remove(key(it)) } }
    }

    private fun key(id: Int) = stringPreferencesKey("style_$id")
}
