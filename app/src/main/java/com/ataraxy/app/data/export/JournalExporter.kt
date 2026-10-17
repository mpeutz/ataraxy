package com.ataraxy.app.data.export

import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.domain.model.JournalEntry
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

private const val EXPORT_FILE_NAME = "ataraxy_journal.txt"

@Singleton
class JournalExporter @Inject constructor(
    private val journalRepository: JournalRepository,
    private val downloadsWriter: DownloadsWriter
) {
    suspend fun exportToDownloads(): Result<Unit> = try {
        val entries = journalRepository.getAllEntries().first()
        downloadsWriter.writeText(EXPORT_FILE_NAME, formatJournalExport(entries))
        Result.success(Unit)
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.failure(e)
    }
}

internal fun formatJournalExport(entries: List<JournalEntry>): String =
    entries.joinToString("\n") { entry ->
        buildString {
            appendLine("Date: ${entry.createdAt}")
            if (entry.promptText.isNotBlank()) appendLine("Prompt: ${entry.promptText}")
            appendLine()
            appendLine(entry.content)
            appendLine("---")
        }
    }
