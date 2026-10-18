package com.ataraxy.app.notifications

import androidx.annotation.StringRes
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.UserPrefs

/** The two daily rituals. [name] matches the ritualType stored on journal entries. */
enum class RitualType(
    val notificationId: Int,
    @StringRes val title: Int,
    @StringRes val body: Int,
    val snoozeMinutes: Long,
    @StringRes val snoozeLabel: Int,
    val snoozeAction: String
) {
    MORNING(
        notificationId = 1002,
        title = R.string.ritual_morning_title,
        body = R.string.ritual_morning_body,
        snoozeMinutes = 30,
        snoozeLabel = R.string.ritual_snooze_morning,
        snoozeAction = NotificationActionReceiver.ACTION_SNOOZE_MORNING
    ),
    EVENING(
        notificationId = 1003,
        title = R.string.ritual_evening_title,
        body = R.string.ritual_evening_body,
        snoozeMinutes = 60,
        snoozeLabel = R.string.ritual_snooze_evening,
        snoozeAction = NotificationActionReceiver.ACTION_SNOOZE_EVENING
    );

    fun isEnabled(prefs: UserPrefs): Boolean = when (this) {
        MORNING -> prefs.morningRitualEnabled
        EVENING -> prefs.eveningRitualEnabled
    }

    companion object {
        /** Accepts enum names and the lowercase values older snooze requests were queued with. */
        fun fromInput(value: String?): RitualType? =
            entries.firstOrNull { it.name.equals(value, ignoreCase = true) }
    }
}
