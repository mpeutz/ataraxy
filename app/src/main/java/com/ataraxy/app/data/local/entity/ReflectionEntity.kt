package com.ataraxy.app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "reflections")
data class ReflectionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val worry: String,
    /** Newline-joined lines. */
    @ColumnInfo(defaultValue = "") val yours: String = "",
    /** Newline-joined lines. */
    @ColumnInfo(defaultValue = "") val notYours: String = "",
    @ColumnInfo(defaultValue = "") val canDo: String = "",
    @ColumnInfo(defaultValue = "") val setDown: String = "",
    val createdAt: String,
    val completedAt: String? = null,
    val setDownAt: String? = null
)

@Entity(
    tableName = "reflection_notes",
    foreignKeys = [
        ForeignKey(
            entity = ReflectionEntity::class,
            parentColumns = ["id"],
            childColumns = ["reflectionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("reflectionId")]
)
data class ReflectionNoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val reflectionId: Long,
    val text: String,
    val createdAt: String
)

data class ReflectionWithNotes(
    @Embedded val reflection: ReflectionEntity,
    @Relation(parentColumn = "id", entityColumn = "reflectionId")
    val notes: List<ReflectionNoteEntity>
)
