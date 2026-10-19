package com.ataraxy.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ataraxy.app.ui.theme.AtaraxyText

/** A large serif number over a small tracked label, e.g. "12 / RELEASED". */
@Composable
fun StatChip(
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = AtaraxyText.figure,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = label.uppercase(),
            style = AtaraxyText.meta,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
