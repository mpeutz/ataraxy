package com.ataraxy.app.ui.practices.whatsyours

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.Reflection
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.components.orrery.orreryBackground
import com.ataraxy.app.ui.components.orrery.rememberOrreryPattern
import com.ataraxy.app.ui.theme.Jost

@Composable
fun WhatsYoursScreen(
    onBack: () -> Unit,
    onBegin: (Long) -> Unit,
    onOpenReflection: (Reflection) -> Unit,
    viewModel: WhatsYoursViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val begin = { viewModel.begin(onBegin) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .orreryBackground(rememberOrreryPattern("whats_yours"))
    ) {
        item {
            AtaraxyTopBar(
                title = stringResource(R.string.whats_yours_title),
                onBack = onBack,
                subtitle = stringResource(R.string.whats_yours_subtitle)
            )
        }
        item {
            Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)) {
                Text(
                    text = stringResource(R.string.whats_yours_explainer),
                    style = serifTextStyle().copy(fontStyle = FontStyle.Italic),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(28.dp))
                ReflectionLabel(stringResource(R.string.whats_yours_prompt))
                Spacer(Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.Bottom) {
                    UnderlinedTextField(
                        value = state.draftWorry,
                        onValueChange = viewModel::updateDraft,
                        hint = stringResource(R.string.whats_yours_prompt_hint),
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Sentences,
                            imeAction = ImeAction.Go
                        ),
                        keyboardActions = KeyboardActions(onGo = { begin() }),
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(Modifier.width(12.dp))
                    TextButton(onClick = begin, enabled = state.draftWorry.isNotBlank()) {
                        Text(
                            text = stringResource(R.string.whats_yours_begin),
                            style = MaterialTheme.typography.labelLarge.copy(fontFamily = Jost, letterSpacing = 2.sp)
                        )
                    }
                }
            }
        }
        reflectionSection(R.string.whats_yours_open_header, state.open, onOpenReflection)
        reflectionSection(R.string.whats_yours_past_header, state.past, onOpenReflection)
        item { Spacer(Modifier.height(32.dp)) }
    }
}

private fun androidx.compose.foundation.lazy.LazyListScope.reflectionSection(
    header: Int,
    reflections: List<Reflection>,
    onOpen: (Reflection) -> Unit
) {
    if (reflections.isEmpty()) return
    item(key = "header_$header") {
        AtaraxyDivider()
        ReflectionLabel(
            text = stringResource(header),
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 20.dp, bottom = 4.dp)
        )
    }
    items(reflections, key = { "reflection_${it.id}" }) { reflection ->
        ReflectionRow(reflection = reflection, onClick = { onOpen(reflection) })
    }
}

@Composable
private fun ReflectionRow(reflection: Reflection, onClick: () -> Unit) {
    val meta = buildList {
        add(stringResource(R.string.whats_yours_started, reflection.createdAt.format(shortDate)))
        when {
            reflection.completedAt == null -> add(stringResource(R.string.whats_yours_unfinished))
            reflection.notes.isNotEmpty() ->
                add(pluralStringResource(R.plurals.whats_yours_note_count, reflection.notes.size, reflection.notes.size))
        }
    }.joinToString(" · ")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(role = Role.Button, onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = reflection.worry,
            style = serifTextStyle(),
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = meta,
            style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
