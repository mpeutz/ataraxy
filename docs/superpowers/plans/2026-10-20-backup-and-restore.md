# Backup and Restore Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Users can keep an automatically updated backup file in a place they choose (including Drive, Dropbox or OneDrive), make a one-off backup, and restore everything on a new phone, without Ataraxy ever touching the network.

**Architecture:** A pure JSON codec (`org.json`, built into Android) turns a `BackupSnapshot` of database rows and user preferences into a versioned file. `BackupRepository` reads and replaces that data in one Room transaction. Storage Access Framework URIs are reached only through a small `BackupDocuments` interface, so the decision logic in `AutomaticBackup` and `RestoreBackup` is unit-testable with a fake. A daily `AutoBackupWorker` runs `AutomaticBackup`; a new Backup section in Settings and a link in onboarding drive it through `BackupViewModel`.

**Tech Stack:** Kotlin, Compose Material 3, Hilt, Room 2.8 (`withTransaction`), DataStore Preferences, WorkManager 2.12, `org.json`, JUnit 4 + Robolectric 4.17.

**Spec:** `docs/superpowers/specs/2026-10-20-backup-lock-widget-lookback-privacy-design.md`, section 1.

## Global Constraints

- No `INTERNET` permission; `allowBackup="false"` and `res/xml/data_extraction_rules.xml` stay unchanged.
- No new dependencies. JSON uses `org.json`; transactions use `androidx.room.withTransaction` (room-ktx is already a dependency).
- No Room schema change (database stays at version 3).
- All text uses `AtaraxyText` roles; `TypographyGuardTest` must pass. Colors from the theme only.
- All user-facing strings go in `app/src/main/res/values/strings_settings.xml` (Settings) or `strings.xml` (onboarding), American English, buttons in tracked caps.
- What a backup contains: `journal_entries`, `reflections`, `reflection_notes`, `bookmarks`, `sos_events`, and every key in the `user_prefs` DataStore. Never seeded content (virtues, sub-concepts, authors, quotes).
- Backup state (chosen file, last success, last failure) lives in a separate DataStore, `backup_prefs`, so it is never inside a backup and `UserPrefsRepository.clearAll()` doesn't touch it.
- Restore validates the whole file before changing anything, then replaces database rows in a single transaction.
- Automatic backup file name default `ataraxy-backup.json`; manual backup default `ataraxy-backup-YYYY-MM-DD.json`; MIME type `application/json`.
- Gradle on this machine: run outside the sandbox with `JAVA_HOME="/c/Program Files/Android/Android Studio/jbr"` (or `Android Studio1/jbr` if `lib/jvm.cfg` is missing), `TMP=TEMP=C:\tmp`, `JAVA_TOOL_OPTIONS="-Djdk.net.unixdomain.tmpdir=C:/tmp -Djava.io.tmpdir=C:/tmp"`.
- Never install on the user's USB phone without asking; use `adb -s emulator-5554`.
- Work on branch `feat/backup-restore` in a worktree based on `docs/feature-specs`.

## Review Focus

1. **The user picks the wrong file to restore** (a photo, a half-synced or truncated JSON, the `.txt` export): restore says the file isn't a readable Ataraxy backup and nothing on the phone changes. *Test in Task 5.*
2. **A backup from a newer app version** is restored on an older install: refused with "made by a newer version" and nothing changes. *Test in Task 2.*
3. **Access to the backup file is lost** (Drive uninstalled, permission revoked, file deleted): the daily job doesn't crash or retry forever; Settings shows the failure and offers to choose again. *Test in Task 4.*
4. **A fresh install is pointed at an existing backup** before restoring: it never overwrites that backup with an empty journal. *Test in Task 4.*
5. **Unusual text and old preference values**: emoji, quotes, newlines and very long entries survive a round trip; unknown preference keys or types in a backup are skipped rather than failing the restore. *Tests in Tasks 2 and 3.*

---

### Task 1: Prove a Drive file can be rewritten every day (spike, throwaway)

The spec makes this a gate: if it fails, stop and raise it before Task 2.

