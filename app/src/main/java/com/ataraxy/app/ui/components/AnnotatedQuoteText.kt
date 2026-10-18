package com.ataraxy.app.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withLink
import com.ataraxy.app.R
import com.ataraxy.app.data.glossary.StoicGlossary
import com.ataraxy.app.ui.theme.GlossaryTint
import com.ataraxy.app.ui.theme.Jost

/**
 * Renders quote text with Stoic glossary terms highlighted in [GlossaryTint].
 * Tapping a highlighted term opens a definition dialog.
 */
@Composable
fun AnnotatedQuoteText(
    text: String,
    style: TextStyle,
    color: Color,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    var selectedKey by remember { mutableStateOf<String?>(null) }

    val annotated = remember(text) { buildGlossaryAnnotatedString(text) { selectedKey = it } }

    Text(
        text = annotated,
        style = style.copy(
            color = color,
            textAlign = textAlign ?: style.textAlign
        ),
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow
    )

    selectedKey?.let { key ->
        StoicGlossary.terms[key]?.let { (displayName, definition) ->
            GlossaryDefinitionDialog(
                displayName = displayName,
                definition = definition,
                onDismiss = { selectedKey = null }
            )
        }
    }
}

@Composable
private fun GlossaryDefinitionDialog(
    displayName: String,
    definition: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = displayName,
                style = MaterialTheme.typography.titleMedium.copy(fontFamily = Jost)
            )
        },
        text = {
            Text(
                text = definition,
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost)
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = stringResource(R.string.close),
                    style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost)
                )
            }
        }
    )
}

private fun buildGlossaryAnnotatedString(text: String, onTermClick: (String) -> Unit) = buildAnnotatedString {
    data class Hit(val start: Int, val end: Int, val key: String)

    val lower = text.lowercase()
    val hits = mutableListOf<Hit>()

    for (key in StoicGlossary.terms.keys) {
        val lowerKey = key.lowercase()
        var idx = 0
        while (idx <= lower.length - lowerKey.length) {
            val pos = lower.indexOf(lowerKey, idx)
            if (pos == -1) break
            val beforeOk = pos == 0 || !lower[pos - 1].isLetterOrDigit()
            val afterOk = pos + lowerKey.length == lower.length || !lower[pos + lowerKey.length].isLetterOrDigit()
            if (beforeOk && afterOk) hits.add(Hit(pos, pos + lowerKey.length, key))
            idx = pos + 1
        }
    }

    // Sort by start ascending, then by length descending (prefer longer match at same position)
    val sorted = hits.sortedWith(compareBy({ it.start }, { it.start - it.end }))

    // Pick non-overlapping hits
    val chosen = mutableListOf<Hit>()
    var cursor = 0
    for (hit in sorted) {
        if (hit.start >= cursor) {
            chosen.add(hit)
            cursor = hit.end
        }
    }

    var pos = 0
    for (hit in chosen) {
        if (hit.start > pos) append(text.substring(pos, hit.start))
        val link = LinkAnnotation.Clickable(
            tag = hit.key,
            styles = TextLinkStyles(style = SpanStyle(color = GlossaryTint)),
            linkInteractionListener = { onTermClick(hit.key) }
        )
        withLink(link) { append(text.substring(hit.start, hit.end)) }
        pos = hit.end
    }
    if (pos < text.length) append(text.substring(pos))
}
