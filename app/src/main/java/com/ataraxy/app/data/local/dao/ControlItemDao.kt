package com.ataraxy.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.ataraxy.app.data.local.entity.ControlItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ControlItemDao {

    @Query("SELECT * FROM control_items WHERE bucket IS NULL AND isArchived = 0 ORDER BY createdAt DESC")
    fun getActiveItems(): Flow<List<ControlItemEntity>>

    @Query("SELECT * FROM control_items WHERE bucket = 'IN_CONTROL' AND isArchived = 0 ORDER BY createdAt DESC")
    fun getInControlItems(): Flow<List<ControlItemEntity>>

    @Query("SELECT * FROM control_items ORDER BY createdAt DESC")
    fun getAllItems(): Flow<List<ControlItemEntity>>

    @Query("SELECT * FROM control_items WHERE bucket = 'IN_CONTROL' AND isArchived = 1 ORDER BY createdAt DESC")
    fun getCompletedItems(): Flow<List<ControlItemEntity>>

    @Query("SELECT * FROM control_items WHERE bucket = 'NOT_IN_CONTROL' AND isArchived = 1 ORDER BY createdAt DESC")
    fun getReleasedItems(): Flow<List<ControlItemEntity>>

    @Query("SELECT COUNT(*) FROM control_items WHERE bucket = 'NOT_IN_CONTROL' AND isArchived = 1")
    fun getReleasedCount(): Flow<Int>

    @Upsert
    suspend fun upsert(item: ControlItemEntity): Long

    @Delete
    suspend fun delete(item: ControlItemEntity)

    @Query("UPDATE control_items SET isArchived = 1 WHERE id = :id")
    suspend fun archiveItem(id: Long)

    @Query("UPDATE control_items SET bucket = :bucket WHERE id = :id")
    suspend fun updateBucket(id: Long, bucket: String)

    @Query("UPDATE control_items SET actionStep = :actionStep WHERE id = :id")
    suspend fun updateActionStep(id: Long, actionStep: String)

    @Query("UPDATE control_items SET text = :text WHERE id = :id")
    suspend fun updateText(id: Long, text: String)

    @Query("UPDATE control_items SET bucket = NULL WHERE id = :id")
    suspend fun clearBucket(id: Long)

    @Query("UPDATE control_items SET isArchived = 0 WHERE id = :id")
    suspend fun unarchiveItem(id: Long)

    @Query("DELETE FROM control_items WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM control_items")
    suspend fun deleteAll()
}
