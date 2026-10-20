package com.ataraxy.app.lock

import java.time.Duration

/** A monotonic ticker that only moves when a test advances it. */
class FakeElapsedRealtime : ElapsedRealtime {
    private var now = 1_000_000L

    fun advance(by: Duration) {
        now += by.toMillis()
    }

    override fun millis(): Long = now
}
