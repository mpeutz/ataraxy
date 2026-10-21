package com.ataraxy.app

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.ataraxy.app.lock.AppLock
import com.ataraxy.app.lock.LockLifecycleObserver
import androidx.lifecycle.lifecycleScope
import com.ataraxy.app.data.backup.AutomaticBackupController
import com.ataraxy.app.data.preferences.UserPrefsRepository
import com.ataraxy.app.notifications.NotificationScheduler
import com.ataraxy.app.notifications.SeedWorker
import com.ataraxy.app.ui.theme.AtaraxyTheme
import com.ataraxy.app.ui.navigation.AtaraxyNavHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.Composable
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.domain.model.UserPrefs
import com.ataraxy.app.domain.model.ContentTextSize

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    @Inject lateinit var userPrefsRepository: UserPrefsRepository
    @Inject lateinit var notificationScheduler: NotificationScheduler
    @Inject lateinit var automaticBackupController: AutomaticBackupController
    @Inject lateinit var appLock: AppLock

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycle.addObserver(LockLifecycleObserver(appLock) { isChangingConfigurations })

        // Notification launches always carry NEW_TASK. Without CLEAR_TASK, Navigation would finish
        // and relaunch this freshly created activity to rebuild the task, so mark it as a clean start.
        if (savedInstanceState == null && intent?.data != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

        // Kick off one-time DB seeding
        SeedWorker.enqueue(this)
        lifecycleScope.launch { automaticBackupController.ensureScheduled() }

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
@Composable
private fun NotificationPermissionEffect(scheduler: NotificationScheduler, prefs: UserPrefs?) {
    val currentPrefs by rememberUpdatedState(prefs)
    val onboardingComplete = prefs?.onboardingComplete == true

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val context = LocalContext.current
        val scope = rememberCoroutineScope()
        val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            val latest = currentPrefs
            if (granted && latest != null) scope.launch { scheduler.ensureScheduled(latest) }
        }
        LaunchedEffect(onboardingComplete) {
            val latest = currentPrefs
            if (!onboardingComplete || latest == null) return@LaunchedEffect
            val permission = Manifest.permission.POST_NOTIFICATIONS
            val granted = ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
            if (granted) scheduler.ensureScheduled(latest) else launcher.launch(permission)
        }
    } else {
        LaunchedEffect(onboardingComplete) {
            val latest = currentPrefs
            if (onboardingComplete && latest != null) scheduler.ensureScheduled(latest)
        }
    }
}
