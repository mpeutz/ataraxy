package com.ataraxy.app.ui.home

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.lock.AppLock
import com.ataraxy.app.lock.FakeDeviceAuthenticator
import com.ataraxy.app.lock.FakeElapsedRealtime
import com.ataraxy.app.lookback.LookBackKind
import com.ataraxy.app.testing.awaitMain
import com.ataraxy.app.testing.settleMain
import com.ataraxy.app.testing.testUserPrefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File
import java.nio.file.Files
import java.time.Clock
import java.time.LocalDate
import java.time.ZoneId

@RunWith(RobolectricTestRunner::class)
class HomeViewModelTest {

    private val today = LocalDate.of(2026, 10, 20)
    private val clock = Clock.fixed(today.atTime(9, 0).atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault())
    private lateinit var db: AtaraxyDatabase
    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    @Before
    fun setUp() {
        db = inMemoryDatabase()
    }

    @After
    fun tearDown() {
        scope.cancel()
        db.close()
    }

    @Test
    fun noOldEntries_noCard() {
        insert("2026-10-10T08:00:00", "Recent", "Too new")
        val vm = viewModel()
        collect(vm)

        settleMain()

        assertNull(vm.lookBack.value)
    }

    @Test
    fun yearAgoEntry_showsYearCardWithExcerpt() {
        val id = insert("2025-10-20T08:00:00", "What weighs on you?", "Work was heavy")
        val vm = viewModel()
        collect(vm)

        awaitMain { vm.lookBack.value != null }

        val card = vm.lookBack.value!!
        assertEquals(LookBackKind.YEAR, card.kind)
        assertEquals(LocalDate.of(2025, 10, 20), card.date)
        assertEquals("What weighs on you?", card.prompt)
        assertEquals("Work was heavy", card.excerpt)
        assertEquals(id, card.entryId)
    }

    @Test
    fun lockOn_hidesPromptAndExcerpt_evenWhenUnlocked() {
        val id = insert("2025-10-20T08:00:00", "What weighs on you?", "Work was heavy")
        val lock = appLock().also { runBlocking { it.setEnabled(true) } }
        val vm = viewModel(lock)
        collect(vm)

        awaitMain { vm.lookBack.value != null }

        val card = vm.lookBack.value!!
        assertTrue(lock.isUnlocked.value)
        assertNull(card.prompt)
        assertNull(card.excerpt)
        assertEquals(id, card.entryId)
    }

    @Test
    fun pickedEntryDeleted_cardUpdates() {
        insert("2025-10-20T08:00:00", "Year prompt", "Year text")
        insert("2026-09-20T08:00:00", "Month prompt", "Month text")
        val vm = viewModel()
        collect(vm)
        awaitMain { vm.lookBack.value?.kind == LookBackKind.YEAR }

        runBlocking { db.journalDao().deleteAll() }
        insert("2026-09-20T08:00:00", "Month prompt", "Month text")

        awaitMain { vm.lookBack.value?.kind == LookBackKind.MONTH }
        assertEquals("Month text", vm.lookBack.value!!.excerpt)
        runBlocking { db.journalDao().deleteAll() }
        awaitMain { vm.lookBack.value == null }
    }

    @Test
    fun onResume_nextDay_repicks() {
        insert("2025-10-21T08:00:00", "Year prompt", "Year text")
        insert("2025-10-01T08:00:00", "Old prompt", "Old text")
        val vm = viewModel()
        collect(vm)
        awaitMain { vm.lookBack.value?.kind == LookBackKind.OLDER }

        vm.onResume(today.plusDays(1))

        awaitMain { vm.lookBack.value?.kind == LookBackKind.YEAR }
        assertEquals("Year text", vm.lookBack.value!!.excerpt)
    }

    private fun collect(vm: HomeViewModel) {
        scope.launch { vm.lookBack.collect {} }
    }

    private fun appLock(): AppLock {
        val dir = Files.createTempDirectory("prefs").toFile()
        val store = PreferenceDataStoreFactory.create(
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { File(dir, "lock_prefs.preferences_pb") }
        )
        return AppLock(store, FakeDeviceAuthenticator(), FakeElapsedRealtime())
    }

    private fun viewModel(lock: AppLock = appLock()) = HomeViewModel(
        QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao()),
        testUserPrefs(),
        JournalRepository(db.journalDao()),
        lock,
        clock
    )

    private fun insert(createdAt: String, prompt: String, content: String): Long = runBlocking {
        db.journalDao().upsert(JournalEntryEntity(0, createdAt, createdAt, content, prompt, null, null))
    }
}
