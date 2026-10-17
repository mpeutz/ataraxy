package com.ataraxy.app.domain.model

import java.time.LocalTime

data class UserPrefs(
    val notificationTime: LocalTime = LocalTime.of(7, 0),
    val theme: AppTheme = AppTheme.SYSTEM,
    val contentTextSize: ContentTextSize = ContentTextSize.DEFAULT,
    val notificationStyle: NotificationStyle = NotificationStyle.MINIMALIST,
    val streakCount: Int = 0,
    val lastOpenedDate: String = "",
    val notificationsEnabled: Boolean = true,
    val onboardingComplete: Boolean = false,
    val birthYear: Int? = null,
    val morningRitualStreak: Int = 0,
    val lastMorningRitualDate: String = "",
    val eveningRitualStreak: Int = 0,
    val lastEveningRitualDate: String = "",
    val morningRitualEnabled: Boolean = true,
    val morningRitualTime: LocalTime = LocalTime.of(7, 0),
    val eveningRitualEnabled: Boolean = true,
    val eveningRitualTime: LocalTime = LocalTime.of(21, 0)
)
