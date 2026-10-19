package com.ataraxy.app.ui.archive

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.data.seed.InsightData
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.domain.model.Virtue
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.theme.AtaraxyText
import com.ataraxy.app.ui.theme.QuoteSize

@Composable
fun ArchiveScreen(
    onNavigateToPractice: (String) -> Unit,
    onNavigateToVirtueDetail: (String) -> Unit,
    onNavigateToInsight: (String) -> Unit,
    onNavigateToAuthor: (String) -> Unit,
    viewModel: ArchiveViewModel = hiltViewModel()
) {
    val quotes by viewModel.quotes.collectAsStateWithLifecycle()
    val authors by viewModel.authors.collectAsStateWithLifecycle()
    val virtues by viewModel.virtues.collectAsStateWithLifecycle()
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val selectedAuthorId by viewModel.selectedAuthorId.collectAsStateWithLifecycle()
    val showBookmarked by viewModel.showBookmarkedOnly.collectAsStateWithLifecycle()
    val featuredQuote by viewModel.featuredQuote.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        item {
            Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                Spacer(Modifier.height(20.dp))
                Text(
                    text = stringResource(R.string.archive_title_eyebrow),
                    style = AtaraxyText.eyebrow,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = stringResource(R.string.archive_title),
                    style = AtaraxyText.display.copy(fontStyle = FontStyle.Italic),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.archive_tagline),
                    style = AtaraxyText.secondary,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(20.dp))
            }
            AtaraxyDivider()
        }

        // Search bar
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Outlined.Search, null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(8.dp))
                BasicSearchField(
                    label = stringResource(R.string.archive_search),
                    value = searchQuery,
                    onValueChange = { viewModel.search(it) },
                    placeholder = stringResource(R.string.archive_search_placeholder)
                )
            }
            AtaraxyDivider()
        }

        // Author filter tabs
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    AuthorTab(
                        label = stringResource(R.string.archive_tab_all),
                        selected = selectedAuthorId == null && !showBookmarked,
                        onClick = { viewModel.filterByAuthor(null) }
                    )
                }
                items(authors) { author ->
                    AuthorTab(
                        label = author.name.split(" ").last().uppercase(),
                        selected = selectedAuthorId == author.id,
                        onClick = { viewModel.filterByAuthor(author.id) }
                    )
                }
                item {
                    AuthorTab(
                        label = stringResource(R.string.archive_tab_saved),
                        selected = showBookmarked,
                        onClick = { viewModel.showBookmarked() }
                    )
                }
            }
        }

        // Quote list
        items(quotes, key = { it.id }) { quote ->
            QuoteCard(
                quote = quote,
                hasInsight = InsightData.insights.containsKey(quote.id),
                onClick = { onNavigateToPractice(quote.id) },
                onInsightClick = { onNavigateToInsight(quote.id) },
                onAuthorClick = { onNavigateToAuthor(quote.authorId) }
            )
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f),
                thickness = 0.5.dp,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }

        // Four Virtues section
        item {
            Spacer(Modifier.height(32.dp))
            AtaraxyDivider()
            Spacer(Modifier.height(24.dp))
            Text(
                text = stringResource(R.string.the_four_virtues),
                style = AtaraxyText.eyebrow,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(Modifier.height(16.dp))
        }

        items(virtues, key = { "virtue_${it.id}" }) { virtue ->
            VirtueCard(
                virtue = virtue,
                onClick = { onNavigateToVirtueDetail(virtue.id) }
            )
        }

        // Featured quote block
        if (featuredQuote != null) {
            item {
                Spacer(Modifier.height(32.dp))
                FeaturedQuoteBlock(quote = featuredQuote!!)
                Spacer(Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun BasicSearchField(label: String, value: String, onValueChange: (String) -> Unit, placeholder: String) {
    Box(modifier = Modifier.fillMaxWidth()) {
        if (value.isEmpty()) {
            Text(
                text = placeholder,
                style = AtaraxyText.hint,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )
        }
        androidx.compose.foundation.text.BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = label },
            textStyle = AtaraxyText.body.copy(color = MaterialTheme.colorScheme.onBackground),
            cursorBrush = androidx.compose.ui.graphics.SolidColor(MaterialTheme.colorScheme.onBackground)
        )
    }
}

@Composable
private fun AuthorTab(label: String, selected: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .minimumInteractiveComponentSize()
            .selectable(selected = selected, role = Role.Tab, onClick = onClick),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = AtaraxyText.meta.copy(fontWeight = if (selected) FontWeight.Medium else FontWeight.Normal),
            color = if (selected) MaterialTheme.colorScheme.onBackground
            else MaterialTheme.colorScheme.onSurfaceVariant
        )
        // Always laid out so selected and unselected labels stay aligned
        Spacer(Modifier.height(2.dp))
        Box(
            modifier = Modifier
                .width(24.dp)
                .height(1.dp)
                .background(if (selected) MaterialTheme.colorScheme.onBackground else Color.Transparent)
        )
    }
}

@Composable
private fun QuoteCard(
    quote: Quote,
    hasInsight: Boolean,
    onClick: () -> Unit,
    onInsightClick: () -> Unit,
    onAuthorClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = quote.source.uppercase(),
                style = AtaraxyText.meta,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = quote.virtueId,
                style = AtaraxyText.meta,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(4.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
        Spacer(Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.quote_attribution, quote.authorName.uppercase()),
            style = AtaraxyText.attribution,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .minimumInteractiveComponentSize()
                .clickable(role = Role.Button, onClick = onAuthorClick)
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = quote.text,
            style = AtaraxyText.quote(quote.text, QuoteSize.CARD),
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
        if (hasInsight) {
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .minimumInteractiveComponentSize()
                    .clickable(role = Role.Button, onClick = onInsightClick)
                    .padding(vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.archive_insight_link),
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

@Composable
private fun VirtueCard(virtue: Virtue, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = virtue.latinName.uppercase(),
                style = AtaraxyText.eyebrow,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = virtue.name,
                style = AtaraxyText.heading,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = virtue.definingQuote.take(80) + if (virtue.definingQuote.length > 80) "…" else "",
                style = AtaraxyText.secondary,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Icon(
            imageVector = Icons.Outlined.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(20.dp)
        )
    }
    HorizontalDivider(
        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f),
        thickness = 0.5.dp,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}

@Composable
private fun FeaturedQuoteBlock(quote: Quote) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
            .padding(24.dp),
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
            text = stringResource(R.string.quote_attribution, quote.authorName.uppercase()),
            style = AtaraxyText.attribution,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
