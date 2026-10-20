package com.ataraxy.app.data.backup

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BackupPrefs

enum class BackupFailure { NO_ACCESS, EXISTING_BACKUP, UNKNOWN }

data class BackupSettings(
    val targetUri: String? = null,
    val lastSuccessAt: Instant? = null,
    val lastWrittenHash: String? = null,
    val failure: BackupFailure? = null,
    /** The file automatic backup refused to overwrite because it already held a backup. */
    val blockedTarget: String? = null,
    /** The file the user agreed to overwrite despite the backup it holds, until the next write to it. */
    val overwriteConsent: String? = null
)

@Singleton
class BackupSettingsRepository @Inject constructor(
    @BackupPrefs private val dataStore: DataStore<Preferences>
) {
    private object Keys {
        val TARGET_URI = stringPreferencesKey("target_uri")
        val LAST_SUCCESS_AT = stringPreferencesKey("last_success_at")
        val LAST_WRITTEN_HASH = stringPreferencesKey("last_written_hash")
        val FAILURE = stringPreferencesKey("failure")
        val BLOCKED_TARGET = stringPreferencesKey("blocked_target")
        val OVERWRITE_CONSENT = stringPreferencesKey("overwrite_consent")
    }

    val settings: Flow<BackupSettings> = dataStore.data.map { prefs ->
        BackupSettings(
            targetUri = prefs[Keys.TARGET_URI],
            lastSuccessAt = prefs[Keys.LAST_SUCCESS_AT]?.let(Instant::parse),
            lastWrittenHash = prefs[Keys.LAST_WRITTEN_HASH],
            failure = prefs[Keys.FAILURE]?.let { name -> BackupFailure.entries.firstOrNull { it.name == name } },
            blockedTarget = prefs[Keys.BLOCKED_TARGET],
            overwriteConsent = prefs[Keys.OVERWRITE_CONSENT]
        )
    }

    suspend fun setTarget(uri: String?) {
        dataStore.edit { prefs ->
            prefs.remove(Keys.LAST_WRITTEN_HASH)
            prefs.remove(Keys.LAST_SUCCESS_AT)
            prefs.remove(Keys.FAILURE)
            prefs.remove(Keys.BLOCKED_TARGET)
            prefs.remove(Keys.OVERWRITE_CONSENT)
            if (uri == null) prefs.remove(Keys.TARGET_URI) else prefs[Keys.TARGET_URI] = uri
        }
    }

    /** Records a write to [target]; ignored if the user has since chosen another file. */
    suspend fun recordSuccess(target: String, at: Instant, hash: String) {
        dataStore.edit { prefs ->
            if (prefs[Keys.TARGET_URI] != target) return@edit
            prefs[Keys.LAST_SUCCESS_AT] = at.toString()
            prefs[Keys.LAST_WRITTEN_HASH] = hash
            prefs.remove(Keys.FAILURE)
            prefs.remove(Keys.OVERWRITE_CONSENT)
        }
    }

    suspend fun recordFailure(failure: BackupFailure) {
        dataStore.edit { it[Keys.FAILURE] = failure.name }
    }

    /** Stops automatic backup from writing to [target] until the user decides what to do with it. */
    suspend fun recordBlocked(target: String) {
        dataStore.edit { prefs ->
            if (prefs[Keys.TARGET_URI] != target) return@edit
            prefs[Keys.FAILURE] = BackupFailure.EXISTING_BACKUP.name
            prefs[Keys.BLOCKED_TARGET] = target
        }
    }

    suspend fun clearBlock() {
        dataStore.edit { prefs ->
            prefs.remove(Keys.BLOCKED_TARGET)
            prefs.remove(Keys.FAILURE)
        }
    }

    /** Lets automatic backup replace the backup [target] holds, however empty this install is. */
    suspend fun grantOverwrite(target: String) {
        dataStore.edit { prefs ->
            if (prefs[Keys.TARGET_URI] != target) return@edit
            prefs[Keys.OVERWRITE_CONSENT] = target
        }
    }
}
