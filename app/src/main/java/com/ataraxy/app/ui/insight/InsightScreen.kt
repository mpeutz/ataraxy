package com.ataraxy.app.ui.insight

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.data.seed.InsightData
import com.ataraxy.app.domain.model.InsightSection
import com.ataraxy.app.domain.model.InsightTable
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.theme.AtaraxyText
import com.ataraxy.app.ui.theme.QuoteSize
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.components.orrery.orreryBackground
import com.ataraxy.app.ui.components.orrery.rememberOrreryPattern

@Composable
fun InsightScreen(
    quoteId: String,
    onBack: () -> Unit,
    onNavigateToAuthor: (String) -> Unit,
    viewModel: InsightViewModel = hiltViewModel()
) {
    LaunchedEffect(quoteId) {
        viewModel.setQuoteId(quoteId)
    }

    val quote by viewModel.quote.collectAsStateWithLifecycle()
    val insight = InsightData.insights[quoteId]

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .orreryBackground(rememberOrreryPattern("insight", centerY = 0.25f))
    ) {
        item {
            AtaraxyTopBar(title = stringResource(R.string.insight_title), onBack = onBack)
        }

        // Quote header — shows which quote this insight is for
        if (quote != null) {
            item {
                QuoteHeader(
                    quote = quote!!,
                    onAuthorClick = { onNavigateToAuthor(quote!!.authorId) }
                )
                AtaraxyDivider()
            }
        }

        if (insight == null) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(48.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.insight_empty),
                        style = AtaraxyText.secondary,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }
            return@LazyColumn
        }

        // Intro
        item {
            Spacer(Modifier.height(28.dp))
            Text(
                text = insight.intro,
                style = AtaraxyText.body,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(Modifier.height(32.dp))
        }

        // Breakdown header
        item {
            Text(
                text = stringResource(R.string.insight_breakdown_header),
                style = AtaraxyText.eyebrow,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(Modifier.height(24.dp))
        }

        // Insight sections
        items(insight.sections) { section ->
            InsightSectionBlock(section = section)
            Spacer(Modifier.height(28.dp))
        }

        // Comparison table
        insight.comparisonTable?.let { table ->
            item {
                Spacer(Modifier.height(4.dp))
                InsightTableBlock(table = table)
                Spacer(Modifier.height(32.dp))
            }
        }

        // Modern Application
        insight.modernApplication?.let { text ->
            item {
                Text(
                    text = stringResource(R.string.insight_modern_application),
                    style = AtaraxyText.eyebrow,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = text,
                    style = AtaraxyText.body,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(Modifier.height(32.dp))
            }
        }

        // Closing blockquote
        insight.closing?.let { text ->
            item {
                ClosingBlock(text = text)
                Spacer(Modifier.height(32.dp))
            }
        }

        // Reflection prompt
        insight.reflectionPrompt?.let { prompt ->
            item {
                Text(
                    text = prompt,
                    style = AtaraxyText.prompt,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(Modifier.height(36.dp))
            }
        }

        // About this author link
        if (quote != null) {
            item {
                AtaraxyDivider()
                Spacer(Modifier.height(8.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    TextButton(onClick = { onNavigateToAuthor(quote!!.authorId) }) {
                        Text(
                            text = stringResource(R.string.insight_about_author),
                            style = AtaraxyText.reading.copy(fontStyle = FontStyle.Italic),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Spacer(Modifier.height(32.dp))
            }
        }
    }
}

@Composable
private fun QuoteHeader(quote: Quote, onAuthorClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.quote_in_marks, quote.text),
            style = AtaraxyText.quote(quote.text),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.quote_attribution_with_source, quote.authorName.uppercase(), quote.source.uppercase()),
            style = AtaraxyText.attribution,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .minimumInteractiveComponentSize()
                .clickable(role = Role.Button, onClick = onAuthorClick)
        )
    }
}

@Composable
private fun InsightSectionBlock(section: InsightSection) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            text = "${section.number}. ${section.title}",
            style = AtaraxyText.heading,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(12.dp))

        // Blockquote with left accent bar
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .width(3.dp)
                    .height(IntrinsicSize.Max)
                    .background(
                        MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                        RoundedCornerShape(2.dp)
                    )
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = stringResource(R.string.quote_in_marks, section.blockquote),
                style = AtaraxyText.quote(section.blockquote, QuoteSize.CARD),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Spacer(Modifier.height(12.dp))

        Text(
            text = section.body,
            style = AtaraxyText.secondary,
            color = MaterialTheme.colorScheme.onBackground
        )

        if (section.bullets.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            section.bullets.forEach { bullet ->
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "·",
                        style = AtaraxyText.secondary,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 1.dp, end = 12.dp)
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = bullet.label,
                            style = AtaraxyText.secondary.copy(fontWeight = FontWeight.Medium),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = bullet.text,
                            style = AtaraxyText.secondary,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun InsightTableBlock(table: InsightTable) {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .border(
                width = 0.5.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.surfaceVariant,
                    RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)
                )
        ) {
            Text(
                text = table.leftHeader,
                style = AtaraxyText.meta.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 14.dp, vertical = 10.dp)
            )
            HorizontalDivider(
                modifier = Modifier
                    .width(0.5.dp)
                    .fillMaxHeight(),
                color = MaterialTheme.colorScheme.outlineVariant
            )
            Text(
                text = table.rightHeader,
                style = AtaraxyText.meta.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 14.dp, vertical = 10.dp)
            )
        }
        AtaraxyDivider()

        table.rows.forEachIndexed { index, (left, right) ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = left,
                    style = AtaraxyText.secondary,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 14.dp, vertical = 10.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .width(0.5.dp)
                        .fillMaxHeight(),
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                Text(
                    text = right,
                    style = AtaraxyText.secondary,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 14.dp, vertical = 10.dp)
                )
            }
            if (index < table.rows.lastIndex) {
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    thickness = 0.5.dp
                )
            }
        }
    }
}

@Composable
private fun ClosingBlock(text: String) {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .width(3.dp)
                .height(IntrinsicSize.Max)
                .background(
                    MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                    RoundedCornerShape(2.dp)
                )
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = text,
            style = AtaraxyText.reading.copy(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
