package com.ataraxy.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ataraxy.app.data.local.entity.SubConceptEntity
import com.ataraxy.app.data.local.entity.VirtueEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VirtueDao {
    @Query("SELECT * FROM virtues ORDER BY name ASC")
    fun getAllVirtues(): Flow<List<VirtueEntity>>

    @Query("SELECT * FROM virtues WHERE id = :id")
    fun getVirtueById(id: String): Flow<VirtueEntity?>

    @Query("SELECT * FROM sub_concepts WHERE virtueId = :virtueId ORDER BY number ASC")
    fun getSubConcepts(virtueId: String): Flow<List<SubConceptEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVirtues(virtues: List<VirtueEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubConcepts(concepts: List<SubConceptEntity>)

    @Query("SELECT COUNT(*) FROM virtues")
    suspend fun count(): Int
}
