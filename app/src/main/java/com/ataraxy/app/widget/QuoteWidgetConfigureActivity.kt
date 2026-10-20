package com.ataraxy.app.widget

import android.appwidget.AppWidgetManager
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
        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish()
            return
        }
        viewModel.load(appWidgetId)

        setContent {
            val prefs by viewModel.userPrefs.collectAsState()
            AtaraxyTheme(
                appTheme = prefs?.theme ?: AppTheme.SYSTEM,
                contentTextSize = prefs?.contentTextSize ?: ContentTextSize.DEFAULT
            ) {
                WidgetSetupScreen(viewModel = viewModel, onSave = { save(appWidgetId) })
            }
        }
    }

    private fun save(appWidgetId: Int) {
        lifecycleScope.launch {
            viewModel.save(appWidgetId)
            setResult(RESULT_OK, resultIntent(appWidgetId))
            finish()
        }
    }

    private fun resultIntent(appWidgetId: Int) =
        Intent().putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
}
