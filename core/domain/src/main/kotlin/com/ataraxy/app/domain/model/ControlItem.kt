package com.ataraxy.app.domain.model

import java.time.LocalDateTime

enum class ControlBucket { IN_CONTROL, NOT_IN_CONTROL }

data class ControlItem(
    val id: Long = 0L,
    val text: String,
    val bucket: ControlBucket? = null,
    val actionStep: String? = null,
    val createdAt: LocalDateTime,
    val isArchived: Boolean = false
)
