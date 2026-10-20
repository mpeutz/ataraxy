package com.ataraxy.app.data.backup

import com.ataraxy.app.data.backup.BackupFormatException.Reason
import com.ataraxy.app.data.local.entity.BookmarkEntity
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.ReflectionEntity
import com.ataraxy.app.data.local.entity.ReflectionNoteEntity
import com.ataraxy.app.data.local.entity.ReflectionWithNotes
import com.ataraxy.app.data.local.entity.SosEventEntity
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.time.Instant

@RunWith(RobolectricTestRunner::class)
class BackupCodecTest {

    private val createdAt = Instant.parse("2026-10-20T14:05:11Z")

    private fun snapshot(content: String = "Plain entry") = BackupSnapshot(
        journalEntries = listOf(
            JournalEntryEntity(
                id = 1, createdAt = "2026-10-01T08:00:00", updatedAt = "2026-10-01T08:05:00",
                content = content, promptText = "What went well?",
                linkedQuoteId = "q1", virtueId = "courage", ritualType = "EVENING"
            ),
            JournalEntryEntity(
                id = 2, createdAt = "2026-10-02T08:00:00", updatedAt = "2026-10-02T08:00:00",
                content = "Second", promptText = "", linkedQuoteId = null, virtueId = null
            )
        ),
        reflections = listOf(
            ReflectionWithNotes(
                reflection = ReflectionEntity(
                    id = 1, worry = "Money", yours = "a\nb", notYours = "c", canDo = "d",
                    setDown = "e", createdAt = "2026-10-03T09:00:00",
                    completedAt = "2026-10-03T09:30:00", setDownAt = null
                ),
                notes = listOf(
                    ReflectionNoteEntity(id = 1, reflectionId = 1, text = "n1", createdAt = "2026-10-04T09:00:00"),
                    ReflectionNoteEntity(id = 2, reflectionId = 1, text = "n2", createdAt = "2026-10-05T09:00:00")
                )
            )
        ),
        bookmarks = listOf(BookmarkEntity(quoteId = "q1", savedAt = "2026-10-06T10:00:00")),
        sosEvents = listOf(SosEventEntity(id = 1, emotion = "anxious", quoteId = "q2", triggeredAt = "2026-10-07T11:00:00")),
        preferences = mapOf(
            "theme" to PrefValue.StringValue("DARK"),
            "birth_year" to PrefValue.IntValue(1980),
            "last_seen" to PrefValue.LongValue(1_700_000_000_000L),
            "onboarded" to PrefValue.BooleanValue(true)
        )
    )

    @Test
    fun roundTrip_keepsEveryRowAndPreference() {
        val original = snapshot()

        val decoded = BackupCodec.decode(BackupCodec.encode(original, createdAt, 7L))

        assertEquals(original, decoded.snapshot)
        assertEquals(createdAt, decoded.createdAt)
        assertEquals(7L, decoded.appVersionCode)
        assertEquals(BackupCodec.FORMAT_VERSION, decoded.formatVersion)
    }

    @Test
    fun roundTrip_keepsUnusualText() {
        val unusual = "Line one\n\"Quoted\" — ünïcödé 🙂\tend"
        val long = "x".repeat(20_000)
        val original = snapshot(content = unusual).let {
            it.copy(journalEntries = it.journalEntries + it.journalEntries[1].copy(id = 3, content = long))
        }

        val decoded = BackupCodec.decode(BackupCodec.encode(original, createdAt, 1L))

        assertEquals(unusual, decoded.snapshot.journalEntries[0].content)
        assertEquals(long, decoded.snapshot.journalEntries[2].content)
    }

    @Test
    fun decode_rejectsNewerFormat() {
        val text = JSONObject(BackupCodec.encode(snapshot(), createdAt, 1L)).put("formatVersion", 2).toString()

        val error = assertThrows(BackupFormatException::class.java) { BackupCodec.decode(text) }

        assertEquals(Reason.NEWER_VERSION, error.reason)
    }

    @Test
    fun decode_rejectsNonBackups() {
        val valid = BackupCodec.encode(snapshot(), createdAt, 1L)
        val inputs = listOf("", "hello", "{}", "[]", "{\"format\":\"other\"}", valid.take(valid.length / 2))

        inputs.forEach { text ->
            val error = assertThrows(BackupFormatException::class.java) { BackupCodec.decode(text) }
            assertEquals(Reason.NOT_A_BACKUP, error.reason)
        }
    }

    @Test
    fun decode_skipsUnknownPreferenceTypes() {
        val root = JSONObject(BackupCodec.encode(snapshot(), createdAt, 1L))
        root.getJSONObject("preferences")
            .put("ratio", JSONObject().put("type", "float").put("value", 1.5))

        val decoded = BackupCodec.decode(root.toString())

        assertEquals(snapshot().preferences, decoded.snapshot.preferences)
    }

    @Test
    fun contentHash_ignoresCreatedAt_changesWithData() {
        val base = snapshot()

        assertEquals(BackupCodec.contentHash(base), BackupCodec.contentHash(snapshot()))
        assertNotEquals(BackupCodec.contentHash(base), BackupCodec.contentHash(snapshot(content = "Edited")))
    }
}
