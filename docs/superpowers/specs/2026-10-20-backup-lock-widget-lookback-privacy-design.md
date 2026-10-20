# Backup, app lock, quote widget, looking back, and privacy policy

Date: 2026-10-20. Five pieces of work for Ataraxy, agreed with Mike in conversation. Build in this order; each ships as its own branch and PR into `main`.

1. Backup and restore
2. App lock
3. Home-screen quote widget
4. Looking back
5. Privacy policy and Play Data safety answers

## Why

Ataraxy is a private Stoic journal whose promise is that nothing leaves the phone: no account, no network, Android cloud backup switched off. That promise currently has a cost: a lost, reset or replaced phone loses every reflection. The first two pieces make the journal survivable and private without breaking the promise. The widget and looking back make the app's existing content more present in daily life. The privacy policy is required for a Play listing.

## Constraints for all five

- **The "never leaves your phone" promise stays exactly as it is.** No `INTERNET` permission, `allowBackup="false"` and the existing `data_extraction_rules.xml` stay unchanged. No analytics, crash reporting or third-party SDKs that phone home.
- Kotlin, Jetpack Compose, Material 3, Hilt, Room (database version 3 today), DataStore preferences, WorkManager. minSdk 29, targetSdk 36, compileSdk 37.
- All UI text uses the `AtaraxyText` roles; `TypographyGuardTest` fails the build on hand-set font sizes, line heights, letter spacing or fonts outside `ui/theme`. Colors come from the theme in `ui/theme/Color.kt`.
- Strings go in `res/values/strings*.xml`; follow the existing tracked-caps conventions for buttons and labels.
- American English in all copy and comments.
- Tests: JVM unit tests with Robolectric (pinned to sdk 35). New logic needs unit tests in the style of the existing ones under `app/src/test`.
- Every PR must pass `./gradlew assembleDebug testDebugUnitTest :app:lintDebug assembleRelease` (the CI command), including R8 keep rules for anything reflective.
- A Room schema bump needs a migration and a migration test, like `MigrationTest`. None of the five pieces should need one (see each section); if one turns out to, call it out in the PR because downgrades crash existing installs.

---

## 1. Backup and restore

### Intent
Mostly: moving to a new phone without losing anything. Also: a safe, current copy at all times. The user wants the app to keep that copy up to date quietly, without remembering to do it.

### Decided
- **Automatic backup to a place the user picks.** In Settings, the user turns on automatic backup and chooses where to keep the backup file, once, with the system save dialog. From then on the app overwrites that file once a day. If the file is in Drive, Dropbox or OneDrive, their app does the syncing; Ataraxy itself never touches the network.
  - *Claude's call:* this uses `ACTION_CREATE_DOCUMENT` for a single file with a persisted URI permission, then rewrites it in place (`openOutputStream(uri, "wt")`), rather than picking a folder with `ACTION_OPEN_DOCUMENT_TREE`. Google Drive's provider doesn't offer folders to the folder picker, so a folder-based design would quietly limit automatic backup to local storage, which is lost with the phone. **Verify on a real device with Google Drive installed** that a persisted Drive document can be rewritten daily and that the change syncs. If it can't, stop and raise it before building the rest of piece 1.
  - Settings copy speaks of "where to keep your backup", not "a folder".
