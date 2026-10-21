package com.ataraxy.app.ui.practices.whatsyours

import androidx.lifecycle.SavedStateHandle
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.testing.awaitMain
import com.ataraxy.app.testing.settleMain
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.Clock
import java.time.LocalDateTime

@RunWith(RobolectricTestRunner::class)
class WhatsYoursViewModelTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var repository: ReflectionRepository

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        repository = ReflectionRepository(db.reflectionDao())
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun begin_createsReflection_andReturnsId() {
        val vm = viewModel()
        var created: Long? = null
        vm.updateDraft("  Job interview on Friday ")

        vm.begin { created = it }
        awaitMain { created != null && vm.uiState.value.open.isNotEmpty() }

        assertTrue(created!! > 0)
        assertEquals("", vm.uiState.value.draftWorry)
        assertEquals("Job interview on Friday", vm.uiState.value.open.single().worry)
    }

    @Test
    fun begin_ignoresBlankWorry() {
        val vm = viewModel()
        var created: Long? = null
        vm.updateDraft("   ")

        vm.begin { created = it }
        settleMain()

        assertNull(created)
        assertTrue(vm.uiState.value.open.isEmpty())
    }

    @Test
    fun draft_survivesSavedState() {
        val handle = SavedStateHandle()
        viewModel(handle).updateDraft("Dad's surgery")
        settleMain()

        assertEquals("Dad's surgery", viewModel(handle).uiState.value.draftWorry)
    }

    @Test
    fun past_listsSetDownReflections() {
        val id = runBlocking { repository.create("Falling behind", LocalDateTime.of(2026, 9, 2, 8, 0)) }
        runBlocking { repository.setDown(id, LocalDateTime.of(2026, 10, 1, 8, 0)) }

        val vm = viewModel()
        awaitMain { vm.uiState.value.past.isNotEmpty() }

        assertEquals(listOf(id), vm.uiState.value.past.map { it.id })
        assertTrue(vm.uiState.value.open.isEmpty())
    }

    private fun viewModel(handle: SavedStateHandle = SavedStateHandle()) = WhatsYoursViewModel(handle, repository, Clock.systemDefaultZone())
}
