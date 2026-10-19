package com.ataraxy.app.ui.practices.whatsyours

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.ataraxy.app.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ataraxy.app.ui.settings.ConfirmDialog
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost
import java.time.format.DateTimeFormatter

internal val shortDate: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d")

// Sizes derive from theme styles so the Content Text Size setting scales them.

/** The worry itself, shown as a heading in quotes. */
@Composable
internal fun worryTextStyle(): TextStyle {
    val base = MaterialTheme.typography.displaySmall
    return base.copy(fontFamily = CormorantGaramond, fontStyle = FontStyle.Italic, fontSize = base.fontSize * 0.87f, lineHeight = 1.3.em)
}

/** Serif reading text: the explainer, row titles, the closing quote. */
@Composable
internal fun serifTextStyle(scale: Float = 1.2f): TextStyle {
    val base = MaterialTheme.typography.bodyLarge
    return base.copy(fontFamily = CormorantGaramond, fontSize = base.fontSize * scale, lineHeight = 1.35.em)
}

/** What the user wrote: lines, answers, notes. */
@Composable
internal fun entryTextStyle(): TextStyle =
    MaterialTheme.typography.bodyLarge.copy(fontFamily = Jost, lineHeight = 1.4.em)

@Composable
internal fun ReflectionLabel(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost, letterSpacing = 2.sp),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier
    )
}

@Composable
internal fun ReflectionHint(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall.copy(fontFamily = Jost, fontStyle = FontStyle.Italic),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier
    )
}

/** The app's quiet text input: no box, a hint, and a hairline underneath. */
@Composable
internal fun UnderlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = singleLine,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
        textStyle = entryTextStyle().copy(color = MaterialTheme.colorScheme.onBackground),
        decorationBox = { inner ->
            Column {
                Box {
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            style = entryTextStyle(),
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                        )
                    }
                    inner()
                }
                Spacer(Modifier.height(8.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)
            }
        }
    )
}

internal data class MenuAction(val label: String, val onClick: () -> Unit)

/** The reflection's overflow menu in the top bar. */
@Composable
internal fun ReflectionOptionsMenu(actions: List<MenuAction>) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = stringResource(R.string.whats_yours_options),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            actions.forEach { action ->
                DropdownMenuItem(
                    text = { Text(action.label) },
                    onClick = {
                        expanded = false
                        action.onClick()
                    }
                )
            }
        }
    }
}

@Composable
internal fun DeleteReflectionDialog(onConfirm: () -> Unit, onDismiss: () -> Unit) {
    ConfirmDialog(
        title = stringResource(R.string.whats_yours_delete_title),
        message = stringResource(R.string.whats_yours_delete_body),
        confirmLabel = stringResource(R.string.whats_yours_delete_confirm),
        onConfirm = onConfirm,
        onDismiss = onDismiss,
        isDestructive = true
    )
}
