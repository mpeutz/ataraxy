package com.ataraxy.app.data.backup

import com.ataraxy.app.data.backup.BackupFormatException.Reason
import com.ataraxy.app.data.local.entity.BookmarkEntity
import com.ataraxy.app.data.local.entity.JournalEntryEntity
import com.ataraxy.app.data.local.entity.ReflectionEntity
import com.ataraxy.app.data.local.entity.ReflectionNoteEntity
import com.ataraxy.app.data.local.entity.ReflectionWithNotes
import com.ataraxy.app.data.local.entity.SosEventEntity
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.security.MessageDigest
import java.time.Instant
import java.time.format.DateTimeParseException

object BackupCodec {
    const val FORMAT_VERSION = 1
    private const val FORMAT_MARKER = "ataraxy-backup"

    fun encode(snapshot: BackupSnapshot, createdAt: Instant, appVersionCode: Long): String =
        JSONObject()
            .put("format", FORMAT_MARKER)
            .put("formatVersion", FORMAT_VERSION)
            .put("createdAt", createdAt.toString())
            .put("appVersionCode", appVersionCode)
            .put("journalEntries", JSONArray(snapshot.journalEntries.map(::journalToJson)))
            .put("reflections", JSONArray(snapshot.reflections.map(::reflectionToJson)))
            .put("bookmarks", JSONArray(snapshot.bookmarks.map(::bookmarkToJson)))
            .put("sosEvents", JSONArray(snapshot.sosEvents.map(::sosToJson)))
            .put("preferences", preferencesToJson(snapshot.preferences))
            .toString()

    fun decode(text: String): BackupFile {
        try {
            val root = JSONObject(text)
            if (root.optString("format") != FORMAT_MARKER) throw BackupFormatException(Reason.NOT_A_BACKUP)
            val version = root.getInt("formatVersion")
            if (version > FORMAT_VERSION) throw BackupFormatException(Reason.NEWER_VERSION)
            return BackupFile(
                formatVersion = version,
                createdAt = Instant.parse(root.getString("createdAt")),
                appVersionCode = root.getLong("appVersionCode"),
                snapshot = BackupSnapshot(
                    journalEntries = root.getJSONArray("journalEntries").mapObjects(::journalFromJson),
                    reflections = root.getJSONArray("reflections").mapObjects(::reflectionFromJson),
                    bookmarks = root.getJSONArray("bookmarks").mapObjects(::bookmarkFromJson),
                    sosEvents = root.getJSONArray("sosEvents").mapObjects(::sosFromJson),
                    preferences = preferencesFromJson(root.getJSONObject("preferences"))
                )
            )
        } catch (e: JSONException) {
            throw BackupFormatException(Reason.NOT_A_BACKUP)
        } catch (e: DateTimeParseException) {
            throw BackupFormatException(Reason.NOT_A_BACKUP)
        }
    }

    fun contentHash(snapshot: BackupSnapshot): String {
        val encoded = encode(snapshot, Instant.EPOCH, 0L)
        return MessageDigest.getInstance("SHA-256")
            .digest(encoded.toByteArray(Charsets.UTF_8))
            .joinToString("") { "%02x".format(it) }
    }

    private fun journalToJson(e: JournalEntryEntity) = JSONObject()
        .put("id", e.id)
        .put("createdAt", e.createdAt)
        .put("updatedAt", e.updatedAt)
        .put("content", e.content)
        .put("promptText", e.promptText)
        .put("linkedQuoteId", e.linkedQuoteId ?: JSONObject.NULL)
        .put("virtueId", e.virtueId ?: JSONObject.NULL)
        .put("ritualType", e.ritualType ?: JSONObject.NULL)

    private fun journalFromJson(o: JSONObject) = JournalEntryEntity(
        id = o.getLong("id"),
        createdAt = o.getString("createdAt"),
        updatedAt = o.getString("updatedAt"),
        content = o.getString("content"),
        promptText = o.getString("promptText"),
        linkedQuoteId = o.nullableString("linkedQuoteId"),
        virtueId = o.nullableString("virtueId"),
        ritualType = o.nullableString("ritualType")
    )

