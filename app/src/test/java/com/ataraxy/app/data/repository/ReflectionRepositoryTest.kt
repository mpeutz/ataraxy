package com.ataraxy.app.data.repository

import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.inMemoryDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.LocalDateTime

@RunWith(RobolectricTestRunner::class)
class ReflectionRepositoryTest {

    private lateinit var db: AtaraxyDatabase
    private lateinit var repository: ReflectionRepository

    private val start = LocalDateTime.of(2026, 10, 18, 9, 0)

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        repository = ReflectionRepository(db.reflectionDao())
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun create_thenObserveOpen_showsUnfinished() = runBlocking {
        repository.create("Job interview", start)

        val open = repository.observeOpen().first()

        assertEquals(1, open.size)
        assertEquals("Job interview", open.single().worry)
        assertNull(open.single().completedAt)
    }

    @Test
    fun lines_roundTrip_collapsesNewlines_dropsBlanks() = runBlocking {
        val id = repository.create("Job interview", start)

        repository.saveAnswers(id, listOf(" Prepare ", "", "Sleep\nwell"), listOf("Their choice"), "Practice", "Their decision")

        val saved = repository.get(id)!!
        assertEquals(listOf("Prepare", "Sleep well"), saved.yours)
        assertEquals(listOf("Their choice"), saved.notYours)
        assertEquals("Practice", saved.canDo)
        assertEquals("Their decision", saved.setDown)
    }

    @Test
    fun setDown_movesToPast_andPickUpReturnsIt() = runBlocking {
        val id = repository.create("Job interview", start)

        repository.setDown(id, start.plusDays(3))

        assertTrue(repository.observeOpen().first().isEmpty())
        assertEquals(start.plusDays(3), repository.observePast().first().single().setDownAt)

        repository.pickUp(id)

        assertEquals(listOf(id), repository.observeOpen().first().map { it.id })
        assertTrue(repository.observePast().first().isEmpty())
    }

    @Test
    fun delete_cascadesNotes() = runBlocking {
        val id = repository.create("Job interview", start)
        repository.addNote(id, "Practiced twice", start.plusDays(1))
        repository.addNote(id, "Calmer now", start.plusDays(2))

        repository.delete(id)

        val cursor = db.openHelper.readableDatabase.query("SELECT COUNT(*) FROM reflection_notes")
        cursor.moveToFirst()
        assertEquals(0, cursor.getInt(0))
        cursor.close()
        assertNull(repository.get(id))
    }

    @Test
    fun notes_areOrderedOldestFirst() = runBlocking {
        val id = repository.create("Job interview", start)
        repository.addNote(id, "Later", start.plusDays(2))
        repository.addNote(id, "Earlier", start.plusDays(1))

        val notes = repository.get(id)!!.notes

        assertEquals(listOf("Earlier", "Later"), notes.map { it.text })
    }

    @Test
    fun complete_setsCompletedAt() = runBlocking {
        val id = repository.create("Job interview", start)

        repository.complete(id, start.plusHours(1))

        assertEquals(start.plusHours(1), repository.get(id)!!.completedAt)
    }
}
