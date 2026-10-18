package com.ataraxy.app.ui.practices.dichotomy

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ataraxy.app.R
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.domain.model.ControlBucket
import com.ataraxy.app.domain.model.ControlItem
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

@Composable
fun DichotomyScreen(
    onBack: () -> Unit,
    viewModel: DichotomyViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    var editingItemId by rememberSaveable { mutableStateOf<Long?>(null) }
    var editText by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Top bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = stringResource(R.string.back),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                Column {
                    Text(
                        text = stringResource(R.string.dichotomy_title),
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontFamily = Jost,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 3.sp,
                            fontSize = 13.sp
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = stringResource(R.string.dichotomy_subtitle),
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontFamily = Jost,
                            fontStyle = FontStyle.Italic
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

            LazyColumn(modifier = Modifier.fillMaxSize()) {

                // Input field
                item {
                    Spacer(Modifier.height(24.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        BasicTextField(
                            value = state.inputText,
                            onValueChange = viewModel::updateInputText,
                            modifier = Modifier.weight(1f),
                            textStyle = MaterialTheme.typography.bodyLarge.copy(
                                fontFamily = Jost,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 16.sp
                            ),
                            decorationBox = { innerTextField ->
                                Column {
                                    Box {
                                        if (state.inputText.isEmpty()) {
                                            Text(
                                                text = stringResource(R.string.dichotomy_input_hint),
                                                style = MaterialTheme.typography.bodyLarge.copy(
                                                    fontFamily = Jost,
                                                    fontSize = 16.sp
                                                ),
                                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                                            )
                                        }
                                        innerTextField()
                                    }
                                    Spacer(Modifier.height(8.dp))
                                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)
                                }
                            }
                        )
                        Spacer(Modifier.width(12.dp))
                        TextButton(
                            onClick = viewModel::addItem,
                            enabled = state.inputText.isNotBlank()
                        ) {
                            Text(
                                text = stringResource(R.string.add),
                                style = MaterialTheme.typography.labelLarge.copy(
                                    fontFamily = Jost,
                                    letterSpacing = 2.sp
                                ),
                                color = if (state.inputText.isNotBlank())
                                    MaterialTheme.colorScheme.onBackground
                                else
                                    MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    Spacer(Modifier.height(24.dp))
                }

                // Stats strip
                item {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        StatChip(value = "${state.inControlItems.size}", label = stringResource(R.string.in_control))
                        StatChip(value = "${state.completedItems.size}", label = stringResource(R.string.completed_count))
                        StatChip(value = "${state.releasedCount}", label = stringResource(R.string.released_count))
                    }
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
                }

                // Action step prompt card
                if (state.actionStepPromptItemId != null) {
                    item {
                        Spacer(Modifier.height(16.dp))
                        ActionStepCard(
                            text = state.actionStepText,
                            onTextChange = viewModel::updateActionStepText,
                            onSave = viewModel::saveActionStep,
                            onDismiss = viewModel::clearActionStepPrompt
                        )
                    }
                }

                // Pending items to sort
                if (state.pendingItems.isNotEmpty()) {
                    item {
                        Spacer(Modifier.height(24.dp))
                        SectionLabel(text = stringResource(R.string.sort_your_worries))
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = stringResource(R.string.sort_subtitle),
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontFamily = Jost,
                                fontStyle = FontStyle.Italic
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 24.dp)
                        )
                        Spacer(Modifier.height(12.dp))
                    }
                    items(items = state.pendingItems, key = { "pending_${it.id}" }) { item ->
                        PendingItemRow(
                            item = item,
                            onSortInControl = { viewModel.sortItem(item.id, ControlBucket.IN_CONTROL) },
                            onSortNotInControl = { viewModel.sortItem(item.id, ControlBucket.NOT_IN_CONTROL) },
                            onEdit = {
                                editingItemId = item.id
                                editText = item.text
                            },
                            onDelete = { viewModel.deleteItem(item.id) }
                        )
                        Spacer(Modifier.height(8.dp))
                    }
                }

                // In Control — active action items
                if (state.inControlItems.isNotEmpty()) {
                    item {
                        Spacer(Modifier.height(24.dp))
                        SectionLabel(text = stringResource(R.string.in_my_control_label))
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = stringResource(R.string.take_action_subtitle),
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontFamily = Jost,
                                fontStyle = FontStyle.Italic
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 24.dp)
                        )
                        Spacer(Modifier.height(12.dp))
                    }
                    items(items = state.inControlItems, key = { "active_${it.id}" }) { item ->
                        InControlItemRow(
                            item = item,
                            onMarkDone = { viewModel.markDone(item.id) },
                            onEdit = {
                                editingItemId = item.id
                                editText = item.text
                            },
                            onDelete = { viewModel.deleteItem(item.id) },
                            onMoveToPending = { viewModel.moveToPending(item.id) },
                            onMoveToReleased = { viewModel.moveToReleased(item.id) },
                            onDefineAction = {
                                viewModel.updateActionStepText(item.actionStep.orEmpty())
                                viewModel.promptActionStep(item.id)
                            }
                        )
                        Spacer(Modifier.height(8.dp))
                    }
                }

                // Empty state — shown only when no items exist at all
                val hasAnyItems = state.pendingItems.isNotEmpty() ||
                        state.inControlItems.isNotEmpty() ||
                        state.completedItems.isNotEmpty() ||
                        state.releasedItems.isNotEmpty()
                if (!hasAnyItems) {
                    item {
                        Spacer(Modifier.height(40.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(R.string.how_to_use_practice),
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontFamily = Jost,
                                    letterSpacing = 2.sp
                                ),
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                textAlign = TextAlign.Center
                            )
                            Spacer(Modifier.height(20.dp))
                            PracticeStep(number = "1", text = stringResource(R.string.practice_step_1))
                            Spacer(Modifier.height(16.dp))
                            PracticeStep(number = "2", text = stringResource(R.string.practice_step_2))
                            Spacer(Modifier.height(16.dp))
                            PracticeStep(number = "3", text = stringResource(R.string.practice_step_3))
                        }
                    }
                }

                // Completed items — collapsible
                if (state.completedItems.isNotEmpty()) {
                    item {
                        Spacer(Modifier.height(24.dp))
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
                        Spacer(Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SectionLabel(text = stringResource(R.string.completed_header, state.completedItems.size), modifier = Modifier)
                            IconButton(
                                onClick = viewModel::toggleShowCompleted,
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    imageVector = if (state.showCompleted) Icons.Outlined.ExpandLess else Icons.Outlined.ExpandMore,
                                    contentDescription = if (state.showCompleted) "Collapse" else "Expand",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                    if (state.showCompleted) {
                        items(items = state.completedItems, key = { "done_${it.id}" }) { item ->
                            CompletedItemRow(
                                item = item,
                                onRestore = { viewModel.restoreToInControl(item.id) },
                                onDelete = { viewModel.deleteItem(item.id) },
                                onEdit = {
                                    editingItemId = item.id
                                    editText = item.text
                                }
                            )
                        }
                    }
                }

                // Released items — collapsible
                if (state.releasedItems.isNotEmpty()) {
                    item {
                        Spacer(Modifier.height(if (state.completedItems.isEmpty()) 24.dp else 8.dp))
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
                        Spacer(Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SectionLabel(text = stringResource(R.string.released_header, state.releasedItems.size), modifier = Modifier)
                            IconButton(
                                onClick = viewModel::toggleShowReleased,
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    imageVector = if (state.showReleased) Icons.Outlined.ExpandLess else Icons.Outlined.ExpandMore,
                                    contentDescription = if (state.showReleased) "Collapse" else "Expand",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                    if (state.showReleased) {
                        items(items = state.releasedItems, key = { "released_${it.id}" }) { item ->
                            ReleasedItemRow(
                                item = item,
                                onRestoreToPending = { viewModel.restoreToPending(item.id) },
                                onRestoreToInControl = { viewModel.restoreToInControl(item.id) },
                                onDelete = { viewModel.deleteItem(item.id) },
                                onEdit = {
                                    editingItemId = item.id
                                    editText = item.text
                                }
                            )
                        }
                    }
                }

                item { Spacer(Modifier.height(32.dp)) }
            }
        }

        val editingId = editingItemId
        if (editingId != null) {
            EditItemDialog(
                text = editText,
                onTextChange = { editText = it },
                onDismiss = { editingItemId = null },
                onSave = {
                    viewModel.updateItemText(editingId, editText)
                    editingItemId = null
                }
            )
        }

        // Release overlay
        AnimatedVisibility(
            visible = state.dismissQuote != null,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.fillMaxSize()
        ) {
            if (state.dismissQuote != null) {
                ReleaseOverlay(quote = state.dismissQuote!!, onDismiss = viewModel::dismissQuoteSeen)
            }
        }
    }
}

@Composable
private fun SectionLabel(text: String, modifier: Modifier = Modifier.padding(horizontal = 24.dp)) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium.copy(
            fontFamily = Jost,
            letterSpacing = 3.sp
        ),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier
    )
}

@Composable
private fun PracticeStep(number: String, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = number,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = CormorantGaramond,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
            modifier = Modifier.width(16.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(
                fontFamily = Jost,
                lineHeight = 20.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun StatChip(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = CormorantGaramond,
                fontWeight = FontWeight.Medium,
                fontSize = 28.sp
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = label.uppercase(),
            style = MaterialTheme.typography.labelSmall.copy(
                fontFamily = Jost,
                letterSpacing = 2.sp,
                fontSize = 9.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun PendingItemRow(
    item: ControlItem,
    onSortInControl: () -> Unit,
    onSortNotInControl: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
                Text(
                    text = item.text,
                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f)
                )
                Box {
                    IconButton(onClick = { menuExpanded = true }, modifier = Modifier.size(28.dp)) {
                        Icon(
                            imageVector = Icons.Outlined.MoreVert,
                            contentDescription = stringResource(R.string.manage_item),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    DropdownMenu(expanded = menuExpanded, onDismissRequest = { menuExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.edit_item)) },
                            onClick = {
                                menuExpanded = false
                                onEdit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.delete_item)) },
                            onClick = {
                                menuExpanded = false
                                onDelete()
                            }
                        )
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = onSortInControl,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.in_my_control_button),
                        style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                OutlinedButton(
                    onClick = onSortNotInControl,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.not_in_my_control_button),
                        style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun InControlItemRow(
    item: ControlItem,
    onMarkDone: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onMoveToPending: () -> Unit,
    onMoveToReleased: () -> Unit,
    onDefineAction: () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
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
                if (!item.actionStep.isNullOrBlank()) {
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = "→ ${item.actionStep}",
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
                Box {
                    IconButton(onClick = { menuExpanded = true }, modifier = Modifier.size(28.dp)) {
                        Icon(
                            imageVector = Icons.Outlined.MoreVert,
                            contentDescription = stringResource(R.string.manage_item),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    DropdownMenu(expanded = menuExpanded, onDismissRequest = { menuExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.define_action_step)) },
                            onClick = {
                                menuExpanded = false
                                onDefineAction()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.move_to_pending)) },
                            onClick = {
                                menuExpanded = false
                                onMoveToPending()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.move_to_released)) },
                            onClick = {
                                menuExpanded = false
                                onMoveToReleased()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.edit_item)) },
                            onClick = {
                                menuExpanded = false
                                onEdit()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.delete_item)) },
                            onClick = {
                                menuExpanded = false
                                onDelete()
                            }
                        )
                    }
                }
                Spacer(Modifier.width(10.dp))
                IconButton(
                    onClick = onMarkDone,
                    modifier = Modifier
                        .size(36.dp)
                        .background(MaterialTheme.colorScheme.onBackground, RoundedCornerShape(6.dp))
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

@Composable
private fun CompletedItemRow(
    item: ControlItem,
    onRestore: () -> Unit,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 10.dp)
    ) {
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
            Box {
                IconButton(onClick = { menuExpanded = true }, modifier = Modifier.size(28.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.MoreVert,
                        contentDescription = stringResource(R.string.manage_item),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                DropdownMenu(expanded = menuExpanded, onDismissRequest = { menuExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.restore_to_in_control)) },
                        onClick = {
                            menuExpanded = false
                            onRestore()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.edit_item)) },
                        onClick = {
                            menuExpanded = false
                            onEdit()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.delete_item)) },
                        onClick = {
                            menuExpanded = false
                            onDelete()
                        }
                    )
                }
            }
        }
        if (!item.actionStep.isNullOrBlank()) {
            Text(
                text = "→ ${item.actionStep}",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontFamily = CormorantGaramond,
                    fontStyle = FontStyle.Italic,
                    fontSize = 13.sp,
                    textDecoration = TextDecoration.LineThrough
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
            )
        }
        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
            thickness = 0.5.dp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
