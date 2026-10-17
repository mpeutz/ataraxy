package com.ataraxy.app.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "sub_concepts",
    foreignKeys = [ForeignKey(
        entity = VirtueEntity::class,
        parentColumns = ["id"],
        childColumns = ["virtueId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("virtueId")]
)
data class SubConceptEntity(
    @PrimaryKey val id: String,
    val virtueId: String,
    val number: Int,
    val title: String,
    val description: String
)
