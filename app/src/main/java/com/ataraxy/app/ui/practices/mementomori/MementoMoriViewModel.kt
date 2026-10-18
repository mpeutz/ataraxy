package com.ataraxy.app.ui.practices.mementomori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.inject.Inject

sealed interface BirthYearError {
    data object NotANumber : BirthYearError
    data class OutOfRange(val min: Int, val max: Int) : BirthYearError
}

private const val MIN_BIRTH_YEAR = 1900

data class MementoMoriUiState(
    val birthYear: Int? = null,
    val weeksLived: Int = 0,
    val totalWeeks: Int = TOTAL_WEEKS,
    val selectedWeekIndex: Int? = null,
    val reflectionQuote: Quote? = null,
    val showBirthYearPicker: Boolean = false,
    val birthYearInput: String = "",
    val birthYearError: BirthYearError? = null,
    val isLoading: Boolean = true
)

private const val LIFE_EXPECTANCY_YEARS = 76
const val TOTAL_WEEKS = LIFE_EXPECTANCY_YEARS * 52

@HiltViewModel
class MementoMoriViewModel @Inject constructor(
    private val userPrefsRepository: UserPrefsRepository,
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MementoMoriUiState())
    val uiState: StateFlow<MementoMoriUiState> = _uiState

    init {
        viewModelScope.launch {
            val birthYear = userPrefsRepository.userPrefs.first().birthYear
            val weeksLived = if (birthYear != null) computeWeeksLived(birthYear) else 0
            _uiState.update {
                it.copy(
                    birthYear = birthYear,
                    weeksLived = weeksLived,
                    birthYearInput = it.birthYearInput.ifEmpty { birthYear?.toString() ?: "" },
                    isLoading = false
                )
            }
        }
    }

    fun updateBirthYearInput(input: String) {
        _uiState.update { it.copy(birthYearInput = input, birthYearError = null) }
    }

    fun confirmBirthYear() {
        val input = _uiState.value.birthYearInput.trim()
        val year = input.toIntOrNull()
        val currentYear = LocalDate.now().year
        when {
            year == null -> _uiState.update { it.copy(birthYearError = BirthYearError.NotANumber) }
            year < MIN_BIRTH_YEAR || year > currentYear - 1 -> _uiState.update {
                it.copy(birthYearError = BirthYearError.OutOfRange(MIN_BIRTH_YEAR, currentYear - 1))
            }
            else -> viewModelScope.launch {
                userPrefsRepository.setBirthYear(year)
                _uiState.update {
                    it.copy(
                        birthYear = year,
                        weeksLived = computeWeeksLived(year),
                        showBirthYearPicker = false,
                        birthYearError = null
                    )
                }
            }
        }
    }

    fun showBirthYearPicker() {
        _uiState.update { it.copy(showBirthYearPicker = true) }
    }

    fun hideBirthYearPicker() {
        _uiState.update { it.copy(showBirthYearPicker = false) }
    }

    fun onWeekTapped(weekIndex: Int) {
        if (weekIndex >= _uiState.value.weeksLived) return
        _uiState.update { it.copy(selectedWeekIndex = weekIndex) }
        viewModelScope.launch {
            val quote = quoteRepository.getRandomQuoteForEmotion("ANXIETY")
                ?: quoteRepository.getAllQuotes().first()
                    .filter { it.virtueId == "WISDOM" || it.virtueId == "COURAGE" }
                    .randomOrNull()
            _uiState.update { it.copy(reflectionQuote = quote) }
        }
    }

    fun dismissReflection() {
        _uiState.update { it.copy(selectedWeekIndex = null, reflectionQuote = null) }
    }

    private fun computeWeeksLived(birthYear: Int): Int {
        val birthDate = LocalDate.of(birthYear, 1, 1)
        val weeks = ChronoUnit.WEEKS.between(birthDate, LocalDate.now()).toInt()
        return weeks.coerceIn(0, TOTAL_WEEKS)
    }
}
