package com.ataraxy.app.domain.model

data class AuthorWork(
    val title: String,
    val type: String,
    val description: String
)

data class AuthorProfile(
    val id: String,
    val name: String,
    val era: String,
    val bio: String,
    val works: List<AuthorWork>
)
