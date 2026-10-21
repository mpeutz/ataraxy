package com.ataraxy.app.ui.entry

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.JournalEntry
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.lookback.JournalSession
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.theme.AtaraxyText
import com.ataraxy.app.ui.theme.QuoteSize
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun EntryScreen(
    onBack: () -> Unit,
    onEdit: (Long) -> Unit,
    viewModel: EntryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        AtaraxyTopBar(title = stringResource(R.string.entry_title), onBack = onBack)
        when (val current = state) {
            EntryUiState.Loading -> Unit
            EntryUiState.Missing -> MissingEntry(onBack)
            is EntryUiState.Shown -> EntryBody(current.session, current.quote, onEdit)
        }
    }
}

@Composable
private fun MissingEntry(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        Text(
            text = stringResource(R.string.entry_missing),
            style = AtaraxyText.prompt,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(16.dp))
        TextButton(onClick = onBack) {
            Text(text = stringResource(R.string.back), style = AtaraxyText.button)
        }
    }
}

@Composable
private fun EntryBody(session: JournalSession, quote: Quote?, onEdit: (Long) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 20.dp)
    ) {
        Text(
            text = session.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
            style = AtaraxyText.meta,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        session.entries.forEach { entry ->
            EntrySection(entry, onEdit = { onEdit(entry.id) })
        }
        if (quote != null) LinkedQuote(quote)
        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun EntrySection(entry: JournalEntry, onEdit: () -> Unit) {
    Spacer(Modifier.height(24.dp))
    if (entry.promptText.isNotBlank()) {
        Text(
            text = entry.promptText,
            style = AtaraxyText.prompt,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(8.dp))
    }
    Text(
        text = entry.content,
        style = AtaraxyText.body,
        color = MaterialTheme.colorScheme.onBackground
    )
    TextButton(onClick = onEdit) {
        Text(
            text = stringResource(R.string.journal_edit),
            style = AtaraxyText.button,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun LinkedQuote(quote: Quote) {
    Spacer(Modifier.height(24.dp))
    Text(
        text = stringResource(R.string.quote_in_marks, quote.text),
        style = AtaraxyText.quote(quote.text, QuoteSize.CARD),
        color = MaterialTheme.colorScheme.onBackground
    )
    Spacer(Modifier.height(4.dp))
    Text(
        text = stringResource(R.string.quote_attribution, quote.authorName.uppercase()),
        style = AtaraxyText.attribution,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}
