package com.ataraxy.app.ui.home

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.lookback.LookBackKind
import com.ataraxy.app.ui.components.AnnotatedQuoteText
import com.ataraxy.app.ui.theme.AtaraxyText
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.orrery.orreryBackground
import com.ataraxy.app.ui.components.orrery.rememberOrreryPattern
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun HomeScreen(
    onNavigateToPractice: (String?) -> Unit,
    onNavigateToAuthor: (String) -> Unit,
    onOpenEntry: (Long) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val quote by viewModel.dailyQuote.collectAsStateWithLifecycle()
    val streak by viewModel.streakCount.collectAsStateWithLifecycle()
    val lookBack by viewModel.lookBack.collectAsStateWithLifecycle()
    val isBookmarked by (quote?.let { viewModel.isBookmarked(it.id) }
        ?: kotlinx.coroutines.flow.flowOf(false)).collectAsStateWithLifecycle(false)

    val context = LocalContext.current
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(quote) {
        if (quote != null) visible = true
    }

    LifecycleResumeEffect(viewModel) {
        viewModel.onResume()
        onPauseOrDispose {}
    }

    val shareChooserTitle = stringResource(R.string.share_quote_chooser)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .orreryBackground(rememberOrreryPattern("home"))
            .verticalScroll(rememberScrollState())
    ) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.home_wordmark),
                style = AtaraxyText.screenTitle,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = viewModel.todayDate,
                style = AtaraxyText.meta,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        AtaraxyDivider()

        Image(
            painter = painterResource(R.drawable.img_zen_sand),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Crop
        )

        AtaraxyDivider()

        Spacer(Modifier.height(24.dp))

        // Section label
        Text(
            text = stringResource(R.string.morning_contemplation),
            style = AtaraxyText.eyebrow,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(24.dp))

        // Quote card
        if (quote == null) {
            ShimmerQuoteCard()
        } else {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(tween(400)) + slideInVertically(tween(400)) { it / 4 }
            ) {
                val shareText = stringResource(R.string.home_share_text, quote!!.text, quote!!.authorName)
                QuoteCard(
                    quote = quote!!,
                    streak = streak,
                    isBookmarked = isBookmarked,
                    onReflect = { onNavigateToPractice(quote!!.id) },
                    onNavigateToAuthor = { onNavigateToAuthor(quote!!.authorId) },
                    onShare = {
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, shareText)
                        }
                        context.startActivity(Intent.createChooser(intent, shareChooserTitle))
                    },
                    onBookmark = { viewModel.toggleBookmark(quote!!.id) }
                )
            }
        }

        lookBack?.let { card ->
            Spacer(Modifier.height(32.dp))
            LookBackCardView(card, onClick = { onOpenEntry(card.entryId) })
        }

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun LookBackCardView(card: LookBackCard, onClick: () -> Unit) {
    val locked = card.excerpt == null
    val date = card.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))
    val lead = stringResource(
        when (card.kind) {
            LookBackKind.YEAR -> if (locked) R.string.home_lookback_locked_year else R.string.home_lookback_year
            LookBackKind.MONTH -> if (locked) R.string.home_lookback_locked_month else R.string.home_lookback_month
            LookBackKind.OLDER -> if (locked) R.string.home_lookback_locked_older else R.string.home_lookback_older
        },
        date
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clickable(role = Role.Button, onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 18.dp)) {
            Text(
                text = stringResource(R.string.home_lookback_eyebrow),
                style = AtaraxyText.eyebrow,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = lead,
                style = AtaraxyText.heading.copy(fontStyle = FontStyle.Italic),
                color = MaterialTheme.colorScheme.onBackground
            )
            card.prompt?.let {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = it,
                    style = AtaraxyText.secondary,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            card.excerpt?.let {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = it,
                    style = AtaraxyText.secondary,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun QuoteCard(
    quote: Quote,
    streak: Int,
    isBookmarked: Boolean,
    onReflect: () -> Unit,
    onNavigateToAuthor: () -> Unit,
    onShare: () -> Unit,
    onBookmark: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        // Streak indicator
        if (streak > 1) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(R.string.day_streak, streak),
                    style = AtaraxyText.meta,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.height(8.dp))
        }

        // Quote text
        AnnotatedQuoteText(
            text = stringResource(R.string.quote_in_marks, quote.text),
            style = AtaraxyText.quote(quote.text),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        // Attribution
        Text(
            text = stringResource(R.string.quote_attribution, quote.authorName.uppercase()),
            style = AtaraxyText.attribution,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .fillMaxWidth()
                .minimumInteractiveComponentSize()
                .clickable(role = Role.Button, onClick = onNavigateToAuthor),
            textAlign = TextAlign.Center
        )

        if (quote.source.isNotBlank()) {
            Text(
                text = quote.source.uppercase(),
                style = AtaraxyText.meta,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        // Virtue badge
        Spacer(Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(
                text = quote.virtueId.uppercase(),
                style = AtaraxyText.meta,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.surfaceVariant,
                        RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            )
        }

        Spacer(Modifier.height(32.dp))

        // Reflect button
        Button(
            onClick = onReflect,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.background
            ),
            shape = MaterialTheme.shapes.extraLarge,
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 14.dp)
        ) {
            Text(
                text = stringResource(R.string.reflect),
                style = AtaraxyText.button
            )
            Spacer(Modifier.width(8.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }

        Spacer(Modifier.height(40.dp))

        AtaraxyDivider()

        Spacer(Modifier.height(16.dp))

        // Action tray
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionIcon(Icons.Outlined.Share, stringResource(R.string.home_share), onShare)
            Spacer(Modifier.width(32.dp))
            ActionIcon(
                if (isBookmarked) Icons.Outlined.Bookmark else Icons.Outlined.BookmarkBorder,
                stringResource(R.string.bookmark),
                onBookmark
            )
        }
    }
}

@Composable
private fun ActionIcon(icon: ImageVector, label: String, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
private fun ShimmerQuoteCard() {
    val baseColor = MaterialTheme.colorScheme.surfaceVariant
    val highlightColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)

    val transition = rememberInfiniteTransition(label = "shimmer")
    val translateX by transition.animateFloat(
        initialValue = -600f,
        targetValue = 600f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmerTranslate"
    )

    val shimmerBrush = Brush.linearGradient(
        colors = listOf(baseColor, highlightColor, baseColor),
        start = Offset(translateX, 0f),
        end = Offset(translateX + 400f, 0f)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        repeat(3) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(if (it == 2) 0.6f else 1f)
                    .height(20.dp)
                    .background(shimmerBrush, RoundedCornerShape(4.dp))
            )
        }
        Spacer(Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(14.dp)
                .align(Alignment.CenterHorizontally)
                .background(shimmerBrush, RoundedCornerShape(4.dp))
        )
    }
}
