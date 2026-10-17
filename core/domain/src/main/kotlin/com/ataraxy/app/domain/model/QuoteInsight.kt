package com.ataraxy.app.domain.model

data class QuoteInsight(
    val intro: String,
    val sections: List<InsightSection>,
    val comparisonTable: InsightTable? = null,
    val modernApplication: String? = null,
    val closing: String? = null,
    val reflectionPrompt: String? = null
)

data class InsightSection(
    val number: Int,
    val title: String,
    val blockquote: String,
    val body: String,
    val bullets: List<InsightBullet> = emptyList()
)

data class InsightBullet(val label: String, val text: String)

data class InsightTable(
    val leftHeader: String,
    val rightHeader: String,
    val rows: List<Pair<String, String>>
)
