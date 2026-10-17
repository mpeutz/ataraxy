package com.ataraxy.app.ui.practice

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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class PracticeViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository,
    private val journalRepository: JournalRepository
) : ViewModel() {

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> = _quote.asStateFlow()

    private val _editingEntry = MutableStateFlow<JournalEntry?>(null)

    val editingContent: StateFlow<String?> = _editingEntry
        .map { it?.content }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    private val _saveSuccess = MutableStateFlow(false)
    val saveSuccess: StateFlow<Boolean> = _saveSuccess.asStateFlow()

    fun setQuoteId(quoteId: String?) {
        if (quoteId != null) {
            viewModelScope.launch {
                quoteRepository.getQuoteById(quoteId).collect { q ->
                    _quote.value = q
                }
            }
        }
    }

    fun setEntryId(entryId: Long?) {
        if (entryId != null && entryId > 0) {
            viewModelScope.launch {
                journalRepository.getEntryById(entryId).collect { entry ->
                    _editingEntry.value = entry
                    if (entry?.linkedQuoteId != null) {
                        setQuoteId(entry.linkedQuoteId)
                    }
                }
            }
        }
    }

    fun saveEntry(content: String) {
        val existingEntry = _editingEntry.value
        if (existingEntry != null) {
            viewModelScope.launch {
                journalRepository.upsert(existingEntry.copy(content = content, updatedAt = LocalDateTime.now()))
                _saveSuccess.value = true
            }
        } else {
            val q = _quote.value
            val now = LocalDateTime.now()
            val prompt = if (q != null) "How can I apply this today?" else "What weighs on your mind today?"
            viewModelScope.launch {
                journalRepository.upsert(
                    JournalEntry(
                        createdAt = now,
                        updatedAt = now,
                        content = content,
                        promptText = prompt,
                        linkedQuoteId = q?.id,
                        virtueId = q?.virtueId
                    )
                )
                _saveSuccess.value = true
            }
        }
    }

    fun clearSaveSuccess() {
        _saveSuccess.value = false
    }
}
