package com.ataraxy.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.ataraxy.app.data.local.entity.ReflectionEntity
import com.ataraxy.app.data.local.entity.ReflectionNoteEntity
import com.ataraxy.app.data.local.entity.ReflectionWithNotes
import kotlinx.coroutines.flow.Flow

@Dao
interface ReflectionDao {

    @Transaction
    @Query("SELECT * FROM reflections WHERE setDownAt IS NULL ORDER BY createdAt DESC")
    fun observeOpen(): Flow<List<ReflectionWithNotes>>

    @Transaction
    @Query("SELECT * FROM reflections WHERE setDownAt IS NOT NULL ORDER BY setDownAt DESC")
    fun observePast(): Flow<List<ReflectionWithNotes>>

    @Transaction
    @Query("SELECT * FROM reflections WHERE id = :id")
    fun observe(id: Long): Flow<ReflectionWithNotes?>

    @Transaction
    @Query("SELECT * FROM reflections WHERE id = :id")
    suspend fun get(id: Long): ReflectionWithNotes?

    @Transaction
    @Query("SELECT * FROM reflections ORDER BY createdAt ASC")
    suspend fun getAll(): List<ReflectionWithNotes>

    @Insert
    suspend fun insert(reflection: ReflectionEntity): Long

    @Insert
    suspend fun insertNote(note: ReflectionNoteEntity): Long

    @Query(
        "UPDATE reflections SET yours = :yours, notYours = :notYours, canDo = :canDo, setDown = :setDown " +
            "WHERE id = :id"
    )
    suspend fun updateAnswers(id: Long, yours: String, notYours: String, canDo: String, setDown: String)

    @Query("UPDATE reflections SET completedAt = :completedAt WHERE id = :id")
    suspend fun updateCompletedAt(id: Long, completedAt: String)

    @Query("UPDATE reflections SET setDownAt = :setDownAt WHERE id = :id")
    suspend fun updateSetDownAt(id: Long, setDownAt: String?)

    @Query("DELETE FROM reflections WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM reflections")
    suspend fun deleteAll()
}
