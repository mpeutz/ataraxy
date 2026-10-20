package com.ataraxy.app.ui.settings

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.data.backup.BackupFailure
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.theme.AtaraxyText
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

private const val BACKUP_MIME = "application/json"
private const val AUTOMATIC_FILE_NAME = "ataraxy-backup.json"
private val RESTORE_MIME_TYPES = arrayOf("application/json", "application/octet-stream", "text/plain")

@Composable
fun BackupSection(
    onMessage: (String) -> Unit,
    viewModel: BackupViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val pendingRestore by viewModel.pendingRestore.collectAsStateWithLifecycle()
    val keepUpdatingUri by viewModel.offerKeepUpdating.collectAsStateWithLifecycle()
    val resources = LocalResources.current

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

    BackupSwitchRow(
        title = stringResource(R.string.settings_backup_auto),
        value = automaticValue(state),
        enabled = state.enabled,
        onToggle = { on ->
            if (on) turnOnLauncher.launch(AUTOMATIC_FILE_NAME) else viewModel.turnOff()
        }
    )

    if (state.enabled) {
        SettingsRow(
            title = stringResource(R.string.settings_backup_location),
            value = state.locationName ?: stringResource(R.string.settings_backup_location_unknown),
            onClick = { turnOnLauncher.launch(AUTOMATIC_FILE_NAME) }
        )
    }

    if (state.failure == BackupFailure.EXISTING_BACKUP) {
        SettingsRow(
            title = stringResource(R.string.settings_restore),
            value = state.locationName ?: stringResource(R.string.settings_backup_location_unknown),
            onClick = { viewModel.previewRestoreOfBackupFile() }
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
        val preview = pending.preview
        ConfirmDialog(
            title = stringResource(R.string.settings_restore_title),
            message = stringResource(
                R.string.settings_restore_message,
                formatBackupTime(preview.createdAt),
                preview.journalEntryCount,
                preview.reflectionCount
            ),
            confirmLabel = stringResource(R.string.settings_restore_confirm),
            onConfirm = { viewModel.confirmRestore() },
            onDismiss = { viewModel.cancelRestore() },
            isDestructive = true
        )
    }

    keepUpdatingUri?.let { uri ->
        ConfirmDialog(
            title = stringResource(R.string.settings_keep_updating_title),
            message = stringResource(R.string.settings_keep_updating_message),
            confirmLabel = stringResource(R.string.settings_keep_updating_confirm),
            dismissLabel = stringResource(R.string.not_now),
            onConfirm = { viewModel.keepUpdating(uri) },
            onDismiss = { viewModel.dismissKeepUpdating() }
        )
    }
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

@Composable
private fun BackupSwitchRow(
    title: String,
    value: String,
    enabled: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(value = enabled, role = Role.Switch, onValueChange = onToggle)
            .padding(horizontal = 24.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = AtaraxyText.body.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = value,
                style = AtaraxyText.secondary,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        // A null onCheckedChange drops the Switch's own 48dp touch padding; keep its footprint.
        Switch(
            checked = enabled,
            onCheckedChange = null,
            modifier = Modifier.minimumInteractiveComponentSize(),
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.background,
                checkedTrackColor = MaterialTheme.colorScheme.onBackground
            )
        )
    }
    HorizontalDivider(
        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
        thickness = 0.5.dp
    )
}
