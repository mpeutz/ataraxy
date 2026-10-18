package com.ataraxy.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.ataraxy.app.ui.theme.CormorantGaramond
import com.ataraxy.app.ui.theme.Jost

/** A large serif number over a small tracked label, e.g. "12 / RELEASED". */
@Composable
fun StatChip(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    valueSize: TextUnit = 20.sp
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = CormorantGaramond,
                fontWeight = FontWeight.Medium,
                fontSize = valueSize
            ),
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = label.uppercase(),
            style = MaterialTheme.typography.labelSmall.copy(fontFamily = Jost, letterSpacing = 2.sp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
