package com.ataraxy.app.lock

import android.app.KeyguardManager
import android.content.Context
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_WEAK
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.resume

class BiometricDeviceAuthenticator @Inject constructor(
    @ApplicationContext private val context: Context
) : DeviceAuthenticator {

    override fun isDeviceSecure(): Boolean =
        context.getSystemService(KeyguardManager::class.java)?.isDeviceSecure == true

    override suspend fun authenticate(activity: FragmentActivity, title: String): Boolean =
        withContext(Dispatchers.Main.immediate) {
            if (!activity.canHostPrompt()) return@withContext false
            suspendCancellableCoroutine { continuation ->
                val callback = object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        if (continuation.isActive) continuation.resume(true)
                    }

                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        if (continuation.isActive) continuation.resume(false)
                    }
                }
                val prompt = BiometricPrompt(activity, ContextCompat.getMainExecutor(activity), callback)
                // No negative button: DEVICE_CREDENTIAL supplies its own and forbids setting one.
                val info = BiometricPrompt.PromptInfo.Builder()
                    .setTitle(title)
                    .setAllowedAuthenticators(BIOMETRIC_WEAK or DEVICE_CREDENTIAL)
                    .build()
                continuation.invokeOnCancellation { activity.runOnUiThread { prompt.cancelAuthentication() } }
                prompt.authenticate(info)
            }
        }
}

private fun FragmentActivity.canHostPrompt(): Boolean =
    !isFinishing && !isDestroyed && lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)
