package com.ataraxy.app.data.export

import com.ataraxy.app.data.local.AtaraxyDatabase
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.inMemoryDatabase
import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.domain.model.JournalEntry
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
        exporter = JournalExporter(JournalRepository(db.journalDao()), writer)
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

    private suspend fun insertEntry(content: String) {
        val now = LocalDateTime.now().toString()
        db.journalDao().upsert(JournalEntryEntity(0, now, now, content, "", null, null))
    }
}
