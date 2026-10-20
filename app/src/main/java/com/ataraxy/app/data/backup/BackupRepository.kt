package com.ataraxy.app.data.backup

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.room.withTransaction
import com.ataraxy.app.data.local.AtaraxyDatabase
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class BackupRepository @Inject constructor(
    private val db: AtaraxyDatabase,
    private val userPrefs: DataStore<Preferences>
) {

    suspend fun snapshot(): BackupSnapshot {
        val backupDao = db.backupDao()
        return BackupSnapshot(
            journalEntries = backupDao.journalEntries(),
            reflections = db.reflectionDao().getAll(),
            bookmarks = backupDao.bookmarks(),
            sosEvents = backupDao.sosEvents(),
            preferences = readPreferences()
        )
    }

    suspend fun replaceAll(snapshot: BackupSnapshot) {
        replaceTables(snapshot)
        userPrefs.edit { prefs ->
            prefs.clear()
            snapshot.preferences.forEach { (name, value) -> prefs.write(name, value) }
        }
    }

    private suspend fun replaceTables(snapshot: BackupSnapshot) {
        val backupDao = db.backupDao()
        db.withTransaction {
            backupDao.deleteJournalEntries()
            backupDao.deleteReflections()
            backupDao.deleteBookmarks()
            backupDao.deleteSosEvents()
            backupDao.insertJournalEntries(snapshot.journalEntries)
            backupDao.insertReflections(snapshot.reflections.map { it.reflection })
            backupDao.insertReflectionNotes(snapshot.reflections.flatMap { it.notes })
            backupDao.insertBookmarks(snapshot.bookmarks)
            backupDao.insertSosEvents(snapshot.sosEvents)
        }
    }

    private suspend fun readPreferences(): Map<String, PrefValue> =
        userPrefs.data.first().asMap().mapNotNull { (key, value) ->
            toPrefValue(value)?.let { key.name to it }
        }.toMap()

    private fun toPrefValue(value: Any): PrefValue? = when (value) {
        is Int -> PrefValue.IntValue(value)
        is Long -> PrefValue.LongValue(value)
        is Boolean -> PrefValue.BooleanValue(value)
        is String -> PrefValue.StringValue(value)
        else -> null
    }

    private fun MutablePreferences.write(name: String, value: PrefValue) {
        when (value) {
            is PrefValue.IntValue -> this[intPreferencesKey(name)] = value.value
            is PrefValue.LongValue -> this[longPreferencesKey(name)] = value.value
            is PrefValue.BooleanValue -> this[booleanPreferencesKey(name)] = value.value
            is PrefValue.StringValue -> this[stringPreferencesKey(name)] = value.value
        }
    }
}
