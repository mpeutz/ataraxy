package com.ataraxy.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Query("SELECT * FROM journal_entries ORDER BY createdAt DESC")
    fun getAllEntries(): Flow<List<JournalEntryEntity>>

    @Query("SELECT * FROM journal_entries WHERE id = :id")
    fun getEntryById(id: Long): Flow<JournalEntryEntity?>

    @Upsert
    suspend fun upsert(entry: JournalEntryEntity): Long

    @Delete
    suspend fun delete(entry: JournalEntryEntity)

    @Query("DELETE FROM journal_entries")
    suspend fun deleteAll()

    @Query("SELECT * FROM journal_entries WHERE ritualType = :type ORDER BY createdAt DESC")
    fun getEntriesByRitualType(type: String): Flow<List<JournalEntryEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM journal_entries WHERE ritualType = :type AND date(createdAt) = :date)")
    suspend fun hasCompletedRitualToday(type: String, date: String): Boolean
}
