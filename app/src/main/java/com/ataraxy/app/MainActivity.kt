package com.ataraxy.app

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.notifications.NotificationScheduler
import com.ataraxy.app.notifications.SeedWorker
import com.ataraxy.app.ui.theme.AtaraxyTheme
import com.ataraxy.app.ui.navigation.AtaraxyNavHost
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
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

        // Notification launches always carry NEW_TASK. Without CLEAR_TASK, Navigation would finish
        // and relaunch this freshly created activity to rebuild the task, so mark it as a clean start.
        if (savedInstanceState == null && intent?.data != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

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
}

/**
 * Once onboarding is done: asks for notification permission (API 33+) and makes sure reminders are
 * scheduled. Keyed on onboarding only, so later preference changes never re-prompt or reschedule.
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun NotificationPermissionEffect(scheduler: NotificationScheduler, prefs: UserPrefs?) {
    val currentPrefs by rememberUpdatedState(prefs)
    val onboardingComplete = prefs?.onboardingComplete == true

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val scope = rememberCoroutineScope()
        val permState = rememberPermissionState(android.Manifest.permission.POST_NOTIFICATIONS) { granted ->
            val latest = currentPrefs
            if (granted && latest != null) scope.launch { scheduler.ensureScheduled(latest) }
        }
        LaunchedEffect(onboardingComplete) {
            val latest = currentPrefs
            if (!onboardingComplete || latest == null) return@LaunchedEffect
            if (permState.status.isGranted) scheduler.ensureScheduled(latest)
            else permState.launchPermissionRequest()
        }
    } else {
        LaunchedEffect(onboardingComplete) {
            val latest = currentPrefs
            if (onboardingComplete && latest != null) scheduler.ensureScheduled(latest)
        }
    }
}
