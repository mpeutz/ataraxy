package com.ataraxy.app.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data class Practice(val quoteId: String? = null) : Screen(
        if (quoteId != null) "practice?quoteId=$quoteId" else "practice"
    ) {
        companion object {
            const val BASE = "practice"
            const val ROUTE = "practice?quoteId={quoteId}"
        }
    }
    data object Archive : Screen("archive")
    data class VirtueDetail(val virtueId: String) : Screen("virtue/$virtueId") {
        companion object {
            const val ROUTE = "virtue/{virtueId}"
        }
    }
    data object Settings : Screen("settings")
    data object About : Screen("about")
    data object Onboarding : Screen("onboarding")
    data object Practices : Screen("practices")
    data object BookendRitual : Screen("bookend_ritual")
    data object DichotomyOfControl : Screen("dichotomy_of_control")
    data object SosQuotes : Screen("sos_quotes")
    data object MementoMori : Screen("memento_mori")
    data object MementoMoriInsight : Screen("memento_mori_insight")
    data object JournalHistory : Screen("journal_history")
    data class Insight(val quoteId: String) : Screen("insight/$quoteId") {
        companion object {
            const val ROUTE = "insight/{quoteId}"
        }
    }
    data class AuthorDetail(val authorId: String) : Screen("author/$authorId") {
        companion object {
            const val ROUTE = "author/{authorId}"
        }
    }
    data class PracticeEdit(val entryId: Long) : Screen("practice/edit/$entryId") {
        companion object {
            const val ROUTE = "practice/edit/{entryId}"
        }
    }
}
