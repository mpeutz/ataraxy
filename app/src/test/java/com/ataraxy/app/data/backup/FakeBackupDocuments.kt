package com.ataraxy.app.data.backup

class FakeBackupDocuments : BackupDocuments {
    val files = mutableMapOf<String, String>()
    var failWith: Exception? = null
    var failReadWith: Exception? = null
    var writeCount = 0
        private set

    override suspend fun read(uri: String): String {
        failReadWith?.let { throw it }
        failWith?.let { throw it }
        return files[uri] ?: throw java.io.FileNotFoundException(uri)
    }

    override suspend fun write(uri: String, text: String) {
        failWith?.let { throw it }
        files[uri] = text
        writeCount++
    }

    override fun displayName(uri: String): String? = uri.substringAfterLast('/')

    override fun persist(uri: String): Boolean = true

    override fun release(uri: String) = Unit
}