private fun ReleasedItemRow(
    item: ControlItem,
    onRestoreToPending: () -> Unit,
    onRestoreToInControl: () -> Unit,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 10.dp)
    ) {
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
            Box {
                IconButton(onClick = { menuExpanded = true }, modifier = Modifier.size(28.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.MoreVert,
                        contentDescription = stringResource(R.string.manage_item),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                DropdownMenu(expanded = menuExpanded, onDismissRequest = { menuExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.restore_to_pending)) },
                        onClick = {
                            menuExpanded = false
                            onRestoreToPending()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.restore_to_in_control)) },
                        onClick = {
                            menuExpanded = false
                            onRestoreToInControl()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.edit_item)) },
                        onClick = {
                            menuExpanded = false
                            onEdit()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(stringResource(R.string.delete_item)) },
                        onClick = {
                            menuExpanded = false
                            onDelete()
                        }
                    )
                }
            }
        }
        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f),
            thickness = 0.5.dp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
private fun EditItemDialog(
    text: String,
    onTextChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onSave: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = stringResource(R.string.edit_item),
                style = MaterialTheme.typography.titleMedium.copy(fontFamily = Jost)
            )
        },
        text = {
            OutlinedTextField(
                value = text,
                onValueChange = onTextChange,
                singleLine = false,
                minLines = 2,
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost)
            )
        },
        confirmButton = {
            TextButton(onClick = onSave, enabled = text.trim().isNotEmpty()) {
                Text(
                    text = stringResource(R.string.save),
                    style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost)
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = stringResource(R.string.cancel),
                    style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost)
                )
            }
        }
    )
}

