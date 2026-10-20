package com.ataraxy.app.ui.settings

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ataraxy.app.R
import com.ataraxy.app.data.backup.AppVersion
import com.ataraxy.app.data.backup.AutomaticBackupController
import com.ataraxy.app.data.backup.BackupCodec
import com.ataraxy.app.data.backup.BackupDocuments
import com.ataraxy.app.data.backup.BackupFailure
import com.ataraxy.app.data.backup.BackupPreview
import com.ataraxy.app.data.backup.BackupRepository
import com.ataraxy.app.data.backup.BackupSettings
import com.ataraxy.app.data.backup.BackupSettingsRepository
import com.ataraxy.app.data.backup.RestoreBackup
import com.ataraxy.app.data.backup.RestoreException
import com.ataraxy.app.data.backup.RestoreProblem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import javax.inject.Inject

data class BackupUiState(
    val enabled: Boolean = false,
    val locationName: String? = null,
    val lastSuccessAt: Instant? = null,
    val failure: BackupFailure? = null
)

data class PendingRestore(val uri: String, val preview: BackupPreview)

sealed interface BackupEvent {
    data object Saved : BackupEvent
    data object Restored : BackupEvent
    data class Failed(@StringRes val message: Int) : BackupEvent
}

@HiltViewModel
class BackupViewModel @Inject constructor(
    private val controller: AutomaticBackupController,
    private val settingsRepository: BackupSettingsRepository,
    private val documents: BackupDocuments,
    private val backupRepository: BackupRepository,
    private val restoreBackup: RestoreBackup,
    private val appVersion: AppVersion,
    private val clock: Clock
) : ViewModel() {

    val state: StateFlow<BackupUiState> = settingsRepository.settings
        .map { it.toUiState() }
        .flowOn(Dispatchers.IO)
        .stateIn(viewModelScope, SharingStarted.Eagerly, BackupUiState())

    private val _events = Channel<BackupEvent>(Channel.BUFFERED)
    val events: Flow<BackupEvent> = _events.receiveAsFlow()

    private val _pendingRestore = MutableStateFlow<PendingRestore?>(null)
    val pendingRestore: StateFlow<PendingRestore?> = _pendingRestore

    private val _offerKeepUpdating = MutableStateFlow<String?>(null)
    val offerKeepUpdating: StateFlow<String?> = _offerKeepUpdating

    fun manualBackupFileName(): String = "ataraxy-backup-${LocalDate.now(clock)}.json"

    fun turnOn(uri: String) {
        viewModelScope.launch {
            if (!controller.enable(uri)) _events.send(BackupEvent.Failed(R.string.settings_backup_failed_access))
        }
    }

    fun turnOff() {
        viewModelScope.launch { controller.disable() }
    }

    fun backUpNow(uri: String) {
        viewModelScope.launch {
            try {
                val text = BackupCodec.encode(backupRepository.snapshot(), clock.instant(), appVersion.code())
                documents.write(uri, text)
                _events.send(BackupEvent.Saved)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _events.send(BackupEvent.Failed(R.string.settings_backup_failed_access))
            }
        }
    }

    /** Opens the restore flow for the file automatic backup is pointed at. */
    fun previewRestoreOfBackupFile() {
        viewModelScope.launch {
            val target = settingsRepository.settings.first().targetUri ?: return@launch
            preview(target)
        }
    }

    fun previewRestore(uri: String) {
        viewModelScope.launch { preview(uri) }
    }

    private suspend fun preview(uri: String) {
        restoreBackup.preview(uri).fold(
            onSuccess = { _pendingRestore.value = PendingRestore(uri, it) },
            onFailure = { fail(it) }
        )
    }

    fun confirmRestore() {
        val pending = _pendingRestore.value ?: return
        _pendingRestore.value = null
        viewModelScope.launch {
            restoreBackup.restore(pending.uri).fold(
                onSuccess = {
                    val target = settingsRepository.settings.first().targetUri
                    if (target == null) _offerKeepUpdating.value = pending.uri
                    else controller.enable(target)
                    _events.send(BackupEvent.Restored)
                },
                onFailure = { fail(it) }
            )
        }
    }

    fun cancelRestore() {
        _pendingRestore.value = null
    }

    fun keepUpdating(uri: String) {
        _offerKeepUpdating.value = null
        turnOn(uri)
    }

    fun dismissKeepUpdating() {
        _offerKeepUpdating.value = null
    }

    private suspend fun fail(error: Throwable) {
        val message = when ((error as? RestoreException)?.problem) {
            RestoreProblem.NOT_A_BACKUP -> R.string.settings_restore_not_backup
            RestoreProblem.NEWER_VERSION -> R.string.settings_restore_newer
            RestoreProblem.NO_ACCESS, null -> R.string.settings_restore_no_access
        }
        _events.send(BackupEvent.Failed(message))
    }

    private fun BackupSettings.toUiState() = BackupUiState(
        enabled = targetUri != null,
        locationName = targetUri?.let(documents::displayName),
        lastSuccessAt = lastSuccessAt,
        failure = failure
    )
}
