package com.ataraxy.app.notifications

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import androidx.work.testing.SynchronousExecutor
import androidx.work.testing.TestListenableWorkerBuilder
import androidx.work.testing.WorkManagerTestInitHelper
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.seed.DatabaseSeeder
import com.ataraxy.app.data.seed.QuoteData
import com.ataraxy.app.widget.WidgetRefreshScheduler
import com.ataraxy.app.widget.WidgetUpdater
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SeedWorkerTest {

    private val context: Context = ApplicationProvider.getApplicationContext()
    private lateinit var db: AtaraxyDatabase
    private lateinit var scheduler: WidgetRefreshScheduler
    private var quotesWhenWidgetsUpdated: Int? = null

    @Before
    fun setUp() {
        WorkManagerTestInitHelper.initializeTestWorkManager(
            context,
            Configuration.Builder().setExecutor(SynchronousExecutor()).build()
        )
        db = inMemoryDatabase()
        scheduler = WidgetRefreshScheduler(context) { true }
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun seeded_updatesWidgetsThenEnsuresTheMidnightChain() {
        val result = runBlocking { worker().doWork() }

        assertEquals(ListenableWorker.Result.success(), result)
        assertEquals(QuoteData.quotes.size, quotesWhenWidgetsUpdated)
        assertEquals(1, pendingWidgetWork().size)
    }

    @Test
    fun failedSeed_retriesWithoutTouchingWidgets() {
        db.close()

        val result = runBlocking { worker().doWork() }

        assertEquals(ListenableWorker.Result.retry(), result)
        assertNull(quotesWhenWidgetsUpdated)
        assertTrue(pendingWidgetWork().isEmpty())
    }

    private fun worker(): SeedWorker {
        val updater = WidgetUpdater { quotesWhenWidgetsUpdated = db.quoteDao().count() }
        val factory = object : WorkerFactory() {
            override fun createWorker(
                appContext: Context,
                workerClassName: String,
                workerParameters: WorkerParameters
            ): ListenableWorker = SeedWorker(appContext, workerParameters, DatabaseSeeder(db), updater, scheduler)
        }
        return TestListenableWorkerBuilder<SeedWorker>(context).setWorkerFactory(factory).build()
    }

    private fun pendingWidgetWork() =
        WorkManager.getInstance(context).getWorkInfosForUniqueWork("quote_widget_midnight").get()
            .filter { it.state == WorkInfo.State.ENQUEUED }
}
