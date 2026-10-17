package com.ataraxy.wear.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.wear.data.WearQuoteStore
import com.ataraxy.wear.domain.ReceivedQuote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WearViewModel @Inject constructor(
    private val wearQuoteStore: WearQuoteStore
) : ViewModel() {

    val quote: StateFlow<ReceivedQuote?> = wearQuoteStore.quote.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )
}
