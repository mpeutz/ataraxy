package com.ataraxy.app.ui.practices.dichotomy

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.ControlItemRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.ControlBucket
import com.ataraxy.app.domain.model.ControlItem
import com.ataraxy.app.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

private const val INPUT_KEY = "inputText"
private const val ACTION_ITEM_KEY = "actionStepItemId"
private const val ACTION_TEXT_KEY = "actionStepText"

data class DichotomyUiState(
    val inputText: String = "",
    val pendingItems: List<ControlItem> = emptyList(),
    val inControlItems: List<ControlItem> = emptyList(),
    val completedItems: List<ControlItem> = emptyList(),
    val releasedItems: List<ControlItem> = emptyList(),
    val releasedCount: Int = 0,
    val dismissQuote: Quote? = null,
    val actionStepPromptItemId: Long? = null,
    val actionStepText: String = "",
    val showCompleted: Boolean = true,
    val showReleased: Boolean = true
)

@HiltViewModel
class DichotomyViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val controlItemRepository: ControlItemRepository,
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        DichotomyUiState(
            inputText = savedStateHandle[INPUT_KEY] ?: "",
            actionStepPromptItemId = savedStateHandle[ACTION_ITEM_KEY],
            actionStepText = savedStateHandle[ACTION_TEXT_KEY] ?: ""
        )
    )
    val uiState: StateFlow<DichotomyUiState> = _uiState

    init {
        // Mirrors unsaved text into saved state so it survives process death.
        viewModelScope.launch {
            _uiState.collect { state ->
                savedStateHandle[INPUT_KEY] = state.inputText
                savedStateHandle[ACTION_ITEM_KEY] = state.actionStepPromptItemId
                savedStateHandle[ACTION_TEXT_KEY] = state.actionStepText
            }
        }
        viewModelScope.launch {
            controlItemRepository.getActiveItems().collect { items ->
                _uiState.update { it.copy(pendingItems = items) }
            }
        }
        viewModelScope.launch {
            controlItemRepository.getInControlItems().collect { items ->
                _uiState.update { it.copy(inControlItems = items) }
            }
        }
        viewModelScope.launch {
            controlItemRepository.getCompletedItems().collect { items ->
                _uiState.update { it.copy(completedItems = items) }
            }
        }
        viewModelScope.launch {
            controlItemRepository.getReleasedItems().collect { items ->
                _uiState.update { it.copy(releasedItems = items, releasedCount = items.size) }
            }
        }
    }

    fun updateInputText(text: String) {
        _uiState.update { it.copy(inputText = text) }
    }

    fun addItem() {
        val text = _uiState.value.inputText.trim()
        if (text.isBlank()) return
        _uiState.update { it.copy(inputText = "") }
        viewModelScope.launch {
            controlItemRepository.upsert(
                ControlItem(
                    text = text,
                    bucket = null,
                    createdAt = LocalDateTime.now()
                )
            )
        }
    }

    fun sortItem(itemId: Long, bucket: ControlBucket) {
        viewModelScope.launch {
            controlItemRepository.updateBucket(itemId, bucket)
            if (bucket == ControlBucket.NOT_IN_CONTROL) {
                controlItemRepository.archiveItem(itemId)
                val quote = quoteRepository.getRandomQuoteForEmotion("ANXIETY")
                _uiState.update { it.copy(dismissQuote = quote) }
            } else {
                _uiState.update { it.copy(actionStepPromptItemId = itemId) }
            }
        }
    }

    fun markDone(itemId: Long) {
        viewModelScope.launch {
            controlItemRepository.archiveItem(itemId)
        }
    }

    fun updateItemText(itemId: Long, text: String) {
        val trimmed = text.trim()
        if (trimmed.isBlank()) return
        viewModelScope.launch {
            controlItemRepository.updateText(itemId, trimmed)
        }
    }

    fun deleteItem(itemId: Long) {
        viewModelScope.launch {
            controlItemRepository.deleteById(itemId)
        }
    }

    fun moveToPending(itemId: Long) {
        viewModelScope.launch {
            controlItemRepository.clearBucket(itemId)
            controlItemRepository.unarchiveItem(itemId)
        }
    }

    fun moveToInControl(itemId: Long) {
        viewModelScope.launch {
            controlItemRepository.updateBucket(itemId, ControlBucket.IN_CONTROL)
            controlItemRepository.unarchiveItem(itemId)
        }
    }

    fun moveToReleased(itemId: Long) {
        viewModelScope.launch {
            controlItemRepository.updateBucket(itemId, ControlBucket.NOT_IN_CONTROL)
            controlItemRepository.archiveItem(itemId)
        }
    }

    fun restoreToInControl(itemId: Long) {
        viewModelScope.launch {
            controlItemRepository.updateBucket(itemId, ControlBucket.IN_CONTROL)
            controlItemRepository.unarchiveItem(itemId)
        }
    }

    fun restoreToPending(itemId: Long) {
        viewModelScope.launch {
            controlItemRepository.clearBucket(itemId)
            controlItemRepository.unarchiveItem(itemId)
        }
    }

    fun dismissQuoteSeen() {
        _uiState.update { it.copy(dismissQuote = null) }
    }

    fun updateActionStepText(text: String) {
        _uiState.update { it.copy(actionStepText = text) }
    }

    fun saveActionStep() {
        val itemId = _uiState.value.actionStepPromptItemId ?: return
        val step = _uiState.value.actionStepText.trim()
        viewModelScope.launch {
            if (step.isNotBlank()) {
                controlItemRepository.updateActionStep(itemId, step)
            }
            _uiState.update { it.copy(actionStepPromptItemId = null, actionStepText = "") }
        }
    }

    fun clearActionStepPrompt() {
        _uiState.update { it.copy(actionStepPromptItemId = null, actionStepText = "") }
    }

    fun promptActionStep(itemId: Long) {
        _uiState.update { it.copy(actionStepPromptItemId = itemId) }
    }

    fun toggleShowCompleted() {
        _uiState.update { it.copy(showCompleted = !it.showCompleted) }
    }

    fun toggleShowReleased() {
        _uiState.update { it.copy(showReleased = !it.showReleased) }
    }
}
