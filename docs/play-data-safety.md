# Play Console: Data safety answers for Ataraxy

Answers to copy into Play Console › App content › Data safety. They describe the app once backup and restore, App Lock, the quote widget and looking back have all shipped. Re-check them if the app ever gains network access, accounts, analytics or crash reporting.

## Data collection and security

| Question | Answer |
|---|---|
| Does your app collect or share any of the required user data types? | **No** |

Answering "No" ends the data-types section; Play then shows "No data collected" and "No data shared with third parties" on the listing.

### Why "No" is accurate

- **Nothing leaves the device through the app.** The app has no `INTERNET` permission, no SDKs that send data, no accounts, ads, analytics or crash reporting. Android cloud backup and device-to-device transfer are disabled (`allowBackup="false"` and `data_extraction_rules.xml` exclude everything).
- **On-device processing is not collection.** Play's definition of "collect" is transmitting data off the device. Journal entries, reflections, bookmarks, Find Your Footing history and settings stay in the app's private storage.
- **Backups and the text export are user-initiated, to a place the user picks.** The app writes a file only after the user chooses a location in Android's system file picker (Storage Access Framework). The app never transmits it; if the chosen location belongs to a cloud provider, that provider's own app uploads it under its own policy. This is a user-directed export, not collection or sharing by the developer.
- **App Lock** uses Android's BiometricPrompt. The app receives only success or failure; biometric data and the PIN never reach the app.
- **The widget** shows only the daily quote, rendered on the device.

### If a reviewer asks about the backup feature

> Ataraxy has no internet permission. Backups are written only to a file location the user selects in Android's system file picker, and only at the user's request (once, or daily after the user turns automatic backup on and picks the file). The app does not transmit the file; any upload is performed by the storage provider the user chose. No data is collected by or shared with the developer.

## Other App content declarations (for reference)

| Section | Answer |
|---|---|
| Privacy policy URL | https://mpeutz.github.io/ataraxy/privacy/ |
| Ads | No ads |
| App access | All functionality is available without special access (no login) |
| Target audience | 13 and older (not designed for children) |
| Data deletion | Not required: no data is collected. In-app: Settings › Deactivate Ataraxy erases the journal, reflections, history and settings on the device; uninstalling removes everything. |

## Permissions in the manifest

| Permission | Why |
|---|---|
| `POST_NOTIFICATIONS` | Daily quote and ritual reminders, scheduled on the device |
| `USE_BIOMETRIC` / `USE_FINGERPRINT` | App Lock (merged from `androidx.biometric`) |

No permission grants network access, location, contacts, camera, microphone or storage outside the app's own files and the files the user picks.
