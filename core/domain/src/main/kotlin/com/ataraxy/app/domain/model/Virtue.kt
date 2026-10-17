package com.ataraxy.app.domain.model

data class Virtue(
    val id: String,
    val name: String,
    val latinName: String,
    val symbol: String,
    val definingQuote: String,
    val definingQuoteAuthor: String,
    val subConcepts: List<SubConcept> = emptyList()
)
