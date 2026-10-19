package com.ataraxy.app.ui.practices.whatsyours

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.domain.model.Reflection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

private const val DRAFT_KEY = "draftWorry"

data class WhatsYoursUiState(
    val draftWorry: String = "",
    val open: List<Reflection> = emptyList(),
    val past: List<Reflection> = emptyList()
)

@HiltViewModel
class WhatsYoursViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: ReflectionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(WhatsYoursUiState(draftWorry = savedStateHandle[DRAFT_KEY] ?: ""))
    val uiState: StateFlow<WhatsYoursUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.observeOpen().collect { open -> _uiState.update { it.copy(open = open) } }
        }
        viewModelScope.launch {
            repository.observePast().collect { past -> _uiState.update { it.copy(past = past) } }
        }
    }

    fun updateDraft(text: String) {
        savedStateHandle[DRAFT_KEY] = text
        _uiState.update { it.copy(draftWorry = text) }
    }

    /** Starts a reflection for the drafted worry and hands back its id; blank drafts do nothing. */
    fun begin(onCreated: (Long) -> Unit) {
        val worry = _uiState.value.draftWorry.trim()
        if (worry.isEmpty()) return
        updateDraft("")
        viewModelScope.launch { onCreated(repository.create(worry, LocalDateTime.now())) }
    }
}
