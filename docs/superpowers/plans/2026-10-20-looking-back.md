# Looking Back Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** A quiet "From your journal" card on Home that resurfaces one past entry a day (a year ago, a month ago, or an older one), a read-only entry view behind App Lock, and two-week check-ins on open What's Yours reflections.

**Architecture:** Pure functions pick the day's look-back session and decide when a reflection's check-in is due, so the rules are unit-tested without Android. Home's view model combines the journal, the date and App Lock's `enabled` flag into a small card state. A new locked `entry/{entryId}` route shows one entry (or a whole ritual session) read-only, with Edit links into the existing editor. What's Yours shows a marker on due reflections and a prompt on the detail page; "Still carrying it" adds a dated note, which resets the two-week clock. No schema change.

**Tech Stack:** Kotlin, Compose Material 3, Hilt, Room (version 3, unchanged), JUnit 4 + Robolectric 4.17.

**Spec:** `docs/superpowers/specs/2026-10-20-backup-lock-widget-lookback-privacy-design.md`, section 4.

## Global Constraints

- No `INTERNET` permission; no new dependencies; Room stays at version 3 (no new columns).
- Which entries count: every row in `journal_entries` (Practice reflections and morning/evening ritual answers). A **session** is either one Practice entry (`ritualType == null`) or all entries with the same non-null `ritualType` and the same `createdAt`, ordered by id; its date is `createdAt.toLocalDate()`, its representative is its first entry.
- Eligible sessions: date ≤ today minus 30 days. No eligible session → no card.
- Pick order: a session dated exactly `today.minusYears(1)` (kind YEAR); else exactly `today.minusMonths(1)` (kind MONTH); else one older eligible session (kind OLDER) chosen by `Math.floorMod(today.toEpochDay(), n)` over eligible sessions sorted by `createdAt` ascending (stable within a day, changes daily). If several sessions match YEAR or MONTH, take the earliest by `createdAt`.
- Card copy (in `res/values/strings.xml`), eyebrow `home_lookback_eyebrow` "FROM YOUR JOURNAL":
  - YEAR: `home_lookback_year` "A year ago today, you wrote"
  - MONTH: `home_lookback_month` "A month ago today, you wrote"
  - OLDER: `home_lookback_older` "On %1$s, you wrote" (date `FormatStyle.LONG`, device locale)
  - With App Lock on (`AppLock.enabled`, not `isUnlocked`): `home_lookback_locked_year` "You wrote something a year ago today", `home_lookback_locked_month` "You wrote something a month ago today", `home_lookback_locked_older` "You wrote something on %1$s" — and no prompt or entry text at all.
  - Unlocked: the representative's prompt (if not blank) and its content limited to 2 lines with ellipsis.
- Tapping the card opens `entry/{representativeId}`. The route is added to `LOCKED_ROUTES`, so the existing gate asks for the unlock.
- Read-only entry view: top bar title `entry_title` "ENTRY"; the session's date (`FormatStyle.LONG`); for each entry in the session its prompt and full content, each with an `EDIT` link (existing `journal_edit` string) to `practice/edit/{id}`; for a Practice entry with `linkedQuoteId`, the quote text and "— AUTHOR" below. If the entry no longer exists, show `entry_missing` "This entry is no longer in your journal." and a Back action.
- Check-in due: the reflection is open (`setDownAt == null`), finished (`completedAt != null`), and `now ≥ lastTouch + 14 days`, where `lastTouch = max(createdAt, newest note's createdAt)`.
- Check-in copy (in `strings_whats_yours.xml`): prompt `whats_yours_checkin_prompt` "Two weeks on, does this still weigh on you?"; actions `whats_yours_checkin_set_down` "SET IT DOWN" (existing set-down behavior) and `whats_yours_checkin_carry` "STILL CARRYING IT" (adds a note with text `whats_yours_checkin_note` "Still carrying this." dated now); list marker `whats_yours_checkin_marker` "Two weeks on". In-app only; no notification.
- No changes to Journal's list.
- Text only through `AtaraxyText` roles (`TypographyGuardTest`); colors from the theme; American English.
- Gradle: run outside the sandbox with `JAVA_HOME` at Android Studio's `jbr` (`Android Studio1/jbr` if `Android Studio/jbr/lib/jvm.cfg` is missing), `TMP=TEMP=C:\tmp`, `JAVA_TOOL_OPTIONS="-Djdk.net.unixdomain.tmpdir=C:/tmp -Djava.io.tmpdir=C:/tmp"`. Devices: `adb -s emulator-5554` only.
- Branch `feat/looking-back` from `origin/feat/backup-restore` (which holds backup + App Lock), worktree `.claude/worktrees/looking-back`.

