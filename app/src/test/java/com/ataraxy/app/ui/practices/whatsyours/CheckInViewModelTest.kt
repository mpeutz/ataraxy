package com.ataraxy.app.ui.practices.whatsyours

import androidx.lifecycle.SavedStateHandle
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.testing.awaitMain
import com.ataraxy.app.testing.settleMain
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.Clock
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset

@RunWith(RobolectricTestRunner::class)
class CheckInViewModelTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var repository: ReflectionRepository
    private val created = LocalDateTime.of(2026, 10, 1, 9, 0)
    private val now = created.plusDays(14)
    private val clock = Clock.fixed(now.toInstant(ZoneOffset.UTC), ZoneId.of("UTC"))
    private var dueId = 0L
    private var freshId = 0L

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        repository = ReflectionRepository(db.reflectionDao())
        runBlocking {
            dueId = repository.create("Interview", created)
            repository.complete(dueId, created.plusMinutes(10))
            freshId = repository.create("Money", now.minusDays(1))
            repository.complete(freshId, now.minusDays(1).plusMinutes(10))
        }
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun dueReflection_isMarkedInTheList() {
        val vm = WhatsYoursViewModel(SavedStateHandle(), repository, clock)
        awaitMain { vm.uiState.value.open.size == 2 }

        assertEquals(setOf(dueId), vm.uiState.value.dueIds)
    }

    @Test
    fun detail_showsCheckInWhenDue() {
        assertTrue(detail(dueId).uiState.value.checkInDue)
        assertFalse(detail(freshId).uiState.value.checkInDue)
    }

    @Test
    fun stillCarrying_addsNote_andHidesCheckInForTwoWeeks() {
        val vm = detail(dueId)

        vm.stillCarrying("Still carrying this.")
        awaitMain { vm.uiState.value.reflection?.notes?.isNotEmpty() == true && !vm.uiState.value.checkInDue }

        val note = vm.uiState.value.reflection!!.notes.single()
        assertEquals("Still carrying this.", note.text)
        assertEquals(now, note.createdAt)
        assertFalse(vm.uiState.value.checkInDue)
    }

    @Test
    fun refresh_picksUpTheTwoWeekMarkWhileOpen() {
        val clockRef = MutableClock(now.minusDays(1))
        val vm = detail(dueId, clockRef)
        assertFalse(vm.uiState.value.checkInDue)

        clockRef.at = now
        vm.refresh()

        assertTrue(vm.uiState.value.checkInDue)
    }

    @Test
    fun stillCarrying_twiceInARow_addsOneNote() {
        val vm = detail(dueId)

        vm.stillCarrying("Still carrying this.")
        vm.stillCarrying("Still carrying this.")
        awaitMain { vm.uiState.value.reflection?.notes?.isNotEmpty() == true }
        settleMain()

        assertEquals(1, vm.uiState.value.reflection!!.notes.size)
    }

    @Test
    fun stillCarrying_thenRefreshBeforeTheNoteLands_keepsCheckInHidden() {
        val vm = detail(dueId)

        vm.stillCarrying("Still carrying this.")
        vm.refresh()
        assertFalse(vm.uiState.value.checkInDue)
        vm.stillCarrying("Still carrying this.")

        awaitMain { vm.uiState.value.reflection?.notes?.isNotEmpty() == true }
        settleMain()
        assertEquals(1, vm.uiState.value.reflection!!.notes.size)
        assertFalse(vm.uiState.value.checkInDue)
    }

    @Test
    fun list_refresh_marksReflectionOnceTwoWeeksPass() {
        val clockRef = MutableClock(now.minusDays(1))
        val vm = WhatsYoursViewModel(SavedStateHandle(), repository, clockRef)
        awaitMain { vm.uiState.value.open.size == 2 }
        assertEquals(emptySet<Long>(), vm.uiState.value.dueIds)

        clockRef.at = now
        vm.refresh()

        assertEquals(setOf(dueId), vm.uiState.value.dueIds)
    }

    @Test
    fun setItDown_movesToPast() {
        val vm = detail(dueId)

        vm.setDown()
        awaitMain { vm.uiState.value.reflection?.setDownAt != null }
        settleMain()

        assertNotNull(vm.uiState.value.reflection!!.setDownAt)
        assertFalse(vm.uiState.value.checkInDue)
        assertEquals(listOf(freshId), runBlocking { repository.observeOpen().first() }.map { it.id })
        assertEquals(listOf(dueId), runBlocking { repository.observePast().first() }.map { it.id })
    }

    private fun detail(id: Long, useClock: Clock = clock) = ReflectionDetailViewModel(
        SavedStateHandle(mapOf(REFLECTION_ID_KEY to id)),
        repository,
        useClock
    ).also { vm -> awaitMain { vm.uiState.value.reflection != null } }

    private class MutableClock(var at: LocalDateTime) : Clock() {
        override fun getZone(): ZoneId = ZoneOffset.UTC
        override fun withZone(zone: ZoneId): Clock = this
        override fun instant(): Instant = at.toInstant(ZoneOffset.UTC)
    }
}
