package com.ataraxy.app.data.repository

import com.ataraxy.app.data.local.dao.JournalDao
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.domain.model.JournalEntry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JournalRepository @Inject constructor(
    private val journalDao: JournalDao
) {
    fun getAllEntries(): Flow<List<JournalEntry>> =
        journalDao.getAllEntries().map { list -> list.map { it.toDomain() } }

    fun getEntryById(id: Long): Flow<JournalEntry?> =
        journalDao.getEntryById(id).map { it?.toDomain() }

    suspend fun upsert(entry: JournalEntry): Long {
        return journalDao.upsert(entry.toEntity())
    }

    suspend fun delete(entry: JournalEntry) {
        journalDao.delete(entry.toEntity())
    }

    suspend fun deleteAll() {
        journalDao.deleteAll()
    }

    suspend fun hasCompletedRitualToday(type: String): Boolean =
        journalDao.hasCompletedRitualToday(type, java.time.LocalDate.now().toString())

    private fun JournalEntryEntity.toDomain() = JournalEntry(
        id = id,
        createdAt = LocalDateTime.parse(createdAt),
        updatedAt = LocalDateTime.parse(updatedAt),
        content = content,
        promptText = promptText,
        linkedQuoteId = linkedQuoteId,
        virtueId = virtueId,
        ritualType = ritualType
    )

    private fun JournalEntry.toEntity() = JournalEntryEntity(
        id = id,
        createdAt = createdAt.toString(),
        updatedAt = updatedAt.toString(),
        content = content,
        promptText = promptText,
        linkedQuoteId = linkedQuoteId,
        virtueId = virtueId,
        ritualType = ritualType
    )
}
