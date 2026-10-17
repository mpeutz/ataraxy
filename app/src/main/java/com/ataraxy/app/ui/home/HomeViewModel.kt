package com.ataraxy.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository,
    private val userPrefsRepository: UserPrefsRepository
) : ViewModel() {

    val dailyQuote: StateFlow<Quote?> = quoteRepository.getDailyQuote()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    val todayDate: String = LocalDate.now()
        .format(DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy").withLocale(java.util.Locale.ENGLISH))
        .uppercase()

    val streakCount: StateFlow<Int> = kotlinx.coroutines.flow.combine(
        userPrefsRepository.userPrefs,
        kotlinx.coroutines.flow.flowOf(Unit)
    ) { prefs, _ -> prefs.streakCount }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    init {
        viewModelScope.launch {
            userPrefsRepository.updateStreak(LocalDate.now().toString())
        }
    }

    fun isBookmarked(quoteId: String) = quoteRepository.isBookmarked(quoteId)

    fun toggleBookmark(quoteId: String) {
        viewModelScope.launch {
            val isCurrentlyBookmarked = quoteRepository.isBookmarked(quoteId).first()
            if (isCurrentlyBookmarked) {
                quoteRepository.removeBookmark(quoteId)
            } else {
                quoteRepository.addBookmark(quoteId)
            }
        }
    }
}
