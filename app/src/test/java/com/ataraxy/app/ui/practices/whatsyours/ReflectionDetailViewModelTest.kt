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
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.LocalDateTime

@RunWith(RobolectricTestRunner::class)
class ReflectionDetailViewModelTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var repository: ReflectionRepository
    private var reflectionId = 0L

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        repository = ReflectionRepository(db.reflectionDao())
        reflectionId = runBlocking {
            repository.create("Job interview on Friday", LocalDateTime.of(2026, 10, 12, 9, 0)).also {
                repository.complete(it, LocalDateTime.of(2026, 10, 12, 9, 10))
            }
        }
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun addNote_appendsDatedNote_andClearsDraft() {
        val vm = viewModel()
        vm.updateNoteDraft("  Practiced twice. Calmer.  ")

        vm.addNote()
        awaitMain { vm.uiState.value.reflection?.notes?.isNotEmpty() == true }

        assertEquals("Practiced twice. Calmer.", vm.uiState.value.reflection!!.notes.single().text)
        assertEquals("", vm.uiState.value.noteDraft)
    }

    @Test
    fun addNote_ignoresBlank() {
        val vm = viewModel()
        vm.updateNoteDraft("   ")

        vm.addNote()
        settleMain()

        assertTrue(vm.uiState.value.reflection!!.notes.isEmpty())
    }

    @Test
    fun setDown_thenPickUp_togglesPast() {
        val vm = viewModel()

        vm.setDown()
        awaitMain { vm.uiState.value.reflection?.setDownAt != null }
        vm.pickUp()
        awaitMain { vm.uiState.value.reflection?.setDownAt == null }

        assertNull(vm.uiState.value.reflection!!.setDownAt)
    }

    @Test
    fun confirmDelete_removesReflection_andCallsBack() {
        val vm = viewModel()
        var deleted = false

        vm.requestDelete()
        assertTrue(vm.uiState.value.confirmingDelete)
        vm.confirmDelete { deleted = true }
        awaitMain { deleted }

        assertNull(runBlocking { repository.get(reflectionId) })
        assertFalse(vm.uiState.value.confirmingDelete)
    }

    @Test
    fun cancelDelete_keepsReflection() {
        val vm = viewModel()

        vm.requestDelete()
        vm.cancelDelete()
        settleMain()

        assertFalse(vm.uiState.value.confirmingDelete)
        assertEquals(reflectionId, runBlocking { repository.get(reflectionId) }!!.id)
    }

    private fun viewModel() = ReflectionDetailViewModel(
        SavedStateHandle(mapOf(REFLECTION_ID_KEY to reflectionId)),
        repository
    ).also { vm -> awaitMain { vm.uiState.value.reflection != null } }
}
