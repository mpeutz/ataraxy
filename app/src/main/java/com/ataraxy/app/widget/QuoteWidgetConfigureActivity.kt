package com.ataraxy.app.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProviderInfo
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.domain.model.ContentTextSize
import com.ataraxy.app.ui.theme.AtaraxyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteWidgetConfigureActivity : ComponentActivity() {

    private val viewModel: WidgetSetupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appWidgetId = intent?.extras?.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID
        ) ?: AppWidgetManager.INVALID_APPWIDGET_ID
        setResult(RESULT_CANCELED, resultIntent(appWidgetId))
        val info = AppWidgetManager.getInstance(this).getAppWidgetInfo(appWidgetId)
        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID || !isOurWidget(info, QuoteWidgetProvider::class.java)) {
            finish()
            return
        }
        viewModel.load(appWidgetId)
        lifecycleScope.launch {
            viewModel.saved.first { it }
            setResult(RESULT_OK, resultIntent(appWidgetId))
            finish()
        }

        setContent {
            val prefs by viewModel.userPrefs.collectAsState()
            AtaraxyTheme(
                appTheme = prefs?.theme ?: AppTheme.SYSTEM,
                contentTextSize = prefs?.contentTextSize ?: ContentTextSize.DEFAULT
            ) {
                WidgetSetupScreen(viewModel = viewModel, onSave = { viewModel.save(appWidgetId) })
            }
        }
    }

    private fun resultIntent(appWidgetId: Int) =
        Intent().putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
}

/** The configure activity is exported, so only widgets of our own provider may be configured through it. */
internal fun isOurWidget(info: AppWidgetProviderInfo?, providerClass: Class<*>): Boolean =
    info?.provider?.className == providerClass.name
