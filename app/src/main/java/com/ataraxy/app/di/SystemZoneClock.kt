package com.ataraxy.app.di

import java.time.Clock
import java.time.Instant
import java.time.ZoneId

/** The system clock in whatever zone the device is in now, so a zone change is picked up without a restart. */
class SystemZoneClock : Clock() {
    override fun getZone(): ZoneId = ZoneId.systemDefault()

    override fun withZone(zone: ZoneId): Clock = system(zone)

    override fun instant(): Instant = Instant.now()

    override fun millis(): Long = System.currentTimeMillis()

    override fun equals(other: Any?): Boolean = other is SystemZoneClock

    override fun hashCode(): Int = SystemZoneClock::class.hashCode()

    override fun toString(): String = "SystemZoneClock[${ZoneId.systemDefault()}]"
}
