package com.ataraxy.app.ui.practices.whatsyours

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.Reflection
import com.ataraxy.app.domain.model.ReflectionNote
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.components.orrery.orreryBackground
import com.ataraxy.app.ui.components.orrery.rememberOrreryPattern
import com.ataraxy.app.ui.theme.Jost

@Composable
fun ReflectionDetailScreen(
    onBack: () -> Unit,
    viewModel: ReflectionDetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val reflection = state.reflection

    Column(
        modifier = Modifier
            .fillMaxSize()
            .orreryBackground(rememberOrreryPattern("whats_yours"))
            .imePadding()
    ) {
        AtaraxyTopBar(
            title = stringResource(R.string.whats_yours_title),
            onBack = onBack,
            actions = {
                if (reflection != null) {
                    val toggle = if (reflection.setDownAt != null) {
                        MenuAction(stringResource(R.string.whats_yours_pick_up_action), viewModel::pickUp)
                    } else {
                        MenuAction(stringResource(R.string.whats_yours_set_down_action), viewModel::setDown)
                    }
                    ReflectionOptionsMenu(
                        listOf(toggle, MenuAction(stringResource(R.string.whats_yours_delete_action), viewModel::requestDelete))
                    )
                }
            }
        )
        if (reflection != null) {
            ReflectionBody(
                reflection = reflection,
                noteDraft = state.noteDraft,
                onNoteDraftChange = viewModel::updateNoteDraft,
                onAddNote = viewModel::addNote
            )
        }
    }

    if (state.confirmingDelete) {
        DeleteReflectionDialog(onConfirm = { viewModel.confirmDelete(onBack) }, onDismiss = viewModel::cancelDelete)
    }
}

@Composable
private fun ReflectionBody(
    reflection: Reflection,
    noteDraft: String,
    onNoteDraftChange: (String) -> Unit,
    onAddNote: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 20.dp)
    ) {
        ReflectionLabel(stringResource(R.string.whats_yours_started_on, reflection.createdAt.format(shortDate).uppercase()))
        reflection.setDownAt?.let {
            Spacer(Modifier.height(4.dp))
            ReflectionHint(stringResource(R.string.whats_yours_set_down_on, it.format(shortDate)))
        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.quote_in_marks, reflection.worry),
            style = worryTextStyle(),
            color = MaterialTheme.colorScheme.onBackground
        )
        AnswerSection(R.string.whats_yours_yours_label, reflection.yours)
        AnswerSection(R.string.whats_yours_not_yours_label, reflection.notYours)
        AnswerSection(R.string.whats_yours_can_do_label, listOf(reflection.canDo).filter { it.isNotBlank() })
        AnswerSection(R.string.whats_yours_set_down_label, listOf(reflection.setDown).filter { it.isNotBlank() })

        Spacer(Modifier.height(32.dp))
        ReflectionLabel(stringResource(R.string.whats_yours_notes_label))
        Spacer(Modifier.height(8.dp))
        reflection.notes.forEach { NoteRow(it) }
        Row(verticalAlignment = Alignment.Bottom) {
            UnderlinedTextField(
                value = noteDraft,
                onValueChange = onNoteDraftChange,
                hint = stringResource(R.string.whats_yours_note_hint),
                singleLine = false,
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(12.dp))
            TextButton(onClick = onAddNote, enabled = noteDraft.isNotBlank()) {
                Text(
                    text = stringResource(R.string.add),
                    style = MaterialTheme.typography.labelLarge.copy(fontFamily = Jost, letterSpacing = 2.sp)
                )
            }
        }
        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun AnswerSection(label: Int, lines: List<String>) {
    if (lines.isEmpty()) return
    Spacer(Modifier.height(24.dp))
    ReflectionLabel(stringResource(label))
    Spacer(Modifier.height(6.dp))
    lines.forEach { line ->
        Text(
            text = line,
            style = entryTextStyle(),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(vertical = 2.dp)
        )
    }
}

@Composable
private fun NoteRow(note: ReflectionNote) {
    Column(modifier = Modifier.padding(bottom = 14.dp)) {
        Text(
            text = note.createdAt.format(shortDate),
            style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = note.text,
            style = entryTextStyle(),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
