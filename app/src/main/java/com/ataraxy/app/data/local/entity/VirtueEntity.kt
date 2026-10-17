package com.ataraxy.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "virtues")
data class VirtueEntity(
    @PrimaryKey val id: String,
    val name: String,
    val latinName: String,
    val symbol: String,
    val definingQuote: String,
    val definingQuoteAuthor: String
)
