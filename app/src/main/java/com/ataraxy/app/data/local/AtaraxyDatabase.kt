package com.ataraxy.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ataraxy.app.data.local.dao.AuthorDao
import com.ataraxy.app.data.local.dao.BackupDao
import com.ataraxy.app.data.local.dao.BookmarkDao
import com.ataraxy.app.data.local.dao.JournalDao
import com.ataraxy.app.data.local.dao.QuoteDao
import com.ataraxy.app.data.local.dao.ReflectionDao
import com.ataraxy.app.data.local.dao.SosEventDao
import com.ataraxy.app.data.local.dao.VirtueDao
import com.ataraxy.app.data.local.entity.AuthorEntity
import com.ataraxy.app.data.local.entity.BookmarkEntity
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.QuoteEntity
import com.ataraxy.app.data.local.entity.ReflectionEntity
import com.ataraxy.app.data.local.entity.ReflectionNoteEntity
import com.ataraxy.app.data.local.entity.SosEventEntity
import com.ataraxy.app.data.local.entity.SubConceptEntity
import com.ataraxy.app.data.local.entity.VirtueEntity

@Database(
    entities = [
        VirtueEntity::class,
        SubConceptEntity::class,
        AuthorEntity::class,
        QuoteEntity::class,
        JournalEntryEntity::class,
        BookmarkEntity::class,
        ReflectionEntity::class,
        ReflectionNoteEntity::class,
        SosEventEntity::class
    ],
    version = 3,
    exportSchema = true
)
abstract class AtaraxyDatabase : RoomDatabase() {
    abstract fun virtueDao(): VirtueDao
    abstract fun quoteDao(): QuoteDao
    abstract fun journalDao(): JournalDao
    abstract fun authorDao(): AuthorDao
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun reflectionDao(): ReflectionDao
    abstract fun sosEventDao(): SosEventDao
    abstract fun backupDao(): BackupDao
}
