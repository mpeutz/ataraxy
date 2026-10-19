package com.ataraxy.app.ui.practices.whatsyours

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.domain.model.SosEmotion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

internal const val REFLECTION_ID_KEY = "reflectionId"
private const val TYPING_SAVE_DELAY_MS = 400L

enum class FlowStep { SPLIT, ACT }

data class ReflectionFlowUiState(
    val worry: String = "",
    val step: FlowStep = FlowStep.SPLIT,
    val yours: List<String> = emptyList(),
    val notYours: List<String> = emptyList(),
    val yoursDraft: String = "",
    val notYoursDraft: String = "",
    val canDo: String = "",
    val setDown: String = "",
    val quote: Quote? = null,
    val loaded: Boolean = false,
    val confirmingDelete: Boolean = false
) {
    val canContinue: Boolean
        get() = yours.isNotEmpty() || notYours.isNotEmpty() || yoursDraft.isNotBlank() || notYoursDraft.isNotBlank()
    val canFinish: Boolean get() = canDo.isNotBlank() || setDown.isNotBlank()
}

@HiltViewModel
class ReflectionFlowViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: ReflectionRepository,
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private val reflectionId: Long = checkNotNull(savedStateHandle[REFLECTION_ID_KEY])

    private val _uiState = MutableStateFlow(ReflectionFlowUiState())
    val uiState: StateFlow<ReflectionFlowUiState> = _uiState.asStateFlow()

    private var typingSave: Job? = null
    private var lastWrite: Job? = null
    private var finishing = false

    init {
        viewModelScope.launch {
            val reflection = repository.get(reflectionId)
            _uiState.update { state ->
                if (reflection == null) return@update state.copy(loaded = true)
                val answered = reflection.canDo.isNotBlank() || reflection.setDown.isNotBlank()
                val split = reflection.yours.isNotEmpty() || reflection.notYours.isNotEmpty()
                state.copy(
                    worry = reflection.worry,
                    yours = reflection.yours,
                    notYours = reflection.notYours,
                    canDo = reflection.canDo,
                    setDown = reflection.setDown,
                    step = if (split && answered) FlowStep.ACT else FlowStep.SPLIT,
                    loaded = true
                )
            }
            if (_uiState.value.step == FlowStep.ACT) loadQuote()
        }
    }

    fun updateYoursDraft(text: String) = _uiState.update { it.copy(yoursDraft = text) }

    fun updateNotYoursDraft(text: String) = _uiState.update { it.copy(notYoursDraft = text) }

    fun addYours() {
        val line = _uiState.value.yoursDraft.trim()
        if (line.isEmpty()) return
        _uiState.update { it.copy(yours = it.yours + line, yoursDraft = "") }
        save()
    }

    fun addNotYours() {
        val line = _uiState.value.notYoursDraft.trim()
        if (line.isEmpty()) return
        _uiState.update { it.copy(notYours = it.notYours + line, notYoursDraft = "") }
        save()
    }

    fun removeYours(index: Int) {
        _uiState.update { it.copy(yours = it.yours.filterIndexed { i, _ -> i != index }) }
        save()
    }

    fun removeNotYours(index: Int) {
        _uiState.update { it.copy(notYours = it.notYours.filterIndexed { i, _ -> i != index }) }
        save()
    }

    fun updateCanDo(text: String) {
        _uiState.update { it.copy(canDo = text) }
        saveSoon()
    }

    fun updateSetDown(text: String) {
        _uiState.update { it.copy(setDown = text) }
        saveSoon()
    }

    fun next() {
        if (!_uiState.value.canContinue) return
        addYours()
        addNotYours()
        save()
        _uiState.update { it.copy(step = FlowStep.ACT) }
        loadQuote()
    }

    /** Steps back within the flow; returns false at the first step so the screen can close. */
    fun back(): Boolean {
        save()
        if (_uiState.value.step == FlowStep.SPLIT) return false
        _uiState.update { it.copy(step = FlowStep.SPLIT) }
        return true
    }

    fun finish(onDone: (Long) -> Unit) {
        if (finishing || !_uiState.value.canFinish) return
        finishing = true
        save()
        val pending = lastWrite
        viewModelScope.launch {
            pending?.join()
            repository.complete(reflectionId, LocalDateTime.now())
            onDone(reflectionId)
        }
    }

    fun requestDelete() = _uiState.update { it.copy(confirmingDelete = true) }

    fun cancelDelete() = _uiState.update { it.copy(confirmingDelete = false) }

    fun confirmDelete(onDeleted: () -> Unit) {
        typingSave?.cancel()
        _uiState.update { it.copy(confirmingDelete = false) }
        val pending = lastWrite
        viewModelScope.launch {
            pending?.join()
            repository.delete(reflectionId)
            onDeleted()
        }
    }

    private fun loadQuote() {
        if (_uiState.value.quote != null) return
        viewModelScope.launch {
            val quote = quoteRepository.getRandomQuoteForEmotion(SosEmotion.HELPLESS.name)
            _uiState.update { it.copy(quote = quote) }
        }
    }

    private fun saveSoon() {
        typingSave?.cancel()
        typingSave = viewModelScope.launch {
            delay(TYPING_SAVE_DELAY_MS)
            typingSave = null
            save()
        }
    }

    /** Writes the current answers, chained after any earlier write so they land in order. */
    private fun save() {
        typingSave?.cancel()
        val state = _uiState.value
        // Before load the state is empty; writing it would wipe the stored answers.
        if (!state.loaded) return
        val previous = lastWrite
        lastWrite = viewModelScope.launch {
            previous?.join()
            repository.saveAnswers(reflectionId, state.yours, state.notYours, state.canDo, state.setDown)
        }
    }
}
