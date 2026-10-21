package com.ataraxy.app.lookback

import com.ataraxy.app.domain.model.Reflection
import com.ataraxy.app.domain.model.ReflectionNote
import java.time.LocalDateTime
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CheckInTest {

    private val created = LocalDateTime.of(2026, 10, 1, 9, 0)

    private fun reflection(
        completedAt: LocalDateTime? = created,
        setDownAt: LocalDateTime? = null,
        notes: List<ReflectionNote> = emptyList()
    ) = Reflection(
        worry = "w",
        notes = notes,
        createdAt = created,
        completedAt = completedAt,
        setDownAt = setDownAt
    )

    @Test
    fun checkIn_dueAfter14DaysForFinishedOpenReflection() {
        val r = reflection()

        assertFalse(isCheckInDue(r, created.plusDays(14).minusSeconds(1)))
        assertTrue(isCheckInDue(r, created.plusDays(14)))
        assertTrue(isCheckInDue(r, created.plusDays(30)))
    }

    @Test
    fun checkIn_notForUnfinishedOrSetDown() {
        val now = created.plusDays(40)

        assertFalse(isCheckInDue(reflection(completedAt = null), now))
        assertFalse(isCheckInDue(reflection(setDownAt = created.plusDays(20)), now))
    }

    @Test
    fun checkIn_aNewNoteResetsTheClock() {
        val noteAt = created.plusDays(10)
        val r = reflection(notes = listOf(ReflectionNote(text = "n", createdAt = noteAt)))

        assertFalse(isCheckInDue(r, created.plusDays(14)))
        assertFalse(isCheckInDue(r, noteAt.plusDays(14).minusSeconds(1)))
        assertTrue(isCheckInDue(r, noteAt.plusDays(14)))
    }
}
