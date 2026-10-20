package com.ataraxy.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ataraxy.app.data.local.entity.BookmarkEntity
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.ReflectionEntity
import com.ataraxy.app.data.local.entity.ReflectionNoteEntity
import com.ataraxy.app.data.local.entity.SosEventEntity

@Dao
interface BackupDao {

    @Query("SELECT * FROM journal_entries ORDER BY id ASC")
    suspend fun journalEntries(): List<JournalEntryEntity>

    @Query("SELECT * FROM bookmarks ORDER BY savedAt ASC, quoteId ASC")
    suspend fun bookmarks(): List<BookmarkEntity>

    @Query("SELECT * FROM sos_events ORDER BY id ASC")
    suspend fun sosEvents(): List<SosEventEntity>

    @Query("DELETE FROM journal_entries")
    suspend fun deleteJournalEntries()

    @Query("DELETE FROM reflections")
    suspend fun deleteReflections()

    @Query("DELETE FROM bookmarks")
    suspend fun deleteBookmarks()

    @Query("DELETE FROM sos_events")
    suspend fun deleteSosEvents()

    @Insert
    suspend fun insertJournalEntries(entries: List<JournalEntryEntity>)

    @Insert
    suspend fun insertReflections(reflections: List<ReflectionEntity>)

    @Insert
    suspend fun insertReflectionNotes(notes: List<ReflectionNoteEntity>)

    @Insert
    suspend fun insertBookmarks(bookmarks: List<BookmarkEntity>)

    @Insert
    suspend fun insertSosEvents(events: List<SosEventEntity>)
}
