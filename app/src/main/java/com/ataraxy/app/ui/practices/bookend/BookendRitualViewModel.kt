package com.ataraxy.app.ui.practices.bookend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.domain.model.JournalEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import javax.inject.Inject

enum class RitualSession { MORNING, EVENING, NEUTRAL }

data class BookendUiState(
    val session: RitualSession = RitualSession.NEUTRAL,
    val answers: Map<String, String> = emptyMap(),
    val isSaved: Boolean = false,
    val morningStreak: Int = 0,
    val eveningStreak: Int = 0,
    val hasCompletedMorningToday: Boolean = false,
    val hasCompletedEveningToday: Boolean = false,
    val isLoading: Boolean = true
)

@HiltViewModel
class BookendRitualViewModel @Inject constructor(
    private val journalRepository: JournalRepository,
    private val userPrefsRepository: UserPrefsRepository
) : ViewModel() {

    companion object {
        val MORNING_PROMPTS = listOf(
            "What obstacles might I encounter today, and how will I respond with virtue?"
        )
        val EVENING_PROMPTS = listOf(
            "What did I do well today?",
            "What did I do poorly?",
            "What will I do differently tomorrow?"
        )
    }

    private val _uiState = MutableStateFlow(BookendUiState())
    val uiState: StateFlow<BookendUiState> = _uiState

    init {
        val hour = LocalTime.now().hour
        val detectedSession = when (hour) {
            in 5..11 -> RitualSession.MORNING
            in 17..22 -> RitualSession.EVENING
            else -> RitualSession.NEUTRAL
        }

        viewModelScope.launch {
            val prefs = userPrefsRepository.userPrefs
            prefs.collect { p ->
                val hasCompletedMorning = journalRepository.hasCompletedRitualToday("MORNING")
                val hasCompletedEvening = journalRepository.hasCompletedRitualToday("EVENING")
                _uiState.update {
                    it.copy(
                        session = detectedSession,
                        morningStreak = p.morningRitualStreak,
                        eveningStreak = p.eveningRitualStreak,
                        hasCompletedMorningToday = hasCompletedMorning,
                        hasCompletedEveningToday = hasCompletedEvening,
                        isLoading = false
                    )
                }
                return@collect
            }
        }
    }

    fun setSession(session: RitualSession) {
        _uiState.update { it.copy(session = session, answers = emptyMap()) }
    }

    fun resetSession() {
        _uiState.update { it.copy(session = RitualSession.NEUTRAL, answers = emptyMap()) }
    }

    fun updateAnswer(prompt: String, answer: String) {
        _uiState.update { it.copy(answers = it.answers + (prompt to answer)) }
    }

    fun saveAndComplete() {
        val state = _uiState.value
        val session = state.session
        val prompts = if (session == RitualSession.MORNING) MORNING_PROMPTS else EVENING_PROMPTS
        val now = LocalDateTime.now()
        val today = LocalDate.now().toString()

        viewModelScope.launch {
            prompts.forEach { prompt ->
                val answer = state.answers[prompt] ?: ""
                if (answer.isNotBlank()) {
                    journalRepository.upsert(
                        JournalEntry(
                            createdAt = now,
                            updatedAt = now,
                            content = answer,
                            promptText = prompt,
                            linkedQuoteId = null,
                            virtueId = null,
                            ritualType = session.name
                        )
                    )
                }
            }

            if (session == RitualSession.MORNING) {
                userPrefsRepository.updateMorningRitualStreak(today)
            } else {
                userPrefsRepository.updateEveningRitualStreak(today)
            }

            _uiState.update { it.copy(isSaved = true) }
        }
    }
}
