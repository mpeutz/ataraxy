package com.ataraxy.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal_entries")
data class JournalEntryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val createdAt: String,
    val updatedAt: String,
    val content: String,
    val promptText: String,
    val linkedQuoteId: String?,
    val virtueId: String?,
    val ritualType: String? = null
)
