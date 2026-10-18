package com.ataraxy.app.ui.virtue

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.domain.model.SubConcept
import com.ataraxy.app.domain.model.Virtue
import com.ataraxy.app.ui.components.AnnotatedQuoteText
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.components.orrery.orreryBackground
import com.ataraxy.app.ui.components.orrery.rememberOrreryPattern
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

@Composable
fun VirtueDetailScreen(
    virtueId: String,
    onNavigateToPractice: (String) -> Unit,
    onBack: () -> Unit,
    viewModel: VirtueDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(virtueId) {
        viewModel.setVirtueId(virtueId)
    }

    val virtue by viewModel.virtue.collectAsStateWithLifecycle()
    val relatedQuotes by viewModel.relatedQuotes.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .orreryBackground(rememberOrreryPattern("virtue"))
    ) {
        // Top bar
        item {
            AtaraxyTopBar(title = null, onBack = onBack)
        }

        if (virtue != null) {
            item {
                VirtueHeader(virtue = virtue!!)
            }

            item {
                Spacer(Modifier.height(32.dp))
                AtaraxyDivider()
                Spacer(Modifier.height(20.dp))
                Text(
                    text = stringResource(R.string.virtue_principles),
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontFamily = Jost, letterSpacing = 3.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(Modifier.height(16.dp))
            }

            items(virtue!!.subConcepts, key = { it.id }) { concept ->
                SubConceptItem(concept = concept)
                Spacer(Modifier.height(20.dp))
            }

            if (relatedQuotes.isNotEmpty()) {
                item {
                    Spacer(Modifier.height(12.dp))
                    AtaraxyDivider()
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = stringResource(R.string.virtue_related_reflections),
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontFamily = Jost, letterSpacing = 3.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(Modifier.height(16.dp))
                }

                items(relatedQuotes, key = { "rq_${it.id}" }) { quote ->
                    RelatedQuoteCard(quote = quote, onClick = { onNavigateToPractice(quote.id) })
                }
            }

            item { Spacer(Modifier.height(24.dp)) }
        } else {
            item {
                Box(Modifier.fillMaxWidth().height(200.dp), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }
}

@Composable
private fun VirtueHeader(virtue: Virtue) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.virtue_current_exploration),
            style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost, letterSpacing = 3.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = virtue.name,
            style = MaterialTheme.typography.headlineLarge.copy(fontFamily = CormorantGaramond, fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(16.dp))
        val iconRes = when (virtue.id) {
            "WISDOM" -> R.drawable.ic_virtue_wisdom
            "COURAGE" -> R.drawable.ic_virtue_courage
            "JUSTICE" -> R.drawable.ic_virtue_justice
            "MODERATION" -> R.drawable.ic_virtue_moderation
            else -> R.drawable.ic_virtue_wisdom
        }
        androidx.compose.foundation.Image(
            painter = painterResource(iconRes),
            contentDescription = virtue.name,
            modifier = Modifier.size(56.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.quote_in_marks, virtue.definingQuote),
            style = MaterialTheme.typography.displaySmall.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.quote_attribution, virtue.definingQuoteAuthor.uppercase()),
            style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost, letterSpacing = 2.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun SubConceptItem(concept: SubConcept) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = concept.number.toString().padStart(2, '0'),
            style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.width(32.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = concept.title,
                style = MaterialTheme.typography.titleSmall.copy(fontFamily = Jost, fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = concept.description,
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun RelatedQuoteCard(quote: Quote, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        AnnotatedQuoteText(
            text = stringResource(R.string.quote_in_marks, quote.text),
            style = MaterialTheme.typography.displaySmall.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.quote_attribution, quote.authorName),
            style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
    HorizontalDivider(
        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f),
        thickness = 0.5.dp,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}
