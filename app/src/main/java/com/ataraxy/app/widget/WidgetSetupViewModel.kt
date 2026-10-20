package com.ataraxy.app.widget

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.domain.model.UserPrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val STOP_TIMEOUT_MS = 5_000L

@HiltViewModel
class WidgetSetupViewModel @Inject constructor(
    private val store: WidgetStyleStore,
    private val updater: WidgetUpdater,
    quotes: QuoteRepository,
    prefs: UserPrefsRepository
) : ViewModel() {

    val styles: List<WidgetStyle> = availableStyles(Build.VERSION.SDK_INT)

    private val _selected = MutableStateFlow(WidgetStyle.MATCH_APP)
    val selected: StateFlow<WidgetStyle> = _selected.asStateFlow()

    private val _alreadyAdded = MutableStateFlow(false)
    val alreadyAdded: StateFlow<Boolean> = _alreadyAdded.asStateFlow()

    private val _loaded = MutableStateFlow(false)
    val loaded: StateFlow<Boolean> = _loaded.asStateFlow()

    val quote: StateFlow<Quote?> = quotes.getDailyQuote()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(STOP_TIMEOUT_MS), null)

    val userPrefs: StateFlow<UserPrefs?> = prefs.userPrefs
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(STOP_TIMEOUT_MS), null)

    private val _saving = MutableStateFlow(false)
    val saving: StateFlow<Boolean> = _saving.asStateFlow()

    private val _saved = MutableStateFlow(false)
    val saved: StateFlow<Boolean> = _saved.asStateFlow()

    private var loadStarted = false

    /** Reads the widget's stored style once; later calls (such as after rotation) keep the user's pick. */
    fun load(appWidgetId: Int) {
        if (loadStarted) return
        loadStarted = true
        viewModelScope.launch {
            _alreadyAdded.value = store.has(appWidgetId)
            _selected.value = store.get(appWidgetId)
            _loaded.value = true
        }
    }

    fun select(style: WidgetStyle) {
        if (!_loaded.value) return
        _selected.value = style
    }

    /** Runs once; the store write and widget update finish together even if the screen is recreated. */
    fun save(appWidgetId: Int) {
        if (!_loaded.value || _saving.value) return
        _saving.value = true
        val style = _selected.value
        viewModelScope.launch {
            withContext(NonCancellable) {
                store.set(appWidgetId, style)
                updater.updateAll()
            }
            _saved.value = true
        }
    }
}
