package com.ataraxy.app.ui.entry

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.lookback.JournalSession
import com.ataraxy.app.lookback.sessionsOf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

sealed interface EntryUiState {
    data object Loading : EntryUiState
    data object Missing : EntryUiState
    data class Shown(val session: JournalSession, val quote: Quote?) : EntryUiState
}

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class EntryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    journalRepository: JournalRepository,
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private val entryId: Long = checkNotNull(savedStateHandle["entryId"])

    val state: StateFlow<EntryUiState> = journalRepository.getAllEntries()
        .map { entries -> sessionsOf(entries).firstOrNull { session -> session.entries.any { it.id == entryId } } }
        .distinctUntilChanged()
        .flatMapLatest { session ->
            if (session == null) flowOf(EntryUiState.Missing) else shown(session)
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, EntryUiState.Loading)

    private fun shown(session: JournalSession): Flow<EntryUiState> {
        val quoteId = session.representative.takeIf { it.ritualType == null }?.linkedQuoteId
            ?: return flowOf(EntryUiState.Shown(session, null))
        return quoteRepository.getQuoteById(quoteId).map { EntryUiState.Shown(session, it) }
    }
}