- **Manual "Back up now"** that saves a backup file wherever the user chooses (`ACTION_CREATE_DOCUMENT`), for people who don't want automatic backup.
- **Restore** from a backup file the user picks (`ACTION_OPEN_DOCUMENT`), available in two places: during onboarding (so a new phone can restore before setup) and in Settings.
- **Restore replaces** everything on the phone, after a clear warning. No merging.
- **No passphrase or encryption.** Keep it simple.
- **What's in a backup:** journal entries (including morning and evening rituals), What's Yours reflections and their notes, bookmarks, Find Your Footing history (`sos_events`), the Memento Mori birth year, and settings: theme, text size, notification style, reminder on/off and times, streak and last-ritual dates.
- **Not in a backup:** seeded content (virtues, quotes, authors), which the app seeds itself; the app lock setting (the new phone decides that); the backup folder choice itself.
- After a restore, reminders are rescheduled from the restored settings.
- Settings shows when the last automatic backup succeeded, and says so plainly if it has failed or the folder is no longer reachable (for example, the user revoked access or uninstalled the Drive app), with a way to pick a folder again.
- The existing readable `.txt` journal export stays as it is. It's for reading, not for restoring.
- **Never overwrite a good backup with an empty journal** *(Claude's call)*:
  - Automatic backup only runs after the user has chosen the backup file in *this* install. A new phone or reinstall can't write to the old file until the user points it there.
  - When the user chooses a backup file that already holds a backup, and this install's journal and reflections are empty, the app offers "Restore from this backup?" instead of overwriting it. If they decline, ask again before the first overwrite.
  - "Deactivate" (which erases everything) also turns automatic backup off and releases the file permission, so the backup survives.
  - "Clear journal" is deliberate, so the next backup reflects it; its confirmation dialog says the backup will match by the next day.

### Left to the builder
- File format. Suggested: a single JSON file with a `formatVersion` and the app's `versionCode`, default name `ataraxy-backup.json` (manual backups default to a dated name like `ataraxy-backup-2026-10-20.json`). Restore must reject files from a newer `formatVersion` with a clear message, and accept older ones.
- Skip the daily write when nothing has changed since the last one.
- Scheduling: a periodic WorkManager job, following the patterns in `notifications/`. No network constraint.
- Restore should validate the whole file before touching the database, then replace in a single transaction, so a bad file can't leave a half-restored journal.

---

## 2. App lock

### Intent
Stop someone who borrows an unlocked phone from reading the user's private writing. Not meant to stop someone who knows the phone's PIN.

### Decided
- An **"App lock" switch in Settings, off by default**, that the user can turn on and off at any time.
- Uses the **phone's own fingerprint, face or screen PIN** (`androidx.biometric` `BiometricPrompt` allowing biometric or device credential). No separate app PIN.
- Turning it **on** asks for the unlock once, to confirm it works. Turning it **off** also asks for the unlock, so a borrower can't simply switch it off.
- If the phone has no screen lock, the switch explains that and can't be turned on.
- **What's locked:** reading past writing: Journal (All Entries, including morning and evening rituals), editing an old entry, and What's Yours (open and past reflections, the revisit page).
- **What stays open:** Home and the daily quote, Archive, Insight pages, Find Your Footing, Memento Mori, and writing something new (a fresh Practice reflection, today's ritual).
- *Claude's call:* the What's Yours start screen lists open reflections, so it's locked as a whole, including starting a new one.
- **Data actions in Settings also ask for the unlock** when the lock is on *(Claude's call)*: the readable `.txt` export, Back up now, choosing or changing the backup file, Restore, Clear journal and Deactivate. Otherwise a borrower could export the journal and read it elsewhere, or wipe it.
- Opening a locked screen shows the phone's unlock prompt. Once unlocked, it stays unlocked until the app has been in the background for about a minute.
- While a locked screen is showing, the recent-apps preview is blank (`FLAG_SECURE` on those screens only).
- Restoring a backup doesn't turn the lock on.
- The widget isn't affected; it only shows the daily quote.

### Left to the builder
- `BiometricPrompt` needs a `FragmentActivity`; `MainActivity` is a `ComponentActivity` today. Switch it to `FragmentActivity` (or `AppCompatActivity`) if that's the cleanest route.
- Where the lock check lives. Suggested: one gate around the locked routes in `AtaraxyNavHost`, not per screen, so a new journal screen can't forget it.
- What the user sees if they cancel the prompt. Suggested: return to where they came from.
- Exact relock timeout (about a minute) and how it's measured (process lifecycle).

---

## 3. Home-screen quote widget

### Intent
The daily quote on the home screen, without a notification. Quiet and simple.

### Decided
- **Shows today's quote and its author only.** The same quote as Home (`QuoteRepository.getDailyQuote`), changing at local midnight. Tapping anywhere opens the app on Home.
- **One layout:** the quote left-aligned in the app's italic quote face, the author underneath in small tracked caps ("— SENECA"). No app-name label. (Mockup "Layout A".)
- **Five color choices**, each changing only the background and text colors:
  1. **Match app theme** (default): Light or Dark, following the app's Theme setting (System, Light, Dark).
  2. **Light:** cream background (`Cream`), ink text (`Ink`, `InkMuted` for the author).
  3. **Dark:** stone background (`Stone`), off-white text (`OffWhite`, `OffWhiteMuted`).
  4. **Clear:** no background; white text with a soft shadow, directly on the wallpaper.
  5. **Phone accent:** a soft surface tint from the phone's Material You colors, switching with the phone's light and dark mode. Android 12 and later only; on Android 10 and 11 this option is hidden.
- The choice is made on a **setup screen with a live preview** shown when the widget is added. Each widget keeps its own choice. On Android 12 and later, long-pressing the widget reopens the setup screen.
- Resizable from a 4×1 strip up to 4×3. Smaller sizes shrink the text, then end long quotes with "…"; the full quote is a tap away in the app.
- The app lock doesn't affect the widget.

### Left to the builder
- Glance (`androidx.glance:glance-appwidget`) vs classic `RemoteViews`. Glance fits the Compose codebase; note that Glance can't use the app's Compose `TextStyle`s directly, so the widget needs its own small set of sizes. Put them in `ui/theme` (or extend `TypographyGuardTest`'s allowlist deliberately) so the guard test still holds.
- Custom fonts in widgets are limited. If the quote face can't be used, fall back to the system serif italic and say so in the PR.
- Midnight refresh: a WorkManager job or an alarm-free approach (for example, refresh on `ACTION_DATE_CHANGED` / `ACTION_TIME_CHANGED` / `ACTION_TIMEZONE_CHANGED` plus the daily-quote worker). Also refresh after a backup restore and when the app's theme setting changes.
- Exact corner radius, padding and shadow values: match the mockups and the app's `Shape.kt`.

---

## 4. Looking back

### Intent
All three of: seeing how far you've come, being reminded of a lesson already learned, and checking whether something that once weighed on you still does.

### Decided
- **"From your journal" card on Home**, below the daily quote. It shows the first two lines of one past entry with its date, for example "A year ago today, you wrote…".
  - Prefers an entry from exactly one year ago, then exactly one month ago. If neither exists, it picks an older entry at least 30 days old.
  - One entry per day: it doesn't change when the app is reopened.
  - Hidden until there are entries at least 30 days old.
  - Tapping opens a new **read-only entry view** *(Claude's call)*: the date, the prompt and the full text, plus the linked quote for a Practice reflection. There's no read-only single-entry screen today (the editor and the inline expand in Journal are the only views), and opening the editor to read invites accidental edits. The view has an Edit action that opens the existing editor. It's a locked route.
  - **Rituals count as one pick** *(Claude's call)*: a morning or evening ritual is saved as one entry per prompt, so the card treats all entries of one ritual session (same `ritualType` and `createdAt`) as a single pick, shows the first answer with its prompt, and the read-only view shows every prompt and answer of that session.
  - **With the app lock on**, the card shows only the date line ("You wrote something a year ago today") with no entry text, and tapping asks to unlock.
- **Check-ins on What's Yours.** An open (not set down) reflection that's two weeks old shows a gentle prompt at the top of its page, and a quiet marker in the What's Yours list: "Two weeks on, does this still weigh on you?"
  - **Set it down** moves it to Past (existing behavior).
  - **Still carrying it** adds a dated note and asks again in two weeks.
  - In-app only. **No notification**: a reminder about a worry works against the app's calm.
- **No changes to Journal's list itself**; search and filters already cover deliberate browsing. (Journal may reuse the new read-only view, but doesn't have to.)

### Left to the builder
- Which journal entries count: Practice reflections and morning and evening rituals, all from `journal_entries`. Suggested: all of them.
- How "one entry per day" is stable: derive the pick from the date (as `dailyQuoteSlot` does) rather than storing it.
- How "asks again in two weeks" is tracked. It can be derived from the latest note's or the reflection's `createdAt`, so no schema change should be needed. If a column is truly needed, that's a Room migration to v4 and must be called out.
- Exact wording of the date line for the month, year and "older" cases.

---

## 5. Privacy policy and Play Data safety answers

### Intent
Play requires a privacy policy URL and a completed Data safety form, even for an app that collects nothing.

### Decided
- **Policy page** at `docs/privacy.md`, published with **GitHub Pages** from `main` `/docs`, at `https://mpeutz.github.io/ataraxy/privacy`. Mike turns on Pages in the repo settings (or approves doing it).
- **Contact:** mikeataviary@gmail.com.
- **The policy says**, in plain language, with an effective date:
  - What the app stores: journal entries, rituals, What's Yours reflections, bookmarks and settings, on the phone only.
  - No accounts, ads, analytics or crash reporting; no internet access at all.
  - Backups are written only to the file location the user chooses. If that's a cloud folder (Drive, Dropbox, OneDrive), that service's policy covers the copy. Ataraxy never reads or sends backups anywhere else.
  - App lock uses Android's own fingerprint, face or PIN check; Ataraxy never sees that data.
  - The widget shows only the daily quote; reminders are scheduled on the phone.
  - Deleting data: uninstalling removes everything; backup files are the user's to delete.
  - Not directed at children under 13.
  - Changes are posted on the page with a new effective date.
- **In-app link:** a "Privacy policy" row in Settings › About opening the page in the browser (an `ACTION_VIEW` intent; this needs no internet permission in the app).
- **Data safety answers** written to `docs/play-data-safety.md` for Mike to copy into Play Console: no data collected, no data shared, with a short note on why user-chosen backups via the system file picker are user-initiated and not collection by the developer, for a reviewer who asks. Claude can't submit the form.
- The README's privacy line gets a link to the policy.

### Left to the builder
- Keep the specs folder off the Pages site (for example, `docs/_config.yml` with `exclude: [superpowers]`).
- Page styling: a plain Jekyll theme is fine.
- Ship the policy last, after pieces 1 to 4, so it describes what the app actually does.

---

## Non-goals and anti-goals

- No accounts, sync service, analytics or network access of any kind.
- No re-enabling Android cloud backup.
- No streak counters or gamified looking back.
- No notifications for looking back.
- No merging of two journals on restore.
- A success that breaks the "never leaves your phone" promise is a failure.
