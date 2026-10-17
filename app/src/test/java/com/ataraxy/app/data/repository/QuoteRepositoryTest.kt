package com.ataraxy.app.data.repository

import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.AuthorEntity
import com.ataraxy.app.data.local.entity.QuoteEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.domain.model.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.LocalDate

@RunWith(RobolectricTestRunner::class)
class QuoteRepositoryTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var repository: QuoteRepository

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        repository = QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao())
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun dailyQuote_appearsOnceSeedingFinishes_whenSubscribedBeforeSeeding() = runBlocking {
        val dayBeyondSeededRange = LocalDate.ofYearDay(2026, 200)
        val emissions = Channel<Quote?>(Channel.UNLIMITED)
        val collector = launch(Dispatchers.IO) {
            repository.getDailyQuote(dayBeyondSeededRange).collect { emissions.send(it) }
        }

        assertNull(withTimeout(5_000) { emissions.receive() })
        seedDailyQuotes(count = 3)
        val quote = withTimeout(5_000) { emissions.receiveAsFlow().first { it != null } }
        collector.cancel()

        assertEquals("q2", quote?.id)
        assertEquals("Marcus Aurelius", quote?.authorName)
    }

    @Test
    fun dailyQuote_isNullWhileNoDailyQuotesExist() = runBlocking {
        assertNull(repository.getDailyQuote().first())
    }

    @Test
    fun dailyQuoteSlot_wrapsDayOfYearOntoRotation() {
        assertEquals(1, dailyQuoteSlot(dayOfYear = 1, totalDailyQuotes = 150))
        assertEquals(150, dailyQuoteSlot(dayOfYear = 150, totalDailyQuotes = 150))
        assertEquals(1, dailyQuoteSlot(dayOfYear = 151, totalDailyQuotes = 150))
        assertEquals(66, dailyQuoteSlot(dayOfYear = 366, totalDailyQuotes = 150))
    }

    private suspend fun seedDailyQuotes(count: Int) {
        db.authorDao().insertAuthors(
            listOf(AuthorEntity("marcus", "Marcus Aurelius", "", "", ""))
        )
        db.quoteDao().insertQuotes(
            (1..count).map { day ->
                QuoteEntity("q$day", "Quote $day", "marcus", "Meditations", "WISDOM", day)
            }
        )
    }
}
