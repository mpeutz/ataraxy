package com.ataraxy.app.domain.model

import java.time.LocalDateTime

data class ReflectionNote(
    val id: Long = 0L,
    val text: String,
    val createdAt: LocalDateTime
)

/** One worry worked through in What's Yours. */
data class Reflection(
    val id: Long = 0L,
    val worry: String,
    val yours: List<String> = emptyList(),
    val notYours: List<String> = emptyList(),
    val canDo: String = "",
    val setDown: String = "",
    val notes: List<ReflectionNote> = emptyList(),
    val createdAt: LocalDateTime,
    /** Null while the guided steps are unfinished. */
    val completedAt: LocalDateTime? = null,
    /** Set once the worry no longer weighs on the user; the reflection then lives under Past. */
    val setDownAt: LocalDateTime? = null
)
