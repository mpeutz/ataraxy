package com.ataraxy.app.notifications

import com.ataraxy.app.domain.model.UserPrefs

/** The two daily rituals. [name] matches the ritualType stored on journal entries. */
enum class RitualType(
    val notificationId: Int,
    val title: String,
    val body: String,
    val snoozeMinutes: Long,
    val snoozeLabel: String,
    val snoozeAction: String
) {
    MORNING(
        notificationId = 1002,
        title = "Morning Ritual",
        body = "Begin with intention. Your morning practice awaits.",
        snoozeMinutes = 30,
        snoozeLabel = "Remind in 30 min",
        snoozeAction = NotificationActionReceiver.ACTION_SNOOZE_MORNING
    ),
    EVENING(
        notificationId = 1003,
        title = "Evening Ritual",
        body = "Reflect before rest. Your evening practice awaits.",
        snoozeMinutes = 60,
        snoozeLabel = "Remind in 1 hour",
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
