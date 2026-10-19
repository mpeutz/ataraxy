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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ataraxy.app.R
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun PracticesHubScreen(
    onNavigateToBookend: () -> Unit,
    onNavigateToWhatsYours: () -> Unit,
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
                text = stringResource(R.string.practices_title),
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

        AtaraxyDivider()

        Image(
            painter = painterResource(R.drawable.img_arches),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        AtaraxyDivider()

        Spacer(Modifier.height(28.dp))

        Text(
            text = stringResource(R.string.practices_tools_header),
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
                eyebrow = stringResource(R.string.practices_bookend_eyebrow),
                title = stringResource(R.string.practices_bookend_title),
                description = stringResource(R.string.practices_bookend_description),
                onClick = onNavigateToBookend
            )
            PracticeCard(
                eyebrow = stringResource(R.string.practices_whats_yours_eyebrow),
                title = stringResource(R.string.practices_whats_yours_title),
                description = stringResource(R.string.practices_whats_yours_description),
                onClick = onNavigateToWhatsYours
            )
            PracticeCard(
                eyebrow = stringResource(R.string.practices_sos_eyebrow),
                title = stringResource(R.string.practices_sos_title),
                description = stringResource(R.string.practices_sos_description),
                onClick = onNavigateToSos
            )
            PracticeCard(
                eyebrow = stringResource(R.string.practices_memento_eyebrow),
                title = stringResource(R.string.practices_memento_title),
                description = stringResource(R.string.practices_memento_description),
                onClick = onNavigateToMementoMori
            )
        }

        Spacer(Modifier.height(32.dp))

        AtaraxyDivider()

        Spacer(Modifier.height(28.dp))

        Text(
            text = stringResource(R.string.practices_journal_header),
            style = MaterialTheme.typography.labelMedium.copy(
                fontFamily = Jost,
                letterSpacing = 3.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(12.dp))

        PracticeCard(
            eyebrow = stringResource(R.string.practices_journal_eyebrow),
            title = stringResource(R.string.practices_journal_title),
            description = stringResource(R.string.practices_journal_description),
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
