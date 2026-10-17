package com.ataraxy.app.ui.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.data.seed.InsightData
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.ui.components.AnnotatedQuoteText
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

@Composable
fun PracticeScreen(
    quoteId: String?,
    entryId: Long? = null,
    onBack: (() -> Unit)? = null,
    onNavigateToInsight: ((String) -> Unit)? = null,
    viewModel: PracticeViewModel = hiltViewModel()
) {
    LaunchedEffect(quoteId) { viewModel.setQuoteId(quoteId) }
    LaunchedEffect(entryId) { viewModel.setEntryId(entryId) }

    val quote by viewModel.quote.collectAsStateWithLifecycle()
    val editingContent by viewModel.editingContent.collectAsStateWithLifecycle()
    val saveSuccess by viewModel.saveSuccess.collectAsStateWithLifecycle()

    var inputText by remember { mutableStateOf("") }

    LaunchedEffect(editingContent) {
        if (editingContent != null && inputText.isEmpty()) {
            inputText = editingContent!!
        }
    }

    LaunchedEffect(saveSuccess) {
        if (saveSuccess) {
            viewModel.clearSaveSuccess()
            if (entryId != null) {
                onBack?.invoke()
            } else {
                inputText = ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (onBack != null) {
                IconButton(onClick = onBack) {
                    Icon(
                        Icons.Outlined.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            } else {
                Spacer(Modifier.size(48.dp))
            }
            Spacer(Modifier.weight(1f))
            Text(
                text = "PRACTICE",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    letterSpacing = 4.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.weight(1f))
            Spacer(Modifier.size(48.dp))
        }

        Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            // Quote recap card
            if (quote != null) {
                item {
                    Spacer(Modifier.height(20.dp))
                    QuoteRecapCard(
                        quote = quote!!,
                        hasInsight = InsightData.insights.containsKey(quote!!.id),
                        onInsightClick = onNavigateToInsight?.let { nav -> { nav(quote!!.id) } }
                    )
                }
            }

            // Prompt + input
            item {
                Spacer(Modifier.height(24.dp))
                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    Text(
                        text = "PRACTICE PROMPT",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontFamily = Jost,
                            letterSpacing = 3.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = if (quote != null) "How can I apply this today?" else "What weighs on your mind today?",
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontFamily = CormorantGaramond,
                            fontStyle = FontStyle.Italic
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(20.dp))
                    BasicTextField(
                        value = inputText,
                        onValueChange = { inputText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 100.dp),
                        textStyle = MaterialTheme.typography.bodyLarge.copy(
                            fontFamily = Jost,
                            color = MaterialTheme.colorScheme.onBackground
                        ),
                        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
                        decorationBox = { innerTextField ->
                            Box {
                                if (inputText.isEmpty()) {
                                    Text(
                                        text = "Begin writing…",
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontFamily = CormorantGaramond,
                                            fontStyle = FontStyle.Italic
                                        ),
                                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )
                    Spacer(Modifier.height(8.dp))
                    Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = { if (inputText.isNotBlank()) viewModel.saveEntry(inputText) },
                        enabled = inputText.isNotBlank(),
                        modifier = Modifier.align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onBackground,
                            contentColor = MaterialTheme.colorScheme.background,
                            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        shape = MaterialTheme.shapes.extraLarge,
                        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = "SAVE REFLECTION",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontFamily = Jost,
                                letterSpacing = 2.sp
                            )
                        )
                    }
                }
            }

            item { Spacer(Modifier.height(32.dp)) }
        }
    }
}

@Composable
private fun QuoteRecapCard(
    quote: Quote,
    hasInsight: Boolean,
    onInsightClick: (() -> Unit)?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        if (quote.source.isNotBlank()) {
            Text(
                text = quote.source.uppercase(),
                style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost, letterSpacing = 2.sp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(6.dp))
        }
        AnnotatedQuoteText(
            text = "\u201C${quote.text}\u201D",
            style = MaterialTheme.typography.displaySmall.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "— ${quote.authorName}",
                style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (hasInsight && onInsightClick != null) {
                Row(
                    modifier = Modifier
                        .clickable(onClick = onInsightClick)
                        .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "INSIGHT",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontFamily = Jost,
                            letterSpacing = 2.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.width(2.dp))
                    Icon(
                        imageVector = Icons.Outlined.ChevronRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}