## Review Focus

1. **App Lock on but already unlocked this session**: the Home card still shows only the date line (it reads `enabled`, not `isUnlocked`), and tapping still goes through the gate. *Test in Task 3.*
2. **Today is Feb 29 or the 31st** (no exact month/year match day): `minusYears`/`minusMonths` clamp (Feb 28, Apr 30) and the pick is still stable. *Test in Task 1.*
3. **The picked entry is deleted or edited while Home is showing**: the card updates or disappears; the entry view shows the "no longer in your journal" state instead of crashing. *Tests in Tasks 2 and 3.*
4. **A reflection with a note added today by the user** (not via "Still carrying it"): no check-in for two weeks from that note. *Test in Task 1.*
5. **Midnight passes while Home is open**: the card's pick follows the new date the next time Home becomes visible. *Test in Task 3.*

---

### Task 1: The rules

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/lookback/LookBack.kt`
- Test: `app/src/test/java/com/ataraxy/app/lookback/LookBackTest.kt`, `CheckInTest.kt`

**Interfaces:**
- Produces:
  - `data class JournalSession(val entries: List<JournalEntry>)` with `val date: LocalDate`, `val representative: JournalEntry`
  - `fun sessionsOf(entries: List<JournalEntry>): List<JournalSession>` (grouping per the constraints)
  - `enum class LookBackKind { YEAR, MONTH, OLDER }` and `data class LookBackPick(val session: JournalSession, val kind: LookBackKind)`
  - `fun pickLookBack(entries: List<JournalEntry>, today: LocalDate): LookBackPick?`
  - `fun isCheckInDue(reflection: Reflection, now: LocalDateTime): Boolean` and `const val CHECK_IN_DAYS = 14L`, `const val LOOKBACK_MIN_DAYS = 30L`

- [ ] **Step 1: Write the failing tests**

```kotlin
@Test fun noEntriesOlderThan30Days_noPick()
@Test fun exactYear_beatsMonthAndOlder()
@Test fun exactMonth_whenNoYear()
@Test fun older_isStableWithinADay_andChangesAcrossDays()     // same pick for two calls on one date; differs for at least one of the next 7 days when 3+ eligible
@Test fun ritualSession_isOnePick_withFirstAnswerAsRepresentative()
@Test fun leapDayAndMonthEnd_clamp()                          // today 2028-02-29 picks an entry dated 2027-02-28 as YEAR; today 2026-03-31 picks 2026-02-28 as MONTH
@Test fun checkIn_dueAfter14DaysForFinishedOpenReflection()
@Test fun checkIn_notForUnfinishedOrSetDown()
@Test fun checkIn_aNewNoteResetsTheClock()                    // Review Focus 4
```

- [ ] **Step 2–4:** fail (`./gradlew :app:testDebugUnitTest --tests "com.ataraxy.app.lookback.*"`), implement, pass.
- [ ] **Step 5: Commit** — `git commit -m "Add the rules for looking back and check-ins"`

---

### Task 2: Read-only entry view

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/ui/entry/EntryScreen.kt`, `EntryViewModel.kt`
- Modify: `app/src/main/java/com/ataraxy/app/ui/navigation/Screen.kt` (`data class Entry(val entryId: Long)` with `ROUTE = "entry/{entryId}"`), `AtaraxyNavHost.kt` (destination + add `Screen.Entry.ROUTE` to `LOCKED_ROUTES`)
- Modify: `app/src/test/java/com/ataraxy/app/ui/lock/LockedRouteTest.kt` (the locked-routes set test now expects six routes)
- Modify: `app/src/main/res/values/strings.xml`
- Test: `app/src/test/java/com/ataraxy/app/ui/entry/EntryViewModelTest.kt`

**Interfaces:**
- Consumes: `sessionsOf` (Task 1), `JournalRepository.getAllEntries()`, `QuoteRepository.getQuoteById(id)`.
- Produces: `EntryViewModel` (`SavedStateHandle` key `entryId`): `val state: StateFlow<EntryUiState>` with `sealed interface EntryUiState { Loading; Missing; data class Shown(val session: JournalSession, val quote: Quote?) }`.

- [ ] **Step 1: Write the failing tests** (in-memory db, real repositories)

```kotlin
@Test fun practiceEntry_showsItAndItsLinkedQuote()
@Test fun ritualAnswer_showsTheWholeSessionInOrder()
@Test fun deletedEntry_showsMissing()                  // Review Focus 3
@Test fun lockedRoutes_includeTheEntryView()           // update LockedRouteTest's set assertion to six routes
```

