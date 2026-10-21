package com.ataraxy.app.widget

import android.content.Context
import android.content.res.Configuration
import android.text.TextUtils
import android.view.View
import android.widget.FrameLayout
import android.widget.RemoteViews
import android.widget.TextView
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.test.core.app.ApplicationProvider
import com.ataraxy.app.MainActivity
import com.ataraxy.app.R
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.AuthorEntity
import com.ataraxy.app.data.local.entity.QuoteEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.testing.testUserPrefs
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.shadows.ShadowLog
import java.io.File
import java.nio.file.Files
import java.time.LocalDate

@RunWith(RobolectricTestRunner::class)
class QuoteWidgetRendererTest {

    private val context: Context = ApplicationProvider.getApplicationContext()
    private lateinit var db: AtaraxyDatabase
    private lateinit var styles: WidgetStyleStore
    private lateinit var renderer: QuoteWidgetRenderer

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        val dir = Files.createTempDirectory("widget").toFile()
        styles = WidgetStyleStore(
            PreferenceDataStoreFactory.create(
                scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
                produceFile = { File(dir, "widget_prefs.preferences_pb") }
            )
        )
        renderer = QuoteWidgetRenderer(
            context,
            QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao()),
            testUserPrefs(),
            styles
        )
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun showsTodaysQuoteAndAuthorInCaps() = runBlocking {
        seedQuotes()
        val expected = QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao())
            .getDailyQuote(LocalDate.now()).first()

        val root = inflate(renderer.render(APP_WIDGET_ID, HEIGHT_4X2))

        assertEquals(expected?.text, root.text(R.id.widget_quote))
        assertEquals("— MARCUS AURELIUS", root.text(R.id.widget_author))
    }

    @Test
    fun beforeSeeding_showsOpenAtaraxy() = runBlocking {
        val root = inflate(renderer.render(APP_WIDGET_ID, HEIGHT_4X2))

        assertEquals(context.getString(R.string.widget_empty), root.text(R.id.widget_quote))
        assertEquals("", root.text(R.id.widget_author))
        assertEquals(View.GONE, root.findViewById<View>(R.id.widget_author).visibility)
    }

    @Test
    fun clearStyle_usesClearLayout() = runBlocking {
        styles.set(APP_WIDGET_ID, WidgetStyle.CLEAR)

        val views = renderer.render(APP_WIDGET_ID, HEIGHT_4X2)

        assertEquals(R.layout.widget_quote_clear, views.layoutId)
    }

    @Test
    fun cardStyle_usesCardLayout() = runBlocking {
        styles.set(APP_WIDGET_ID, WidgetStyle.LIGHT)

        assertEquals(R.layout.widget_quote_card_light, renderer.render(APP_WIDGET_ID, HEIGHT_4X2).layoutId)
    }

    @Test
    fun smallHeight_limitsLinesAndEllipsizes() = runBlocking {
        seedQuotes()

        val quote = inflate(renderer.render(APP_WIDGET_ID, 60)).findViewById<TextView>(R.id.widget_quote)

        assertEquals(2, quote.maxLines)
        assertEquals(TextUtils.TruncateAt.END, quote.ellipsize)
    }

    @Test
    fun tap_opensHomeDeepLink() = runBlocking {
        val root = inflate(renderer.render(APP_WIDGET_ID, HEIGHT_4X2))

        root.findViewById<android.view.View>(R.id.widget_root).performClick()

        val started = shadowOf(context as android.app.Application).nextStartedActivity
        assertNotNull(started)
        assertEquals(MainActivity::class.java.name, started.component?.className)
        assertEquals("ataraxy://home", started.data.toString())
    }

    @Test
    fun matchAppWithSystemTheme_followsThePhonesNightMode() = runBlocking {
        seedQuotes()
        val views = renderer.render(APP_WIDGET_ID, HEIGHT_4X2)

        assertQuoteColor(R.color.widget_quote_light, views, night = false)
        assertQuoteColor(R.color.widget_quote_dark, views, night = true)
    }

    @Test
    fun accentStyle_followsThePhonesNightMode() = runBlocking {
        seedQuotes()
        styles.set(APP_WIDGET_ID, WidgetStyle.ACCENT)
        val views = renderer.render(APP_WIDGET_ID, HEIGHT_4X2)

        val day = quoteColor(views, night = false)
        val night = quoteColor(views, night = true)
        assertEquals(configContext(false).getColor(R.color.widget_quote_accent), day)
        assertEquals(configContext(true).getColor(R.color.widget_quote_accent), night)
        assertNotEquals(day, night)
    }

    @Test
    fun fixedStyles_ignoreTheNightMode() = runBlocking {
        seedQuotes()
        styles.set(APP_WIDGET_ID, WidgetStyle.LIGHT)
        val views = renderer.render(APP_WIDGET_ID, HEIGHT_4X2)

        assertQuoteColor(R.color.widget_quote_light, views, night = true)
    }

    private fun configContext(night: Boolean): Context {
        val config = Configuration(context.resources.configuration).apply {
            val mode = if (night) Configuration.UI_MODE_NIGHT_YES else Configuration.UI_MODE_NIGHT_NO
            uiMode = (uiMode and Configuration.UI_MODE_NIGHT_MASK.inv()) or mode
        }
        return context.createConfigurationContext(config)
    }

    private fun quoteColor(views: RemoteViews, night: Boolean): Int {
        val ctx = configContext(night)
        val parent = FrameLayout(ctx)
        parent.addView(views.apply(ctx, parent))
        return parent.findViewById<TextView>(R.id.widget_quote).currentTextColor
    }

    private fun assertQuoteColor(@androidx.annotation.ColorRes expected: Int, views: RemoteViews, night: Boolean) =
        assertEquals(configContext(night).getColor(expected), quoteColor(views, night))

    @Test
    fun updateEach_failureOnOneId_stillUpdatesTheOthers() = runBlocking {
        val pushed = mutableListOf<Int>()

        updateEach(
            ids = intArrayOf(1, 2, 3),
            render = { id -> if (id == 2) error("boom") else RemoteViews(context.packageName, R.layout.widget_quote_card_follow) },
            push = { id, _ -> pushed += id }
        )

        assertEquals(listOf(1, 3), pushed)
    }

    @Test
    fun updateEach_rethrowsCancellation() {
        val result = runCatching {
            runBlocking {
                updateEach(
                    ids = intArrayOf(1),
                    render = { throw CancellationException("stop") },
                    push = { _, _ -> }
                )
            }
        }

        assertTrue(result.exceptionOrNull() is CancellationException)
    }

    @Test
    fun withUpdateTimeout_slowWork_endsWithoutCrashing() = runBlocking {
        var finished = false

        withUpdateTimeout(timeoutMs = 50) {
            delay(5_000)
            finished = true
        }

        assertFalse(finished)
    }

    @Test
    fun withUpdateTimeout_slowWork_logsTheTimeout() = runBlocking {
        ShadowLog.clear()

        withUpdateTimeout(timeoutMs = 50) { delay(5_000) }

        assertTrue(ShadowLog.getLogsForTag("QuoteWidget").any { it.msg.contains("timed out") })
    }

    @Test
    fun withUpdateTimeout_fastWork_logsNothing() = runBlocking {
        ShadowLog.clear()

        withUpdateTimeout(timeoutMs = 5_000) { }

        assertTrue(ShadowLog.getLogsForTag("QuoteWidget").isEmpty())
    }

    private fun inflate(views: android.widget.RemoteViews): FrameLayout {
        val parent = FrameLayout(context)
        parent.addView(views.apply(context, parent))
        return parent
    }

    private fun FrameLayout.text(id: Int) = findViewById<TextView>(id).text.toString()

    private suspend fun seedQuotes() {
        db.authorDao().insertAuthors(listOf(AuthorEntity("marcus", "Marcus Aurelius", "", "", "")))
        db.quoteDao().insertQuotes(
            (1..366).map { day -> QuoteEntity("q$day", "Quote $day", "marcus", "Meditations", "WISDOM", day) }
        )
    }

    private companion object {
        const val APP_WIDGET_ID = 7
        const val HEIGHT_4X2 = 130
    }

    @Test
    fun updateAll_withNoWidgets_completes() = runBlocking {
        renderer.updateAll()
    }

    @Test
    fun guardedUpdate_swallowsFailures() = runBlocking {
        guardedUpdate { error("id lookup failed") }
    }

    @Test(expected = CancellationException::class)
    fun guardedUpdate_rethrowsCancellation(): Unit = runBlocking {
        guardedUpdate { throw CancellationException("cancelled") }
    }
}
