package com.ataraxy.wear.domain

/**
 * Lightweight model representing a quote received from the phone via the Wearable Data Layer.
 * Stored locally on the watch via WearQuoteStore (DataStore).
 */
data class ReceivedQuote(
    val id: String,
    val text: String,
    val authorName: String
)
