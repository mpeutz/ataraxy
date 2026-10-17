package com.ataraxy.app.ui.practices.journal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.domain.model.JournalEntry
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost
import java.time.format.DateTimeFormatter

@Composable
fun JournalHistoryScreen(
    onBack: () -> Unit,
    onEditEntry: (JournalEntry) -> Unit,
    viewModel: JournalHistoryViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val quotesMap by viewModel.quotesMap.collectAsStateWithLifecycle()
    var expandedEntryId by remember { mutableStateOf<Long?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            Column {
                Text(
                    text = "JOURNAL",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontFamily = Jost,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 4.sp,
                        fontSize = 14.sp
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "${state.entries.size} ${if (state.entries.size == 1) "entry" else "entries"}",
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        // Search field
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Outlined.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(8.dp))
            Box(modifier = Modifier.weight(1f)) {
                if (state.searchQuery.isEmpty()) {
                    Text(
                        text = "Search entries…",
                        style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                    )
                }
                BasicTextField(
                    value = state.searchQuery,
                    onValueChange = { viewModel.setSearchQuery(it) },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = Jost,
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
                    singleLine = true
                )
            }
        }

        Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        // Filter chips
        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(JournalFilter.entries) { filter ->
                FilterChip(
                    selected = state.filter == filter,
                    onClick = { viewModel.setFilter(filter) },
                    label = {
                        Text(
                            text = filter.label,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontFamily = Jost,
                                letterSpacing = 1.5.sp
                            )
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.onBackground,
                        selectedLabelColor = MaterialTheme.colorScheme.background,
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = state.filter == filter,
                        borderColor = MaterialTheme.colorScheme.outlineVariant,
                        selectedBorderColor = MaterialTheme.colorScheme.onBackground,
                        borderWidth = 0.5.dp,
                        selectedBorderWidth = 0.dp
                    ),
                    shape = RoundedCornerShape(6.dp)
                )
            }
        }

        Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        if (state.entries.isEmpty()) {
            EmptyState(filter = state.filter, hasSearch = state.searchQuery.isNotBlank())
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items = state.entries, key = { it.id }) { entry ->
                    JournalEntryRow(
                        entry = entry,
                        linkedQuote = entry.linkedQuoteId?.let { quotesMap[it] },
                        isExpanded = expandedEntryId == entry.id,
                        onToggleExpand = {
                            expandedEntryId = if (expandedEntryId == entry.id) null else entry.id
                        },
                        onEdit = { onEditEntry(entry) },
                        onDelete = {
                            if (expandedEntryId == entry.id) expandedEntryId = null
                            viewModel.deleteEntry(entry)
                        }
                    )
                    Divider(
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                        thickness = 0.5.dp,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                }
                item { Spacer(Modifier.height(32.dp)) }
            }
        }
    }
}

private val JournalFilter.label: String get() = when (this) {
    JournalFilter.ALL -> "ALL"
    JournalFilter.REFLECTIONS -> "REFLECTIONS"
    JournalFilter.MORNING -> "MORNING"
    JournalFilter.EVENING -> "EVENING"
}

@Composable
private fun EmptyState(filter: JournalFilter, hasSearch: Boolean) {
    val message = when {
        hasSearch -> "No entries match your search."
        filter == JournalFilter.ALL -> "No journal entries yet.\nBegin a practice to write your first reflection."
        filter == JournalFilter.REFLECTIONS -> "No reflections yet.\nWrite one from the Practice tab."
        filter == JournalFilter.MORNING -> "No morning rituals recorded.\nComplete a morning bookend to begin."
        else -> "No evening rituals recorded.\nComplete an evening bookend to begin."
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic,
                fontSize = 18.sp,
                lineHeight = 28.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 40.dp)
        )
    }
}

@Composable
private fun JournalEntryRow(
    entry: JournalEntry,
    linkedQuote: Quote?,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    val dateStr = entry.createdAt.format(DateTimeFormatter.ofPattern("d MMM yyyy"))
    val timeStr = entry.createdAt.format(DateTimeFormatter.ofPattern("HH:mm"))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggleExpand() }
            .padding(horizontal = 24.dp, vertical = 14.dp)
    ) {
        // Date + type badge row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dateStr,
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = timeStr,
                    style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                )
            }
            entry.ritualType?.let { type ->
                Text(
                    text = type,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontFamily = Jost, letterSpacing = 1.sp, fontSize = 9.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                )
            } ?: entry.virtueId?.let { virtue ->
                Text(
                    text = virtue.uppercase(),
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontFamily = Jost, letterSpacing = 1.sp, fontSize = 9.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
        }

        Spacer(Modifier.height(6.dp))

        // Entry content (collapsed = 2 lines, expanded = full)
        Text(
            text = if (isExpanded) entry.content else entry.content,
            style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = if (isExpanded) Int.MAX_VALUE else 2,
            overflow = TextOverflow.Ellipsis
        )

        if (isExpanded) {
            // Linked quote
            if (linkedQuote != null) {
                Spacer(Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.surfaceVariant,
                            RoundedCornerShape(6.dp)
                        )
                        .padding(12.dp)
                ) {
                    Text(
                        text = linkedQuote.source.uppercase(),
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontFamily = Jost,
                            letterSpacing = 2.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "\u201C${linkedQuote.text}\u201D",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontFamily = CormorantGaramond,
                            fontStyle = FontStyle.Italic,
                            lineHeight = 24.sp
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "— ${linkedQuote.authorName}",
                        style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Edit + delete actions
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = onEdit,
                    contentPadding = PaddingValues(horizontal = 0.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "EDIT",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontFamily = Jost,
                            letterSpacing = 1.5.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                IconButton(
                    onClick = onDelete,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete entry",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}
