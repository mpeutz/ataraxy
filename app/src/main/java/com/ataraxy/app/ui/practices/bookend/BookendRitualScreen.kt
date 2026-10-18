package com.ataraxy.app.ui.practices.bookend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.ataraxy.app.R
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            val sessionLabel = when (state.session) {
                RitualSession.MORNING -> "MORNING RITUAL"
                RitualSession.EVENING -> "EVENING RITUAL"
                RitualSession.NEUTRAL -> "DAILY RITUAL"
            }
            Text(
                text = sessionLabel,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 4.sp,
                    fontSize = 14.sp
                ),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.weight(1f)
            )
            // Show "Change" only while actively in a session (not on selector, completion, or already-done screens)
            if (!state.isSaved && !state.isLoading && state.session != RitualSession.NEUTRAL) {
                TextButton(onClick = viewModel::resetSession) {
                    Text(
                        text = "CHANGE",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontFamily = Jost,
                            letterSpacing = 1.5.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        Image(
            painter = painterResource(R.drawable.img_bowls),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentScale = ContentScale.Crop
        )

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        if (!state.isLoading) {
            when {
                state.isSaved -> CompletionContent(session = state.session, onBack = onBack)
                state.session == RitualSession.NEUTRAL -> SessionSelector(onSelectSession = viewModel::setSession)
                state.session == RitualSession.MORNING && state.hasCompletedMorningToday ->
                    AlreadyCompletedContent(label = "morning", onBack = onBack)
                state.session == RitualSession.EVENING && state.hasCompletedEveningToday ->
                    AlreadyCompletedContent(label = "evening", onBack = onBack)
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
        text = "Which ritual would you like to complete?",
        style = MaterialTheme.typography.bodyMedium.copy(
            fontFamily = CormorantGaramond,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp
        ),
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
        listOf(RitualSession.MORNING to "Morning", RitualSession.EVENING to "Evening").forEach { (session, label) ->
            Card(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onSelectSession(session) },
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
                        text = label.uppercase(),
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontFamily = Jost,
                            letterSpacing = 3.sp
                        ),
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
    val ritualLabel = if (state.session == RitualSession.MORNING) "PRAEMEDITATIO MALORUM" else "EVENING REVIEW"

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
            style = MaterialTheme.typography.labelMedium.copy(
                fontFamily = Jost,
                letterSpacing = 3.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (streak > 1) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Day $streak",
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
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
            text = "COMPLETE RITUAL",
            style = MaterialTheme.typography.labelLarge.copy(
                fontFamily = Jost,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Medium
            )
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
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(12.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = Jost,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
                lineHeight = 26.sp
            ),
            decorationBox = { innerTextField ->
                Column {
                    Box {
                        if (value.isEmpty()) {
                            Text(
                                text = "Write freely\u2026",
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
    }
}

@Composable
private fun CompletionContent(session: RitualSession, onBack: () -> Unit) {
    val quote = if (session == RitualSession.MORNING)
        "He who rises with the sun sets the course of his day with intention."
    else
        "The evening review is complete. Sleep with a calm mind."

    Spacer(Modifier.height(48.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "\u201C$quote\u201D",
            style = MaterialTheme.typography.displaySmall.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic,
                lineHeight = 36.sp,
                fontSize = 24.sp
            ),
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
                text = "DONE",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}

@Composable
private fun AlreadyCompletedContent(label: String, onBack: () -> Unit) {
    Spacer(Modifier.height(48.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You have already completed today\u2019s $label ritual.",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(24.dp))
        TextButton(onClick = onBack) {
            Text(
                text = "BACK",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    letterSpacing = 2.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