**Files:**
- Create (throwaway, never committed to `feat/backup-restore`): `app/src/debug/java/com/ataraxy/app/BackupSpikeActivity.kt` and its manifest entry in `app/src/debug/AndroidManifest.xml`

- [ ] **Step 1: Build a two-button debug activity**

Button 1 launches `ActivityResultContracts.CreateDocument("application/json")` with `ataraxy-backup.json`, calls `contentResolver.takePersistableUriPermission(uri, FLAG_GRANT_READ_URI_PERMISSION or FLAG_GRANT_WRITE_URI_PERMISSION)`, stores the URI string in `SharedPreferences`, and writes `{"spike": "<timestamp>"}` with `openOutputStream(uri, "wt")`. Button 2 rewrites the stored URI the same way with a new timestamp. Also try the same with `OpenDocument` on an existing file.

- [ ] **Step 2: Ask the user to run it on a phone with Google Drive signed in**

Ask before installing on the user's phone. Choose a Drive folder in step 1, force-stop the app, reopen, and tap button 2. Expected: no `SecurityException`, and within a few minutes drive.google.com shows the new timestamp in the same file (not a second copy). Repeat after a reboot.

- [ ] **Step 3: Record the result and delete the spike**

Note the result in the PR description. If Drive fails, stop and report to the user with what failed.

---

### Task 2: Backup file format

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/data/backup/BackupSnapshot.kt`
- Create: `app/src/main/java/com/ataraxy/app/data/backup/BackupCodec.kt`
- Test: `app/src/test/java/com/ataraxy/app/data/backup/BackupCodecTest.kt`

**Interfaces:**
- Produces:
  - `sealed interface PrefValue { data class IntValue(val value: Int); data class LongValue(val value: Long); data class BooleanValue(val value: Boolean); data class StringValue(val value: String) }`
  - `data class BackupSnapshot(val journalEntries: List<JournalEntryEntity>, val reflections: List<ReflectionWithNotes>, val bookmarks: List<BookmarkEntity>, val sosEvents: List<SosEventEntity>, val preferences: Map<String, PrefValue>)` with `val hasPrivateData: Boolean get() = journalEntries.isNotEmpty() || reflections.isNotEmpty()`
  - `data class BackupFile(val formatVersion: Int, val createdAt: Instant, val appVersionCode: Long, val snapshot: BackupSnapshot)`
  - `class BackupFormatException(val reason: Reason) : Exception()` with `enum class Reason { NOT_A_BACKUP, NEWER_VERSION }`
  - `object BackupCodec { const val FORMAT_VERSION = 1; fun encode(snapshot: BackupSnapshot, createdAt: Instant, appVersionCode: Long): String; fun decode(text: String): BackupFile; fun contentHash(snapshot: BackupSnapshot): String }`

File shape (the top-level `"format"` marker is how a non-backup JSON file is told apart):

```json
{
  "format": "ataraxy-backup",
  "formatVersion": 1,
  "createdAt": "2026-10-20T14:05:11Z",
  "appVersionCode": 1,
  "journalEntries": [{"id": 1, "createdAt": "...", "updatedAt": "...", "content": "...", "promptText": "...", "linkedQuoteId": null, "virtueId": null, "ritualType": "EVENING"}],
  "reflections": [{"id": 1, "worry": "...", "yours": "...", "notYours": "...", "canDo": "...", "setDown": "...", "createdAt": "...", "completedAt": null, "setDownAt": null,
                   "notes": [{"id": 1, "text": "...", "createdAt": "..."}]}],
  "bookmarks": [{"quoteId": "...", "savedAt": "..."}],
  "sosEvents": [{"id": 1, "emotion": "...", "quoteId": "...", "triggeredAt": "..."}],
  "preferences": {"theme": {"type": "string", "value": "DARK"}, "birth_year": {"type": "int", "value": 1980}}
}
```

- [ ] **Step 1: Write the failing tests** (Robolectric runner, so `org.json` is the real implementation)

```kotlin
@Test fun roundTrip_keepsEveryRowAndPreference()      // decode(encode(s)).snapshot == s, for a snapshot with 2 journal entries (one ritual, nullable fields null and set), 1 reflection with 2 notes, 1 bookmark, 1 sos event, and one pref of each PrefValue type
@Test fun roundTrip_keepsUnusualText()                 // content "Line one\n\"Quoted\" — ünïcödé 🙂\tend" and a 20_000-char string survive unchanged
@Test fun decode_rejectsNewerFormat()                  // formatVersion 2 -> BackupFormatException with reason NEWER_VERSION
@Test fun decode_rejectsNonBackups()                   // "", "hello", "{}", "[]", {"format":"other"}, and a valid backup cut off halfway -> reason NOT_A_BACKUP
@Test fun decode_skipsUnknownPreferenceTypes()         // a pref {"type":"float","value":1.5} is dropped; the others decode
@Test fun contentHash_ignoresCreatedAt_changesWithData() // same snapshot -> same hash; changing one journal entry's content -> different hash
```

- [ ] **Step 2: Run them to see them fail**

Run: `./gradlew :app:testDebugUnitTest --tests "com.ataraxy.app.data.backup.BackupCodecTest"`
Expected: compilation failure (`BackupCodec` unresolved).

- [ ] **Step 3: Implement `BackupSnapshot.kt` and `BackupCodec.kt`**

Any `JSONException`, missing required field or wrong `format` becomes `NOT_A_BACKUP`. `formatVersion > FORMAT_VERSION` becomes `NEWER_VERSION`. Nullable strings use `JSONObject.NULL` when writing and `isNull()` when reading (never `optString`, which turns null into `"null"`). `contentHash` is SHA-256 (hex) of the encoded snapshot with a fixed `createdAt` and `appVersionCode`.

- [ ] **Step 4: Run the tests to see them pass**

Same command. Expected: 6 tests PASS.

- [ ] **Step 5: Commit**

```bash
git add app/src/main/java/com/ataraxy/app/data/backup app/src/test/java/com/ataraxy/app/data/backup
git commit -m "Add the versioned backup file format"
```

---

### Task 3: Read and replace all backed-up data

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/data/local/dao/BackupDao.kt`
- Modify: `app/src/main/java/com/ataraxy/app/data/local/AtaraxyDatabase.kt` (add `abstract fun backupDao(): BackupDao`)
- Modify: `app/src/main/java/com/ataraxy/app/di/DatabaseModule.kt` (provide `BackupDao`)
- Create: `app/src/main/java/com/ataraxy/app/data/backup/BackupRepository.kt`
- Test: `app/src/test/java/com/ataraxy/app/data/backup/BackupRepositoryTest.kt`

