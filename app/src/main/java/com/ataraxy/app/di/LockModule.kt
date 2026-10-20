package com.ataraxy.app.di

import android.content.Context
import android.os.SystemClock
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.ataraxy.app.lock.AppLock
import com.ataraxy.app.lock.BiometricDeviceAuthenticator
import com.ataraxy.app.lock.DeviceAuthenticator
import com.ataraxy.app.lock.ElapsedRealtime
import com.ataraxy.app.lock.LockPrefs
import com.ataraxy.app.lock.SingleFlightAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.lockPrefsDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "lock_prefs",
    corruptionHandler = AppLock.corruptionHandler()
)

@Module
@InstallIn(SingletonComponent::class)
abstract class LockModule {

    companion object {
        @Provides
        @Singleton
        fun provideDeviceAuthenticator(impl: BiometricDeviceAuthenticator): DeviceAuthenticator =
            SingleFlightAuthenticator(impl)

        @Provides
        fun provideElapsedRealtime(): ElapsedRealtime = ElapsedRealtime(SystemClock::elapsedRealtime)

        @Provides
        @Singleton
        @LockPrefs
        fun provideLockPrefsDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
            context.lockPrefsDataStore
    }
}
