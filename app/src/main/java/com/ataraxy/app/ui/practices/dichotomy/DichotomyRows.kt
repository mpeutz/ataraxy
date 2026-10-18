package com.ataraxy.app.ui.practices.dichotomy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.ControlItem
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

private data class OverflowAction(val label: String, val onClick: () -> Unit)

@Composable
private fun ItemOverflowMenu(actions: List<OverflowAction>) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = stringResource(R.string.manage_item),
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
private fun ItemCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        content()
    }
}

@Composable
internal fun PendingItemRow(
    item: ControlItem,
    onSortInControl: () -> Unit,
    onSortNotInControl: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    ItemCard {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
                Text(
                    text = item.text,
                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f)
                )
                ItemOverflowMenu(
                    listOf(
                        OverflowAction(stringResource(R.string.edit_item), onEdit),
                        OverflowAction(stringResource(R.string.delete_item), onDelete)
                    )
                )
            }
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SortButton(
                    text = stringResource(R.string.in_my_control_button),
                    color = MaterialTheme.colorScheme.onBackground,
                    onClick = onSortInControl
                )
                SortButton(
                    text = stringResource(R.string.not_in_my_control_button),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    onClick = onSortNotInControl
                )
            }
        }
    }
}

@Composable
private fun RowScope.SortButton(text: String, color: Color, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.weight(1f),
        shape = RoundedCornerShape(6.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
            color = color
        )
    }
}

@Composable
internal fun InControlItemRow(
    item: ControlItem,
    onMarkDone: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onMoveToPending: () -> Unit,
    onMoveToReleased: () -> Unit,
    onDefineAction: () -> Unit
) {
    ItemCard {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.text,
                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
                    color = MaterialTheme.colorScheme.onBackground
                )
                val actionStep = item.actionStep
                if (!actionStep.isNullOrBlank()) {
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = stringResource(R.string.dichotomy_action_step, actionStep),
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontFamily = CormorantGaramond,
                            fontStyle = FontStyle.Italic,
                            fontSize = 15.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Spacer(Modifier.width(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                ItemOverflowMenu(
                    listOf(
                        OverflowAction(stringResource(R.string.define_action_step), onDefineAction),
                        OverflowAction(stringResource(R.string.move_to_pending), onMoveToPending),
                        OverflowAction(stringResource(R.string.move_to_released), onMoveToReleased),
                        OverflowAction(stringResource(R.string.edit_item), onEdit),
                        OverflowAction(stringResource(R.string.delete_item), onDelete)
                    )
                )
                IconButton(onClick = onMarkDone) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(MaterialTheme.colorScheme.onBackground, RoundedCornerShape(6.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Check,
                            contentDescription = stringResource(R.string.mark_done),
                            tint = MaterialTheme.colorScheme.background,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
internal fun CompletedItemRow(
    item: ControlItem,
    onRestore: () -> Unit,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    ArchivedRow {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
            Text(
                text = item.text,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontFamily = Jost,
                    textDecoration = TextDecoration.LineThrough
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                modifier = Modifier.weight(1f)
            )
            ItemOverflowMenu(
                listOf(
                    OverflowAction(stringResource(R.string.restore_to_in_control), onRestore),
                    OverflowAction(stringResource(R.string.edit_item), onEdit),
                    OverflowAction(stringResource(R.string.delete_item), onDelete)
                )
            )
        }
        val actionStep = item.actionStep
        if (!actionStep.isNullOrBlank()) {
            Text(
                text = stringResource(R.string.dichotomy_action_step, actionStep),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontFamily = CormorantGaramond,
                    fontStyle = FontStyle.Italic,
                    fontSize = 13.sp,
                    textDecoration = TextDecoration.LineThrough
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
            )
        }
    }
}

@Composable
internal fun ReleasedItemRow(
    item: ControlItem,
    onRestoreToPending: () -> Unit,
    onRestoreToInControl: () -> Unit,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    ArchivedRow {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
            Text(
                text = item.text,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontFamily = Jost,
                    fontStyle = FontStyle.Italic
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                modifier = Modifier.weight(1f)
            )
            ItemOverflowMenu(
                listOf(
                    OverflowAction(stringResource(R.string.restore_to_pending), onRestoreToPending),
                    OverflowAction(stringResource(R.string.restore_to_in_control), onRestoreToInControl),
                    OverflowAction(stringResource(R.string.edit_item), onEdit),
                    OverflowAction(stringResource(R.string.delete_item), onDelete)
                )
            )
        }
    }
}

/** Shared frame for completed and released rows: padded column ending in a faint rule. */
@Composable
private fun ArchivedRow(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 10.dp)
    ) {
        content()
        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
            thickness = 0.5.dp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}
