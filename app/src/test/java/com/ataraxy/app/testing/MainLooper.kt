package com.ataraxy.app.testing

import android.os.Looper
import org.robolectric.Shadows.shadowOf

/** Runs the Robolectric main looper until [condition] holds, failing after [timeoutMs]. */
fun awaitMain(timeoutMs: Long = 5_000, condition: () -> Boolean) {
    val deadline = System.currentTimeMillis() + timeoutMs
    while (!condition()) {
        check(System.currentTimeMillis() < deadline) { "Condition not met within ${timeoutMs}ms" }
        shadowOf(Looper.getMainLooper()).idle()
        Thread.sleep(10)
    }
}

/** Keeps the main looper running for [millis] so background emissions can land. */
fun settleMain(millis: Long = 300) {
    val end = System.currentTimeMillis() + millis
    while (System.currentTimeMillis() < end) {
        shadowOf(Looper.getMainLooper()).idle()
        Thread.sleep(10)
    }
}
