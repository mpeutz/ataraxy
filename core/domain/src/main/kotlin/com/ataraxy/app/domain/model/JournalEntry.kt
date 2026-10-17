package com.ataraxy.app.domain.model

import java.time.LocalDateTime

data class JournalEntry(
    val id: Long = 0L,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val content: String,
    val promptText: String,
    val linkedQuoteId: String?,
    val virtueId: String?,
    val ritualType: String? = null
)
