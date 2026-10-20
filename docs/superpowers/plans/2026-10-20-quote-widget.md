# Quote Widget Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** A resizable home-screen widget showing today's quote and author, in one of five color styles chosen on a setup screen, that opens the app on Home when tapped.

**Architecture:** Classic `AppWidgetProvider` + `RemoteViews` (not Glance: Glance can't draw a text shadow, which the Clear style needs, and can't use custom fonts anyway). Pure Kotlin decides the style's colors, layout and text size so it's unit-testable; a thin provider applies them to two XML layouts (card and clear). A per-widget style lives in a `widget_prefs` DataStore. A one-shot WorkManager job at the next local midnight plus time/zone-change receivers keeps the quote current; the app also refreshes the widget when the theme changes or a backup is restored. A Compose setup activity with a live preview picks the style when the widget is added and, on Android 12+, when it's reconfigured.

**Tech Stack:** Kotlin, `AppWidgetProvider`/`RemoteViews`, Compose Material 3 (setup screen), Hilt (`@AndroidEntryPoint` receivers), DataStore Preferences, WorkManager, Robolectric 4.17. No new dependencies.

**Spec:** `docs/superpowers/specs/2026-10-20-backup-lock-widget-lookback-privacy-design.md`, section 3.

## Global Constraints

- No `INTERNET` permission; no new dependencies; Room stays at version 3.
- The widget shows only today's quote (`QuoteRepository.getDailyQuote(LocalDate.now())`) and its author as `"— " + authorName.uppercase()`; never journal content. App Lock doesn't affect it.
- One layout: quote left-aligned, italic serif (`android:fontFamily="serif"`, `android:textStyle="italic"` — the app's Cormorant face can't be used in RemoteViews; say so in the PR), author underneath in small tracked caps (`android:letterSpacing="0.2"`, sans-serif-medium). No app-name label.
- Five styles, enum `WidgetStyle { MATCH_APP, LIGHT, DARK, CLEAR, ACCENT }`, default `MATCH_APP`:
  - `LIGHT`: background `#F5F0E8` (Cream), quote `#1A1814` (Ink), author `#5C5549` (InkMuted).
  - `DARK`: background `#1C1C1A` (Stone), quote `#F0EBE2` (OffWhite), author `#ABA49A` (OffWhiteMuted).
  - `MATCH_APP`: `LIGHT` or `DARK` from the app's `AppTheme` (SYSTEM follows the phone's night mode).
  - `CLEAR`: no background; quote `#FFFFFF`, author `#D9FFFFFF`; text shadow `#80000000`, radius 6, dy 1.
  - `ACCENT` (API 31+ only; hidden below): background `@android:color/system_accent2_100`, text `system_accent2_900` / `system_accent2_700`; in night mode background `system_accent2_800`, text `system_accent2_50` / `system_accent2_200` (via `-night-v31` resources, so it follows the phone).
- Card corner radius 20 dp, padding 16 dp horizontal × 14 dp vertical (mockup values).
- Sizes: `minWidth`/`minHeight` for 4×1, `minResizeHeight` for 4×1, `maxResizeHeight` for 4×3, `resizeMode="vertical|horizontal"`, `targetCellWidth="4" targetCellHeight="2"`; `widgetFeatures="reconfigurable"` (API 31+); `android:configure` set to the setup activity.
- Quote text size by widget height (dp): `< 110` → 14 sp, 2 lines max; `< 180` → 16 sp, 4 lines; otherwise 18 sp, 7 lines; then ellipsize at the end. Author 10 sp. These numbers live in `ui/theme/WidgetType.kt` so `TypographyGuardTest` holds.
- Tap anywhere: `PendingIntent` opening `MainActivity` with `ataraxy://home`.
- Per-widget style in a `widget_prefs` DataStore (key `style_<appWidgetId>`), deleted in `onDeleted`; never in `user_prefs`, so backups don't carry it.
- Before the database is seeded the widget shows the string `widget_empty` ("Open Ataraxy to begin.").
- All strings in `res/values/strings_widget.xml`, American English; Compose text via `AtaraxyText`.
- Gradle: run outside the sandbox with `JAVA_HOME` at Android Studio's `jbr` (`Android Studio1/jbr` if `Android Studio/jbr/lib/jvm.cfg` is missing), `TMP=TEMP=C:\tmp`, `JAVA_TOOL_OPTIONS="-Djdk.net.unixdomain.tmpdir=C:/tmp -Djava.io.tmpdir=C:/tmp"`. Devices: `adb -s emulator-5554` only.
- Branch `feat/quote-widget`, stacked on `feat/app-lock`, worktree `.claude/worktrees/widget`.