    private fun reflectionToJson(r: ReflectionWithNotes) = JSONObject()
        .put("id", r.reflection.id)
        .put("worry", r.reflection.worry)
        .put("yours", r.reflection.yours)
        .put("notYours", r.reflection.notYours)
        .put("canDo", r.reflection.canDo)
        .put("setDown", r.reflection.setDown)
        .put("createdAt", r.reflection.createdAt)
        .put("completedAt", r.reflection.completedAt ?: JSONObject.NULL)
        .put("setDownAt", r.reflection.setDownAt ?: JSONObject.NULL)
        .put("notes", JSONArray(r.notes.map(::noteToJson)))

    private fun reflectionFromJson(o: JSONObject): ReflectionWithNotes {
        val id = o.getLong("id")
        return ReflectionWithNotes(
            reflection = ReflectionEntity(
                id = id,
                worry = o.getString("worry"),
                yours = o.getString("yours"),
                notYours = o.getString("notYours"),
                canDo = o.getString("canDo"),
                setDown = o.getString("setDown"),
                createdAt = o.getString("createdAt"),
                completedAt = o.nullableString("completedAt"),
                setDownAt = o.nullableString("setDownAt")
            ),
            notes = o.getJSONArray("notes").mapObjects { noteFromJson(it, id) }
        )
    }

    private fun noteToJson(n: ReflectionNoteEntity) = JSONObject()
        .put("id", n.id)
        .put("text", n.text)
        .put("createdAt", n.createdAt)

    private fun noteFromJson(o: JSONObject, reflectionId: Long) = ReflectionNoteEntity(
        id = o.getLong("id"),
        reflectionId = reflectionId,
        text = o.getString("text"),
        createdAt = o.getString("createdAt")
    )

    private fun bookmarkToJson(b: BookmarkEntity) = JSONObject()
        .put("quoteId", b.quoteId)
        .put("savedAt", b.savedAt)

    private fun bookmarkFromJson(o: JSONObject) = BookmarkEntity(
        quoteId = o.getString("quoteId"),
        savedAt = o.getString("savedAt")
    )

    private fun sosToJson(s: SosEventEntity) = JSONObject()
        .put("id", s.id)
        .put("emotion", s.emotion)
        .put("quoteId", s.quoteId)
        .put("triggeredAt", s.triggeredAt)

    private fun sosFromJson(o: JSONObject) = SosEventEntity(
        id = o.getLong("id"),
        emotion = o.getString("emotion"),
        quoteId = o.getString("quoteId"),
        triggeredAt = o.getString("triggeredAt")
    )

    private fun preferencesToJson(prefs: Map<String, PrefValue>): JSONObject {
        val out = JSONObject()
        prefs.toSortedMap().forEach { (key, value) ->
            val entry = when (value) {
                is PrefValue.IntValue -> JSONObject().put("type", "int").put("value", value.value)
                is PrefValue.LongValue -> JSONObject().put("type", "long").put("value", value.value)
                is PrefValue.BooleanValue -> JSONObject().put("type", "boolean").put("value", value.value)
                is PrefValue.StringValue -> JSONObject().put("type", "string").put("value", value.value)
            }
            out.put(key, entry)
        }
        return out
    }

    private fun preferencesFromJson(o: JSONObject): Map<String, PrefValue> {
        val result = linkedMapOf<String, PrefValue>()
        for (key in o.keys()) {
            val entry = o.getJSONObject(key)
            val value = when (entry.getString("type")) {
                "int" -> PrefValue.IntValue(entry.getInt("value"))
                "long" -> PrefValue.LongValue(entry.getLong("value"))
                "boolean" -> PrefValue.BooleanValue(entry.getBoolean("value"))
                "string" -> PrefValue.StringValue(entry.getString("value"))
                else -> null
            }
            if (value != null) result[key] = value
        }
        return result
    }

    private fun JSONObject.nullableString(name: String): String? =
        if (isNull(name)) null else getString(name)

    private fun <T> JSONArray.mapObjects(transform: (JSONObject) -> T): List<T> =
        List(length()) { transform(getJSONObject(it)) }
}
