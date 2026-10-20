package com.ataraxy.app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.ataraxy.app.lock.LockPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.lockPrefsDataStore: DataStore<Preferences> by preferencesDataStore(name = "lock_prefs")

@Module
@InstallIn(SingletonComponent::class)
object LockModule {

    @Provides
    @Singleton
    @LockPrefs
    fun provideLockPrefsDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        context.lockPrefsDataStore
}
