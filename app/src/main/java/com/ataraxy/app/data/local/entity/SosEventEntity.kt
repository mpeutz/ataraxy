package com.ataraxy.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sos_events")
data class SosEventEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val emotion: String,
    val quoteId: String,
    val triggeredAt: String
)
