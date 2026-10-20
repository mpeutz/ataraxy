package com.ataraxy.app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.ataraxy.app.data.backup.AppVersion
import com.ataraxy.app.data.backup.BackupDocuments
import com.ataraxy.app.data.backup.BackupPrefs
import com.ataraxy.app.data.backup.ContentResolverBackupDocuments
import com.ataraxy.app.data.backup.NotificationRescheduler
import com.ataraxy.app.data.backup.Rescheduler
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.time.Clock
import javax.inject.Singleton

private val Context.backupPrefsDataStore: DataStore<Preferences> by preferencesDataStore(name = "backup_prefs")

@Module
@InstallIn(SingletonComponent::class)
abstract class BackupModule {

    @Binds
    abstract fun bindBackupDocuments(impl: ContentResolverBackupDocuments): BackupDocuments

    @Binds
    abstract fun bindRescheduler(impl: NotificationRescheduler): Rescheduler

    companion object {
        @Provides
        @Singleton
        @BackupPrefs
        fun provideBackupPrefsDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
            context.backupPrefsDataStore

        @Provides
        fun provideAppVersion(@ApplicationContext context: Context): AppVersion = AppVersion {
            context.packageManager.getPackageInfo(context.packageName, 0).longVersionCode
        }

        @Provides
        @Singleton
        fun provideClock(): Clock = Clock.systemDefaultZone()
    }
}
