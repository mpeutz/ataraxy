package com.ataraxy.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ataraxy.app.data.local.entity.QuoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes WHERE dayOfYear = :dayOfYear LIMIT 1")
    fun getQuoteForDay(dayOfYear: Int): Flow<QuoteEntity?>

    @Query("SELECT * FROM quotes ORDER BY id ASC")
    fun getAllQuotes(): Flow<List<QuoteEntity>>

    @Query("SELECT * FROM quotes WHERE authorId = :authorId ORDER BY id ASC")
    fun getQuotesByAuthor(authorId: String): Flow<List<QuoteEntity>>

    @Query("SELECT * FROM quotes WHERE virtueId = :virtueId ORDER BY id ASC")
    fun getQuotesByVirtue(virtueId: String): Flow<List<QuoteEntity>>

    @Query("SELECT * FROM quotes WHERE text LIKE '%' || :query || '%' ORDER BY id ASC")
    fun searchQuotes(query: String): Flow<List<QuoteEntity>>

    @Query("SELECT * FROM quotes WHERE id = :id")
    fun getQuoteById(id: String): Flow<QuoteEntity?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuotes(quotes: List<QuoteEntity>)

    @Query("SELECT COUNT(*) FROM quotes")
    suspend fun count(): Int

    @Query("SELECT COUNT(*) FROM quotes WHERE dayOfYear IS NOT NULL")
    fun observeDailyQuoteCount(): Flow<Int>

    @Query("SELECT * FROM quotes WHERE emotionTag = :tag ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomQuoteByEmotion(tag: String): QuoteEntity?

    @Query("SELECT COUNT(*) FROM quotes WHERE emotionTag = :tag")
    suspend fun countByEmotion(tag: String): Int

    @Query("SELECT id FROM quotes WHERE emotionTag = :tag ORDER BY id ASC")
    suspend fun getQuoteIdsByEmotion(tag: String): List<String>

    @Query("""
        SELECT q.* FROM quotes q
        INNER JOIN bookmarks b ON q.id = b.quoteId
        ORDER BY b.savedAt DESC
    """)
    fun getBookmarkedQuotes(): Flow<List<QuoteEntity>>
}
