package com.ataraxy.app.ui.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.data.seed.InsightData
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.ui.components.AnnotatedQuoteText
import com.ataraxy.app.ui.theme.QuoteSize
import com.ataraxy.app.ui.theme.AtaraxyText
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.components.orrery.orreryBackground
import com.ataraxy.app.ui.components.orrery.rememberOrreryPattern

@Composable
fun PracticeScreen(
    onBack: (() -> Unit)? = null,
    onNavigateToInsight: ((String) -> Unit)? = null,
    viewModel: PracticeViewModel = hiltViewModel()
) {
    val quote by viewModel.quote.collectAsStateWithLifecycle()
    val promptText = stringResource(
        if (quote != null) R.string.practice_prompt_with_quote else R.string.practice_prompt_default
    )
    val saveSuccess by viewModel.saveSuccess.collectAsStateWithLifecycle()

    val inputText by viewModel.draft.collectAsStateWithLifecycle()

    LaunchedEffect(saveSuccess) {
        if (saveSuccess) {
            viewModel.clearSaveSuccess()
            if (viewModel.isEditing) onBack?.invoke()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .orreryBackground(rememberOrreryPattern("practice", centerY = 0.3f))
    ) {
        AtaraxyTopBar(title = stringResource(R.string.practice_title), onBack = onBack)

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
                        text = stringResource(R.string.practice_prompt_label),
                        style = AtaraxyText.eyebrow,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = promptText,
                        style = AtaraxyText.prompt,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(20.dp))
                    BasicTextField(
                        value = inputText,
                        onValueChange = viewModel::updateDraft,
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 100.dp),
                        textStyle = AtaraxyText.body.copy(color = MaterialTheme.colorScheme.onBackground),
                        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
                        decorationBox = { innerTextField ->
                            Box {
                                if (inputText.isEmpty()) {
                                    Text(
                                        text = stringResource(R.string.practice_input_placeholder),
                                        style = AtaraxyText.hint,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )
                    Spacer(Modifier.height(8.dp))
                    AtaraxyDivider()
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = { viewModel.saveEntry(promptText) },
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
                            text = stringResource(R.string.practice_save_reflection),
                            style = AtaraxyText.button
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
                style = AtaraxyText.meta,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(6.dp))
        }
        AnnotatedQuoteText(
            text = stringResource(R.string.quote_in_marks, quote.text),
            style = AtaraxyText.quote(quote.text, QuoteSize.CARD),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.quote_attribution, quote.authorName.uppercase()),
                style = AtaraxyText.attribution,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (hasInsight && onInsightClick != null) {
                Row(
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .clickable(role = Role.Button, onClick = onInsightClick)
                        .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.practice_insight_link),
                        style = AtaraxyText.meta,
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
