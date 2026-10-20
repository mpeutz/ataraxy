package com.ataraxy.app.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class QuoteWidgetProvider : AppWidgetProvider() {

    @Inject lateinit var renderer: QuoteWidgetRenderer

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val pending = goAsync()
        CoroutineScope(SupervisorJob() + Dispatchers.Default).launch {
            try {
                appWidgetIds.forEach { id ->
                    appWidgetManager.updateAppWidget(id, renderer.render(id, heightOf(appWidgetManager, id)))
                }
            } finally {
                pending.finish()
            }
        }
    }
}