**Interfaces:**
- Consumes: `BackupSnapshot`, `PrefValue` (Task 2); existing `ReflectionDao.getAll()`.
- Produces:
  - `BackupDao`: `suspend fun journalEntries(): List<JournalEntryEntity>`, `bookmarks()`, `sosEvents()`, `suspend fun deleteJournalEntries()`, `deleteReflections()` (notes go by cascade), `deleteBookmarks()`, `deleteSosEvents()`, and `@Insert` list inserts `insertJournalEntries`, `insertReflections`, `insertReflectionNotes`, `insertBookmarks`, `insertSosEvents`.
  - `class BackupRepository @Inject constructor(private val db: AtaraxyDatabase, private val userPrefs: DataStore<Preferences>)` with `suspend fun snapshot(): BackupSnapshot` and `suspend fun replaceAll(snapshot: BackupSnapshot)`.

- [ ] **Step 1: Write the failing tests** (use `inMemoryDatabase()` and a temp-file DataStore built like `testUserPrefs()`; expose the DataStore through a small helper in the test file)

```kotlin
@Test fun snapshot_includesAllPrivateTablesAndPrefs() // seed rows in all five tables + set theme DARK and birth_year 1980 via UserPrefsRepository; snapshot has them all, with original ids
@Test fun replaceAll_leavesSeededContentAlone()     // insert a QuoteEntity and a VirtueEntity; after replaceAll they are still there
@Test fun replaceAll_replacesEverything()            // existing rows and prefs are gone; restored rows equal the snapshot's (ids preserved); prefs equal the snapshot's
@Test fun replaceAll_keepsUnknownPrefKeys()          // a snapshot with an extra key "future_key" = StringValue("x") restores without error and the key is written
@Test fun replaceAll_isAllOrNothingForTheDatabase()  // snapshot with two journal entries sharing one id -> replaceAll throws; the original rows are still there
```