## Review Focus

1. **The database isn't seeded yet** (widget added right after install, before the app has run): shows "Open Ataraxy to begin.", then the quote after the next refresh. *Test in Task 2.*
2. **The phone switches dark mode while the widget is on screen**: MATCH_APP with theme SYSTEM and ACCENT both follow it without the app running. *Test in Task 1 (resolution) and checked on the emulator in Task 5.*
3. **The user cancels the setup screen**: the widget isn't added (result CANCELED) and no style is stored. *Test in Task 4.*
4. **The clock jumps past midnight or the time zone changes**: the quote updates and the midnight job is rescheduled for the new local midnight. *Test in Task 3.*
5. **A very long quote at the smallest size**: it ends with "…" rather than clipping mid-line. *Test in Task 1 (line limits) and checked on the emulator in Task 5.*

---

### Task 1: Style and sizing rules

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/widget/WidgetStyle.kt`
- Create: `app/src/main/java/com/ataraxy/app/widget/WidgetStyleStore.kt`
- Create: `app/src/main/java/com/ataraxy/app/ui/theme/WidgetType.kt`
- Create: `app/src/main/java/com/ataraxy/app/di/WidgetModule.kt` (`@WidgetPrefs` DataStore `widget_prefs`)
- Test: `app/src/test/java/com/ataraxy/app/widget/WidgetStyleTest.kt`, `WidgetStyleStoreTest.kt`

**Interfaces:**
- Produces:
  - `enum class WidgetStyle { MATCH_APP, LIGHT, DARK, CLEAR, ACCENT }` and `fun availableStyles(sdkInt: Int): List<WidgetStyle>` (ACCENT only when `sdkInt >= 31`).
  - `enum class WidgetLayout { CARD, CLEAR }` and `data class WidgetLook(val layout: WidgetLayout, @DrawableRes val background: Int?, @ColorRes val quoteColor: Int, @ColorRes val authorColor: Int)`.
  - `fun resolveLook(style: WidgetStyle, appTheme: AppTheme, systemDark: Boolean): WidgetLook` (resource ids point at `res/color/widget_*` and `res/drawable/widget_bg_*`, created here with the constraint colors).
  - `data class QuoteTextSpec(val sizeSp: Float, val maxLines: Int)` and `fun quoteTextSpec(heightDp: Int): QuoteTextSpec` using the `WidgetType` constants.
  - `class WidgetStyleStore @Inject constructor(@WidgetPrefs dataStore)`: `suspend fun get(id: Int): WidgetStyle` (default MATCH_APP), `suspend fun set(id: Int, style: WidgetStyle)`, `suspend fun remove(ids: IntArray)`.

- [ ] **Step 1: Write the failing tests**

```kotlin
@Test fun accentHiddenBelowAndroid12()                    // availableStyles(30) has no ACCENT; availableStyles(31) has it
@Test fun matchApp_followsAppTheme()                      // LIGHT theme -> light look even when systemDark; DARK -> dark look
@Test fun matchApp_systemTheme_followsPhone()             // SYSTEM + systemDark true -> dark look; false -> light
@Test fun clear_usesClearLayoutWithoutBackground()
@Test fun textSpec_shrinksWithHeight()                    // 90 -> 14sp/2; 150 -> 16sp/4; 250 -> 18sp/7
@Test fun store_defaultsToMatchApp_andRemovesDeleted()
```

- [ ] **Step 2–4:** fail (`./gradlew :app:testDebugUnitTest --tests "com.ataraxy.app.widget.*"`), implement, pass.
- [ ] **Step 5: Commit** — `git commit -m "Add the widget's color styles and text sizing"`

---

### Task 2: The widget itself

**Files:**
- Create: `app/src/main/res/layout/widget_quote_card.xml`, `widget_quote_clear.xml`
- Create: `app/src/main/res/xml/quote_widget_info.xml`, `app/src/main/res/values/strings_widget.xml`
- Create: `app/src/main/java/com/ataraxy/app/widget/QuoteWidgetProvider.kt` (`@AndroidEntryPoint`, uses `goAsync()` + a coroutine)
- Create: `app/src/main/java/com/ataraxy/app/widget/QuoteWidgetRenderer.kt`
- Modify: `app/src/main/AndroidManifest.xml` (receiver with `APPWIDGET_UPDATE` and `@xml/quote_widget_info`)
- Test: `app/src/test/java/com/ataraxy/app/widget/QuoteWidgetRendererTest.kt`

**Interfaces:**
- Consumes: Task 1 (`resolveLook`, `quoteTextSpec`, `WidgetStyleStore`), `QuoteRepository.getDailyQuote`, `UserPrefsRepository.userPrefs`.
- Produces:
  - `class QuoteWidgetRenderer @Inject constructor(@ApplicationContext context, quotes: QuoteRepository, prefs: UserPrefsRepository, styles: WidgetStyleStore)`: `suspend fun render(appWidgetId: Int, heightDp: Int): RemoteViews` and `suspend fun updateAll()` (renders every id from `AppWidgetManager.getAppWidgetIds` and pushes them).
  - `fun quoteWidgetIds(context: Context): IntArray`.
  - Strings: `widget_empty` "Open Ataraxy to begin.", `widget_description` "Today's Stoic quote", `widget_setup_title` "Choose a style", `widget_style_match_app` "Match app theme", `widget_style_light` "Light", `widget_style_dark` "Dark", `widget_style_clear` "Clear", `widget_style_accent` "Phone accent", `widget_setup_save` "ADD WIDGET", `widget_setup_save_reconfigure` "SAVE".

- [ ] **Step 1: Write the failing tests** (Robolectric; in-memory db seeded with one quote via the existing seeder or a direct insert; read texts back by applying the RemoteViews to a FrameLayout with `RemoteViews.apply`)

```kotlin
@Test fun showsTodaysQuoteAndAuthorInCaps()     // same quote getDailyQuote returns; author "— SENECA"
@Test fun beforeSeeding_showsOpenAtaraxy()      // empty db -> widget_empty text (Review Focus 1)
@Test fun clearStyle_usesClearLayout()
@Test fun smallHeight_limitsLinesAndEllipsizes() // TextView maxLines 2, ellipsize END (Review Focus 5)
@Test fun tap_opensHomeDeepLink()               // the root's PendingIntent targets MainActivity with data ataraxy://home
```

- [ ] **Step 2–4:** fail, implement, pass; `./gradlew :app:assembleDebug`.
- [ ] **Step 5: Commit** — `git commit -m "Add the daily quote home-screen widget"`

---

### Task 3: Keep it current

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/widget/WidgetRefresh.kt` (`MidnightWidgetWorker` `@HiltWorker`, `WidgetRefreshScheduler`, `TimeChangeReceiver` `@AndroidEntryPoint`)
- Modify: `QuoteWidgetProvider.kt` (`onEnabled` schedules, `onDisabled` cancels, `onDeleted` removes styles, `onAppWidgetOptionsChanged` re-renders that id)
- Modify: `app/src/main/AndroidManifest.xml` (TimeChangeReceiver for `android.intent.action.TIME_SET` and `android.intent.action.TIMEZONE_CHANGED`)
- Modify: `app/src/main/java/com/ataraxy/app/ui/settings/SettingsViewModel.kt` (`setTheme` → `renderer.updateAll()` after saving)
- Modify: `app/src/main/java/com/ataraxy/app/data/backup/RestoreBackup.kt` (`NotificationRescheduler.reschedule` also calls `renderer.updateAll()`)
- Test: `app/src/test/java/com/ataraxy/app/widget/WidgetRefreshTest.kt`

