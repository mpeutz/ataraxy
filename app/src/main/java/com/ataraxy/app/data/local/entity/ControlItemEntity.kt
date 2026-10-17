package com.ataraxy.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "control_items")
data class ControlItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val text: String,
    val bucket: String? = null,
    val actionStep: String? = null,
    val createdAt: String,
    val isArchived: Boolean = false
)