- [ ] **Step 2: Run them to see them fail**

Run: `./gradlew :app:testDebugUnitTest --tests "com.ataraxy.app.data.backup.BackupRepositoryTest"`
Expected: compilation failure.

- [ ] **Step 3: Implement `BackupDao`, wire it into `AtaraxyDatabase` and `DatabaseModule`, implement `BackupRepository`**

`replaceAll` runs all deletes and inserts inside `db.withTransaction { }`, then replaces preferences with `userPrefs.edit { it.clear(); ... }` using `intPreferencesKey`, `longPreferencesKey`, `booleanPreferencesKey` or `stringPreferencesKey` per `PrefValue`. `snapshot` maps `userPrefs.data.first().asMap()`; values of any other type are skipped. Adding a DAO with no new entity doesn't change the schema; confirm `app/schemas/.../3.json` is unchanged after the build.

- [ ] **Step 4: Run the tests to see them pass**

Same command. Expected: 5 tests PASS. Also run `MigrationTest` to confirm the schema is unchanged.

- [ ] **Step 5: Commit**

```bash
git add app/src/main/java/com/ataraxy/app/data app/src/main/java/com/ataraxy/app/di/DatabaseModule.kt app/src/test/java/com/ataraxy/app/data/backup
git commit -m "Snapshot and replace journal data and preferences for backups"
```

---

