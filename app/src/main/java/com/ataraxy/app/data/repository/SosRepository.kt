package com.ataraxy.app.data.repository

import com.ataraxy.app.data.local.dao.SosEventDao
import com.ataraxy.app.data.local.entity.SosEventEntity
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.domain.model.SosEmotion
import com.ataraxy.app.domain.model.SosEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SosRepository @Inject constructor(
    private val sosEventDao: SosEventDao,
    private val quoteRepository: QuoteRepository
) {
    suspend fun getRandomQuoteForEmotion(emotion: SosEmotion): Quote? =
        quoteRepository.getRandomQuoteForEmotion(emotion.name)

    suspend fun getQuoteCountForEmotion(emotion: SosEmotion): Int =
        quoteRepository.getQuoteCountForEmotion(emotion.name)

    suspend fun getQuotePositionForEmotion(emotion: SosEmotion, quoteId: String): Pair<Int, Int> =
        quoteRepository.getQuotePositionForEmotion(emotion.name, quoteId)

    suspend fun logSosEvent(emotion: SosEmotion, quoteId: String) {
        sosEventDao.insert(
            SosEventEntity(
                emotion = emotion.name,
                quoteId = quoteId,
                triggeredAt = LocalDateTime.now().toString()
            )
        )
    }

    suspend fun deleteAll() = sosEventDao.deleteAll()
}
