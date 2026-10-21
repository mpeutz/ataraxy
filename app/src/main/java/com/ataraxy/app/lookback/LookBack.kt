package com.ataraxy.app.lookback

import com.ataraxy.app.domain.model.JournalEntry
import com.ataraxy.app.domain.model.Reflection
import java.time.LocalDate
import java.time.LocalDateTime

const val CHECK_IN_DAYS = 14L
const val LOOKBACK_MIN_DAYS = 30L

data class JournalSession(val entries: List<JournalEntry>) {
    val representative: JournalEntry get() = entries.first()
    val date: LocalDate get() = representative.createdAt.toLocalDate()
}

enum class LookBackKind { YEAR, MONTH, OLDER }

data class LookBackPick(val session: JournalSession, val kind: LookBackKind)

fun sessionsOf(entries: List<JournalEntry>): List<JournalSession> {
    val practice = entries.filter { it.ritualType == null }.map { JournalSession(listOf(it)) }
    val rituals = entries
        .filter { it.ritualType != null }
        .groupBy { it.ritualType to it.createdAt }
        .values
        .map { group -> JournalSession(group.sortedBy { it.id }) }
    return practice + rituals
}

fun pickLookBack(entries: List<JournalEntry>, today: LocalDate): LookBackPick? {
    val sessions = sessionsOf(entries).sortedWith(SESSION_ORDER)

    sessions.firstOrNull { it.date == today.minusYears(1) }
        ?.let { return LookBackPick(it, LookBackKind.YEAR) }
    sessions.firstOrNull { it.date == today.minusMonths(1) }
        ?.let { return LookBackPick(it, LookBackKind.MONTH) }

    val eligible = sessions.filter { it.date <= today.minusDays(LOOKBACK_MIN_DAYS) }
    if (eligible.isEmpty()) return null
    val index = Math.floorMod(today.toEpochDay(), eligible.size.toLong()).toInt()
    return LookBackPick(eligible[index], LookBackKind.OLDER)
}

private val SESSION_ORDER = compareBy<JournalSession>(
    { it.representative.createdAt },
    { it.representative.id }
)

fun isCheckInDue(reflection: Reflection, now: LocalDateTime): Boolean {
    if (reflection.setDownAt != null || reflection.completedAt == null) return false
    val lastTouch = (reflection.notes.map { it.createdAt } + reflection.createdAt).max()
    return !now.isBefore(lastTouch.plusDays(CHECK_IN_DAYS))
}
