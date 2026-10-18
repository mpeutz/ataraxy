package com.ataraxy.app.ui.practices.mementomori

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ataraxy.app.R
import com.ataraxy.app.ui.components.AtaraxyDivider
import com.ataraxy.app.ui.components.AtaraxyTopBar
import com.ataraxy.app.ui.components.StatChip
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

// Warm amber accent matching the existing GlossaryTint color
private val MementoAccent = Color(0xFFA07850)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MementoMoriScreen(
    onBack: () -> Unit,
    onNavigateToInsight: () -> Unit,
    viewModel: MementoMoriViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        AtaraxyTopBar(
            title = stringResource(R.string.memento_mori_title),
            onBack = onBack,
            subtitle = stringResource(R.string.memento_mori_subtitle)
        )

        if (!state.isLoading) {
            if (state.birthYear == null || state.showBirthYearPicker) {
                BirthYearSetup(
                    input = state.birthYearInput,
                    error = when (val error = state.birthYearError) {
                        null -> null
                        BirthYearError.NotANumber -> stringResource(R.string.memento_error_not_a_year)
                        is BirthYearError.OutOfRange -> stringResource(R.string.memento_error_year_range, error.min, error.max)
                    },
                    onInputChange = viewModel::updateBirthYearInput,
                    onConfirm = viewModel::confirmBirthYear,
                    showCancel = state.showBirthYearPicker && state.birthYear != null,
                    onCancel = viewModel::hideBirthYearPicker
                )
            } else {
                WeeksGrid(
                    weeksLived = state.weeksLived,
                    totalWeeks = state.totalWeeks,
                    onWeekTapped = viewModel::onWeekTapped,
                    onChangeBirthYear = viewModel::showBirthYearPicker,
                    onNavigateToInsight = onNavigateToInsight
                )
            }
        }
    }

    // Reflection bottom sheet
    if (state.selectedWeekIndex != null) {
        val weekIndex = state.selectedWeekIndex!!
        val yearNum = weekIndex / 52 + 1
        val quote = state.reflectionQuote

        ModalBottomSheet(
            onDismissRequest = viewModel::dismissReflection,
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .padding(bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.year_label, yearNum),
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontFamily = Jost,
                        letterSpacing = 3.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(24.dp))
                if (quote != null) {
                    Text(
                        text = stringResource(R.string.quote_in_marks, quote.text),
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontFamily = CormorantGaramond,
                            fontStyle = FontStyle.Italic,
                            lineHeight = 34.sp,
                            fontSize = 22.sp
                        ),
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = stringResource(R.string.quote_attribution, quote.authorName.uppercase()),
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontFamily = Jost,
                            letterSpacing = 2.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(Modifier.height(24.dp))
                Text(
                    text = stringResource(R.string.memento_mori_prompt),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = CormorantGaramond,
                        fontStyle = FontStyle.Italic,
                        fontSize = 18.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(24.dp))
                TextButton(onClick = viewModel::dismissReflection) {
                    Text(
                        text = stringResource(R.string.close),
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontFamily = Jost,
                            letterSpacing = 2.sp
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

@Composable
private fun BirthYearSetup(
    input: String,
    error: String?,
    onInputChange: (String) -> Unit,
    onConfirm: () -> Unit,
    showCancel: Boolean,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img_zen_garden),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            text = stringResource(R.string.marcus_aurelius_quote),
            style = MaterialTheme.typography.displaySmall.copy(
                fontFamily = CormorantGaramond,
                fontStyle = FontStyle.Italic,
                lineHeight = 36.sp,
                fontSize = 22.sp
            ),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.quote_attribution, stringResource(R.string.marcus_aurelius_name)),
            style = MaterialTheme.typography.labelSmall.copy(
                fontFamily = Jost,
                letterSpacing = 2.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(40.dp))
        OutlinedTextField(
            value = input,
            onValueChange = onInputChange,
            label = {
                Text(
                    text = stringResource(R.string.birth_year_label),
                    style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            isError = error != null,
            supportingText = error?.let {
                { Text(text = it, style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost)) }
            },
            modifier = Modifier.fillMaxWidth(0.6f)
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = onConfirm,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.background
            ),
            shape = MaterialTheme.shapes.extraLarge,
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 14.dp)
        ) {
            Text(
                text = stringResource(R.string.set_birth_year),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
        if (showCancel) {
            Spacer(Modifier.height(8.dp))
            TextButton(onClick = onCancel) {
                Text(
                    text = stringResource(R.string.cancel),
                    style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        } // inner padding Column
    } // outer scroll Column
}

@Composable
private fun WeeksGrid(
    weeksLived: Int,
    totalWeeks: Int,
    onWeekTapped: (Int) -> Unit,
    onChangeBirthYear: () -> Unit,
    onNavigateToInsight: () -> Unit
) {
    val weeksRemaining = totalWeeks - weeksLived
    val percentage = (weeksLived.toFloat() / totalWeeks * 100).toInt()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        // Stats strip
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatChip(value = "$weeksLived", label = stringResource(R.string.lived))
            StatChip(value = "$weeksRemaining", label = stringResource(R.string.remaining))
            StatChip(value = "$percentage%", label = stringResource(R.string.of_life))
        }

        AtaraxyDivider()

        // Grid — Canvas-based single draw call for all 3952 cells
        val filledColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.85f)
        val currentColor = MementoAccent
        val emptyColor = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
        val density = LocalDensity.current
        val cellDp = 5.dp
        val gapDp = 1.5.dp
        val stepDp = cellDp + gapDp
        val cols = 52
        val rows = (totalWeeks + cols - 1) / cols
        val canvasWidthDp = stepDp * cols - gapDp
        val canvasHeightDp = stepDp * rows - gapDp

        val stepPx = with(density) { stepDp.toPx() }
        val cellPx = with(density) { cellDp.toPx() }

        Canvas(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 12.dp)
                .width(canvasWidthDp)
                .height(canvasHeightDp)
                .align(Alignment.CenterHorizontally)
                .pointerInput(weeksLived, stepPx) {
                    detectTapGestures { offset ->
                        val col = (offset.x / stepPx).toInt().coerceIn(0, cols - 1)
                        val row = (offset.y / stepPx).toInt()
                        val index = row * cols + col
                        if (index < weeksLived) onWeekTapped(index)
                    }
                }
        ) {
            repeat(totalWeeks) { index ->
                val col = index % cols
                val row = index / cols
                val color = when {
                    index < weeksLived -> filledColor
                    index == weeksLived -> currentColor
                    else -> emptyColor
                }
                drawRect(
                    color = color,
                    topLeft = Offset(col * stepPx, row * stepPx),
                    size = Size(cellPx, cellPx)
                )
            }
        }

        AtaraxyDivider()

        TextButton(
            onClick = onChangeBirthYear,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = stringResource(R.string.change_birth_year),
                style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        TextButton(
            onClick = onNavigateToInsight,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 12.dp)
        ) {
            Text(
                text = stringResource(R.string.memento_mori_insight_link),
                style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost, letterSpacing = 1.sp),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

