package com.ataraxy.app.ui.practices.journal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.JournalEntry
import com.ataraxy.app.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

enum class JournalFilter { ALL, REFLECTIONS, MORNING, EVENING }

data class JournalHistoryUiState(
    val filter: JournalFilter = JournalFilter.ALL,
    val entries: List<JournalEntry> = emptyList(),
    val searchQuery: String = ""
)

@HiltViewModel
class JournalHistoryViewModel @Inject constructor(
    private val journalRepository: JournalRepository,
    quoteRepository: QuoteRepository
) : ViewModel() {

    private val _filter = MutableStateFlow(JournalFilter.ALL)
    private val _searchQuery = MutableStateFlow("")

    private val _allEntries = journalRepository.getAllEntries()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    val quotesMap: StateFlow<Map<String, Quote>> = quoteRepository.getAllQuotes()
        .map { quotes -> quotes.associateBy { it.id } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyMap())

    val uiState: StateFlow<JournalHistoryUiState> = combine(
        _filter, _allEntries, _searchQuery
    ) { filter, entries, query ->
        val filtered = when (filter) {
            JournalFilter.ALL -> entries
            JournalFilter.REFLECTIONS -> entries.filter { it.ritualType == null }
            JournalFilter.MORNING -> entries.filter { it.ritualType == "MORNING" }
            JournalFilter.EVENING -> entries.filter { it.ritualType == "EVENING" }
        }
        val searched = if (query.isBlank()) filtered else filtered.filter {
            it.content.contains(query, ignoreCase = true) ||
                it.promptText.contains(query, ignoreCase = true)
        }
        JournalHistoryUiState(filter = filter, entries = searched, searchQuery = query)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), JournalHistoryUiState())

    fun setFilter(filter: JournalFilter) {
        _filter.value = filter
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun deleteEntry(entry: JournalEntry) {
        viewModelScope.launch {
            journalRepository.delete(entry)
        }
    }
}
