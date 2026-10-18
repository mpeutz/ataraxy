package com.ataraxy.app.data.seed

import com.ataraxy.app.domain.model.SosEmotion
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SosQuoteDataTest {

    private val sosQuotes = QuoteData.quotes.filter { it.emotionTag != null }

    @Test
    fun everyFeeling_hasAtLeastSixQuotes() {
        val counts = sosQuotes.groupingBy { it.emotionTag }.eachCount()
        val thin = SosEmotion.entries.filter { (counts[it.name] ?: 0) < MIN_QUOTES_PER_FEELING }

        assertTrue("Feelings with fewer than $MIN_QUOTES_PER_FEELING quotes: $thin", thin.isEmpty())
    }

    @Test
    fun everyEmotionTag_isAKnownFeeling() {
        val known = SosEmotion.entries.map { it.name }.toSet()
        val unknown = sosQuotes.mapNotNull { it.emotionTag }.toSet() - known

        assertEquals(emptySet<String>(), unknown)
    }

    @Test
    fun quoteIds_areUnique() {
        val duplicates = QuoteData.quotes.groupingBy { it.id }.eachCount().filterValues { it > 1 }.keys

        assertEquals(emptySet<String>(), duplicates)
    }

    @Test
    fun sosQuoteTexts_areUnique() {
        val duplicates = sosQuotes.groupingBy { it.text }.eachCount().filterValues { it > 1 }.keys

        assertEquals(emptySet<String>(), duplicates)
    }

    private companion object {
        const val MIN_QUOTES_PER_FEELING = 6
    }
}
