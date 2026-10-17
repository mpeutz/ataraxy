package com.ataraxy.app.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ataraxy.app.R
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

@Composable
fun AboutScreen(onBack: () -> Unit) {
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
            IconButton(onClick = onBack) {
                Icon(
                    Icons.Outlined.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                text = stringResource(R.string.about),
                style = MaterialTheme.typography.labelMedium.copy(
                    fontFamily = Jost,
                    letterSpacing = 3.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.weight(1f))
            Spacer(Modifier.size(48.dp))
        }
        Divider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        // Scrollable content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(Modifier.height(32.dp))

            // Disclaimer section
            AboutSection(
                title = stringResource(R.string.disclaimer_title),
                content = stringResource(R.string.disclaimer_content)
            )

            // About section
            AboutSection(
                title = stringResource(R.string.about_ataraxy_title),
                content = stringResource(R.string.about_ataraxy_content)
            )

            // Quotes attribution
            AboutSection(
                title = stringResource(R.string.quote_sources_title),
                content = listOf(
                    "Marcus Aurelius - Meditations",
                    "Epictetus - Enchiridion & Discourses",
                    "Seneca - Letters from a Stoic & Essays",
                    "Zeno of Citium - Stoic Fragments",
                    "Cleanthes - Stoic Philosophy"
                )
            )

            // Image attributions
            AboutSection(
                title = stringResource(R.string.image_attributions_title),
                content = listOf(
                    "Kari Shea (Unsplash) - Onboarding imagery",
                    "Ray Wyman Jr. (Unsplash) - Virtue visuals",
                    "Michael Vinel (Unsplash) - Practice imagery",
                    "John Salzarulo (Unsplash) - Background elements",
                    "Robin Schreiner (Unsplash) - Reflection visuals",
                    "Zhen Yao (Unsplash) - Mindfulness imagery",
                    "Magic Bowls (Unsplash) - Meditation visuals"
                )
            )

            // Philosophy statement
            AboutSection(
                title = stringResource(R.string.philosophy_title),
                content = stringResource(R.string.philosophy_content)
            )

            // AI content disclosure
            AboutSection(
                title = stringResource(R.string.ai_content_title),
                content = stringResource(R.string.ai_content_content)
            )

            Spacer(Modifier.height(48.dp))
        }
    }
}

@Composable
private fun AboutSection(
    title: String,
    content: String
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium.copy(
                fontFamily = Jost,
                letterSpacing = 3.sp,
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Text(
            text = content,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontFamily = Jost,
                lineHeight = 24.sp
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(28.dp))
    }
}

@Composable
private fun AboutSection(
    title: String,
    content: List<String>
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium.copy(
                fontFamily = Jost,
                letterSpacing = 3.sp,
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Column {
            content.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "·",
                        style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(end = 12.dp, top = 2.dp)
                    )
                    Text(
                        text = item,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontFamily = Jost,
                            lineHeight = 22.sp
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
        Spacer(Modifier.height(28.dp))
    }
}
