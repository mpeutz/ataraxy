package com.ataraxy.app.lock

import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import java.time.Duration
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LockPrefs

@Singleton
class AppLock @Inject constructor(
    @LockPrefs private val dataStore: DataStore<Preferences>,
    private val authenticator: DeviceAuthenticator,
    private val elapsedRealtime: ElapsedRealtime
) {
    @Volatile private var storedFlag = runBlocking { dataStore.data.first()[ENABLED_KEY] ?: false }
    @Volatile private var backgroundedAt: Long? = null

    private val _enabled = MutableStateFlow(storedFlag && authenticator.isDeviceSecure())
    val enabled: StateFlow<Boolean> = _enabled.asStateFlow()

    private val _isUnlocked = MutableStateFlow(!_enabled.value)
    val isUnlocked: StateFlow<Boolean> = _isUnlocked.asStateFlow()

    private val _relocks = MutableStateFlow(0)

    /** Counts relocks, including ones while already locked, so open confirmations can be dropped each time. */
    val relocks: StateFlow<Int> = _relocks.asStateFlow()

    fun isAvailable(): Boolean = authenticator.isDeviceSecure()

    suspend fun setEnabled(on: Boolean) {
        dataStore.edit { it[ENABLED_KEY] = on }
        storedFlag = on
        refreshEnabled()
        _isUnlocked.value = true
    }

    fun markUnlocked() {
        _isUnlocked.value = true
    }

    fun onBackgrounded() {
        backgroundedAt = elapsedRealtime.millis()
    }

    fun onForegrounded() {
        val since = backgroundedAt
        backgroundedAt = null
        refreshEnabled()
        if (!_enabled.value) {
            _isUnlocked.value = true
            return
        }
        if (since != null && elapsedRealtime.millis() - since >= RELOCK_AFTER.toMillis()) {
            _isUnlocked.value = false
            _relocks.update { it + 1 }
        }
    }

    private fun refreshEnabled() {
        _enabled.value = storedFlag && authenticator.isDeviceSecure()
    }

    companion object {
        val RELOCK_AFTER: Duration = Duration.ofSeconds(60)
        private val ENABLED_KEY = booleanPreferencesKey("app_lock_enabled")

        /** A corrupt file fails closed: the lock stays on (still ANDed with the device being secure). */
        fun corruptionHandler() = ReplaceFileCorruptionHandler<Preferences> { preferencesOf(ENABLED_KEY to true) }
    }
}
