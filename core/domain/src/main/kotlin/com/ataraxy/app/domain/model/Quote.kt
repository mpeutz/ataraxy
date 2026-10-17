package com.ataraxy.app.domain.model

data class Quote(
    val id: String,
    val text: String,
    val authorId: String,
    val authorName: String,
    val source: String,
    val virtueId: String,
    val dayOfYear: Int?,
    val emotionTag: String? = null
)
