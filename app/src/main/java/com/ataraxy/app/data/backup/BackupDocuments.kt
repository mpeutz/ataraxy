package com.ataraxy.app.data.backup

import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.OpenableColumns
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.FileNotFoundException
import javax.inject.Inject

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
        stream.use { it.readBytes().toString(Charsets.UTF_8) }
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
