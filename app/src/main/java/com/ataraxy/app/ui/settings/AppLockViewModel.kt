package com.ataraxy.app.ui.settings

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.lock.AppLock
import com.ataraxy.app.lock.DeviceAuthenticator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class AppLockUiState(val enabled: Boolean, val available: Boolean)

@HiltViewModel
class AppLockViewModel @Inject constructor(
    private val appLock: AppLock,
    private val authenticator: DeviceAuthenticator
) : ViewModel() {

    private val available = MutableStateFlow(appLock.isAvailable())

    val state: StateFlow<AppLockUiState> = combine(appLock.enabled, available, ::AppLockUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            AppLockUiState(appLock.enabled.value, available.value)
        )

    /** Re-reads whether the phone has a screen lock, e.g. after the user returns from setting one up. */
    fun refreshAvailability() {
        available.value = appLock.isAvailable()
    }

    suspend fun toggle(activity: FragmentActivity, title: String) {
        if (!appLock.isAvailable()) return
        if (!authenticator.authenticate(activity, title)) return
        appLock.setEnabled(!appLock.enabled.value)
    }
}
