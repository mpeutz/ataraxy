package com.ataraxy.app.data.backup

import com.ataraxy.app.data.local.entity.BookmarkEntity
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.ReflectionWithNotes
import com.ataraxy.app.data.local.entity.SosEventEntity
import java.time.Instant

sealed interface PrefValue {
    data class IntValue(val value: Int) : PrefValue
    data class LongValue(val value: Long) : PrefValue
    data class BooleanValue(val value: Boolean) : PrefValue
    data class StringValue(val value: String) : PrefValue
}

data class BackupSnapshot(
    val journalEntries: List<JournalEntryEntity>,
    val reflections: List<ReflectionWithNotes>,
    val bookmarks: List<BookmarkEntity>,
    val sosEvents: List<SosEventEntity>,
    val preferences: Map<String, PrefValue>
) {
    val hasPrivateData: Boolean
        get() = journalEntries.isNotEmpty() || reflections.isNotEmpty()
}

data class BackupFile(
    val formatVersion: Int,
    val createdAt: Instant,
    val appVersionCode: Long,
    val snapshot: BackupSnapshot
)

class BackupFormatException(val reason: Reason) : Exception("Unreadable backup: $reason") {
    enum class Reason { NOT_A_BACKUP, NEWER_VERSION }
}
