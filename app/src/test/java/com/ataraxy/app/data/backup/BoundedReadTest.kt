package com.ataraxy.app.data.backup

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.ByteArrayInputStream

class BoundedReadTest {

    @Test
    fun backupReadCap_isTenMegabytes() {
        assertEquals(10 * 1024 * 1024, MAX_BACKUP_BYTES)
    }

    @Test
    fun readCappedText_atLimit_returnsText() {
        val text = "é".repeat(8)

        assertEquals(text, ByteArrayInputStream(text.toByteArray()).readCappedText(maxBytes = 16))
    }

    @Test
    fun readCappedText_overLimit_throws() {
        val stream = ByteArrayInputStream(ByteArray(17) { 'a'.code.toByte() })

        assertThrows(BackupTooLargeException::class.java) { stream.readCappedText(maxBytes = 16) }
    }

    @Test
    fun readCappedText_doesNotReadFarPastLimit() {
        var read = 0
        val endless = object : java.io.InputStream() {
            override fun read(): Int = 'a'.code.also { read++ }
            override fun read(b: ByteArray, off: Int, len: Int): Int {
                b.fill('a'.code.toByte(), off, off + len)
                read += len
                return len
            }
        }

        assertThrows(BackupTooLargeException::class.java) { endless.readCappedText(maxBytes = 1024) }
        assertTrue(read <= 1024 + 8192)
    }
}