@Composable
private fun ActionStepCard(
    text: String,
    onTextChange: (String) -> Unit,
    onSave: () -> Unit,
    onDismiss: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.action_step_prompt),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = CormorantGaramond,
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(12.dp))
            BasicTextField(
                value = text,
                onValueChange = onTextChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = Jost,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                decorationBox = { innerTextField ->
                    Column {
                        Box {
                            if (text.isEmpty()) {
                                Text(
                                    text = stringResource(R.string.action_step_hint),
                                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                                )
                            }
                            innerTextField()
                        }
                        Spacer(Modifier.height(8.dp))
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)
                    }
                }
            )
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = onDismiss) {
                    Text(
                        text = stringResource(R.string.skip),
                        style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = onSave,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onBackground,
                        contentColor = MaterialTheme.colorScheme.background
                    ),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.save),
                        style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost)
                    )
                }
            }
        }
    }
}

@Composable
private fun ReleaseOverlay(quote: Quote, onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.97f))
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.released_overlay_title),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    letterSpacing = 3.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.released_overlay_subtitle),
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = Jost),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(40.dp))
            Text(
                text = "\u201C${quote.text}\u201D",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontFamily = CormorantGaramond,
                    fontStyle = FontStyle.Italic,
                    lineHeight = 44.sp
                ),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "\u2014 ${quote.authorName.uppercase()}",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontFamily = Jost,
                    letterSpacing = 2.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(48.dp))
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    contentColor = MaterialTheme.colorScheme.background
                ),
                shape = MaterialTheme.shapes.extraLarge,
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 14.dp)
            ) {
                Text(
                    text = stringResource(R.string.continue_label),
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontFamily = Jost,
                        letterSpacing = 2.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }
}
