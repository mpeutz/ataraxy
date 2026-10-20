package com.ataraxy.app.ui.onboarding

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.ui.settings.BackupEvent
import com.ataraxy.app.ui.settings.BackupViewModel
import com.ataraxy.app.ui.settings.KeepUpdatingDialog
import com.ataraxy.app.ui.settings.RESTORE_MIME_TYPES
import com.ataraxy.app.ui.settings.RestoreConfirmDialog
import com.ataraxy.app.ui.theme.AtaraxyText
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    onComplete: () -> Unit,
    backupViewModel: BackupViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val pendingRestore by backupViewModel.pendingRestore.collectAsStateWithLifecycle()
    val keepUpdatingUri by backupViewModel.offerKeepUpdating.collectAsStateWithLifecycle()
    val resources = LocalResources.current
    val currentOnComplete by rememberUpdatedState(onComplete)
    var restored by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(backupViewModel) {
        backupViewModel.events.collect { event ->
            when (event) {
                BackupEvent.Restored -> restored = true
                is BackupEvent.Failed -> snackbarHostState.showSnackbar(resources.getString(event.message))
                BackupEvent.Saved -> Unit
            }
        }
    }

    // The keep-updating offer is set before Restored is sent, so null here means there is nothing to answer.
    LaunchedEffect(restored) {
        if (!restored) return@LaunchedEffect
        backupViewModel.offerKeepUpdating.first { it == null }
        currentOnComplete()
    }

    val restoreLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri -> uri?.let { backupViewModel.previewRestore(it.toString()) } }

    pendingRestore?.let { pending ->
        RestoreConfirmDialog(
            pending = pending,
            onConfirm = { backupViewModel.confirmRestore() },
            onDismiss = { backupViewModel.cancelRestore() }
        )
    }

    keepUpdatingUri?.let { uri ->
        KeepUpdatingDialog(
            onKeep = { backupViewModel.keepUpdating(uri) },
            onDismiss = { backupViewModel.dismissKeepUpdating() }
        )
    }

    Box(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                when (page) {
                    0 -> OnboardingPage1(onRestore = { restoreLauncher.launch(RESTORE_MIME_TYPES) })
                    1 -> OnboardingPage2()
                    2 -> OnboardingPage3()
                }
            }

            // Dot indicator + button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    repeat(3) { idx ->
                        Box(
                            modifier = Modifier
                                .size(if (pagerState.currentPage == idx) 8.dp else 5.dp)
                                .background(
                                    if (pagerState.currentPage == idx)
                                        MaterialTheme.colorScheme.onBackground
                                    else MaterialTheme.colorScheme.outlineVariant,
                                    androidx.compose.foundation.shape.CircleShape
                                )
                        )
                    }
                }

                Button(
                    onClick = {
                        if (pagerState.currentPage < 2) {
                            scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                        } else {
                            onComplete()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onBackground,
                        contentColor = MaterialTheme.colorScheme.background
                    ),
                    shape = MaterialTheme.shapes.extraLarge,
                    contentPadding = PaddingValues(horizontal = 28.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = if (pagerState.currentPage < 2) stringResource(R.string.next) else stringResource(R.string.begin),
                        style = AtaraxyText.button
                    )
                    if (pagerState.currentPage < 2) {
                        Spacer(Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }
        }
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun OnboardingPage1(onRestore: () -> Unit) {
    OnboardingPage {
        Text(
            text = stringResource(R.string.onboarding_wordmark),
            style = AtaraxyText.screenTitle,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.onboarding_p1_subtitle),
            style = AtaraxyText.display.copy(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.onboarding_p1_body),
            style = AtaraxyText.body,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(16.dp))
        TextButton(onClick = onRestore) {
            Text(
                text = stringResource(R.string.onboarding_restore),
                style = AtaraxyText.secondary,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun OnboardingPage2() {
    OnboardingPage {
        Text(
            text = stringResource(R.string.the_four_virtues),
            style = AtaraxyText.eyebrow,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(24.dp))
        listOf(
            R.string.onboarding_virtue_wisdom to R.string.onboarding_virtue_wisdom_greek,
            R.string.onboarding_virtue_courage to R.string.onboarding_virtue_courage_greek,
            R.string.onboarding_virtue_justice to R.string.onboarding_virtue_justice_greek,
            R.string.onboarding_virtue_moderation to R.string.onboarding_virtue_moderation_greek
        ).forEach { (nameRes, latinRes) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(nameRes),
                    style = AtaraxyText.heading,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = stringResource(latinRes),
                    style = AtaraxyText.reading.copy(fontStyle = FontStyle.Italic),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f), thickness = 0.5.dp)
        }
    }
}

@Composable
private fun OnboardingPage3() {
    OnboardingPage {
        Text(
            text = stringResource(R.string.your_morning),
            style = AtaraxyText.eyebrow,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.onboarding_p3_subtitle),
            style = AtaraxyText.display.copy(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.onboarding_p3_body),
            style = AtaraxyText.body,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}

/** Centers a page's content vertically, scrolling instead of clipping when it is taller than the screen. */
@Composable
private fun OnboardingPage(content: @Composable ColumnScope.() -> Unit) {
    BoxWithConstraints(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .heightIn(min = maxHeight)
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = content
        )
    }
}