### Task 4: Automatic daily backup

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/data/backup/BackupDocuments.kt` (interface + `ContentResolverBackupDocuments`)
- Create: `app/src/main/java/com/ataraxy/app/data/backup/BackupSettingsRepository.kt`
- Create: `app/src/main/java/com/ataraxy/app/data/backup/AutomaticBackup.kt` (also holds `AutomaticBackupController`)
- Create: `app/src/main/java/com/ataraxy/app/data/backup/AutoBackupWorker.kt`
- Create: `app/src/main/java/com/ataraxy/app/di/BackupModule.kt` (binds `BackupDocuments`; provides `@BackupPrefs DataStore<Preferences>` named `backup_prefs`; provides `AppVersion`)
- Modify: `app/src/main/java/com/ataraxy/app/MainActivity.kt` (call `automaticBackupController.ensureScheduled()` in `onCreate`, next to `SeedWorker.enqueue`)
- Test: `app/src/test/java/com/ataraxy/app/data/backup/AutomaticBackupTest.kt`, `app/src/test/java/com/ataraxy/app/data/backup/FakeBackupDocuments.kt`

**Interfaces:**
- Consumes: `BackupRepository.snapshot()`, `BackupCodec` (Tasks 2–3).
- Produces:
  - `interface BackupDocuments { suspend fun read(uri: String): String; suspend fun write(uri: String, text: String); fun displayName(uri: String): String?; fun persist(uri: String): Boolean; fun release(uri: String) }`. `persist` takes read and write persistable permission and returns false if write can't be persisted. `write` uses `openOutputStream(uri, "wt")`. Missing access surfaces as `SecurityException` or `FileNotFoundException`.
  - `@Qualifier annotation class BackupPrefs`
  - `enum class BackupFailure { NO_ACCESS, EXISTING_BACKUP, UNKNOWN }`
  - `data class BackupSettings(val targetUri: String? = null, val lastSuccessAt: Instant? = null, val lastWrittenHash: String? = null, val failure: BackupFailure? = null)`
  - `class BackupSettingsRepository @Inject constructor(@BackupPrefs dataStore: DataStore<Preferences>)`: `val settings: Flow<BackupSettings>`, `suspend fun setTarget(uri: String?)` (also clears hash, success time and failure), `suspend fun recordSuccess(at: Instant, hash: String)`, `suspend fun recordFailure(failure: BackupFailure)`
  - `fun interface AppVersion { fun code(): Long }` (real one reads `PackageInfo.longVersionCode`)
  - `enum class BackupRunResult { DISABLED, UNCHANGED, WRITTEN, BLOCKED_EXISTING_BACKUP, FAILED }`
  - `class AutomaticBackup @Inject constructor(repository, documents, settings, appVersion, clock: Clock)`: `suspend fun run(): BackupRunResult`
  - `class AutomaticBackupController @Inject constructor(@ApplicationContext context, documents, settings)`: `suspend fun enable(uri: String): Boolean` (persist, set target, enqueue periodic work and one immediate run; false if `persist` fails), `suspend fun disable()` (cancel work, release the URI, `setTarget(null)`), `suspend fun ensureScheduled()` (enqueue periodic work with `KEEP` if a target is set)
  - Unique work names: `"automatic_backup"` (periodic, 1 day, `ExistingPeriodicWorkPolicy.KEEP`) and `"automatic_backup_now"` (one-time, `REPLACE`).

`AutomaticBackup.run()` rules, in order:

1. No target: `DISABLED`.
2. `hash = BackupCodec.contentHash(snapshot)`. Equal to `lastWrittenHash`: `UNCHANGED`.
3. `lastWrittenHash == null` (this install hasn't written to this target yet) and the local snapshot has no private data: read the target. If it decodes and its snapshot has private data, `recordFailure(EXISTING_BACKUP)` and return `BLOCKED_EXISTING_BACKUP`. A read that fails or a file that isn't a backup (for example, the empty file just created) means carry on.
4. Write, then `recordSuccess(clock.instant(), hash)`: `WRITTEN`.
5. `SecurityException` or `FileNotFoundException`: `recordFailure(NO_ACCESS)`; any other exception: `recordFailure(UNKNOWN)`. Both return `FAILED`. Never rethrow (rethrow `CancellationException`).

`AutoBackupWorker` is a `@HiltWorker` `CoroutineWorker` like `SeedWorker`; it calls `run()` and always returns `Result.success()`, so a revoked file never causes a retry loop.

- [ ] **Step 1: Write the failing tests** (in-memory database, temp DataStores, `FakeBackupDocuments` holding a `MutableMap<String, String>` and a `var failWith: Exception?`, a fixed `Clock`)

```kotlin
@Test fun run_withoutTarget_isDisabled()
@Test fun run_firstTime_writesBackupAndRecordsSuccess()        // file decodes to the snapshot; lastSuccessAt == clock instant; failure == null
@Test fun run_twiceWithoutChanges_writesOnce()                 // second result UNCHANGED; fake write count == 1
@Test fun run_afterChange_writesAgain()
@Test fun run_emptyInstall_doesNotOverwriteExistingBackup()    // target already holds a backup with 3 journal entries; local is empty -> BLOCKED_EXISTING_BACKUP, file unchanged, failure EXISTING_BACKUP
@Test fun run_afterThisInstallWrote_emptyJournalDoesOverwrite() // write once with data, delete all journal entries and reflections, run -> WRITTEN (Clear journal carries through)
@Test fun run_whenAccessLost_recordsNoAccess()                 // failWith = SecurityException -> FAILED, failure NO_ACCESS; FileNotFoundException likewise
@Test fun setTarget_clearsHashAndFailure()
```

- [ ] **Step 2: Run them to see them fail**

Run: `./gradlew :app:testDebugUnitTest --tests "com.ataraxy.app.data.backup.AutomaticBackupTest"`
Expected: compilation failure.

- [ ] **Step 3: Implement the files listed above**

- [ ] **Step 4: Run the tests to see them pass**

Same command. Expected: 8 tests PASS.

- [ ] **Step 5: Commit**

```bash
git add app/src/main/java/com/ataraxy/app app/src/test/java/com/ataraxy/app/data/backup
git commit -m "Keep a backup file up to date once a day"
```

---

### Task 5: Restore from a backup file

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/data/backup/RestoreBackup.kt`
- Test: `app/src/test/java/com/ataraxy/app/data/backup/RestoreBackupTest.kt`

