package com.ataraxy.app.notifications

import com.ataraxy.app.R
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalTime

class ContemplationTitleTest {

    @Test
    fun titleFollowsTheScheduledTimeOfDay() {
        assertEquals(R.string.notification_title_morning, contemplationTitle(LocalTime.of(7, 0)))
        assertEquals(R.string.notification_title_morning, contemplationTitle(LocalTime.of(11, 59)))
        assertEquals(R.string.notification_title_afternoon, contemplationTitle(LocalTime.of(12, 0)))
        assertEquals(R.string.notification_title_afternoon, contemplationTitle(LocalTime.of(16, 59)))
        assertEquals(R.string.notification_title_evening, contemplationTitle(LocalTime.of(17, 0)))
        assertEquals(R.string.notification_title_evening, contemplationTitle(LocalTime.of(23, 30)))
        assertEquals(R.string.notification_title_evening, contemplationTitle(LocalTime.of(2, 0)))
    }
}
