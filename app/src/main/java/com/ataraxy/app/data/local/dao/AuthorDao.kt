package com.ataraxy.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ataraxy.app.data.local.entity.AuthorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {
    @Query("SELECT * FROM authors ORDER BY name ASC")
    fun getAllAuthors(): Flow<List<AuthorEntity>>

    @Query("SELECT * FROM authors WHERE id = :id")
    fun getAuthorById(id: String): Flow<AuthorEntity?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAuthors(authors: List<AuthorEntity>)

    @Query("SELECT COUNT(*) FROM authors")
    suspend fun count(): Int
}
