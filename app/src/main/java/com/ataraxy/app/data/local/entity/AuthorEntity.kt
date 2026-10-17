package com.ataraxy.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class AuthorEntity(
    @PrimaryKey val id: String,
    val name: String,
    val bio: String,
    val era: String,
    val school: String
)