**Interfaces:**
- Consumes: `BackupDocuments`, `BackupCodec`, `BackupRepository.replaceAll`, `UserPrefsRepository.userPrefs`, `NotificationScheduler.ensureScheduled(prefs)`.
- Produces:
  - `data class BackupPreview(val createdAt: Instant, val journalEntryCount: Int, val reflectionCount: Int)`
  - `enum class RestoreProblem { NOT_A_BACKUP, NEWER_VERSION, NO_ACCESS }` and `class RestoreException(val problem: RestoreProblem) : Exception()`
  - `class RestoreBackup @Inject constructor(...)`: `suspend fun preview(uri: String): Result<BackupPreview>`, `suspend fun restore(uri: String): Result<Unit>`. Journal entry count counts ritual sessions as one entry each (same `ritualType` and `createdAt`), matching how Journal shows them.

`restore` reads and decodes the whole file first; only then calls `replaceAll`, then `notificationScheduler.ensureScheduled(userPrefs.first())`. `NotificationScheduler` is a concrete class, so `RestoreBackup` takes a `fun interface Rescheduler { suspend fun reschedule(prefs: UserPrefs) }`, bound in `BackupModule` to `NotificationScheduler.ensureScheduled`; the test passes a recording fake.

- [ ] **Step 1: Write the failing tests**

```kotlin
@Test fun preview_countsEntriesAndReflections()        // 1 practice entry + 1 evening ritual of 3 answers -> journalEntryCount 2; reflections 1; createdAt from the file
@Test fun restore_replacesDataAndReschedules()        // local data gone, backup data present, reschedule called once with the restored prefs (e.g. morningRitualTime 06:30)
@Test fun restore_badFile_changesNothing()            // "not json", a truncated backup, and the .txt export text -> failure NOT_A_BACKUP; local rows and prefs unchanged; reschedule not called
@Test fun restore_newerVersion_changesNothing()       // NEWER_VERSION; unchanged
@Test fun restore_unreadableFile_reportsNoAccess()    // fake read throws SecurityException -> NO_ACCESS
```

- [ ] **Step 2: Run them to see them fail**

Run: `./gradlew :app:testDebugUnitTest --tests "com.ataraxy.app.data.backup.RestoreBackupTest"`
Expected: compilation failure.

- [ ] **Step 3: Implement `RestoreBackup.kt` and its binding**

- [ ] **Step 4: Run the tests to see them pass**

Same command. Expected: 5 tests PASS.

- [ ] **Step 5: Commit**

```bash
git add app/src/main/java/com/ataraxy/app app/src/test/java/com/ataraxy/app/data/backup
git commit -m "Restore everything from a backup file in one step"
```

---

### Task 6: Backup in Settings

**Files:**
- Create: `app/src/main/java/com/ataraxy/app/ui/settings/BackupViewModel.kt`
- Create: `app/src/main/java/com/ataraxy/app/ui/settings/BackupSection.kt`
- Modify: `app/src/main/java/com/ataraxy/app/ui/settings/SettingsScreen.kt` (insert `BackupSection()` between the Notifications and Account sections; update the Clear journal dialog message)
- Modify: `app/src/main/java/com/ataraxy/app/ui/settings/SettingsViewModel.kt` (`deactivate()` also calls `automaticBackupController.disable()`)
- Modify: `app/src/main/res/values/strings_settings.xml`
- Test: `app/src/test/java/com/ataraxy/app/ui/settings/BackupViewModelTest.kt`

