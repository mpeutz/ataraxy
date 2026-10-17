package com.ataraxy.app.ui.settings

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.domain.model.ContentTextSize
import com.ataraxy.app.domain.model.NotificationStyle
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.DestructiveRed
import com.ataraxy.app.ui.theme.Jost
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onNavigateToAbout: () -> Unit = {},
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val prefs by viewModel.prefs.collectAsStateWithLifecycle()

    var showClearConfirm by remember { mutableStateOf(false) }
    var showDeactivateConfirm by remember { mutableStateOf(false) }
    var snackbarMessage by remember { mutableStateOf<String?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }

    // Which time picker is open: "daily", "morning", "evening", or null
    var timePickerTarget by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        viewModel.exportResults.collect { result ->
            snackbarHostState.showSnackbar(
                result.fold(
                    onSuccess = { "Journal exported to Downloads" },
                    onFailure = { "Export failed: ${it.message}" }
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
                    text = "CONFIGURATION",
                    style = MaterialTheme.typography.labelLarge.copy(fontFamily = Jost, letterSpacing = 4.sp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontFamily = CormorantGaramond,
                        fontStyle = FontStyle.Italic
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

            // Preview quote card
            Spacer(Modifier.height(20.dp))
            PreviewCard()
            Spacer(Modifier.height(20.dp))

            Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

            // System Preferences
            SectionHeader("SYSTEM PREFERENCES")

            // Theme toggle
            SettingsRow(
                title = "Theme",
                value = prefs.theme.name,
                onClick = {}
            ) {
                ThemeToggle(
                    current = prefs.theme,
                    onSelect = { viewModel.setTheme(it) }
                )
            }

            SettingsRow(
                title = "Content Text Size",
                value = when (prefs.contentTextSize) {
                    ContentTextSize.DEFAULT -> "Default"
                    ContentTextSize.LARGE -> "Large"
                    ContentTextSize.LARGER -> "Largest"
                },
                onClick = {}
            ) {
                ContentTextSizeToggle(
                    current = prefs.contentTextSize,
                    onSelect = { viewModel.setContentTextSize(it) }
                )
            }

            // Notification style
            SettingsRow(
                title = "Notification Style",
                value = when (prefs.notificationStyle) {
                    NotificationStyle.MINIMALIST -> "Minimalist Text"
                    NotificationStyle.DIRECT_ADDRESS -> "Direct Address"
                },
                onClick = {
                    val next = if (prefs.notificationStyle == NotificationStyle.MINIMALIST)
                        NotificationStyle.DIRECT_ADDRESS else NotificationStyle.MINIMALIST
                    viewModel.setNotificationStyle(next)
                }
            )

            Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
            SectionHeader("NOTIFICATIONS")

            // Daily Quote
            NotificationGroup(
                title = "Daily Quote",
                subtitle = "A Stoic quote each morning",
                enabled = prefs.notificationsEnabled,
                time = prefs.notificationTime,
                timeLabel = "Delivery time",
                onToggle = { viewModel.setNotificationsEnabled(it) },
                onTimeClick = { timePickerTarget = "daily" }
            )

            // Morning Ritual
            NotificationGroup(
                title = "Morning Ritual",
                subtitle = "Reminder to begin your morning practice",
                enabled = prefs.morningRitualEnabled,
                time = prefs.morningRitualTime,
                timeLabel = "Reminder time",
                onToggle = { viewModel.setMorningRitualEnabled(it) },
                onTimeClick = { timePickerTarget = "morning" }
            )

            // Evening Ritual
            NotificationGroup(
                title = "Evening Ritual",
                subtitle = "Reminder to close your day with reflection",
                enabled = prefs.eveningRitualEnabled,
                time = prefs.eveningRitualTime,
                timeLabel = "Reminder time",
                onToggle = { viewModel.setEveningRitualEnabled(it) },
                onTimeClick = { timePickerTarget = "evening" }
            )

            Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
            SectionHeader("ACCOUNT & SOUL")

            // Export
            SettingsRow(
                title = "Export Personal Reflections",
                value = "Save to Downloads",
                onClick = { viewModel.exportJournal() }
            )

            // Clear journal
            SettingsRow(
                title = "Clear Local Sanctuary",
                value = "Delete all journal entries",
                onClick = { showClearConfirm = true }
            )

            // Deactivate
            SettingsRow(
                title = "Deactivate Ataraxy",
                value = "Clear all data",
                onClick = { showDeactivateConfirm = true },
                isDestructive = true
            )

            Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
            SectionHeader("APP INFORMATION")

            // About
            SettingsRow(
                title = "About & Disclaimers",
                value = "Sources, attributions, and information",
                onClick = { onNavigateToAbout() }
            )

            Spacer(Modifier.height(24.dp))
        }
    }

    if (timePickerTarget != null) {
        val initial = when (timePickerTarget) {
            "morning" -> prefs.morningRitualTime
            "evening" -> prefs.eveningRitualTime
            else -> prefs.notificationTime
        }
        val title = when (timePickerTarget) {
            "morning" -> "Morning Ritual Time"
            "evening" -> "Evening Ritual Time"
            else -> "Daily Quote Time"
        }
        TimePickerModal(
            title = title,
            initial = initial,
            onConfirm = { time ->
                when (timePickerTarget) {
                    "morning" -> viewModel.setMorningRitualTime(time)
                    "evening" -> viewModel.setEveningRitualTime(time)
                    else -> viewModel.setNotificationTime(time)
                }
                timePickerTarget = null
            },
            onDismiss = { timePickerTarget = null }
        )
    }

    if (showClearConfirm) {
        ConfirmDialog(
            title = "Clear Your Sanctuary?",
            message = "All journal entries will be permanently deleted. This cannot be undone.",
            confirmLabel = "Clear",
            onConfirm = {
                viewModel.clearJournal()
                showClearConfirm = false
                snackbarMessage = "Journal cleared"
            },
            onDismiss = { showClearConfirm = false }
        )
    }

    if (showDeactivateConfirm) {
        ConfirmDialog(
            title = "Deactivate Ataraxy?",
            message = "All data, preferences, and journal entries will be deleted. Notifications will be cancelled.",
            confirmLabel = "Deactivate",
            onConfirm = {
                viewModel.deactivate()
                showDeactivateConfirm = false
                snackbarMessage = "All data cleared"
            },
            onDismiss = { showDeactivateConfirm = false },
            isDestructive = true
        )
    }
}

@Composable
private fun NotificationGroup(
    title: String,
    subtitle: String,
    enabled: Boolean,
    time: LocalTime,
    timeLabel: String,
    onToggle: (Boolean) -> Unit,
    onTimeClick: () -> Unit
) {
    val timeFormatter = remember { DateTimeFormatter.ofPattern("h:mm a") }
    val contentAlpha = if (enabled) 1f else 0.38f

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = Jost,
                    fontWeight = FontWeight.Medium
                ),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = contentAlpha)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = Jost),
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = contentAlpha)
            )
        }
        Switch(
            checked = enabled,
            onCheckedChange = onToggle,
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.background,
                checkedTrackColor = MaterialTheme.colorScheme.onBackground
            )
        )
    }

    AnimatedVisibility(visible = enabled) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onTimeClick() }
                .padding(start = 24.dp, end = 24.dp, top = 10.dp, bottom = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = timeLabel,
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = Jost),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = time.format(timeFormatter),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = Jost,
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Outlined.ChevronRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }

    Divider(
        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
        thickness = 0.5.dp
    )
}

