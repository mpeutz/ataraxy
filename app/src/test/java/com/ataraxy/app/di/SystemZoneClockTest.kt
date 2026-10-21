package com.ataraxy.app.di

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.TimeZone

class SystemZoneClockTest {

    @Test
    fun providedClock_followsDefaultZoneChanges() {
        val original = TimeZone.getDefault()
        try {
            TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"))
            val clock = BackupModule.provideClock()

            TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"))

            val tokyo = ZoneId.of("Asia/Tokyo")
            assertEquals(tokyo, clock.zone)
            val drift = Duration.between(LocalDateTime.now(tokyo), LocalDateTime.now(clock)).abs()
            assertTrue("LocalDateTime.now(clock) is off by $drift", drift < Duration.ofMinutes(1))
        } finally {
            TimeZone.setDefault(original)
        }
    }
}
