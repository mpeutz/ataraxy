package com.ataraxy.app.ui.virtue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.data.repository.VirtueRepository
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.domain.model.Virtue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class VirtueDetailViewModel @Inject constructor(
    private val virtueRepository: VirtueRepository,
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private val _virtueId = MutableStateFlow("")

    val virtue: StateFlow<Virtue?> = _virtueId
        .filter { it.isNotEmpty() }
        .flatMapLatest { virtueRepository.getVirtueById(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    val relatedQuotes: StateFlow<List<Quote>> = _virtueId
        .filter { it.isNotEmpty() }
        .flatMapLatest { quoteRepository.getQuotesByVirtue(it).map { list -> list.take(3) } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun setVirtueId(id: String) {
        _virtueId.value = id
    }
}