@Composable
private fun SectionHeader(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost, letterSpacing = 3.sp),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
    )
}

@Composable
private fun SettingsRow(
    title: String,
    value: String,
    onClick: () -> Unit,
    isDestructive: Boolean = false,
    trailing: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost, fontWeight = FontWeight.Medium),
                color = if (isDestructive) DestructiveRed else MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = Jost),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        if (trailing != null) trailing()
        else Icon(
            imageVector = Icons.Outlined.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(20.dp)
        )
    }
    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f), thickness = 0.5.dp)
}

@Composable
private fun ThemeToggle(current: AppTheme, onSelect: (AppTheme) -> Unit) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(50.dp))
            .padding(2.dp)
    ) {
        listOf(AppTheme.LIGHT to "LIGHT", AppTheme.DARK to "DARK").forEach { (theme, label) ->
            val selected = current == theme
            Box(
                modifier = Modifier
                    .background(
                        if (selected) MaterialTheme.colorScheme.onBackground else androidx.compose.ui.graphics.Color.Transparent,
                        RoundedCornerShape(50.dp)
                    )
                    .clickable { onSelect(theme) }
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost, letterSpacing = 1.sp),
                    color = if (selected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun ContentTextSizeToggle(current: ContentTextSize, onSelect: (ContentTextSize) -> Unit) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(50.dp))
            .padding(2.dp)
    ) {
        listOf(
            ContentTextSize.DEFAULT to "A",
            ContentTextSize.LARGE to "A+",
            ContentTextSize.LARGER to "A++"
        ).forEach { (size, label) ->
            val selected = current == size
            Box(
                modifier = Modifier
                    .background(
                        if (selected) MaterialTheme.colorScheme.onBackground else androidx.compose.ui.graphics.Color.Transparent,
                        RoundedCornerShape(50.dp)
                    )
                    .clickable { onSelect(size) }
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost, letterSpacing = 1.sp),
                    color = if (selected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun PreviewCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "\"The impediment to action advances action.\"",
            style = MaterialTheme.typography.displaySmall.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "— MARCUS AURELIUS",
            style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost, letterSpacing = 2.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TimePickerModal(
    title: String,
    initial: LocalTime,
    onConfirm: (LocalTime) -> Unit,
    onDismiss: () -> Unit
) {
    val timePickerState = rememberTimePickerState(
        initialHour = initial.hour,
        initialMinute = initial.minute,
        is24Hour = false
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title, style = MaterialTheme.typography.titleMedium.copy(fontFamily = Jost)) },
        text = {
            TimePicker(state = timePickerState)
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirm(LocalTime.of(timePickerState.hour, timePickerState.minute))
            }) {
                Text("Confirm", style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost))
            }
        }
    )
}

@Composable
private fun ConfirmDialog(
    title: String,
    message: String,
    confirmLabel: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    isDestructive: Boolean = false
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title, style = MaterialTheme.typography.titleMedium.copy(fontFamily = Jost)) },
        text = { Text(message, style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost)) },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(
                    confirmLabel,
                    style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost),
                    color = if (isDestructive) DestructiveRed else MaterialTheme.colorScheme.onBackground
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost))
            }
        }
    )
}
