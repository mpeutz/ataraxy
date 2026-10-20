package com.ataraxy.app.widget

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.domain.model.UserPrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
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

    /** Reads the widget's stored style once; later calls (such as after rotation) keep the user's pick. */
    fun load(appWidgetId: Int) {
        if (_loaded.value) return
        viewModelScope.launch {
            _alreadyAdded.value = store.has(appWidgetId)
            _selected.value = store.get(appWidgetId)
            _loaded.value = true
        }
    }

    fun select(style: WidgetStyle) {
        _selected.value = style
    }

    suspend fun save(appWidgetId: Int) {
        store.set(appWidgetId, _selected.value)
        updater.updateAll()
    }
}
