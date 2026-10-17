package com.ataraxy.app

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.notifications.NotificationScheduler
import com.ataraxy.app.notifications.SeedWorker
import com.ataraxy.app.ui.theme.AtaraxyTheme
import com.ataraxy.app.ui.navigation.AtaraxyNavHost
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.compose.runtime.Composable
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.domain.model.UserPrefs
import com.ataraxy.app.domain.model.ContentTextSize

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var userPrefsRepository: UserPrefsRepository
    @Inject lateinit var notificationScheduler: NotificationScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Kick off one-time DB seeding
        SeedWorker.enqueue(this)

        setContent {
            val prefs by userPrefsRepository.userPrefs.collectAsState(initial = null)
            val theme = prefs?.theme ?: AppTheme.SYSTEM
            val contentTextSize = prefs?.contentTextSize ?: ContentTextSize.DEFAULT

            AtaraxyTheme(appTheme = theme, contentTextSize = contentTextSize) {
                NotificationPermissionEffect(notificationScheduler, prefs)
                AtaraxyNavHost()
            }
        }
    }

    // Forward new intents (e.g. notification deep links while app is running)
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun NotificationPermissionEffect(scheduler: NotificationScheduler, prefs: UserPrefs?) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val permState = rememberPermissionState(android.Manifest.permission.POST_NOTIFICATIONS) { granted ->
            if (granted) prefs?.let { scheduler.scheduleAll(it) } ?: scheduler.scheduleDefault()
        }
        androidx.compose.runtime.LaunchedEffect(prefs) {
            if (prefs == null) return@LaunchedEffect
            if (!permState.status.isGranted) {
                permState.launchPermissionRequest()
            } else {
                scheduler.scheduleAll(prefs)
            }
        }
    } else {
        androidx.compose.runtime.LaunchedEffect(prefs) {
            if (prefs != null) scheduler.scheduleAll(prefs)
        }
    }
}