- [ ] **Step 2–4:** fail, implement, pass; `TypographyGuardTest` and `:app:assembleDebug`.
- [ ] **Step 5: Commit** — `git commit -m "Add a read-only view for a past journal entry"`

---

### Task 3: "From your journal" on Home

**Files:**
- Modify: `app/src/main/java/com/ataraxy/app/ui/home/HomeViewModel.kt`, `HomeScreen.kt`, `AtaraxyNavHost.kt` (Home's `onOpenEntry` navigates to `Screen.Entry(id).route`)
- Modify: `app/src/main/res/values/strings.xml`
- Test: `app/src/test/java/com/ataraxy/app/ui/home/HomeViewModelTest.kt` (create)

**Interfaces:**
- Consumes: `pickLookBack` (Task 1), `AppLock.enabled`, `JournalRepository.getAllEntries()`.
- Produces: `data class LookBackCard(val kind: LookBackKind, val date: LocalDate, val prompt: String?, val excerpt: String?, val entryId: Long)` (prompt and excerpt null when locked); `HomeViewModel.lookBack: StateFlow<LookBackCard?>`; `fun onResume(today: LocalDate = LocalDate.now(clock))` that re-picks when the date changed (Review Focus 5). Inject `Clock` (already bound).

The card sits below the daily quote's actions, uses the existing card surface style, and is not shown when `lookBack` is null.

- [ ] **Step 1: Write the failing tests** (in-memory db, real AppLock on a temp DataStore with a fake authenticator reporting a secure device)

```kotlin
@Test fun noOldEntries_noCard()
@Test fun yearAgoEntry_showsYearCardWithExcerpt()
@Test fun lockOn_hidesPromptAndExcerpt_evenWhenUnlocked()   // Review Focus 1
@Test fun pickedEntryDeleted_cardUpdates()                  // Review Focus 3
@Test fun onResume_nextDay_repicks()                        // Review Focus 5
```

- [ ] **Step 2–4:** fail, implement, pass; `TypographyGuardTest`.
- [ ] **Step 5: Commit** — `git commit -m "Show one past entry a day on Home"`

---

### Task 4: Check-ins on What's Yours

**Files:**
- Modify: `app/src/main/java/com/ataraxy/app/ui/practices/whatsyours/WhatsYoursViewModel.kt`, `WhatsYoursScreen.kt` (marker on due open reflections), `ReflectionDetailViewModel.kt`, `ReflectionDetailScreen.kt` (prompt card at the top with the two actions)
- Modify: `app/src/main/res/values/strings_whats_yours.xml`
- Test: `app/src/test/java/com/ataraxy/app/ui/practices/whatsyours/CheckInViewModelTest.kt` (or extend the existing view model tests)

**Interfaces:**
- Consumes: `isCheckInDue` (Task 1), `ReflectionRepository.addNote/setDown`, `Clock`.
- Produces: `WhatsYoursUiState.dueIds: Set<Long>`; `ReflectionDetailUiState.checkInDue: Boolean`; `ReflectionDetailViewModel.stillCarrying(noteText: String)` (adds the note dated `now`) — the screen passes `stringResource(R.string.whats_yours_checkin_note)`.

- [ ] **Step 1: Write the failing tests**

```kotlin
@Test fun dueReflection_isMarkedInTheList()
@Test fun detail_showsCheckInWhenDue()
@Test fun stillCarrying_addsNote_andHidesCheckInForTwoWeeks()
@Test fun setItDown_movesToPast()
```

- [ ] **Step 2–4:** fail, implement, pass; `TypographyGuardTest`.
- [ ] **Step 5: Commit** — `git commit -m "Ask about a worry again after two weeks"`

---

### Task 5: Verify on the emulator and open the PR

- [ ] **Step 1:** `./gradlew assembleDebug testDebugUnitTest :app:lintDebug assembleRelease` — BUILD SUCCESSFUL; `app/schemas` unchanged.
- [ ] **Step 2:** On `emulator-5554`, seed old data by setting the device date back (`cmd alarm set-time`), writing a Practice reflection, an evening ritual and a What's Yours reflection, then returning to today (or restore a backup file crafted with old `createdAt` values). Check: the Home card for YEAR, MONTH and OLDER; stable across app restarts on one day; tapping opens the read-only view (a ritual shows all answers); Edit opens the editor; App Lock on hides the text and asks before the view opens; the check-in marker and prompt appear on a two-week-old reflection; "Still carrying it" adds the note and hides the prompt; "Set it down" moves it to Past.
- [ ] **Step 3:** Push and open a PR into `main` (after #20 merges) — only with the user's go-ahead.
