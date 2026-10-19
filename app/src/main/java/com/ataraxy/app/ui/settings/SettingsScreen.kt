package com.ataraxy.app.ui.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.domain.model.ContentTextSize
import com.ataraxy.app.domain.model.NotificationStyle
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.SegmentedToggle
import com.ataraxy.app.ui.theme.AtaraxyText

private enum class TimePickerTarget { DAILY, MORNING, EVENING }

@Composable
fun SettingsScreen(
    onNavigateToAbout: () -> Unit = {},
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val prefs by viewModel.prefs.collectAsStateWithLifecycle()
    val resources = LocalResources.current

    var showClearConfirm by rememberSaveable { mutableStateOf(false) }
    var showDeactivateConfirm by rememberSaveable { mutableStateOf(false) }
    var snackbarMessage by remember { mutableStateOf<String?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }
    var timePickerTarget by rememberSaveable { mutableStateOf<TimePickerTarget?>(null) }

    val journalClearedMessage = stringResource(R.string.settings_journal_cleared)
    val allDataClearedMessage = stringResource(R.string.settings_all_data_cleared)

    LaunchedEffect(Unit) {
        viewModel.exportResults.collect { result ->
            snackbarHostState.showSnackbar(
                result.fold(
                    onSuccess = { resources.getString(R.string.settings_export_success) },
                    onFailure = { resources.getString(R.string.settings_export_failed, it.message.orEmpty()) }
                )
            )
        }
    }

    LaunchedEffect(snackbarMessage) {
        snackbarMessage?.let {
            snackbarHostState.showSnackbar(it)
            snackbarMessage = null
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Header
            Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 20.dp)) {
                Text(
                    text = stringResource(R.string.settings_header_label),
                    style = AtaraxyText.eyebrow,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = stringResource(R.string.settings_title),
                    style = AtaraxyText.display.copy(fontStyle = FontStyle.Italic),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            AtaraxyDivider()

            Spacer(Modifier.height(20.dp))
            PreviewCard()
            Spacer(Modifier.height(20.dp))

            AtaraxyDivider()

            SectionHeader(stringResource(R.string.settings_section_system))

            SettingsRow(
                title = stringResource(R.string.settings_theme),
                value = stringResource(prefs.theme.displayNameRes()),
                onClick = null
            ) {
                ThemeToggle(
                    current = prefs.theme,
                    onSelect = { viewModel.setTheme(it) }
                )
            }

            SettingsRow(
                title = stringResource(R.string.settings_text_size),
                value = stringResource(prefs.contentTextSize.displayNameRes()),
                onClick = null
            ) {
                ContentTextSizeToggle(
                    current = prefs.contentTextSize,
                    onSelect = { viewModel.setContentTextSize(it) }
                )
            }

            SettingsRow(
                title = stringResource(R.string.settings_notification_style),
                value = stringResource(prefs.notificationStyle.displayNameRes()),
                onClick = {
                    val next = if (prefs.notificationStyle == NotificationStyle.MINIMALIST)
                        NotificationStyle.DIRECT_ADDRESS else NotificationStyle.MINIMALIST
                    viewModel.setNotificationStyle(next)
                }
            )

            AtaraxyDivider()
            SectionHeader(stringResource(R.string.settings_section_notifications))

            NotificationGroup(
                title = stringResource(R.string.settings_daily_quote),
                subtitle = stringResource(R.string.settings_daily_quote_subtitle),
                enabled = prefs.notificationsEnabled,
                time = prefs.notificationTime,
                timeLabel = stringResource(R.string.settings_delivery_time),
                onToggle = { viewModel.setNotificationsEnabled(it) },
                onTimeClick = { timePickerTarget = TimePickerTarget.DAILY }
            )

            NotificationGroup(
                title = stringResource(R.string.settings_morning_ritual),
                subtitle = stringResource(R.string.settings_morning_ritual_subtitle),
                enabled = prefs.morningRitualEnabled,
                time = prefs.morningRitualTime,
                timeLabel = stringResource(R.string.settings_reminder_time),
                onToggle = { viewModel.setMorningRitualEnabled(it) },
                onTimeClick = { timePickerTarget = TimePickerTarget.MORNING }
            )

            NotificationGroup(
                title = stringResource(R.string.settings_evening_ritual),
                subtitle = stringResource(R.string.settings_evening_ritual_subtitle),
                enabled = prefs.eveningRitualEnabled,
                time = prefs.eveningRitualTime,
                timeLabel = stringResource(R.string.settings_reminder_time),
                onToggle = { viewModel.setEveningRitualEnabled(it) },
                onTimeClick = { timePickerTarget = TimePickerTarget.EVENING }
            )

            AtaraxyDivider()
            SectionHeader(stringResource(R.string.settings_section_account))

            SettingsRow(
                title = stringResource(R.string.settings_export),
                value = stringResource(R.string.settings_export_value),
                onClick = { viewModel.exportJournal() }
            )

            SettingsRow(
                title = stringResource(R.string.settings_clear_journal),
                value = stringResource(R.string.settings_clear_journal_value),
                onClick = { showClearConfirm = true }
            )

            SettingsRow(
                title = stringResource(R.string.settings_deactivate),
                value = stringResource(R.string.settings_deactivate_value),
                onClick = { showDeactivateConfirm = true },
                isDestructive = true
            )

            AtaraxyDivider()
            SectionHeader(stringResource(R.string.settings_section_app_info))

            SettingsRow(
                title = stringResource(R.string.settings_about),
                value = stringResource(R.string.settings_about_value),
                onClick = { onNavigateToAbout() }
            )

            Spacer(Modifier.height(24.dp))
        }
    }

    timePickerTarget?.let { target ->
        val initial = when (target) {
            TimePickerTarget.DAILY -> prefs.notificationTime
            TimePickerTarget.MORNING -> prefs.morningRitualTime
            TimePickerTarget.EVENING -> prefs.eveningRitualTime
        }
        val title = when (target) {
            TimePickerTarget.DAILY -> R.string.settings_daily_quote_time
            TimePickerTarget.MORNING -> R.string.settings_morning_ritual_time
            TimePickerTarget.EVENING -> R.string.settings_evening_ritual_time
        }
        TimePickerModal(
            title = stringResource(title),
            initial = initial,
            onConfirm = { time ->
                when (target) {
                    TimePickerTarget.DAILY -> viewModel.setNotificationTime(time)
                    TimePickerTarget.MORNING -> viewModel.setMorningRitualTime(time)
                    TimePickerTarget.EVENING -> viewModel.setEveningRitualTime(time)
                }
                timePickerTarget = null
            },
            onDismiss = { timePickerTarget = null }
        )
    }

    if (showClearConfirm) {
        ConfirmDialog(
            title = stringResource(R.string.settings_clear_journal_title),
            message = stringResource(R.string.settings_clear_journal_message),
            confirmLabel = stringResource(R.string.settings_clear_journal_confirm),
            onConfirm = {
                viewModel.clearJournal()
                showClearConfirm = false
                snackbarMessage = journalClearedMessage
            },
            onDismiss = { showClearConfirm = false }
        )
    }

    if (showDeactivateConfirm) {
        ConfirmDialog(
            title = stringResource(R.string.settings_deactivate_title),
            message = stringResource(R.string.settings_deactivate_message),
            confirmLabel = stringResource(R.string.settings_deactivate_confirm),
            onConfirm = {
                viewModel.deactivate()
                showDeactivateConfirm = false
                snackbarMessage = allDataClearedMessage
            },
            onDismiss = { showDeactivateConfirm = false },
            isDestructive = true
        )
    }
}

