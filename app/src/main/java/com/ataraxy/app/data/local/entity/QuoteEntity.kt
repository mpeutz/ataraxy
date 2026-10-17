package com.ataraxy.app.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "quotes",
    foreignKeys = [
        ForeignKey(
            entity = AuthorEntity::class,
            parentColumns = ["id"],
            childColumns = ["authorId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("authorId"), Index("virtueId"), Index("dayOfYear"), Index("emotionTag")]
)
data class QuoteEntity(
    @PrimaryKey val id: String,
    val text: String,
    val authorId: String,
    val source: String,
    val virtueId: String,
    val dayOfYear: Int?,
    val emotionTag: String? = null
)
