package com.ataraxy.app.ui.practices.sos

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.SosEmotion
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.components.orrery.orreryBackground
import com.ataraxy.app.ui.components.orrery.rememberOrreryPattern
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

internal data class EmotionOption(
    val emotion: SosEmotion,
    @StringRes val label: Int,
    @StringRes val latin: Int
)

internal val sosEmotionOptions = listOf(
    EmotionOption(SosEmotion.ANGRY, R.string.sos_emotion_angry, R.string.sos_latin_angry),
    EmotionOption(SosEmotion.ANXIOUS, R.string.sos_emotion_anxious, R.string.sos_latin_anxious),
    EmotionOption(SosEmotion.GRIEVING, R.string.sos_emotion_grieving, R.string.sos_latin_grieving),
    EmotionOption(SosEmotion.AFRAID, R.string.sos_emotion_afraid, R.string.sos_latin_afraid),
    EmotionOption(SosEmotion.OVERWHELMED, R.string.sos_emotion_overwhelmed, R.string.sos_latin_overwhelmed),
    EmotionOption(SosEmotion.PROCRASTINATING, R.string.sos_emotion_procrastinating, R.string.sos_latin_procrastinating),
    EmotionOption(SosEmotion.STUCK, R.string.sos_emotion_stuck, R.string.sos_latin_stuck),
    EmotionOption(SosEmotion.HELPLESS, R.string.sos_emotion_helpless, R.string.sos_latin_helpless),
    EmotionOption(SosEmotion.INSECURE, R.string.sos_emotion_insecure, R.string.sos_latin_insecure),
    EmotionOption(SosEmotion.ASHAMED, R.string.sos_emotion_ashamed, R.string.sos_latin_ashamed),
    EmotionOption(SosEmotion.GUILTY, R.string.sos_emotion_guilty, R.string.sos_latin_guilty),
    EmotionOption(SosEmotion.LONELY, R.string.sos_emotion_lonely, R.string.sos_latin_lonely),
    EmotionOption(SosEmotion.REJECTED, R.string.sos_emotion_rejected, R.string.sos_latin_rejected),
    EmotionOption(SosEmotion.DISCOURAGED, R.string.sos_emotion_discouraged, R.string.sos_latin_discouraged),
    EmotionOption(SosEmotion.RESENTFUL, R.string.sos_emotion_resentful, R.string.sos_latin_resentful),
    EmotionOption(SosEmotion.TREATED_UNFAIRLY, R.string.sos_emotion_treated_unfairly, R.string.sos_latin_treated_unfairly),
    EmotionOption(SosEmotion.BURNED_OUT, R.string.sos_emotion_burned_out, R.string.sos_latin_burned_out),
    EmotionOption(SosEmotion.NUMB, R.string.sos_emotion_numb, R.string.sos_latin_numb),
    EmotionOption(SosEmotion.RESTLESS, R.string.sos_emotion_restless, R.string.sos_latin_restless),
    EmotionOption(SosEmotion.CONFUSED, R.string.sos_emotion_confused, R.string.sos_latin_confused),
    EmotionOption(SosEmotion.REGRETFUL, R.string.sos_emotion_regretful, R.string.sos_latin_regretful),
    EmotionOption(SosEmotion.JEALOUS_ENVIOUS, R.string.sos_emotion_jealous_envious, R.string.sos_latin_jealous_envious),
    EmotionOption(SosEmotion.UNMOTIVATED, R.string.sos_emotion_unmotivated, R.string.sos_latin_unmotivated),
    EmotionOption(SosEmotion.HOPELESS, R.string.sos_emotion_hopeless, R.string.sos_latin_hopeless)
)

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun SosScreen(
    onBack: () -> Unit,
    onNavigateToInsight: (String) -> Unit,
    viewModel: SosViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val selectedOption = state.selectedEmotion?.let { emotion ->
        sosEmotionOptions.firstOrNull { it.emotion == emotion }
    }
    val scrollState = rememberScrollState()
    val quoteBringIntoViewRequester = remember { BringIntoViewRequester() }

    LaunchedEffect(state.currentQuote?.id) {
        if (state.currentQuote != null) {
            quoteBringIntoViewRequester.bringIntoView()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .orreryBackground(rememberOrreryPattern("sos"))
            .verticalScroll(scrollState)
    ) {
        AtaraxyTopBar(title = stringResource(R.string.sos_title), onBack = onBack)

        Spacer(Modifier.height(32.dp))

        Text(
            text = stringResource(R.string.sos_prompt),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic,
                fontSize = 22.sp
            ),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(24.dp))

        // Emotion grid 2x2
        Column(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            sosEmotionOptions.chunked(2).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    row.forEach { option ->
                        EmotionCard(
                            option = option,
                            isSelected = state.selectedEmotion == option.emotion,
                            onClick = { viewModel.selectEmotion(option.emotion) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        // Quote display
        AnimatedVisibility(
            visible = state.currentQuote != null,
            enter = fadeIn(tween(400)),
            exit = fadeOut(tween(300))
        ) {
            state.currentQuote?.let { quote ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .bringIntoViewRequester(quoteBringIntoViewRequester)
                        .padding(horizontal = 24.dp, vertical = 32.dp)
                ) {
                    AtaraxyDivider()
                    Spacer(Modifier.height(32.dp))
                    selectedOption?.let { option ->
                        Text(
                            text = stringResource(R.string.sos_selected_feeling),
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontFamily = Jost,
                                letterSpacing = 2.sp
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = stringResource(option.label),
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontFamily = Jost,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = 2.sp
                            ),
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stringResource(option.latin),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = CormorantGaramond,
                                fontStyle = FontStyle.Italic,
                                fontSize = 16.sp
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        Spacer(Modifier.height(24.dp))
                    }
                    Text(
                        text = stringResource(R.string.quote_in_marks, quote.text),
                        style = sosQuoteStyle(quote.text),
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = stringResource(R.string.quote_attribution, quote.authorName.uppercase()),
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontFamily = Jost,
                            letterSpacing = 2.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    if (quote.source.isNotBlank()) {
                        Text(
                            text = quote.source.uppercase(),
                            style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                    if (state.quoteTotal > 0 && state.quotePosition > 0) {
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = stringResource(R.string.sos_quote_position, state.quotePosition, state.quoteTotal),
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontFamily = Jost,
                                letterSpacing = 1.sp
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75f),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(Modifier.height(32.dp))
                    OutlinedButton(
                        onClick = viewModel::refreshQuote,
                        enabled = !state.isLoading,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        shape = MaterialTheme.shapes.extraLarge,
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Refresh,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = stringResource(R.string.sos_another_quote),
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontFamily = Jost,
                                letterSpacing = 2.sp
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    TextButton(
                        onClick = { onNavigateToInsight(quote.id) },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = stringResource(R.string.sos_explore_insight),
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontFamily = CormorantGaramond,
                                fontStyle = FontStyle.Italic,
                                fontSize = 15.sp
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        if (state.currentQuote == null) {
            Spacer(Modifier.height(48.dp))
            Text(
                text = stringResource(R.string.sos_footer),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontFamily = CormorantGaramond,
                    fontStyle = FontStyle.Italic,
                    fontSize = 15.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(Modifier.height(32.dp))
    }
}

private const val LONG_QUOTE_CHARS = 160

/** Quote text sized off the theme so the user's text-size setting still applies; long quotes step down. */
@Composable
private fun sosQuoteStyle(text: String): TextStyle {
    val base = MaterialTheme.typography.displaySmall
    val fontSize = if (text.length > LONG_QUOTE_CHARS) base.fontSize * 0.85f else base.fontSize
    return base.copy(
        fontFamily = CormorantGaramond,
        fontStyle = FontStyle.Italic,
        fontSize = fontSize,
        lineHeight = 1.3.em
    )
}

@Composable
private fun EmotionCard(
    option: EmotionOption,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val containerColor = if (isSelected)
        MaterialTheme.colorScheme.onBackground
    else
        MaterialTheme.colorScheme.surfaceVariant

    val textColor = if (isSelected)
        MaterialTheme.colorScheme.background
    else
        MaterialTheme.colorScheme.onBackground

    val subtitleColor = if (isSelected)
        MaterialTheme.colorScheme.background.copy(alpha = 0.7f)
    else
        MaterialTheme.colorScheme.onSurfaceVariant

    Card(
        modifier = modifier.selectable(selected = isSelected, role = Role.RadioButton, onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val label = stringResource(option.label)
            val isLongLabel = label.length > 12
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    fontSize = if (isLongLabel) 12.sp else 13.sp,
                    letterSpacing = if (isLongLabel) 1.5.sp else 2.sp,
                    fontWeight = FontWeight.Medium
                ),
                color = textColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = stringResource(option.latin),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontFamily = CormorantGaramond,
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp
                ),
                color = subtitleColor
            )
        }
    }
}
