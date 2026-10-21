package com.ataraxy.app.lock

/** Milliseconds since boot, including deep sleep; unaffected by changes to the phone's clock. */
fun interface ElapsedRealtime {
    fun millis(): Long
}
