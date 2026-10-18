package com.ataraxy.app.data.seed

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DailyQuoteDataTest {

    private val dailyQuotes = QuoteData.quotes.filter { it.emotionTag == null }

    @Test
    fun everyDailyQuote_hasAnInsight() {
        val missing = dailyQuotes.map { it.id }.filter { it !in InsightData.insights }

        assertEquals(emptyList<String>(), missing)
    }

    @Test
    fun dailyInsightBlockquotes_comeFromTheirQuote() {
        val mismatched = dailyQuotes.filter { quote ->
            val sections = InsightData.insights[quote.id]?.sections.orEmpty()
            sections.isEmpty() || sections.any { it.blockquote.isBlank() || it.blockquote !in quote.text }
        }.map { it.id }

        assertTrue("Blockquotes not found in their quote: $mismatched", mismatched.isEmpty())
    }

    @Test
    fun dailyQuotes_haveUniqueTexts() {
        val repeated = dailyQuotes.groupBy { it.text }.filterValues { it.size > 1 }.keys

        assertEquals(emptySet<String>(), repeated)
    }

    @Test
    fun dailyQuotes_haveUniqueDays() {
        val days = dailyQuotes.mapNotNull { it.dayOfYear }

        assertEquals(days.size, days.toSet().size)
    }
}
