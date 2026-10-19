package com.ataraxy.app.ui.practices.bookend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.theme.AtaraxyText

@Composable
fun BookendRitualScreen(
    onBack: () -> Unit,
    viewModel: BookendRitualViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .imePadding()
            .verticalScroll(rememberScrollState())
    ) {
        val titleRes = when (state.session) {
            RitualSession.MORNING -> R.string.bookend_title_morning
            RitualSession.EVENING -> R.string.bookend_title_evening
            RitualSession.NEUTRAL -> R.string.bookend_title_daily
        }
        AtaraxyTopBar(
            title = stringResource(titleRes),
            onBack = onBack,
            actions = {
                // Show "Change" only while actively in a session (not on selector, completion, or already-done screens)
                if (!state.isSaved && !state.isLoading && state.session != RitualSession.NEUTRAL) {
                    TextButton(onClick = viewModel::resetSession) {
                        Text(
                            text = stringResource(R.string.bookend_change),
                            style = AtaraxyText.button,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        )

        Image(
            painter = painterResource(R.drawable.img_bowls),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentScale = ContentScale.Crop
        )

        AtaraxyDivider()

        if (!state.isLoading) {
            when {
                state.isSaved -> CompletionContent(session = state.session, onBack = onBack)
                state.session == RitualSession.NEUTRAL -> SessionSelector(onSelectSession = viewModel::setSession)
                state.session == RitualSession.MORNING && state.hasCompletedMorningToday ->
                    AlreadyCompletedContent(
                        message = stringResource(R.string.bookend_already_completed_morning),
                        onBack = onBack
                    )
                state.session == RitualSession.EVENING && state.hasCompletedEveningToday ->
                    AlreadyCompletedContent(
                        message = stringResource(R.string.bookend_already_completed_evening),
                        onBack = onBack
                    )
                else -> RitualContent(
                    state = state,
                    onUpdateAnswer = viewModel::updateAnswer,
                    onComplete = viewModel::saveAndComplete
                )
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun SessionSelector(onSelectSession: (RitualSession) -> Unit) {
    Spacer(Modifier.height(32.dp))
    Text(
        text = stringResource(R.string.bookend_select_prompt),
        style = AtaraxyText.prompt,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
    Spacer(Modifier.height(24.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        listOf(
            RitualSession.MORNING to R.string.bookend_session_morning,
            RitualSession.EVENING to R.string.bookend_session_evening
        ).forEach { (session, labelRes) ->
            Card(
                modifier = Modifier
                    .weight(1f)
                    .clickable(role = Role.Button) { onSelectSession(session) },
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(labelRes),
                        style = AtaraxyText.button,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

@Composable
private fun RitualContent(
    state: BookendUiState,
    onUpdateAnswer: (String, String) -> Unit,
    onComplete: () -> Unit
) {
    val prompts = if (state.session == RitualSession.MORNING)
        BookendRitualViewModel.MORNING_PROMPTS
    else
        BookendRitualViewModel.EVENING_PROMPTS

    val streak = if (state.session == RitualSession.MORNING) state.morningStreak else state.eveningStreak
    val ritualLabel = stringResource(
        if (state.session == RitualSession.MORNING) R.string.bookend_label_morning else R.string.bookend_label_evening
    )

    Spacer(Modifier.height(32.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = ritualLabel,
            style = AtaraxyText.eyebrow,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (streak > 1) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = stringResource(R.string.day_streak, streak),
                    style = AtaraxyText.meta,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }

    Spacer(Modifier.height(32.dp))

    prompts.forEach { prompt ->
        PromptField(
            prompt = prompt,
            value = state.answers[prompt] ?: "",
            onValueChange = { onUpdateAnswer(prompt, it) }
        )
        Spacer(Modifier.height(28.dp))
    }

    Spacer(Modifier.height(8.dp))

    val allAnswered = prompts.all { (state.answers[it] ?: "").isNotBlank() }
    Button(
        onClick = onComplete,
        enabled = allAnswered,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.background,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        shape = MaterialTheme.shapes.extraLarge,
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 14.dp)
    ) {
        Text(
            text = stringResource(R.string.bookend_complete_ritual),
            style = AtaraxyText.button
        )
    }
}

@Composable
private fun PromptField(
    prompt: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            text = prompt,
            style = AtaraxyText.prompt,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(12.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = AtaraxyText.body.copy(color = MaterialTheme.colorScheme.onBackground),
            decorationBox = { innerTextField ->
                Column {
                    Box {
                        if (value.isEmpty()) {
                            Text(
                                text = stringResource(R.string.bookend_input_placeholder),
                                style = AtaraxyText.hint,
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
    }
}

@Composable
private fun CompletionContent(session: RitualSession, onBack: () -> Unit) {
    val quote = stringResource(
        if (session == RitualSession.MORNING) R.string.bookend_completion_morning else R.string.bookend_completion_evening
    )
    val quoteText = stringResource(R.string.quote_in_marks, quote)

    Spacer(Modifier.height(48.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = quoteText,
            style = AtaraxyText.quote(quoteText),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(32.dp))
        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.background
            ),
            shape = MaterialTheme.shapes.extraLarge,
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 14.dp)
        ) {
            Text(
                text = stringResource(R.string.bookend_done),
                style = AtaraxyText.button
            )
        }
    }
}

@Composable
private fun AlreadyCompletedContent(message: String, onBack: () -> Unit) {
    Spacer(Modifier.height(48.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            style = AtaraxyText.prompt,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(24.dp))
        TextButton(onClick = onBack) {
            Text(
                text = stringResource(R.string.bookend_back),
                style = AtaraxyText.button,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
