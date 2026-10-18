package com.ataraxy.app.ui.practices.dichotomy

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.ControlBucket
import com.ataraxy.app.domain.model.ControlItem
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.components.StatChip
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
    val startEditing: (ControlItem) -> Unit = { item ->
        editingItemId = item.id
        editText = item.text
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val overlayShown = state.dismissQuote != null
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(if (overlayShown) Modifier.clearAndSetSemantics {} else Modifier)
        ) {
            AtaraxyTopBar(
                title = stringResource(R.string.dichotomy_title),
                onBack = onBack,
                subtitle = stringResource(R.string.dichotomy_subtitle)
            )

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
                    AtaraxyDivider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        StatChip(value = "${state.inControlItems.size}", label = stringResource(R.string.in_control), valueSize = 28.sp)
                        StatChip(value = "${state.completedItems.size}", label = stringResource(R.string.completed_count), valueSize = 28.sp)
                        StatChip(value = "${state.releasedCount}", label = stringResource(R.string.released_count), valueSize = 28.sp)
                    }
                    AtaraxyDivider()
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
                        SectionIntro(
                            title = stringResource(R.string.sort_your_worries),
                            subtitle = stringResource(R.string.sort_subtitle)
                        )
                    }
                    items(items = state.pendingItems, key = { "pending_${it.id}" }) { item ->
                        PendingItemRow(
                            item = item,
                            onSortInControl = { viewModel.sortItem(item.id, ControlBucket.IN_CONTROL) },
                            onSortNotInControl = { viewModel.sortItem(item.id, ControlBucket.NOT_IN_CONTROL) },
                            onEdit = { startEditing(item) },
                            onDelete = { viewModel.deleteItem(item.id) }
                        )
                        Spacer(Modifier.height(8.dp))
                    }
                }

                // In Control — active action items
                if (state.inControlItems.isNotEmpty()) {
                    item {
                        SectionIntro(
                            title = stringResource(R.string.in_my_control_label),
                            subtitle = stringResource(R.string.take_action_subtitle)
                        )
                    }
                    items(items = state.inControlItems, key = { "active_${it.id}" }) { item ->
                        InControlItemRow(
                            item = item,
                            onMarkDone = { viewModel.markDone(item.id) },
                            onEdit = { startEditing(item) },
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
                    item { EmptyState() }
                }

                // Completed items — collapsible
                if (state.completedItems.isNotEmpty()) {
                    item {
                        CollapsibleSectionHeader(
                            title = stringResource(R.string.completed_header, state.completedItems.size),
                            expanded = state.showCompleted,
                            onToggle = viewModel::toggleShowCompleted,
                            topSpacing = 24.dp
                        )
                    }
                    if (state.showCompleted) {
                        items(items = state.completedItems, key = { "done_${it.id}" }) { item ->
                            CompletedItemRow(
                                item = item,
                                onRestore = { viewModel.restoreToInControl(item.id) },
                                onDelete = { viewModel.deleteItem(item.id) },
                                onEdit = { startEditing(item) }
                            )
                        }
                    }
                }

                // Released items — collapsible
                if (state.releasedItems.isNotEmpty()) {
                    item {
                        CollapsibleSectionHeader(
                            title = stringResource(R.string.released_header, state.releasedItems.size),
                            expanded = state.showReleased,
                            onToggle = viewModel::toggleShowReleased,
                            topSpacing = if (state.completedItems.isEmpty()) 24.dp else 8.dp
                        )
                    }
                    if (state.showReleased) {
                        items(items = state.releasedItems, key = { "released_${it.id}" }) { item ->
                            ReleasedItemRow(
                                item = item,
                                onRestoreToPending = { viewModel.restoreToPending(item.id) },
                                onRestoreToInControl = { viewModel.restoreToInControl(item.id) },
                                onDelete = { viewModel.deleteItem(item.id) },
                                onEdit = { startEditing(item) }
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

        AnimatedVisibility(
            visible = state.dismissQuote != null,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.fillMaxSize()
        ) {
            state.dismissQuote?.let { quote ->
                ReleaseOverlay(quote = quote, onDismiss = viewModel::dismissQuoteSeen)
            }
        }
    }
}

@Composable
private fun SectionLabel(text: String, modifier: Modifier = Modifier) {
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
private fun SectionIntro(title: String, subtitle: String) {
    Spacer(Modifier.height(24.dp))
    SectionLabel(text = title, modifier = Modifier.padding(horizontal = 24.dp))
    Spacer(Modifier.height(4.dp))
    Text(
        text = subtitle,
        style = MaterialTheme.typography.bodySmall.copy(
            fontFamily = Jost,
            fontStyle = FontStyle.Italic
        ),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
    Spacer(Modifier.height(12.dp))
}

@Composable
private fun CollapsibleSectionHeader(
    title: String,
    expanded: Boolean,
    onToggle: () -> Unit,
    topSpacing: Dp
) {
    Spacer(Modifier.height(topSpacing))
    AtaraxyDivider()
    Spacer(Modifier.height(4.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SectionLabel(text = title)
        IconButton(onClick = onToggle) {
            Icon(
                imageVector = if (expanded) Icons.Outlined.ExpandLess else Icons.Outlined.ExpandMore,
                contentDescription = stringResource(
                    if (expanded) R.string.dichotomy_collapse else R.string.dichotomy_expand
                ),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
private fun EmptyState() {
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
        PracticeStep(number = 1, text = stringResource(R.string.practice_step_1))
        Spacer(Modifier.height(16.dp))
        PracticeStep(number = 2, text = stringResource(R.string.practice_step_2))
        Spacer(Modifier.height(16.dp))
        PracticeStep(number = 3, text = stringResource(R.string.practice_step_3))
    }
}

@Composable
private fun PracticeStep(number: Int, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = number.toString(),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = CormorantGaramond,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
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
