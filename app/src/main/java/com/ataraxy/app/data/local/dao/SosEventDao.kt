package com.ataraxy.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ataraxy.app.data.local.entity.SosEventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SosEventDao {

    @Insert
    suspend fun insert(event: SosEventEntity)

    @Query("SELECT * FROM sos_events ORDER BY triggeredAt DESC LIMIT :limit")
    fun getRecentEvents(limit: Int = 10): Flow<List<SosEventEntity>>

    @Query("DELETE FROM sos_events")
    suspend fun deleteAll()
}
