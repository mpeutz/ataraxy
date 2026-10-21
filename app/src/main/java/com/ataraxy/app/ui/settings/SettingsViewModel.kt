package com.ataraxy.app.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.data.backup.AutomaticBackupController
import com.ataraxy.app.data.export.JournalExporter
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.data.repository.SosRepository
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.domain.model.ContentTextSize
import com.ataraxy.app.domain.model.NotificationStyle
import com.ataraxy.app.domain.model.UserPrefs
import com.ataraxy.app.lock.AppLock
import com.ataraxy.app.notifications.NotificationScheduler
import com.ataraxy.app.widget.WidgetUpdater
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPrefsRepository: UserPrefsRepository,
    private val journalRepository: JournalRepository,
    private val notificationScheduler: NotificationScheduler,
    private val reflectionRepository: ReflectionRepository,
    private val sosRepository: SosRepository,
    private val journalExporter: JournalExporter,
    private val automaticBackupController: AutomaticBackupController,
    private val appLock: AppLock,
    private val widgets: WidgetUpdater
) : ViewModel() {

    private val _exportResults = Channel<Result<Unit>>(Channel.BUFFERED)
    val exportResults: Flow<Result<Unit>> = _exportResults.receiveAsFlow()

    val prefs: StateFlow<UserPrefs> = userPrefsRepository.userPrefs
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), UserPrefs())

    fun setTheme(theme: AppTheme) {
        viewModelScope.launch {
            userPrefsRepository.setTheme(theme)
            widgets.updateAll()
        }
    }

    fun setContentTextSize(size: ContentTextSize) {
        viewModelScope.launch { userPrefsRepository.setContentTextSize(size) }
    }

    fun setNotificationTime(time: LocalTime) {
        viewModelScope.launch {
            userPrefsRepository.setNotificationTime(time)
            notificationScheduler.schedule(time)
        }
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        viewModelScope.launch {
            userPrefsRepository.setNotificationsEnabled(enabled)
            if (enabled) notificationScheduler.schedule(prefs.value.notificationTime)
            else notificationScheduler.cancel()
        }
    }

    fun setNotificationStyle(style: NotificationStyle) {
        viewModelScope.launch { userPrefsRepository.setNotificationStyle(style) }
    }

    fun setMorningRitualEnabled(enabled: Boolean) {
        viewModelScope.launch {
            userPrefsRepository.setMorningRitualEnabled(enabled)
            if (enabled) notificationScheduler.scheduleMorningRitual(prefs.value.morningRitualTime)
            else notificationScheduler.cancelMorningRitual()
        }
    }

    fun setMorningRitualTime(time: LocalTime) {
        viewModelScope.launch {
            userPrefsRepository.setMorningRitualTime(time)
            notificationScheduler.scheduleMorningRitual(time)
        }
    }

    fun setEveningRitualEnabled(enabled: Boolean) {
        viewModelScope.launch {
            userPrefsRepository.setEveningRitualEnabled(enabled)
            if (enabled) notificationScheduler.scheduleEveningRitual(prefs.value.eveningRitualTime)
            else notificationScheduler.cancelEveningRitual()
        }
    }

    fun setEveningRitualTime(time: LocalTime) {
        viewModelScope.launch {
            userPrefsRepository.setEveningRitualTime(time)
            notificationScheduler.scheduleEveningRitual(time)
        }
    }

    fun clearJournal() {
        viewModelScope.launch { journalRepository.deleteAll() }
    }

    fun deactivate() {
        viewModelScope.launch {
            automaticBackupController.disable()
            journalRepository.deleteAll()
            reflectionRepository.deleteAll()
            sosRepository.deleteAll()
            notificationScheduler.cancelAll()
            appLock.setEnabled(false)
            userPrefsRepository.clearAll()
            widgets.updateAll()
        }
    }

    fun exportJournal() {
        viewModelScope.launch { _exportResults.send(journalExporter.exportToDownloads()) }
    }
}
