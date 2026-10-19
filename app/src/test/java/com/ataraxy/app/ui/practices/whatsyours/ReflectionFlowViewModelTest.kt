package com.ataraxy.app.ui.practices.whatsyours

import androidx.lifecycle.SavedStateHandle
import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.QuoteRepository
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.data.seed.DatabaseSeeder
import com.ataraxy.app.data.seed.QuoteData
import com.ataraxy.app.domain.model.SosEmotion
import com.ataraxy.app.testing.awaitMain
import com.ataraxy.app.testing.settleMain
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
import java.time.LocalDateTime

@RunWith(RobolectricTestRunner::class)
class ReflectionFlowViewModelTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var repository: ReflectionRepository
    private var reflectionId = 0L

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        repository = ReflectionRepository(db.reflectionDao())
        runBlocking {
            DatabaseSeeder(db).seed()
            reflectionId = repository.create("My dog is very sick", LocalDateTime.of(2026, 10, 18, 9, 0))
        }
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun loads_theWorry_atStepOne() {
        val vm = viewModel()

        assertEquals("My dog is very sick", vm.uiState.value.worry)
        assertEquals(FlowStep.SPLIT, vm.uiState.value.step)
    }

    @Test
    fun addYours_ignoresBlank_andTrims() {
        val vm = viewModel()

        vm.updateYoursDraft("   ")
        vm.addYours()
        vm.updateYoursDraft("  Being with her  ")
        vm.addYours()

        assertEquals(listOf("Being with her"), vm.uiState.value.yours)
        assertEquals("", vm.uiState.value.yoursDraft)
    }

    @Test
    fun next_requiresALine() {
        val vm = viewModel()

        assertFalse(vm.uiState.value.canContinue)
        vm.next()

        assertEquals(FlowStep.SPLIT, vm.uiState.value.step)
    }

    @Test
    fun next_loadsHelplessQuote() {
        val vm = viewModel()
        vm.updateNotYoursDraft("The illness")
        vm.addNotYours()

        vm.next()
        awaitMain { vm.uiState.value.quote != null }

        val helplessIds = QuoteData.quotes.filter { it.emotionTag == SosEmotion.HELPLESS.name }.map { it.id }
        assertEquals(FlowStep.ACT, vm.uiState.value.step)
        assertTrue(vm.uiState.value.quote!!.id in helplessIds)
    }

    @Test
    fun back_fromStep2_keepsAnswers() {
        val vm = viewModel()
        vm.updateYoursDraft("Keeping her comfortable")
        vm.addYours()
        vm.next()
        vm.updateCanDo("Sit with her tonight")

        assertTrue(vm.back())
        assertEquals(FlowStep.SPLIT, vm.uiState.value.step)
        assertEquals("Sit with her tonight", vm.uiState.value.canDo)
        assertFalse(vm.back())
    }

    @Test
    fun edits_persist_andReloadInNewViewModel() {
        val handle = SavedStateHandle(mapOf(REFLECTION_ID_KEY to reflectionId))
        val first = viewModel(handle)
        first.updateYoursDraft("Being there")
        first.addYours()
        first.updateNotYoursDraft("The timing")
        first.addNotYours()
        first.next()
        first.updateCanDo("Say goodbye the way I want")
        first.updateSetDown("Her illness, and when it ends")
        first.back()
        first.next()
        settleMain()

        val restored = viewModel(handle).uiState.value

        assertEquals(listOf("Being there"), restored.yours)
        assertEquals(listOf("The timing"), restored.notYours)
        assertEquals("Say goodbye the way I want", restored.canDo)
        assertEquals("Her illness, and when it ends", restored.setDown)
        assertEquals(FlowStep.ACT, restored.step)
    }

    @Test
    fun finish_setsCompletedAt_andReturnsId() {
        val vm = viewModel()
        vm.updateYoursDraft("Being there")
        vm.addYours()
        vm.next()
        vm.updateCanDo("Sit with her")
        var done: Long? = null

        vm.finish { done = it }
        awaitMain { done != null }

        assertEquals(reflectionId, done)
        assertNotNull(runBlocking { repository.get(reflectionId) }!!.completedAt)
        assertEquals("Sit with her", runBlocking { repository.get(reflectionId) }!!.canDo)
    }

    @Test
    fun back_beforeLoad_doesNotWipeSavedAnswers() {
        runBlocking { repository.saveAnswers(reflectionId, listOf("Being there"), listOf("The timing"), "Sit with her", "") }

        val vm = ReflectionFlowViewModel(
            SavedStateHandle(mapOf(REFLECTION_ID_KEY to reflectionId)),
            repository,
            QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao())
        )
        vm.back()
        settleMain()

        val stored = runBlocking { repository.get(reflectionId) }!!
        assertEquals(listOf("Being there"), stored.yours)
        assertEquals("Sit with her", stored.canDo)
    }

    @Test
    fun finish_twice_callsBackOnce() {
        val vm = viewModel()
        vm.updateYoursDraft("Being there")
        vm.addYours()
        vm.next()
        vm.updateCanDo("Sit with her")
        var calls = 0

        vm.finish { calls++ }
        vm.finish { calls++ }
        settleMain()

        assertEquals(1, calls)
    }

    @Test
    fun next_commitsPendingDrafts() {
        val vm = viewModel()
        vm.updateYoursDraft("Being there")
        vm.addYours()
        vm.updateYoursDraft("Keeping her comfortable")
        vm.updateNotYoursDraft("The illness")

        assertTrue(vm.uiState.value.canContinue)
        vm.next()

        assertEquals(listOf("Being there", "Keeping her comfortable"), vm.uiState.value.yours)
        assertEquals(listOf("The illness"), vm.uiState.value.notYours)
        assertEquals(FlowStep.ACT, vm.uiState.value.step)
    }

    @Test
    fun confirmDelete_removesUnfinishedReflection() {
        val vm = viewModel()
        var deleted = false

        vm.requestDelete()
        assertTrue(vm.uiState.value.confirmingDelete)
        vm.confirmDelete { deleted = true }
        awaitMain { deleted }

        assertEquals(null, runBlocking { repository.get(reflectionId) })
    }

    private fun viewModel(handle: SavedStateHandle = SavedStateHandle(mapOf(REFLECTION_ID_KEY to reflectionId))) =
        ReflectionFlowViewModel(
            handle,
            repository,
            QuoteRepository(db.quoteDao(), db.authorDao(), db.bookmarkDao())
        ).also { vm -> awaitMain { vm.uiState.value.loaded } }
}
