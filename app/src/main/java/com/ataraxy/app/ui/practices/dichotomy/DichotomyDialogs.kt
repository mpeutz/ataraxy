package com.ataraxy.app.ui.practices.dichotomy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.Quote
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

@Composable
internal fun EditItemDialog(
    text: String,
    onTextChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onSave: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = stringResource(R.string.edit_item),
                style = MaterialTheme.typography.titleMedium.copy(fontFamily = Jost)
            )
        },
        text = {
            OutlinedTextField(
                value = text,
                onValueChange = onTextChange,
                singleLine = false,
                minLines = 2,
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost)
            )
        },
        confirmButton = {
            TextButton(onClick = onSave, enabled = text.trim().isNotEmpty()) {
                Text(
                    text = stringResource(R.string.save),
                    style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost)
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = stringResource(R.string.cancel),
                    style = MaterialTheme.typography.labelMedium.copy(fontFamily = Jost)
                )
            }
        }
    )
}

@Composable
internal fun ActionStepCard(
    text: String,
    onTextChange: (String) -> Unit,
    onSave: () -> Unit,
    onDismiss: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.action_step_prompt),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = CormorantGaramond,
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(12.dp))
            BasicTextField(
                value = text,
                onValueChange = onTextChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = Jost,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                decorationBox = { innerTextField ->
                    Column {
                        Box {
                            if (text.isEmpty()) {
                                Text(
                                    text = stringResource(R.string.action_step_hint),
                                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = Jost),
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                                )
                            }
                            innerTextField()
                        }
                        Spacer(Modifier.height(8.dp))
                        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)
                    }
                }
            )
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = onDismiss) {
                    Text(
                        text = stringResource(R.string.skip),
                        style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = onSave,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onBackground,
                        contentColor = MaterialTheme.colorScheme.background
                    ),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.save),
                        style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost)
                    )
                }
            }
        }
    }
}

@Composable
internal fun ReleaseOverlay(quote: Quote, onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            // Swallows touches and scrolls so the list underneath stays inert.
            .pointerInput(Unit) {}
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.97f))
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.released_overlay_title),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Jost,
                    letterSpacing = 3.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.released_overlay_subtitle),
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = Jost),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(40.dp))
            Text(
                text = stringResource(R.string.quote_in_marks, quote.text),
                style = MaterialTheme.typography.displayMedium.copy(
                    fontFamily = CormorantGaramond,
                    fontStyle = FontStyle.Italic,
                    lineHeight = 44.sp
                ),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.quote_attribution, quote.authorName.uppercase()),
                style = MaterialTheme.typography.labelMedium.copy(
                    fontFamily = Jost,
                    letterSpacing = 2.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(48.dp))
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    contentColor = MaterialTheme.colorScheme.background
                ),
                shape = MaterialTheme.shapes.extraLarge,
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 14.dp)
            ) {
                Text(
                    text = stringResource(R.string.continue_label),
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontFamily = Jost,
                        letterSpacing = 2.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }
}
