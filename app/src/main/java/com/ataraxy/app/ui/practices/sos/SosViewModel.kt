package com.ataraxy.app.ui.practices.sos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.SosRepository
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.domain.model.SosEmotion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SosUiState(
    val selectedEmotion: SosEmotion? = null,
    val currentQuote: Quote? = null,
    val isLoading: Boolean = false,
    val quotePosition: Int = 0,
    val quoteTotal: Int = 0
)

@HiltViewModel
class SosViewModel @Inject constructor(
    private val sosRepository: SosRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SosUiState())
    val uiState: StateFlow<SosUiState> = _uiState

    fun selectEmotion(emotion: SosEmotion) {
        _uiState.update {
            it.copy(
                selectedEmotion = emotion,
                isLoading = true,
                currentQuote = null,
                quotePosition = 0,
                quoteTotal = 0
            )
        }
        loadQuote(emotion)
    }

    fun refreshQuote() {
        val emotion = _uiState.value.selectedEmotion ?: return
        _uiState.update { it.copy(isLoading = true) }
        loadQuote(emotion)
    }

    private fun loadQuote(emotion: SosEmotion) {
        viewModelScope.launch {
            val quote = sosRepository.getRandomQuoteForEmotion(emotion)
            quote?.let { sosRepository.logSosEvent(emotion, it.id) }

            val (quotePosition, quoteTotal) = if (quote != null) {
                sosRepository.getQuotePositionForEmotion(emotion, quote.id)
            } else {
                0 to sosRepository.getQuoteCountForEmotion(emotion)
            }

            _uiState.update {
                it.copy(
                    currentQuote = quote,
                    isLoading = false,
                    quotePosition = quotePosition,
                    quoteTotal = quoteTotal
                )
            }
        }
    }
}
