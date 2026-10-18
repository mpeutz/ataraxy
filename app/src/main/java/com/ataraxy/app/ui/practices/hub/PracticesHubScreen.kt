package com.ataraxy.app.ui.practices.hub

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ataraxy.app.R
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun PracticesHubScreen(
    onNavigateToBookend: () -> Unit,
    onNavigateToDichotomy: () -> Unit,
    onNavigateToSos: () -> Unit,
    onNavigateToMementoMori: () -> Unit,
    onNavigateToJournal: () -> Unit
) {
    val todayDate = LocalDate.now()
        .format(DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy").withLocale(java.util.Locale.ENGLISH))
        .uppercase()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "PRACTICES",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 4.sp,
                    fontSize = 14.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = todayDate,
                style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        Image(
            painter = painterResource(R.drawable.img_arches),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        Spacer(Modifier.height(28.dp))

        Text(
            text = "YOUR STOIC TOOLS",
            style = MaterialTheme.typography.labelMedium.copy(
                fontFamily = Jost,
                letterSpacing = 3.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            PracticeCard(
                eyebrow = "DAILY PRACTICE",
                title = "Morning & Evening Ritual",
                description = "Praemeditatio Malorum at dawn. Seneca's review at dusk.",
                onClick = onNavigateToBookend
            )
            PracticeCard(
                eyebrow = "CLARITY",
                title = "Dichotomy of Control",
                description = "Sort your worries. Release what is not yours to carry.",
                onClick = onNavigateToDichotomy
            )
            PracticeCard(
                eyebrow = "IN CRISIS",
                title = "Find Your Footing",
                description = "Stoic wisdom for anger, anxiety, grief, and fear.",
                onClick = onNavigateToSos
            )
            PracticeCard(
                eyebrow = "PERSPECTIVE",
                title = "Memento Mori",
                description = "Your life in weeks. Remember it is finite. Act accordingly.",
                onClick = onNavigateToMementoMori
            )
        }

        Spacer(Modifier.height(32.dp))

        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 0.5.dp)

        Spacer(Modifier.height(28.dp))

        Text(
            text = "YOUR JOURNAL",
            style = MaterialTheme.typography.labelMedium.copy(
                fontFamily = Jost,
                letterSpacing = 3.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(12.dp))

        PracticeCard(
            eyebrow = "HISTORY",
            title = "All Entries",
            description = "Browse reflections, morning premeditations, and evening reviews.",
            onClick = onNavigateToJournal,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(32.dp))
    }
}

@Composable
private fun PracticeCard(
    eyebrow: String,
    title: String,
    description: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = eyebrow,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontFamily = Jost,
                        letterSpacing = 3.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontFamily = CormorantGaramond,
                        fontStyle = FontStyle.Italic,
                        fontSize = 24.sp
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall.copy(fontFamily = Jost),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.width(12.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}
