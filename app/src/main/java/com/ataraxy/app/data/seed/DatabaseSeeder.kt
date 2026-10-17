package com.ataraxy.app.data.seed

import com.ataraxy.app.data.local.dao.AuthorDao
import com.ataraxy.app.data.local.dao.QuoteDao
import com.ataraxy.app.data.local.dao.VirtueDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseSeeder @Inject constructor(
    private val virtueDao: VirtueDao,
    private val quoteDao: QuoteDao,
    private val authorDao: AuthorDao
) {
    suspend fun seedIfEmpty() {
        if (virtueDao.count() > 0) {
            seedEmotionQuotesIfMissing()
            return
        }

        authorDao.insertAuthors(AuthorData.authors)
        virtueDao.insertVirtues(VirtueData.virtues)
        virtueDao.insertSubConcepts(VirtueData.subConcepts)
        quoteDao.insertQuotes(QuoteData.quotes)
    }

    private suspend fun seedEmotionQuotesIfMissing() {
        if (quoteDao.countByEmotion("OVERWHELMED") > 0) return
        val emotionQuotes = QuoteData.quotes.filter { it.emotionTag != null }
        quoteDao.insertQuotes(emotionQuotes)
    }
}