**Interfaces:**
- Produces: `internal fun delayUntilNextMidnight(now: ZonedDateTime): Duration` (to the next local 00:00:30 after `now`); `class WidgetRefreshScheduler @Inject constructor(@ApplicationContext context)`: `fun scheduleNext()` (unique one-time work `"quote_widget_midnight"`, `REPLACE`), `fun cancel()`. The worker calls `renderer.updateAll()` then `scheduleNext()` and returns success.

- [ ] **Step 1: Write the failing tests**

```kotlin
@Test fun delay_isToJustAfterNextLocalMidnight()   // 23:59:00 -> 90 s; 00:00:10 -> 20 s; 00:00:30 -> 24 h
@Test fun delay_honorsDstDay()                      // a spring-forward date in America/New_York
@Test fun scheduleNext_replacesPendingWork()        // WorkManagerTestInitHelper: one ENQUEUED work with the unique name
@Test fun timeZoneChange_rerendersAndReschedules()  // send TIMEZONE_CHANGED to the receiver with a fake renderer/scheduler: both called (Review Focus 4)
```

- [ ] **Step 2–4:** fail, implement, pass.
- [ ] **Step 5: Commit** — `git commit -m "Refresh the widget at midnight, on clock changes, theme changes and restores"`

---

### Task 4: Setup screen

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/widget/QuoteWidgetConfigureActivity.kt` (`@AndroidEntryPoint` `ComponentActivity`)
- Create: `app/src/main/java/com/ataraxy/app/widget/WidgetSetupViewModel.kt`, `WidgetSetupScreen.kt`
- Modify: `app/src/main/AndroidManifest.xml` (activity with `APPWIDGET_CONFIGURE`, `exported="true"`), `quote_widget_info.xml` (`android:configure`)
- Test: `app/src/test/java/com/ataraxy/app/widget/WidgetSetupViewModelTest.kt`

**Interfaces:**
- Consumes: `availableStyles`, `resolveLook`, `WidgetStyleStore`, `QuoteWidgetRenderer`.
- Produces: `WidgetSetupViewModel`: `val styles: List<WidgetStyle>` (from `Build.VERSION.SDK_INT`), `val selected: StateFlow<WidgetStyle>` (stored style or MATCH_APP), `fun select(style)`, `suspend fun save(appWidgetId: Int)` (stores, then `renderer.updateAll()`).

The activity sets `RESULT_CANCELED` first (so backing out doesn't add the widget), reads `EXTRA_APPWIDGET_ID` (finishes if invalid), shows the style list with a Compose preview of the widget using the resolved colors and today's quote, and on Save stores the style, updates the widget, sets `RESULT_OK` with the id and finishes. The button reads `widget_setup_save_reconfigure` when a style is already stored for that id.

- [ ] **Step 1: Write the failing tests**

```kotlin
@Test fun defaultsToMatchApp_andListsAccentOnlyOn31()
@Test fun select_thenSave_storesStyleForThatWidget()
@Test fun reopening_showsTheStoredStyle()
@Test fun cancel_storesNothing()                    // no save -> store.get(id) still MATCH_APP and no key written (Review Focus 3)
```

- [ ] **Step 2–4:** fail, implement, pass; also `TypographyGuardTest` and `:app:lintDebug`.
- [ ] **Step 5: Commit** — `git commit -m "Let people pick the widget's style when adding it"`

---

### Task 5: Verify on the emulator and open the PR

- [ ] **Step 1:** `./gradlew assembleDebug testDebugUnitTest :app:lintDebug assembleRelease` — BUILD SUCCESSFUL; schemas unchanged.
- [ ] **Step 2:** On `emulator-5554` (API 36): add the widget from the launcher (long-press home › Widgets › Ataraxy), check the setup screen lists five styles with a live preview; add one of each style; screenshot each. Resize one from 4×1 to 4×3: text grows; a long quote at 4×1 ends with "…". Toggle dark mode (`cmd uimode night yes/no`): MATCH_APP (theme System) and Phone accent follow. Change the app theme to Dark in Settings: MATCH_APP widgets switch. Long-press › reconfigure: setup opens with the current style. Tap a widget: app opens on Home. Set the time to 23:59:30 (`cmd alarm set-time`), wait 2 min: the quote changes. Restore a backup: widgets refresh. Cancel the setup screen: no widget added.
- [ ] **Step 3:** Push and open a PR into `feat/app-lock` (or whatever it has merged into) — only with the user's go-ahead.
