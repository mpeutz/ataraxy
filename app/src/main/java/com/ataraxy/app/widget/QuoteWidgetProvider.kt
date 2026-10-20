package com.ataraxy.app.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuoteWidgetProvider : AppWidgetProvider() {

    @Inject lateinit var renderer: QuoteWidgetRenderer
    @Inject lateinit var styles: WidgetStyleStore
    @Inject lateinit var scheduler: WidgetRefreshScheduler

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        launchBounded { renderEach(appWidgetManager, appWidgetIds) }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
        newOptions: Bundle
    ) {
        launchBounded { renderEach(appWidgetManager, intArrayOf(appWidgetId)) }
    }

    override fun onEnabled(context: Context) {
        scheduler.scheduleNext()
    }

    override fun onDisabled(context: Context) {
        scheduler.cancel()
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        launchBounded { styles.remove(appWidgetIds) }
    }

    private suspend fun renderEach(manager: AppWidgetManager, ids: IntArray) {
        updateEach(
            ids = ids,
            render = { id -> renderer.render(id, heightOf(manager, id)) },
            push = manager::updateAppWidget
        )
    }
}
