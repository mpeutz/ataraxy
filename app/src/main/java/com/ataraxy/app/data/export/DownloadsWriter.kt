package com.ataraxy.app.data.export

import android.content.ContentValues
import android.content.Context
import android.os.Environment
import android.provider.MediaStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

interface DownloadsWriter {
    suspend fun writeText(fileName: String, text: String)
}

class MediaStoreDownloadsWriter @Inject constructor(
    @ApplicationContext private val context: Context
) : DownloadsWriter {

    override suspend fun writeText(fileName: String, text: String) = withContext(Dispatchers.IO) {
        val values = ContentValues().apply {
            put(MediaStore.Downloads.DISPLAY_NAME, fileName)
            put(MediaStore.Downloads.MIME_TYPE, "text/plain")
            put(MediaStore.Downloads.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
        }
        val resolver = context.contentResolver
        val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values)
            ?: throw IOException("Could not create $fileName in Downloads")
        try {
            val stream = resolver.openOutputStream(uri)
                ?: throw IOException("Could not open $fileName for writing")
            stream.use { it.write(text.toByteArray()) }
        } catch (e: Exception) {
            resolver.delete(uri, null, null)
            throw e
        }
    }
}
