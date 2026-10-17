package com.ataraxy.wear.ui.quote

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import com.ataraxy.wear.R
import com.ataraxy.wear.ui.WearViewModel
import com.google.android.gms.wearable.Wearable
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@Composable
fun QuoteScreen(
    viewModel: WearViewModel = hiltViewModel()
) {
    val quote by viewModel.quote.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var bookmarked by remember { mutableStateOf(false) }
    val listState = rememberScalingLazyListState()

    ScalingLazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = listState,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        item {
            Text(
                text = stringResource(R.string.quote_screen_label),
                style = MaterialTheme.typography.labelSmall.copy(
                    letterSpacing = 2.sp,
                    color = MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        if (quote == null) {
            item {
                Text(
                    text = stringResource(R.string.no_quote_yet),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        } else {
            item {
                Text(
                    text = "\u201c${quote!!.text}\u201d",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontStyle = FontStyle.Italic,
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                )
            }

            item {
                Text(
                    text = "\u2014 ${quote!!.authorName.uppercase()}",
                    style = MaterialTheme.typography.labelSmall.copy(
                        letterSpacing = 1.sp,
                        color = MaterialTheme.colorScheme.secondary
                    ),
                    textAlign = TextAlign.Center
                )
            }

            item {
                Button(
                    onClick = {
                        bookmarked = true
                        scope.launch { sendMessage(context, "/bookmark", quote!!.id) }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                ) {
                    Text(
                        text = if (bookmarked)
                            stringResource(R.string.bookmarked_confirm)
                        else
                            stringResource(R.string.bookmark_action)
                    )
                }
            }

            item {
                Button(
                    onClick = {
                        scope.launch { sendMessage(context, "/open-app", "") }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(stringResource(R.string.open_on_phone_action))
                }
            }
        }
    }
}

private suspend fun sendMessage(context: Context, path: String, payload: String) {
    try {
        val nodes = Wearable.getNodeClient(context).connectedNodes.await()
        nodes.forEach { node ->
            Wearable.getMessageClient(context)
                .sendMessage(node.id, path, payload.toByteArray())
                .await()
        }
    } catch (_: Exception) {
        // Phone not connected - message dropped silently
    }
}
