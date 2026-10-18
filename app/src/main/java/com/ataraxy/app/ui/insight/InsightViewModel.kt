package com.ataraxy.app.ui.insight

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class InsightViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private val _quoteId = MutableStateFlow("")

    val quote: StateFlow<Quote?> = _quoteId
        .filter { it.isNotEmpty() }
        .flatMapLatest { quoteRepository.getQuoteById(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    fun setQuoteId(id: String) {
        _quoteId.value = id
    }
}
