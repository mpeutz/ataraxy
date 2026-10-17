package com.ataraxy.wear.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ataraxy.wear.domain.ReceivedQuote
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.wearDataStore: DataStore<Preferences> by preferencesDataStore(name = "wear_quote")

@Singleton
class WearQuoteStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private val KEY_QUOTE_ID = stringPreferencesKey("quote_id")
        private val KEY_QUOTE_TEXT = stringPreferencesKey("quote_text")
        private val KEY_AUTHOR_NAME = stringPreferencesKey("author_name")
    }

    val quote: Flow<ReceivedQuote?> = context.wearDataStore.data.map { prefs ->
        val text = prefs[KEY_QUOTE_TEXT] ?: return@map null
        val author = prefs[KEY_AUTHOR_NAME] ?: return@map null
        val id = prefs[KEY_QUOTE_ID] ?: return@map null
        ReceivedQuote(id = id, text = text, authorName = author)
    }

    suspend fun save(id: String, text: String, authorName: String) {
        context.wearDataStore.edit { prefs ->
            prefs[KEY_QUOTE_ID] = id
            prefs[KEY_QUOTE_TEXT] = text
            prefs[KEY_AUTHOR_NAME] = authorName
        }
    }
}
