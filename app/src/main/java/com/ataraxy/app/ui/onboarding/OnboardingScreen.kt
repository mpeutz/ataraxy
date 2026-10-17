package com.ataraxy.app.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ataraxy.app.R
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost
import kotlinx.coroutines.launch

@OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(onComplete: () -> Unit) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val scope = rememberCoroutineScope()

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
                0 -> OnboardingPage1()
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
                    style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost, letterSpacing = 2.sp)
                )
                if (pagerState.currentPage < 2) {
                    Spacer(Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Outlined.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun OnboardingPage1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "ATARAXY",
            style = MaterialTheme.typography.labelLarge.copy(fontFamily = Jost, letterSpacing = 6.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.onboarding_p1_subtitle),
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic,
                lineHeight = 64.sp
            ),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.onboarding_p1_body),
            style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun OnboardingPage2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.the_four_virtues),
            style = MaterialTheme.typography.labelLarge.copy(fontFamily = Jost, letterSpacing = 4.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(24.dp))
        listOf(
            "Wisdom" to "Phronesis",
            "Courage" to "Andreia",
            "Justice" to "Dikaiosyne",
            "Moderation" to "Sophrosyne"
        ).forEach { (name, latin) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineSmall.copy(fontFamily = CormorantGaramond),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = latin,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontFamily = Jost,
                        fontStyle = FontStyle.Italic
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f), thickness = 0.5.dp)
        }
    }
}

@Composable
private fun OnboardingPage3() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.your_morning),
            style = MaterialTheme.typography.labelLarge.copy(fontFamily = Jost, letterSpacing = 4.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.onboarding_p3_subtitle),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic,
                lineHeight = 48.sp
            ),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.onboarding_p3_body),
            style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}