@StringRes
private fun AppTheme.displayNameRes(): Int = when (this) {
    AppTheme.SYSTEM -> R.string.settings_theme_follow_system
    AppTheme.LIGHT -> R.string.settings_theme_light
    AppTheme.DARK -> R.string.settings_theme_dark
}

@StringRes
private fun ContentTextSize.displayNameRes(): Int = when (this) {
    ContentTextSize.DEFAULT -> R.string.settings_text_size_default
    ContentTextSize.LARGE -> R.string.settings_text_size_large
    ContentTextSize.LARGER -> R.string.settings_text_size_larger
}

@StringRes
private fun NotificationStyle.displayNameRes(): Int = when (this) {
    NotificationStyle.MINIMALIST -> R.string.settings_notification_style_minimalist
    NotificationStyle.DIRECT_ADDRESS -> R.string.settings_notification_style_direct
}

@Composable
internal fun ThemeToggle(current: AppTheme, onSelect: (AppTheme) -> Unit) {
    SegmentedToggle(
        options = listOf(
            AppTheme.SYSTEM to stringResource(R.string.settings_theme_option_system),
            AppTheme.LIGHT to stringResource(R.string.settings_theme_option_light),
            AppTheme.DARK to stringResource(R.string.settings_theme_option_dark)
        ),
        selected = current,
        onSelect = onSelect
    )
}
