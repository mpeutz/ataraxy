package com.ataraxy.app.data.backup

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject
import javax.inject.Singleton

/** Keeps automatic backup runs, target changes and restores from interleaving. Not reentrant. */
@Singleton
class BackupLock @Inject constructor() {
    private val mutex = Mutex()

    suspend fun <T> withLock(block: suspend () -> T): T = mutex.withLock { block() }
}
