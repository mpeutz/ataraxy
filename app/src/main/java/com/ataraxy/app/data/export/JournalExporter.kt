package com.ataraxy.app.data.export

import com.ataraxy.app.data.repository.JournalRepository
import com.ataraxy.app.data.repository.ReflectionRepository
import com.ataraxy.app.domain.model.JournalEntry
import com.ataraxy.app.domain.model.Reflection
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

private const val EXPORT_FILE_NAME = "ataraxy_journal.txt"

@Singleton
class JournalExporter @Inject constructor(
    private val journalRepository: JournalRepository,
    private val reflectionRepository: ReflectionRepository,
    private val downloadsWriter: DownloadsWriter
) {
    suspend fun exportToDownloads(): Result<Unit> = try {
        val entries = journalRepository.getAllEntries().first()
        val reflections = formatReflectionsExport(reflectionRepository.getAll())
        val journal = formatJournalExport(entries)
        val text = listOf(journal, reflections).filter { it.isNotEmpty() }.joinToString("\n")
        downloadsWriter.writeText(EXPORT_FILE_NAME, text)
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

internal fun formatReflectionsExport(reflections: List<Reflection>): String {
    if (reflections.isEmpty()) return ""
    val body = reflections.joinToString("\n") { reflection ->
        buildString {
            appendLine("Worry: ${reflection.worry}")
            appendLine("Started: ${reflection.createdAt}")
            appendIfPresent("Yours", reflection.yours.joinToString("; "))
            appendIfPresent("Not yours", reflection.notYours.joinToString("; "))
            appendIfPresent("Can still do", reflection.canDo)
            appendIfPresent("Set down", reflection.setDown)
            reflection.notes.forEach { appendLine("Note (${it.createdAt}): ${it.text}") }
            reflection.setDownAt?.let { appendLine("Set down on: $it") }
            appendLine("---")
        }
    }
    return "=== What's Yours ===\n\n$body"
}

private fun StringBuilder.appendIfPresent(label: String, value: String) {
    if (value.isNotBlank()) appendLine("$label: $value")
}
