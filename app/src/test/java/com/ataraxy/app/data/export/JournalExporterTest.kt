package com.ataraxy.app.data.export

import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.domain.model.JournalEntry
import com.ataraxy.app.domain.model.Reflection
import com.ataraxy.app.domain.model.ReflectionNote
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException
import java.time.LocalDateTime

@RunWith(RobolectricTestRunner::class)
class JournalExporterTest {

    private class RecordingWriter : DownloadsWriter {
        val writes = mutableListOf<String>()
        var failWith: Exception? = null

        override suspend fun writeText(fileName: String, text: String) {
            failWith?.let { throw it }
            writes += text
        }
    }

    private lateinit var db: AtaraxyDatabase
    private lateinit var writer: RecordingWriter
    private lateinit var exporter: JournalExporter

    @Before
    fun setUp() {
        db = inMemoryDatabase()
        writer = RecordingWriter()
        exporter = JournalExporter(JournalRepository(db.journalDao()), ReflectionRepository(db.reflectionDao()), writer)
    }

    @After
    fun tearDown() = db.close()

    @Test
    fun export_writesOnce_andIgnoresLaterJournalChanges() = runBlocking {
        insertEntry("First thought")

        val result = withTimeout(5_000) { exporter.exportToDownloads() }
        insertEntry("Written after export")

        assertTrue(result.isSuccess)
        assertEquals(1, writer.writes.size)
        assertTrue(writer.writes.single().contains("First thought"))
    }

    @Test
    fun export_reportsFailure_whenWriteFails() = runBlocking {
        writer.failWith = IOException("disk full")

        val result = exporter.exportToDownloads()

        assertEquals("disk full", result.exceptionOrNull()?.message)
    }

    @Test
    fun formatJournalExport_listsEachEntryWithOptionalPrompt() {
        val at = LocalDateTime.of(2026, 10, 17, 8, 30)
        val entries = listOf(
            JournalEntry(1, at, at, "Body one", "What weighs on you?", null, null),
            JournalEntry(2, at, at, "Body two", "", null, null)
        )

        val expected = """
            |Date: 2026-10-17T08:30
            |Prompt: What weighs on you?
            |
            |Body one
            |---
            |
            |Date: 2026-10-17T08:30
            |
            |Body two
            |---
            |""".trimMargin()

        assertEquals(expected, formatJournalExport(entries))
    }

    @Test
    fun formatReflectionsExport_listsFieldsAndNotes() {
        val at = LocalDateTime.of(2026, 10, 12, 9, 0)
        val reflection = Reflection(
            id = 1,
            worry = "Job interview on Friday",
            yours = listOf("How well I prepare", "Sleep"),
            notYours = listOf("Whether they pick me"),
            canDo = "Practice with Sam",
            setDown = "Their decision",
            notes = listOf(
                ReflectionNote(1, "Practiced twice", at.plusDays(2)),
                ReflectionNote(2, "Did my part", at.plusDays(5))
            ),
            createdAt = at,
            completedAt = at,
            setDownAt = at.plusDays(6)
        )

        val expected = """
            |=== What's Yours ===
            |
            |Worry: Job interview on Friday
            |Started: 2026-10-12T09:00
            |Yours: How well I prepare; Sleep
            |Not yours: Whether they pick me
            |Can still do: Practice with Sam
            |Set down: Their decision
            |Note (2026-10-14T09:00): Practiced twice
            |Note (2026-10-17T09:00): Did my part
            |Set down on: 2026-10-18T09:00
            |---
            |""".trimMargin()

        assertEquals(expected, formatReflectionsExport(listOf(reflection)))
    }

    @Test
    fun formatReflectionsExport_omitsEmptyFields() {
        val at = LocalDateTime.of(2026, 10, 12, 9, 0)

        val text = formatReflectionsExport(listOf(Reflection(worry = "Unfinished worry", createdAt = at)))

        assertEquals("=== What's Yours ===\n\nWorry: Unfinished worry\nStarted: 2026-10-12T09:00\n---\n", text)
    }

    @Test
    fun formatReflectionsExport_emptyIsBlank() {
        assertEquals("", formatReflectionsExport(emptyList()))
    }

    @Test
    fun export_includesReflectionsAfterJournal() = runBlocking {
        insertEntry("First thought")
        ReflectionRepository(db.reflectionDao()).create("Job interview", LocalDateTime.of(2026, 10, 12, 9, 0))

        exporter.exportToDownloads()

        val text = writer.writes.single()
        assertTrue(text.indexOf("First thought") < text.indexOf("Worry: Job interview"))
    }

    private suspend fun insertEntry(content: String) {
        val now = LocalDateTime.now().toString()
        db.journalDao().upsert(JournalEntryEntity(0, now, now, content, "", null, null))
    }
}
