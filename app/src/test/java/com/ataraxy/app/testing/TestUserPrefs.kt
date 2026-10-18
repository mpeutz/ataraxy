package com.ataraxy.app.testing

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.ataraxy.app.data.preferences.UserPrefsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import java.io.File
import java.nio.file.Files

/** A UserPrefsRepository backed by its own temporary file, so tests never share preferences. */
fun testUserPrefs(): UserPrefsRepository {
    val dir = Files.createTempDirectory("prefs").toFile()
    val dataStore = PreferenceDataStoreFactory.create(
        scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
        produceFile = { File(dir, "user_prefs.preferences_pb") }
    )
    return UserPrefsRepository(dataStore)
}
