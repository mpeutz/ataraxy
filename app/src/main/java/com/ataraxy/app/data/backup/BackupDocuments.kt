package com.ataraxy.app.data.backup

import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.OpenableColumns
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.InputStream
import javax.inject.Inject

/** Far beyond any real journal; keeps a wrong file from exhausting memory. */
const val MAX_BACKUP_BYTES = 50 * 1024 * 1024

class BackupTooLargeException : Exception("Backup file is larger than $MAX_BACKUP_BYTES bytes")

interface BackupDocuments {
    suspend fun read(uri: String): String
    suspend fun write(uri: String, text: String)
    fun displayName(uri: String): String?

    /** Takes read and write persistable permission; false if write access cannot be kept. */
    fun persist(uri: String): Boolean
    fun release(uri: String)
}

class ContentResolverBackupDocuments @Inject constructor(
    @ApplicationContext context: Context
) : BackupDocuments {

    private val resolver: ContentResolver = context.contentResolver

    override suspend fun read(uri: String): String = withContext(Dispatchers.IO) {
        val stream = resolver.openInputStream(Uri.parse(uri)) ?: throw FileNotFoundException(uri)
        stream.use { it.readCappedText(MAX_BACKUP_BYTES) }
    }

    override suspend fun write(uri: String, text: String) = withContext(Dispatchers.IO) {
        val stream = resolver.openOutputStream(Uri.parse(uri), "wt") ?: throw FileNotFoundException(uri)
        stream.use { it.write(text.toByteArray(Charsets.UTF_8)) }
    }

    override fun displayName(uri: String): String? = try {
        resolver.query(Uri.parse(uri), arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) cursor.getString(0) else null
        }
    } catch (e: Exception) {
        null
    }

    override fun persist(uri: String): Boolean = try {
        resolver.takePersistableUriPermission(Uri.parse(uri), READ_WRITE)
        true
    } catch (e: SecurityException) {
        false
    }

    override fun release(uri: String) {
        try {
            resolver.releasePersistableUriPermission(Uri.parse(uri), READ_WRITE)
        } catch (e: SecurityException) {
            // Permission was already gone.
        }
    }

    private companion object {
        const val READ_WRITE = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
    }
}

/** Reads the stream as UTF-8, throwing [BackupTooLargeException] once it passes [maxBytes]. */
internal fun InputStream.readCappedText(maxBytes: Int): String {
    val out = ByteArrayOutputStream()
    val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
    while (true) {
        val count = read(buffer)
        if (count < 0) break
        if (out.size() + count > maxBytes) throw BackupTooLargeException()
        out.write(buffer, 0, count)
    }
    return out.toString(Charsets.UTF_8.name())
}
