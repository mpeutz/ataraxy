package com.ataraxy.app.ui.practices.whatsyours

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.lookback.isCheckInDue
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.domain.model.Reflection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Clock
import java.time.LocalDateTime
import javax.inject.Inject

private const val NOTE_DRAFT_KEY = "noteDraft"

data class ReflectionDetailUiState(
    val reflection: Reflection? = null,
    val noteDraft: String = "",
    val confirmingDelete: Boolean = false,
    val checkInDue: Boolean = false
)

@HiltViewModel
class ReflectionDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ReflectionRepository,
    private val clock: Clock
) : ViewModel() {

    private val reflectionId: Long = checkNotNull(savedStateHandle[REFLECTION_ID_KEY])

    private val _uiState = MutableStateFlow(ReflectionDetailUiState(noteDraft = savedStateHandle[NOTE_DRAFT_KEY] ?: ""))
    val uiState: StateFlow<ReflectionDetailUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.observe(reflectionId).collect { reflection ->
                if (reflection != null) _uiState.update { it.copy(reflection = reflection, checkInDue = isDue(reflection)) }
            }
        }
    }

    fun updateNoteDraft(text: String) {
        savedStateHandle[NOTE_DRAFT_KEY] = text
        _uiState.update { it.copy(noteDraft = text) }
    }

    fun addNote() {
        val note = _uiState.value.noteDraft.trim()
        if (note.isEmpty()) return
        updateNoteDraft("")
        viewModelScope.launch { repository.addNote(reflectionId, note, LocalDateTime.now(clock)) }
    }

    fun setDown() {
        viewModelScope.launch { repository.setDown(reflectionId, LocalDateTime.now(clock)) }
    }

    fun stillCarrying(noteText: String) {
        viewModelScope.launch { repository.addNote(reflectionId, noteText, LocalDateTime.now(clock)) }
    }

    /** Re-checks the two-week mark; the screen calls this on resume. */
    fun refresh() {
        _uiState.update { state -> state.copy(checkInDue = state.reflection?.let(::isDue) ?: false) }
    }

    private fun isDue(reflection: Reflection) = isCheckInDue(reflection, LocalDateTime.now(clock))

    fun pickUp() {
        viewModelScope.launch { repository.pickUp(reflectionId) }
    }

    fun requestDelete() = _uiState.update { it.copy(confirmingDelete = true) }

    fun cancelDelete() = _uiState.update { it.copy(confirmingDelete = false) }

    fun confirmDelete(onDeleted: () -> Unit) {
        _uiState.update { it.copy(confirmingDelete = false) }
        viewModelScope.launch {
            repository.delete(reflectionId)
            onDeleted()
        }
    }
}
