package com.ataraxy.app.di

import android.content.Context
import androidx.room.Room
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.MIGRATION_1_2
import com.ataraxy.app.data.local.MIGRATION_2_3
import com.ataraxy.app.data.local.dao.AuthorDao
import com.ataraxy.app.data.local.dao.BackupDao
import com.ataraxy.app.data.local.dao.BookmarkDao
import com.ataraxy.app.data.local.dao.JournalDao
import com.ataraxy.app.data.local.dao.QuoteDao
import com.ataraxy.app.data.local.dao.ReflectionDao
import com.ataraxy.app.data.local.dao.SosEventDao
import com.ataraxy.app.data.local.dao.VirtueDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AtaraxyDatabase =
        Room.databaseBuilder(
            context,
            AtaraxyDatabase::class.java,
            "ataraxy.db"
        ).addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()

    @Provides fun provideVirtueDao(db: AtaraxyDatabase): VirtueDao = db.virtueDao()
    @Provides fun provideQuoteDao(db: AtaraxyDatabase): QuoteDao = db.quoteDao()
    @Provides fun provideJournalDao(db: AtaraxyDatabase): JournalDao = db.journalDao()
    @Provides fun provideAuthorDao(db: AtaraxyDatabase): AuthorDao = db.authorDao()
    @Provides fun provideBookmarkDao(db: AtaraxyDatabase): BookmarkDao = db.bookmarkDao()
    @Provides fun provideReflectionDao(db: AtaraxyDatabase): ReflectionDao = db.reflectionDao()
    @Provides fun provideSosEventDao(db: AtaraxyDatabase): SosEventDao = db.sosEventDao()
    @Provides fun provideBackupDao(db: AtaraxyDatabase): BackupDao = db.backupDao()
}
