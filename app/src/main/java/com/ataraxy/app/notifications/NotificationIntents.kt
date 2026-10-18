package com.ataraxy.app.notifications

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.ataraxy.app.MainActivity

/**
 * Opens [uri] in the app. If the app is already running, the existing activity receives it via
 * onNewIntent instead of its screens being cleared, so in-progress work is kept. The VIEW action
 * keeps the intent matching MainActivity's filters under Android 16's stricter intent resolution.
 */
internal fun openAppIntent(context: Context, uri: Uri): Intent =
    Intent(Intent.ACTION_VIEW, uri, context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
    }
