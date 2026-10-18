package com.ataraxy.app.data.repository

import com.ataraxy.app.data.local.dao.AuthorDao
import com.ataraxy.app.data.local.dao.BookmarkDao
import com.ataraxy.app.data.local.dao.QuoteDao
import com.ataraxy.app.data.local.entity.BookmarkEntity
import com.ataraxy.app.data.local.entity.QuoteEntity
import com.ataraxy.app.domain.model.Quote
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

/** Maps a day of the year onto the 1-based rotation of [totalDailyQuotes] daily quotes. */
internal fun dailyQuoteSlot(dayOfYear: Int, totalDailyQuotes: Int): Int =
    ((dayOfYear - 1) % totalDailyQuotes) + 1

@OptIn(ExperimentalCoroutinesApi::class)
@Singleton
class QuoteRepository @Inject constructor(
    private val quoteDao: QuoteDao,
    private val authorDao: AuthorDao,
    private val bookmarkDao: BookmarkDao
) {
    fun getDailyQuote(today: LocalDate = LocalDate.now()): Flow<Quote?> =
        quoteDao.observeDailyQuoteCount().distinctUntilChanged().flatMapLatest { total ->
            if (total == 0) flowOf(null)
            else quoteDao.getQuoteForDay(dailyQuoteSlot(today.dayOfYear, total)).flatMapLatest { entity ->
                if (entity == null) flowOf(null)
                else authorDao.getAuthorById(entity.authorId).map { author ->
                    entity.toDomain(author?.name ?: entity.authorId)
                }
            }
        }

    fun getAllQuotes(): Flow<List<Quote>> =
        combine(quoteDao.getAllQuotes(), authorDao.getAllAuthors()) { quotes, authors ->
            val authorMap = authors.associateBy { it.id }
            quotes.map { it.toDomain(authorMap[it.authorId]?.name ?: it.authorId) }
        }

    fun getQuotesByAuthor(authorId: String): Flow<List<Quote>> =
        combine(quoteDao.getQuotesByAuthor(authorId), authorDao.getAllAuthors()) { quotes, authors ->
            val authorMap = authors.associateBy { it.id }
            quotes.map { it.toDomain(authorMap[it.authorId]?.name ?: it.authorId) }
        }

    fun getQuotesByVirtue(virtueId: String): Flow<List<Quote>> =
        combine(quoteDao.getQuotesByVirtue(virtueId), authorDao.getAllAuthors()) { quotes, authors ->
            val authorMap = authors.associateBy { it.id }
            quotes.map { it.toDomain(authorMap[it.authorId]?.name ?: it.authorId) }
        }

    fun searchQuotes(query: String): Flow<List<Quote>> =
        combine(quoteDao.searchQuotes(query), authorDao.getAllAuthors()) { quotes, authors ->
            val authorMap = authors.associateBy { it.id }
            quotes.map { it.toDomain(authorMap[it.authorId]?.name ?: it.authorId) }
        }

    fun getQuoteById(id: String): Flow<Quote?> =
        quoteDao.getQuoteById(id).flatMapLatest { entity ->
            if (entity == null) flowOf(null)
            else authorDao.getAuthorById(entity.authorId).map { author ->
                entity.toDomain(author?.name ?: entity.authorId)
            }
        }

    fun getBookmarkedQuotes(): Flow<List<Quote>> =
        combine(quoteDao.getBookmarkedQuotes(), authorDao.getAllAuthors()) { quotes, authors ->
            val authorMap = authors.associateBy { it.id }
            quotes.map { it.toDomain(authorMap[it.authorId]?.name ?: it.authorId) }
        }

    fun isBookmarked(quoteId: String): Flow<Boolean> = bookmarkDao.isBookmarked(quoteId)

    suspend fun addBookmark(quoteId: String) {
        bookmarkDao.insert(BookmarkEntity(quoteId, java.time.LocalDateTime.now().toString()))
    }

    suspend fun removeBookmark(quoteId: String) {
        bookmarkDao.deleteByQuoteId(quoteId)
    }

    suspend fun getRandomQuoteForEmotion(tag: String): Quote? {
        val entity = quoteDao.getRandomQuoteByEmotion(tag) ?: return null
        val author = authorDao.getAuthorById(entity.authorId).first()
        return entity.toDomain(author?.name ?: entity.authorId)
    }

    suspend fun getQuoteCountForEmotion(tag: String): Int = quoteDao.countByEmotion(tag)

    suspend fun getQuotePositionForEmotion(tag: String, quoteId: String): Pair<Int, Int> {
        val ids = quoteDao.getQuoteIdsByEmotion(tag)
        val total = ids.size
        if (total == 0) return 0 to 0

        val index = ids.indexOf(quoteId)
        val position = if (index >= 0) index + 1 else 1
        return position to total
    }

    private fun QuoteEntity.toDomain(authorName: String) = Quote(
        id = id,
        text = text,
        authorId = authorId,
        authorName = authorName,
        source = source,
        virtueId = virtueId,
        dayOfYear = dayOfYear,
        emotionTag = emotionTag
    )
}
