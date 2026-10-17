package com.ataraxy.app.ui.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.preferences.UserPrefsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AtaraxyNavViewModel @Inject constructor(
    val userPrefsRepository: UserPrefsRepository
) : ViewModel() {

    val onboardingComplete = userPrefsRepository.userPrefs
        .map { it.onboardingComplete }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), null)

    fun completeOnboarding() {
        viewModelScope.launch {
            userPrefsRepository.setOnboardingComplete(true)
        }
    }
}
