package com.ataraxy.app.lookback

import com.ataraxy.app.domain.model.JournalEntry
import java.time.LocalDate
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class LookBackTest {

    private val today = LocalDate.of(2026, 10, 20)

    private fun entry(
        id: Long,
        date: LocalDate,
        ritualType: String? = null,
        content: String = "content $id"
    ): JournalEntry {
        val at = date.atTime(8, 0)
        return JournalEntry(
            id = id,
            createdAt = at,
            updatedAt = at,
            content = content,
            promptText = "prompt $id",
            linkedQuoteId = null,
            virtueId = null,
            ritualType = ritualType
        )
    }

    @Test
    fun noEntriesOlderThan30Days_noPick() {
        val entries = listOf(
            entry(1, today),
            entry(2, today.minusDays(29)),
            entry(3, today.minusDays(5))
        )

        assertNull(pickLookBack(entries, today))
        assertNull(pickLookBack(emptyList(), today))
    }

    @Test
    fun exactYear_beatsMonthAndOlder() {
        val entries = listOf(
            entry(1, today.minusMonths(1)),
            entry(2, today.minusDays(90)),
            entry(3, today.minusYears(1))
        )

        val pick = pickLookBack(entries, today)

        assertNotNull(pick)
        assertEquals(LookBackKind.YEAR, pick!!.kind)
        assertEquals(3L, pick.session.representative.id)
    }

    @Test
    fun exactMonth_whenNoYear() {
        val entries = listOf(
            entry(1, today.minusDays(90)),
            entry(2, today.minusMonths(1))
        )

        val pick = pickLookBack(entries, today)

        assertEquals(LookBackKind.MONTH, pick!!.kind)
        assertEquals(2L, pick.session.representative.id)
    }

    @Test
    fun exactMatchesWithSeveralSessions_takeEarliestCreatedAt() {
        val day = today.minusYears(1)
        val late = entry(1, day).copy(createdAt = day.atTime(20, 0))
        val early = entry(2, day).copy(createdAt = day.atTime(7, 0))

        val pick = pickLookBack(listOf(late, early), today)

        assertEquals(2L, pick!!.session.representative.id)
    }

    @Test
    fun older_isStableWithinADay_andChangesAcrossDays() {
        val entries = (1L..5L).map { entry(it, today.minusDays(40L + it * 3)) }

        val first = pickLookBack(entries, today)
        val again = pickLookBack(entries, today)
        assertEquals(LookBackKind.OLDER, first!!.kind)
        assertEquals(first, again)

        val picks = (1L..7L).map { pickLookBack(entries, today.plusDays(it))!! }
        assertTrue(picks.any { it.session != first.session })
    }

    @Test
    fun older_usesFloorModOverCreatedAtAscending() {
        val entries = (1L..3L).map { entry(it, today.minusDays(100L - it)) }
        val expected = Math.floorMod(today.toEpochDay(), 3L).toInt()

        val pick = pickLookBack(entries.reversed(), today)

        assertEquals(entries.sortedBy { it.createdAt }[expected].id, pick!!.session.representative.id)
    }

    @Test
    fun ritualSession_isOnePick_withFirstAnswerAsRepresentative() {
        val date = today.minusDays(60)
        val entries = listOf(
            entry(11, date, ritualType = "morning"),
            entry(10, date, ritualType = "morning"),
            entry(12, date, ritualType = "evening"),
            entry(13, date)
        )

        val sessions = sessionsOf(entries)

        assertEquals(3, sessions.size)
        val morning = sessions.single { it.entries.any { e -> e.ritualType == "morning" } }
        assertEquals(listOf(10L, 11L), morning.entries.map { it.id })
        assertEquals(10L, morning.representative.id)
        assertEquals(date, morning.date)
    }

    @Test
    fun leapDayAndMonthEnd_clamp() {
        val leapToday = LocalDate.of(2028, 2, 29)
        val year = pickLookBack(listOf(entry(1, LocalDate.of(2027, 2, 28))), leapToday)
        assertEquals(LookBackKind.YEAR, year!!.kind)

        val endToday = LocalDate.of(2026, 3, 31)
        val month = pickLookBack(listOf(entry(2, LocalDate.of(2026, 2, 28))), endToday)
        assertEquals(LookBackKind.MONTH, month!!.kind)
    }


    @Test
    fun exactMonth_winsEvenWhenUnder30Days() {
        val march = LocalDate.of(2026, 3, 15)
        val pick = pickLookBack(listOf(entry(1, LocalDate.of(2026, 2, 15))), march)

        assertEquals(LookBackKind.MONTH, pick!!.kind)
    }

    @Test
    fun sameCreatedAt_pickIsIndependentOfInputOrder() {
        val date = today.minusDays(60)
        val a = entry(1, date)
        val b = entry(2, date)

        assertEquals(pickLookBack(listOf(a, b), today), pickLookBack(listOf(b, a), today))
        val yearDay = today.minusYears(1)
        val c = entry(3, yearDay)
        val d = entry(4, yearDay)
        assertEquals(3L, pickLookBack(listOf(d, c), today)!!.session.representative.id)
    }

    @Test
    fun olderBoundary_30DaysEligible_29DaysNot() {
        val day = LocalDate.of(2026, 10, 31)
        assertEquals(LookBackKind.OLDER, pickLookBack(listOf(entry(1, day.minusDays(30))), day)!!.kind)
        assertNull(pickLookBack(listOf(entry(2, day.minusDays(29))), day))
    }

    @Test
    fun sameRitualTypeSameDate_differentCreatedAt_areTwoSessions() {
        val date = today.minusDays(60)
        val first = entry(1, date, ritualType = "morning")
        val second = entry(2, date, ritualType = "morning").copy(createdAt = date.atTime(9, 0))

        assertEquals(2, sessionsOf(listOf(first, second)).size)
    }
}
