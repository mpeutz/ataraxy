package com.ataraxy.app.ui.practice

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.JournalEntry
import com.ataraxy.app.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

private const val DRAFT_KEY = "draft"

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class PracticeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val quoteRepository: QuoteRepository,
    private val journalRepository: JournalRepository
) : ViewModel() {

    private val quoteId: String? = savedStateHandle["quoteId"]
    private val entryId: Long? = savedStateHandle.get<Long>("entryId")?.takeIf { it > 0 }
    private val draftRestored = savedStateHandle.contains(DRAFT_KEY)

    val isEditing: Boolean = entryId != null

    /** Unsaved text, kept in saved state so it survives rotation and process death. */
    val draft: StateFlow<String> = savedStateHandle.getStateFlow(DRAFT_KEY, "")

    private val editingEntry: StateFlow<JournalEntry?> =
        (entryId?.let { journalRepository.getEntryById(it) } ?: flowOf(null))
            .stateIn(viewModelScope, SharingStarted.Eagerly, null)

    val quote: StateFlow<Quote?> =
        (quoteId?.let { flowOf(it) } ?: editingEntry.map { it?.linkedQuoteId })
            .distinctUntilChanged()
            .flatMapLatest { id -> id?.let { quoteRepository.getQuoteById(it) } ?: flowOf(null) }
            .stateIn(viewModelScope, SharingStarted.Eagerly, null)

    private val _saveSuccess = MutableStateFlow(false)
    val saveSuccess: StateFlow<Boolean> = _saveSuccess.asStateFlow()

    init {
        if (isEditing && !draftRestored) {
            viewModelScope.launch {
                val entry = editingEntry.filterNotNull().first()
                if (draft.value.isEmpty()) updateDraft(entry.content)
            }
        }
    }

    fun updateDraft(text: String) {
        savedStateHandle[DRAFT_KEY] = text
    }

    /** Saves the draft. [promptText] is the prompt shown to the user, stored with a new entry. */
    fun saveEntry(promptText: String) {
        val content = draft.value
        if (content.isBlank()) return
        val existingEntry = editingEntry.value
        if (isEditing && existingEntry == null) return
        viewModelScope.launch {
            if (existingEntry != null) {
                journalRepository.upsert(existingEntry.copy(content = content, updatedAt = LocalDateTime.now()))
            } else {
                journalRepository.upsert(newEntry(content, promptText, quote.value))
                updateDraft("")
            }
            _saveSuccess.value = true
        }
    }

    fun clearSaveSuccess() {
        _saveSuccess.value = false
    }

    private fun newEntry(content: String, promptText: String, q: Quote?): JournalEntry {
        val now = LocalDateTime.now()
        return JournalEntry(
            createdAt = now,
            updatedAt = now,
            content = content,
            promptText = promptText,
            linkedQuoteId = q?.id,
            virtueId = q?.virtueId
        )
    }
}
