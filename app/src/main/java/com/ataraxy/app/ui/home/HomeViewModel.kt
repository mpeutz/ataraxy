package com.ataraxy.app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.lock.AppLock
import com.ataraxy.app.lookback.LookBackKind
import com.ataraxy.app.lookback.LookBackPick
import com.ataraxy.app.lookback.pickLookBack
import com.ataraxy.app.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.Clock
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

data class LookBackCard(
    val kind: LookBackKind,
    val date: LocalDate,
    val prompt: String?,
    val excerpt: String?,
    val entryId: Long
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository,
    private val userPrefsRepository: UserPrefsRepository,
    journalRepository: JournalRepository,
    appLock: AppLock,
    private val clock: Clock
) : ViewModel() {

    private val today = MutableStateFlow(LocalDate.now(clock))

    val lookBack: StateFlow<LookBackCard?> = combine(
        journalRepository.getAllEntries(),
        appLock.enabled,
        today
    ) { entries, locked, day ->
        pickLookBack(entries, day)?.toCard(locked)
    }
        .flowOn(Dispatchers.Default)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

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

    fun onResume(day: LocalDate = LocalDate.now(clock)) {
        today.value = day
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

private fun LookBackPick.toCard(locked: Boolean): LookBackCard {
    val entry = session.representative
    return LookBackCard(
        kind = kind,
        date = session.date,
        prompt = entry.promptText.takeIf { !locked && it.isNotBlank() },
        excerpt = entry.content.takeIf { !locked },
        entryId = entry.id
    )
}
