package com.ataraxy.app.data.seed

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class InsightDataTest {

    private val quoteIds = QuoteData.quotes.map { it.id }.toSet()

    @Test
    fun everySosQuote_hasAnInsight() {
        val missing = QuoteData.quotes
            .filter { it.emotionTag != null && it.id !in InsightData.insights }
            .map { it.id }

        assertEquals(emptyList<String>(), missing)
    }

    @Test
    fun everyInsight_belongsToASeededQuote() {
        val orphans = InsightData.insights.keys - quoteIds

        assertEquals(emptySet<String>(), orphans)
    }

    @Test
    fun sosInsightBlockquotes_comeFromTheirQuote() {
        val quotesById = QuoteData.quotes.associateBy { it.id }
        val mismatched = SosInsightData.insights.filter { (id, insight) ->
            val text = quotesById.getValue(id).text
            insight.sections.any { it.blockquote !in text }
        }.keys

        assertTrue("Blockquotes not found in their quote: $mismatched", mismatched.isEmpty())
    }
}
