package com.ataraxy.app.ui.settings

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.data.backup.BackupFailure
import com.ataraxy.app.ui.components.AtaraxyDivider
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

private const val BACKUP_MIME = "application/json"
private const val AUTOMATIC_FILE_NAME = "ataraxy-backup.json"
internal val RESTORE_MIME_TYPES = arrayOf("application/json", "application/octet-stream", "text/plain")

@Composable
fun BackupSection(
    onMessage: (String) -> Unit,
    viewModel: BackupViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val pendingRestore by viewModel.pendingRestore.collectAsStateWithLifecycle()
    val keepUpdatingUri by viewModel.offerKeepUpdating.collectAsStateWithLifecycle()
    val resources = LocalResources.current
    var showReplaceConfirm by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            val message = when (event) {
                BackupEvent.Saved -> R.string.settings_backup_saved
                BackupEvent.Restored -> R.string.settings_restored
                is BackupEvent.Failed -> event.message
            }
            onMessage(resources.getString(message))
        }
    }

    val turnOnLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument(BACKUP_MIME)
    ) { uri -> uri?.let { viewModel.turnOn(it.toString()) } }
    val backUpNowLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument(BACKUP_MIME)
    ) { uri -> uri?.let { viewModel.backUpNow(it.toString()) } }
    val restoreLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri -> uri?.let { viewModel.previewRestore(it.toString()) } }

    AtaraxyDivider()
    SectionHeader(stringResource(R.string.settings_section_backup))

    SettingsSwitchRow(
        title = stringResource(R.string.settings_backup_auto),
        subtitle = automaticValue(state),
        checked = state.enabled,
        onToggle = { on ->
            if (on) turnOnLauncher.launch(AUTOMATIC_FILE_NAME) else viewModel.turnOff()
        }
    )
    RowDivider()

    if (state.enabled) {
        SettingsRow(
            title = stringResource(R.string.settings_backup_location),
            value = state.locationName ?: stringResource(R.string.settings_backup_location_unknown),
            onClick = { turnOnLauncher.launch(AUTOMATIC_FILE_NAME) }
        )
    }

    if (state.failure == BackupFailure.EXISTING_BACKUP) {
        SettingsRow(
            title = stringResource(R.string.settings_backup_restore_blocked),
            value = state.locationName ?: stringResource(R.string.settings_backup_location_unknown),
            onClick = { viewModel.previewRestoreOfBackupFile() }
        )
        SettingsRow(
            title = stringResource(R.string.settings_backup_replace),
            value = stringResource(R.string.settings_backup_replace_value),
            onClick = { showReplaceConfirm = true },
            isDestructive = true
        )
    }

    SettingsRow(
        title = stringResource(R.string.settings_backup_now),
        value = stringResource(R.string.settings_backup_now_value),
        onClick = { backUpNowLauncher.launch(viewModel.manualBackupFileName()) }
    )

    SettingsRow(
        title = stringResource(R.string.settings_restore),
        value = stringResource(R.string.settings_restore_value),
        onClick = { restoreLauncher.launch(RESTORE_MIME_TYPES) }
    )

    pendingRestore?.let { pending ->
        RestoreConfirmDialog(
            pending = pending,
            onConfirm = { viewModel.confirmRestore() },
            onDismiss = { viewModel.cancelRestore() }
        )
    }

    keepUpdatingUri?.let { uri ->
        KeepUpdatingDialog(
            onKeep = { viewModel.keepUpdating(uri) },
            onDismiss = { viewModel.dismissKeepUpdating() }
        )
    }

    if (showReplaceConfirm) {
        ConfirmDialog(
            title = stringResource(R.string.settings_backup_replace_title),
            message = stringResource(R.string.settings_backup_replace_message),
            confirmLabel = stringResource(R.string.settings_backup_replace_confirm),
            onConfirm = {
                showReplaceConfirm = false
                viewModel.replaceBlockedBackup()
            },
            onDismiss = { showReplaceConfirm = false },
            isDestructive = true
        )
    }
}

@Composable
internal fun RestoreConfirmDialog(
    pending: PendingRestore,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    val preview = pending.preview
    val message = stringResource(
        R.string.settings_restore_message,
        formatBackupTime(preview.createdAt),
        pluralStringResource(R.plurals.settings_restore_entries, preview.journalEntryCount, preview.journalEntryCount),
        pluralStringResource(R.plurals.settings_restore_reflections, preview.reflectionCount, preview.reflectionCount)
    )
    val updatesBackup = stringResource(R.string.settings_restore_updates_backup)
    ConfirmDialog(
        title = stringResource(R.string.settings_restore_title),
        message = if (pending.updatesAutomaticBackup) "$message $updatesBackup" else message,
        confirmLabel = stringResource(R.string.settings_restore_confirm),
        onConfirm = onConfirm,
        onDismiss = onDismiss,
        isDestructive = true
    )
}

@Composable
internal fun KeepUpdatingDialog(onKeep: () -> Unit, onDismiss: () -> Unit) {
    ConfirmDialog(
        title = stringResource(R.string.settings_keep_updating_title),
        message = stringResource(R.string.settings_keep_updating_message),
        confirmLabel = stringResource(R.string.settings_keep_updating_confirm),
        dismissLabel = stringResource(R.string.not_now),
        onConfirm = onKeep,
        onDismiss = onDismiss
    )
}

@Composable
private fun automaticValue(state: BackupUiState): String {
    val failure = when (state.failure) {
        BackupFailure.NO_ACCESS -> R.string.settings_backup_failed_access
        BackupFailure.EXISTING_BACKUP -> R.string.settings_backup_failed_existing
        BackupFailure.UNKNOWN -> R.string.settings_backup_failed_unknown
        null -> null
    }
    return when {
        !state.enabled -> stringResource(R.string.settings_backup_auto_off)
        failure != null -> stringResource(failure)
        state.lastSuccessAt != null ->
            stringResource(R.string.settings_backup_last, formatBackupTime(state.lastSuccessAt))
        else -> stringResource(R.string.settings_backup_pending)
    }
}

@Composable
private fun formatBackupTime(instant: Instant): String {
    val formatter = remember {
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT)
            .withZone(ZoneId.systemDefault())
    }
    return formatter.format(instant)
}
