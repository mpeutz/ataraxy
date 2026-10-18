package com.ataraxy.app.ui.author

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ataraxy.app.R
import com.ataraxy.app.data.seed.AuthorDetailData
import com.ataraxy.app.domain.model.AuthorWork
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

@Composable
fun AuthorDetailScreen(
    authorId: String,
    onBack: () -> Unit
) {
    val profile = AuthorDetailData.profiles[authorId]

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Top bar
        item {
            AtaraxyTopBar(title = stringResource(R.string.author_title), onBack = onBack)
        }

        if (profile == null) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(48.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.author_empty),
                        style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }
            return@LazyColumn
        }

        // Author name + era header
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = profile.name,
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontFamily = CormorantGaramond,
                        fontWeight = FontWeight.Normal
                    ),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = profile.era,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontFamily = Jost,
                        letterSpacing = 2.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
            AtaraxyDivider()
        }

        // Biography
        item {
            Spacer(Modifier.height(28.dp))
            Text(
                text = stringResource(R.string.author_biography),
                style = MaterialTheme.typography.labelMedium.copy(
                    fontFamily = Jost,
                    letterSpacing = 3.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(Modifier.height(16.dp))
        }

        // Split bio on paragraph breaks so each paragraph is its own item for readability
        val paragraphs = profile.bio.split("\n\n")
        items(paragraphs) { paragraph ->
            Text(
                text = paragraph,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = Jost,
                    lineHeight = 26.sp
                ),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(Modifier.height(16.dp))
        }

        // Works section
        item {
            Spacer(Modifier.height(12.dp))
            AtaraxyDivider()
            Spacer(Modifier.height(28.dp))
            Text(
                text = stringResource(R.string.author_works),
                style = MaterialTheme.typography.labelMedium.copy(
                    fontFamily = Jost,
                    letterSpacing = 3.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(Modifier.height(24.dp))
        }

        items(profile.works) { work ->
            WorkBlock(work = work)
            Spacer(Modifier.height(28.dp))
        }

        item { Spacer(Modifier.height(32.dp)) }
    }
}

@Composable
private fun WorkBlock(work: AuthorWork) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            text = work.title,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontFamily = CormorantGaramond,
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = work.type,
            style = MaterialTheme.typography.labelSmall.copy(
                fontFamily = Jost,
                letterSpacing = 1.5.sp,
                fontStyle = FontStyle.Normal
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(12.dp))

        val descParagraphs = work.description.split("\n\n")
        descParagraphs.forEachIndexed { index, para ->
            Text(
                text = para,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = Jost,
                    lineHeight = 24.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            if (index < descParagraphs.lastIndex) Spacer(Modifier.height(12.dp))
        }
    }
}
