package com.ataraxy.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ataraxy.app.data.local.entity.BookmarkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmarks ORDER BY savedAt DESC")
    fun getAllBookmarks(): Flow<List<BookmarkEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarks WHERE quoteId = :quoteId)")
    fun isBookmarked(quoteId: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bookmark: BookmarkEntity)

    @Delete
    suspend fun delete(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmarks WHERE quoteId = :quoteId")
    suspend fun deleteByQuoteId(quoteId: String)
}
