package com.ataraxy.app.ui.practices.whatsyours

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.background
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.components.orrery.orreryBackground
import com.ataraxy.app.ui.components.orrery.rememberOrreryPattern
import com.ataraxy.app.ui.theme.Jost

private const val STEP_COUNT = 2

@Composable
fun ReflectionFlowScreen(
    onClose: () -> Unit,
    onFinished: (Long) -> Unit,
    viewModel: ReflectionFlowViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val goBack = { if (!viewModel.back()) onClose() }
    BackHandler(onBack = goBack)
    LaunchedEffect(state.loaded, state.worry) {
        if (state.loaded && state.worry.isEmpty()) onClose()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .orreryBackground(rememberOrreryPattern("whats_yours"))
            .imePadding()
    ) {
        AtaraxyTopBar(
            title = stringResource(R.string.whats_yours_title),
            onBack = goBack,
            actions = {
                ReflectionOptionsMenu(
                    listOf(MenuAction(stringResource(R.string.whats_yours_delete_action), viewModel::requestDelete))
                )
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            StepDots(current = state.step.ordinal + 1)
            Spacer(Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.quote_in_marks, state.worry),
                style = worryTextStyle(),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(24.dp))
            when (state.step) {
                FlowStep.SPLIT -> SplitStep(state, viewModel)
                FlowStep.ACT -> ActStep(state, viewModel, onFinished)
            }
            Spacer(Modifier.height(32.dp))
        }
    }

    if (state.confirmingDelete) {
        DeleteReflectionDialog(onConfirm = { viewModel.confirmDelete(onClose) }, onDismiss = viewModel::cancelDelete)
    }
}

@Composable
private fun SplitStep(state: ReflectionFlowUiState, viewModel: ReflectionFlowViewModel) {
    LineList(
        question = stringResource(R.string.whats_yours_yours_question),
        hint = stringResource(R.string.whats_yours_yours_hint),
        lines = state.yours,
        draft = state.yoursDraft,
        onDraftChange = viewModel::updateYoursDraft,
        onAdd = viewModel::addYours,
        onRemove = viewModel::removeYours
    )
    Spacer(Modifier.height(32.dp))
    LineList(
        question = stringResource(R.string.whats_yours_not_yours_question),
        hint = stringResource(R.string.whats_yours_not_yours_hint),
        lines = state.notYours,
        draft = state.notYoursDraft,
        onDraftChange = viewModel::updateNotYoursDraft,
        onAdd = viewModel::addNotYours,
        onRemove = viewModel::removeNotYours
    )
    Spacer(Modifier.height(36.dp))
    FlowButton(
        text = stringResource(R.string.continue_label),
        enabled = state.canContinue,
        onClick = viewModel::next
    )
}

@Composable
private fun ActStep(state: ReflectionFlowUiState, viewModel: ReflectionFlowViewModel, onFinished: (Long) -> Unit) {
    AnswerField(
        question = stringResource(R.string.whats_yours_can_do_question),
        hint = stringResource(R.string.whats_yours_can_do_hint),
        value = state.canDo,
        onValueChange = viewModel::updateCanDo
    )
    Spacer(Modifier.height(32.dp))
    AnswerField(
        question = stringResource(R.string.whats_yours_set_down_question),
        hint = stringResource(R.string.whats_yours_set_down_hint),
        value = state.setDown,
        onValueChange = viewModel::updateSetDown
    )
    state.quote?.let { ClosingQuote(it) }
    Spacer(Modifier.height(32.dp))
    FlowButton(
        text = stringResource(R.string.whats_yours_keep),
        enabled = state.canFinish,
        onClick = { viewModel.finish(onFinished) }
    )
}

@Composable
internal fun LineList(
    question: String,
    hint: String,
    lines: List<String>,
    draft: String,
    onDraftChange: (String) -> Unit,
    onAdd: () -> Unit,
    onRemove: (Int) -> Unit
) {
    ReflectionLabel(question)
    Spacer(Modifier.height(4.dp))
    ReflectionHint(hint)
    Spacer(Modifier.height(8.dp))
    lines.forEachIndexed { index, line ->
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = line,
                style = entryTextStyle(),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { onRemove(index) }) {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = stringResource(R.string.whats_yours_remove_line, line),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
    Row(verticalAlignment = Alignment.Bottom) {
        UnderlinedTextField(
            value = draft,
            onValueChange = onDraftChange,
            hint = stringResource(R.string.whats_yours_add_line_hint),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { onAdd() }),
            modifier = Modifier
                .weight(1f)
                .semantics { contentDescription = question }
        )
        IconButton(onClick = onAdd, enabled = draft.isNotBlank()) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = stringResource(R.string.whats_yours_add_line),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
private fun AnswerField(question: String, hint: String, value: String, onValueChange: (String) -> Unit) {
    ReflectionLabel(question)
    Spacer(Modifier.height(4.dp))
    ReflectionHint(hint)
    Spacer(Modifier.height(10.dp))
    UnderlinedTextField(
        value = value,
        onValueChange = onValueChange,
        hint = "",
        singleLine = false,
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
        modifier = Modifier
            .fillMaxWidth()
            .semantics { contentDescription = question }
    )
}

@Composable
private fun ClosingQuote(quote: Quote) {
    Spacer(Modifier.height(36.dp))
    Text(
        text = stringResource(R.string.quote_in_marks, quote.text),
        style = serifTextStyle(scale = 1.25f).copy(fontStyle = FontStyle.Italic),
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(Modifier.height(10.dp))
    Text(
        text = stringResource(R.string.quote_attribution, quote.authorName.uppercase()),
        style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost, letterSpacing = 2.sp),
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun StepDots(current: Int) {
    val description = stringResource(R.string.whats_yours_step, current, STEP_COUNT)
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .semantics { contentDescription = description },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.weight(1f))
        repeat(STEP_COUNT) { index ->
            val filled = index < current
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .background(
                        color = if (filled) MaterialTheme.colorScheme.onBackground
                        else MaterialTheme.colorScheme.outlineVariant,
                        shape = CircleShape
                    )
            )
        }
        Spacer(Modifier.weight(1f))
    }
}

@Composable
private fun FlowButton(text: String, enabled: Boolean, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        OutlinedButton(
            onClick = onClick,
            enabled = enabled,
            shape = MaterialTheme.shapes.extraLarge,
            contentPadding = PaddingValues(horizontal = 28.dp, vertical = 12.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge.copy(fontFamily = Jost, letterSpacing = 2.sp),
                color = if (enabled) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