**Interfaces:**
- Consumes: `AutomaticBackupController`, `BackupSettingsRepository.settings`, `BackupDocuments`, `BackupRepository`, `BackupCodec`, `RestoreBackup`, `AppVersion`, `Clock`.
- Produces (used again in Task 7):
  - `data class BackupUiState(val enabled: Boolean, val locationName: String?, val lastSuccessAt: Instant?, val failure: BackupFailure?)`
  - `sealed interface BackupEvent { data object Saved; data object Restored; data class Failed(@StringRes val message: Int) }`
  - `class BackupViewModel`: `val state: StateFlow<BackupUiState>`, `val events: Flow<BackupEvent>`, `fun turnOn(uri: String)`, `fun turnOff()`, `fun backUpNow(uri: String)` (writes a one-off file, doesn't change automatic settings), `fun previewRestore(uri: String)` (exposes `val pendingRestore: StateFlow<PendingRestore?>` with `uri` and `BackupPreview`), `fun confirmRestore()`, `fun cancelRestore()`, `val offerKeepUpdating: StateFlow<String?>` (set to the restored URI after a successful restore when automatic backup is off), `fun keepUpdating(uri: String)` (calls `turnOn`), `fun dismissKeepUpdating()`.

Rows (use `SectionHeader`, `SettingsRow`, `ConfirmDialog`; the switch row follows `NotificationGroup`'s switch styling):

| Row | Value text | Action |
|---|---|---|
| Automatic backup (switch) | off: `settings_backup_auto_off`; on, success: `settings_backup_last` with a localized date and time; on, never run: `settings_backup_pending`; failure: the matching failure string | On: `CreateDocument("application/json")` with `ataraxy-backup.json`, then `turnOn`. Off: `turnOff` |
| Backup file (only when on) | `locationName`, or `settings_backup_location_unknown` | `CreateDocument` again, then `turnOn` |
| Back up now | `settings_backup_now_value` | `CreateDocument` with `ataraxy-backup-YYYY-MM-DD.json`, then `backUpNow` |
| Restore from backup | `settings_restore_value` | `OpenDocument(arrayOf("application/json", "application/octet-stream", "text/plain"))`, then `previewRestore`, then a `ConfirmDialog` (destructive) |

Exact copy for `strings_settings.xml`:

```xml
<string name="settings_section_backup">BACKUP</string>
<string name="settings_backup_auto">Automatic Backup</string>
<string name="settings_backup_auto_off">Keep a copy up to date in a place you choose</string>
<string name="settings_backup_pending">Your first backup will be saved shortly</string>
<string name="settings_backup_last">Last backed up %1$s</string>
<string name="settings_backup_failed_access">Your backup couldn\'t be saved. Choose where to keep it again.</string>
<string name="settings_backup_failed_existing">That file already holds a backup. Restore it, or choose a new place.</string>
<string name="settings_backup_failed_unknown">Your last backup didn\'t save. It will try again tomorrow.</string>
<string name="settings_backup_location">Backup File</string>
<string name="settings_backup_location_unknown">Chosen file</string>
<string name="settings_backup_now">Back Up Now</string>
<string name="settings_backup_now_value">Save a copy anywhere</string>
<string name="settings_backup_saved">Backup saved</string>
<string name="settings_restore">Restore From Backup</string>
<string name="settings_restore_value">Replace this journal with a backup</string>
<string name="settings_restore_title">Restore This Backup?</string>
<string name="settings_restore_message">Backup from %1$s with %2$d journal entries and %3$d reflections. Everything on this phone will be replaced. This cannot be undone.</string>
<string name="settings_restore_confirm">RESTORE</string>
<string name="settings_restored">Your journal has been restored</string>
<string name="settings_restore_not_backup">That file isn\'t an Ataraxy backup</string>
<string name="settings_restore_newer">That backup was made by a newer version of Ataraxy. Update the app, then try again.</string>
<string name="settings_restore_no_access">That file couldn\'t be opened</string>
<string name="settings_keep_updating_title">Keep This Backup Up to Date?</string>
<string name="settings_keep_updating_message">Ataraxy can update this file once a day, so it\'s always ready for your next phone.</string>
<string name="settings_keep_updating_confirm">KEEP IT UPDATED</string>
<string name="not_now">NOT NOW</string>
```

Replace `settings_clear_journal_message` with: `All journal entries will be permanently deleted. This cannot be undone. If automatic backup is on, your backup will match by tomorrow.`

The `EXISTING_BACKUP` failure row's action opens the restore flow for the chosen file (the target URI) instead of a new picker.

- [ ] **Step 1: Write the failing tests** (fakes from Task 4; `MainLooper`/`StandardTestDispatcher` as in `WhatsYoursViewModelTest`; initialize WorkManager with `WorkManagerTestInitHelper.initializeTestWorkManager` since the controller enqueues work)

```kotlin
@Test fun turnOn_enablesAndShowsPending()               // state.enabled true, locationName from fake displayName, lastSuccessAt null
@Test fun turnOn_whenWriteCantBeKept_emitsFailed()       // fake persist returns false -> Failed(R.string.settings_backup_failed_access); state.enabled false
@Test fun turnOff_releasesFileAndDisables()              // fake release called with the URI; state.enabled false
@Test fun previewRestore_thenConfirm_restoresAndOffersKeepUpdating() // pendingRestore has the preview; after confirm: event Restored, offerKeepUpdating == uri
@Test fun previewRestore_badFile_emitsNotBackup()        // Failed(R.string.settings_restore_not_backup); pendingRestore null
@Test fun backUpNow_writesFileWithoutChangingAutomatic() // file decodes; settings target unchanged
```

- [ ] **Step 2: Run them to see them fail**

Run: `./gradlew :app:testDebugUnitTest --tests "com.ataraxy.app.ui.settings.BackupViewModelTest"`
Expected: compilation failure.

- [ ] **Step 3: Implement `BackupViewModel`, `BackupSection`, the strings, and the Settings and Deactivate changes**

- [ ] **Step 4: Run the tests and the guard**

Run: `./gradlew :app:testDebugUnitTest --tests "com.ataraxy.app.ui.settings.*" --tests "com.ataraxy.app.ui.theme.TypographyGuardTest"`
Expected: all PASS.

- [ ] **Step 5: Commit**

```bash
git add app/src/main app/src/test
git commit -m "Add automatic backup, Back up now and Restore to Settings"
```

---

### Task 7: Restore during onboarding

**Files:**
- Modify: `app/src/main/java/com/ataraxy/app/ui/onboarding/OnboardingScreen.kt`
- Modify: `app/src/main/res/values/strings.xml`

**Interfaces:**
- Consumes: `BackupViewModel` (Task 6): `previewRestore`, `pendingRestore`, `confirmRestore`, `events`, `offerKeepUpdating`, `keepUpdating`.

- [ ] **Step 1: Add the link and dialogs**

On the first onboarding page, under the body text, a quiet text button `onboarding_restore` ("Moving from another phone? Restore a backup") that launches `OpenDocument`, then shows the same restore confirm dialog and keep-updating dialog as Settings (reuse the composables from `BackupSection.kt`; make them `internal`). On `BackupEvent.Restored`, after the keep-updating dialog is answered, call `onComplete()`, so the user lands on Home with their restored settings.

```xml
<string name="onboarding_restore">Moving from another phone? Restore a backup</string>
```

- [ ] **Step 2: Build and run the whole suite**

Run: `./gradlew assembleDebug testDebugUnitTest`
Expected: BUILD SUCCESSFUL.

- [ ] **Step 3: Commit**

```bash
git add app/src/main
git commit -m "Offer to restore a backup during onboarding"
```

---

### Task 8: Verify on a device and open the PR

- [ ] **Step 1: Run the CI command**

Run: `./gradlew assembleDebug testDebugUnitTest :app:lintDebug assembleRelease`
Expected: BUILD SUCCESSFUL, no new lint errors. `app/schemas` unchanged (`git status` shows no schema file).

- [ ] **Step 2: Walk through it on the emulator** (`adb -s emulator-5554`)

1. Write a Practice reflection and an evening ritual; start a What's Yours reflection; bookmark a quote; set theme Dark and a birth year.
2. Settings › Automatic Backup on, choose Downloads; within a minute the row shows "Last backed up…". Pull the file with `adb -s emulator-5554 pull` and check it's readable JSON.
3. Back Up Now to a second file.
4. Clear app data (`adb -s emulator-5554 shell pm clear com.ataraxy.app`), reopen, tap "Restore a backup" in onboarding, choose the file. Everything from step 1 is back, the theme is Dark, and reminders are scheduled (`adb shell dumpsys jobscheduler | grep ataraxy`).
5. Turn automatic backup on again, pointing at the same file, on the now-restored install: it writes (data present). Then clear app data again, skip restore, finish onboarding, turn automatic backup on pointing at that file: Settings shows the "already holds a backup" message and the file is unchanged.
6. Restore the `.txt` journal export: "That file isn't an Ataraxy backup", nothing changes.

- [ ] **Step 3: Push and open the PR** (only with the user's go-ahead)

PR into `main` titled "Back up and restore the journal", noting the Drive spike result from Task 1 and that the database schema is unchanged.
