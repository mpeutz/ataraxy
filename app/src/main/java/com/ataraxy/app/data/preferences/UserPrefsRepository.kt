package com.ataraxy.app.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.domain.model.ContentTextSize
import com.ataraxy.app.domain.model.NotificationStyle
import com.ataraxy.app.domain.model.UserPrefs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.time.LocalTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPrefsRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private object Keys {
        val NOTIFICATION_HOUR = intPreferencesKey("notification_hour")
        val NOTIFICATION_MINUTE = intPreferencesKey("notification_minute")
        val THEME = stringPreferencesKey("theme")
        val CONTENT_TEXT_SIZE = stringPreferencesKey("content_text_size")
        val NOTIFICATION_STYLE = stringPreferencesKey("notification_style")
        val STREAK_COUNT = intPreferencesKey("streak_count")
        val LAST_OPENED_DATE = stringPreferencesKey("last_opened_date")
        val NOTIFICATIONS_ENABLED = booleanPreferencesKey("notifications_enabled")
        val ONBOARDING_COMPLETE = booleanPreferencesKey("onboarding_complete")
        val BIRTH_YEAR = intPreferencesKey("birth_year")
        val MORNING_RITUAL_STREAK = intPreferencesKey("morning_ritual_streak")
        val LAST_MORNING_RITUAL_DATE = stringPreferencesKey("last_morning_ritual_date")
        val EVENING_RITUAL_STREAK = intPreferencesKey("evening_ritual_streak")
        val LAST_EVENING_RITUAL_DATE = stringPreferencesKey("last_evening_ritual_date")
        val MORNING_RITUAL_ENABLED = booleanPreferencesKey("morning_ritual_enabled")
        val MORNING_RITUAL_HOUR = intPreferencesKey("morning_ritual_hour")
        val MORNING_RITUAL_MINUTE = intPreferencesKey("morning_ritual_minute")
        val EVENING_RITUAL_ENABLED = booleanPreferencesKey("evening_ritual_enabled")
        val EVENING_RITUAL_HOUR = intPreferencesKey("evening_ritual_hour")
        val EVENING_RITUAL_MINUTE = intPreferencesKey("evening_ritual_minute")
    }

    val userPrefs: Flow<UserPrefs> = dataStore.data.map { prefs ->
        val birthYearRaw = prefs[Keys.BIRTH_YEAR] ?: -1
        UserPrefs(
            notificationTime = LocalTime.of(
                prefs[Keys.NOTIFICATION_HOUR] ?: 7,
                prefs[Keys.NOTIFICATION_MINUTE] ?: 0
            ),
            theme = runCatching {
                AppTheme.valueOf(prefs[Keys.THEME] ?: AppTheme.SYSTEM.name)
            }.getOrDefault(AppTheme.SYSTEM),
            contentTextSize = runCatching {
                ContentTextSize.valueOf(prefs[Keys.CONTENT_TEXT_SIZE] ?: ContentTextSize.DEFAULT.name)
            }.getOrDefault(ContentTextSize.DEFAULT),
            notificationStyle = runCatching {
                NotificationStyle.valueOf(prefs[Keys.NOTIFICATION_STYLE] ?: NotificationStyle.MINIMALIST.name)
            }.getOrDefault(NotificationStyle.MINIMALIST),
            streakCount = prefs[Keys.STREAK_COUNT] ?: 0,
            lastOpenedDate = prefs[Keys.LAST_OPENED_DATE] ?: "",
            notificationsEnabled = prefs[Keys.NOTIFICATIONS_ENABLED] ?: true,
            onboardingComplete = prefs[Keys.ONBOARDING_COMPLETE] ?: false,
            birthYear = if (birthYearRaw == -1) null else birthYearRaw,
            morningRitualStreak = prefs[Keys.MORNING_RITUAL_STREAK] ?: 0,
            lastMorningRitualDate = prefs[Keys.LAST_MORNING_RITUAL_DATE] ?: "",
            eveningRitualStreak = prefs[Keys.EVENING_RITUAL_STREAK] ?: 0,
            lastEveningRitualDate = prefs[Keys.LAST_EVENING_RITUAL_DATE] ?: "",
            morningRitualEnabled = prefs[Keys.MORNING_RITUAL_ENABLED] ?: true,
            morningRitualTime = LocalTime.of(
                prefs[Keys.MORNING_RITUAL_HOUR] ?: 7,
                prefs[Keys.MORNING_RITUAL_MINUTE] ?: 0
            ),
            eveningRitualEnabled = prefs[Keys.EVENING_RITUAL_ENABLED] ?: true,
            eveningRitualTime = LocalTime.of(
                prefs[Keys.EVENING_RITUAL_HOUR] ?: 21,
                prefs[Keys.EVENING_RITUAL_MINUTE] ?: 0
            )
        )
    }.catch { emit(UserPrefs()) }

    suspend fun setNotificationTime(time: LocalTime) {
        dataStore.edit { prefs ->
            prefs[Keys.NOTIFICATION_HOUR] = time.hour
            prefs[Keys.NOTIFICATION_MINUTE] = time.minute
        }
    }

    suspend fun setTheme(theme: AppTheme) {
        dataStore.edit { prefs ->
            prefs[Keys.THEME] = theme.name
        }
    }

    suspend fun setContentTextSize(size: ContentTextSize) {
        dataStore.edit { prefs ->
            prefs[Keys.CONTENT_TEXT_SIZE] = size.name
        }
    }

    suspend fun setNotificationStyle(style: NotificationStyle) {
        dataStore.edit { prefs ->
            prefs[Keys.NOTIFICATION_STYLE] = style.name
        }
    }

    suspend fun updateStreak(today: String) {
        dataStore.edit { prefs ->
            val last = prefs[Keys.LAST_OPENED_DATE] ?: ""
            val streak = prefs[Keys.STREAK_COUNT] ?: 0

            val newStreak = when {
                last.isEmpty() -> 1
                last == today -> streak
                else -> {
                    try {
                        val lastDate = java.time.LocalDate.parse(last)
                        val todayDate = java.time.LocalDate.parse(today)
                        val diff = java.time.temporal.ChronoUnit.DAYS.between(lastDate, todayDate)
                        if (diff == 1L) streak + 1 else 1
                    } catch (e: Exception) {
                        1
                    }
                }
            }

            prefs[Keys.STREAK_COUNT] = newStreak
            prefs[Keys.LAST_OPENED_DATE] = today
        }
    }

    suspend fun setNotificationsEnabled(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[Keys.NOTIFICATIONS_ENABLED] = enabled
        }
    }

    suspend fun setOnboardingComplete(complete: Boolean) {
        dataStore.edit { prefs ->
            prefs[Keys.ONBOARDING_COMPLETE] = complete
        }
    }

    suspend fun setBirthYear(year: Int) {
        dataStore.edit { prefs ->
            prefs[Keys.BIRTH_YEAR] = year
        }
    }

    suspend fun updateMorningRitualStreak(today: String) {
        dataStore.edit { prefs ->
            val last = prefs[Keys.LAST_MORNING_RITUAL_DATE] ?: ""
            val streak = prefs[Keys.MORNING_RITUAL_STREAK] ?: 0
            val newStreak = when {
                last.isEmpty() -> 1
                last == today -> streak
                else -> {
                    try {
                        val lastDate = java.time.LocalDate.parse(last)
                        val todayDate = java.time.LocalDate.parse(today)
                        val diff = java.time.temporal.ChronoUnit.DAYS.between(lastDate, todayDate)
                        if (diff == 1L) streak + 1 else 1
                    } catch (e: Exception) { 1 }
                }
            }
            prefs[Keys.MORNING_RITUAL_STREAK] = newStreak
            prefs[Keys.LAST_MORNING_RITUAL_DATE] = today
        }
    }

    suspend fun updateEveningRitualStreak(today: String) {
        dataStore.edit { prefs ->
            val last = prefs[Keys.LAST_EVENING_RITUAL_DATE] ?: ""
            val streak = prefs[Keys.EVENING_RITUAL_STREAK] ?: 0
            val newStreak = when {
                last.isEmpty() -> 1
                last == today -> streak
                else -> {
                    try {
                        val lastDate = java.time.LocalDate.parse(last)
                        val todayDate = java.time.LocalDate.parse(today)
                        val diff = java.time.temporal.ChronoUnit.DAYS.between(lastDate, todayDate)
                        if (diff == 1L) streak + 1 else 1
                    } catch (e: Exception) { 1 }
                }
            }
            prefs[Keys.EVENING_RITUAL_STREAK] = newStreak
            prefs[Keys.LAST_EVENING_RITUAL_DATE] = today
        }
    }

    suspend fun setMorningRitualEnabled(enabled: Boolean) {
        dataStore.edit { prefs -> prefs[Keys.MORNING_RITUAL_ENABLED] = enabled }
    }

    suspend fun setMorningRitualTime(time: LocalTime) {
        dataStore.edit { prefs ->
            prefs[Keys.MORNING_RITUAL_HOUR] = time.hour
            prefs[Keys.MORNING_RITUAL_MINUTE] = time.minute
        }
    }

    suspend fun setEveningRitualEnabled(enabled: Boolean) {
        dataStore.edit { prefs -> prefs[Keys.EVENING_RITUAL_ENABLED] = enabled }
    }

    suspend fun setEveningRitualTime(time: LocalTime) {
        dataStore.edit { prefs ->
            prefs[Keys.EVENING_RITUAL_HOUR] = time.hour
            prefs[Keys.EVENING_RITUAL_MINUTE] = time.minute
        }
    }

    suspend fun clearAll() {
        dataStore.edit { it.clear() }
    }
}
