package com.ataraxy.app.ui.practices.sos

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.domain.model.SosEmotion
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

private data class EmotionOption(
    val emotion: SosEmotion,
    val label: String,
    val latin: String
)

private val emotions = listOf(
    EmotionOption(SosEmotion.OVERWHELMED, "OVERWHELMED", "Pressura"),
    EmotionOption(SosEmotion.PROCRASTINATING, "PROCRASTINATING", "Dilatio"),
    EmotionOption(SosEmotion.STUCK, "STUCK", "Haesitatio"),
    EmotionOption(SosEmotion.HELPLESS, "HELPLESS", "Impotentia"),
    EmotionOption(SosEmotion.INSECURE, "INSECURE", "Incertitudo"),
    EmotionOption(SosEmotion.ASHAMED, "ASHAMED", "Pudor"),
    EmotionOption(SosEmotion.GUILTY, "GUILTY", "Culpa"),
    EmotionOption(SosEmotion.LONELY, "LONELY", "Solitudo"),
    EmotionOption(SosEmotion.REJECTED, "REJECTED", "Repulsa"),
    EmotionOption(SosEmotion.DISCOURAGED, "DISCOURAGED", "Demissus"),
    EmotionOption(SosEmotion.RESENTFUL, "RESENTFUL", "Resentimentum"),
    EmotionOption(SosEmotion.TREATED_UNFAIRLY, "TREATED UNFAIRLY", "Iniuria"),
    EmotionOption(SosEmotion.BURNED_OUT, "BURNED OUT", "Exhaustio"),
    EmotionOption(SosEmotion.NUMB, "NUMB", "Torpor"),
    EmotionOption(SosEmotion.RESTLESS, "RESTLESS", "Inquietudo"),
    EmotionOption(SosEmotion.CONFUSED, "CONFUSED", "Confusio"),
    EmotionOption(SosEmotion.REGRETFUL, "REGRETFUL", "Paenitentia"),
    EmotionOption(SosEmotion.JEALOUS_ENVIOUS, "JEALOUS / ENVIOUS", "Invidia"),
    EmotionOption(SosEmotion.UNMOTIVATED, "UNMOTIVATED", "Segnitia"),
    EmotionOption(SosEmotion.HOPELESS, "HOPELESS", "Desperatio")
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
        emotions.firstOrNull { it.emotion == emotion }
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
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
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
            Text(
                text = "FIND YOUR FOOTING",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 4.sp,
                    fontSize = 14.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        Spacer(Modifier.height(32.dp))

        Text(
            text = "What are you feeling right now?",
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
            emotions.chunked(2).forEach { row ->
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
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
                    Spacer(Modifier.height(32.dp))
                    selectedOption?.let { option ->
                        Text(
                            text = "SELECTED FEELING",
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
                            text = option.label,
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
                            text = option.latin,
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
                        text = "\u201C${quote.text}\u201D",
                        style = MaterialTheme.typography.displayMedium.copy(
                            fontFamily = CormorantGaramond,
                            fontStyle = FontStyle.Italic,
                            lineHeight = 44.sp
                        ),
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = "\u2014 ${quote.authorName.uppercase()}",
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
                            text = "${state.quotePosition}/${state.quoteTotal}",
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
                            text = "ANOTHER QUOTE",
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
                            text = "Explore this insight",
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
                text = "These quotes are drawn from the Stoics\nwho faced these same struggles.",
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
        modifier = modifier.clickable(onClick = onClick),
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
            val isLongLabel = option.label.length > 12
            Text(
                text = option.label,
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
                text = option.latin,
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
