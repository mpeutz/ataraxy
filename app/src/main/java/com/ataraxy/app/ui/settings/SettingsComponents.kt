package com.ataraxy.app.ui.settings

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.ContentTextSize
import com.ataraxy.app.ui.components.SegmentedToggle
import com.ataraxy.app.ui.theme.AtaraxyText
import com.ataraxy.app.ui.theme.DestructiveRed
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
internal fun NotificationGroup(
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

    SettingsSwitchRow(
        title = title,
        subtitle = subtitle,
        checked = enabled,
        onToggle = onToggle,
        contentAlpha = contentAlpha
    )

    AnimatedVisibility(visible = enabled) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(role = Role.Button) { onTimeClick() }
                .heightIn(min = 48.dp)
                .padding(start = 24.dp, end = 24.dp, top = 10.dp, bottom = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = timeLabel,
                style = AtaraxyText.secondary,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = time.format(timeFormatter),
                    style = AtaraxyText.secondary.copy(fontWeight = FontWeight.Medium),
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

    RowDivider()
}

@Composable
internal fun SettingsSwitchRow(
    title: String,
    subtitle: String,
    checked: Boolean,
    onToggle: (Boolean) -> Unit,
    contentAlpha: Float = 1f,
    enabled: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(value = checked, enabled = enabled, role = Role.Switch, onValueChange = onToggle)
            .padding(horizontal = 24.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = AtaraxyText.body.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = contentAlpha)
            )
            Text(
                text = subtitle,
                style = AtaraxyText.secondary,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = contentAlpha)
            )
        }
        // A null onCheckedChange drops the Switch's own 48dp touch padding; keep its footprint.
        Switch(
            checked = checked,
            onCheckedChange = null,
            enabled = enabled,
            modifier = Modifier.minimumInteractiveComponentSize(),
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.background,
                checkedTrackColor = MaterialTheme.colorScheme.onBackground
            )
        )
    }
}

@Composable
internal fun SectionHeader(text: String) {
    Text(
        text = text,
        style = AtaraxyText.eyebrow,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
    )
}

/** A settings row. Pass a null [onClick] when [trailing] holds the row's control. */
@Composable
internal fun SettingsRow(
    title: String,
    value: String,
    onClick: (() -> Unit)?,
    isDestructive: Boolean = false,
    trailing: @Composable (() -> Unit)? = null
) {
    val clickModifier = if (onClick != null) Modifier.clickable(role = Role.Button) { onClick() } else Modifier
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(clickModifier)
            .padding(horizontal = 24.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = AtaraxyText.body.copy(fontWeight = FontWeight.Medium),
                color = if (isDestructive) DestructiveRed else MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = value,
                style = AtaraxyText.secondary,
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
    RowDivider()
}

/** A lighter hairline than [com.ataraxy.app.ui.components.AtaraxyDivider], used between rows. */
@Composable
internal fun RowDivider() {
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f), thickness = 0.5.dp)
}

@Composable
internal fun PreviewCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        val quote = stringResource(R.string.settings_preview_quote)
        Text(
            text = quote,
            style = AtaraxyText.quote(quote),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.memento_mori_quote_author_1),
            style = AtaraxyText.attribution,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TimePickerModal(
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
        title = { Text(title, style = AtaraxyText.heading) },
        text = {
            TimePicker(state = timePickerState)
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirm(LocalTime.of(timePickerState.hour, timePickerState.minute))
            }) {
                Text(
                    stringResource(R.string.settings_confirm),
                    style = AtaraxyText.button
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    stringResource(R.string.settings_cancel),
                    style = AtaraxyText.button
                )
            }
        }
    )
}

@Composable
internal fun ConfirmDialog(
    title: String,
    message: String,
    confirmLabel: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    isDestructive: Boolean = false,
    dismissLabel: String = stringResource(R.string.settings_cancel)
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title, style = AtaraxyText.heading) },
        text = { Text(message, style = AtaraxyText.secondary) },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(
                    confirmLabel,
                    style = AtaraxyText.button,
                    color = if (isDestructive) DestructiveRed else MaterialTheme.colorScheme.onBackground
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    dismissLabel,
                    style = AtaraxyText.button
                )
            }
        }
    )
}

@Composable
internal fun ContentTextSizeToggle(current: ContentTextSize, onSelect: (ContentTextSize) -> Unit) {
    val spokenNames = mapOf(
        ContentTextSize.DEFAULT to stringResource(R.string.settings_text_size_default),
        ContentTextSize.LARGE to stringResource(R.string.settings_text_size_large),
        ContentTextSize.LARGER to stringResource(R.string.settings_text_size_larger)
    )
    SegmentedToggle(
        options = listOf(
            ContentTextSize.DEFAULT to stringResource(R.string.settings_text_size_option_default),
            ContentTextSize.LARGE to stringResource(R.string.settings_text_size_option_large),
            ContentTextSize.LARGER to stringResource(R.string.settings_text_size_option_larger)
        ),
        selected = current,
        onSelect = onSelect,
        spokenLabel = { size -> spokenNames.getValue(size) }
    )
}
