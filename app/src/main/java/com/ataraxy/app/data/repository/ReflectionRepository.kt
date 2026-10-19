package com.ataraxy.app.data.repository

import com.ataraxy.app.data.local.dao.ReflectionDao
import com.ataraxy.app.data.local.entity.ReflectionEntity
import com.ataraxy.app.data.local.entity.ReflectionNoteEntity
import com.ataraxy.app.data.local.entity.ReflectionWithNotes
import com.ataraxy.app.domain.model.Reflection
import com.ataraxy.app.domain.model.ReflectionNote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReflectionRepository @Inject constructor(
    private val dao: ReflectionDao
) {
    fun observeOpen(): Flow<List<Reflection>> = dao.observeOpen().map { list -> list.map { it.toDomain() } }

    fun observePast(): Flow<List<Reflection>> = dao.observePast().map { list -> list.map { it.toDomain() } }

    fun observe(id: Long): Flow<Reflection?> = dao.observe(id).map { it?.toDomain() }

    suspend fun get(id: Long): Reflection? = dao.get(id)?.toDomain()

    suspend fun getAll(): List<Reflection> = dao.getAll().map { it.toDomain() }

    suspend fun create(worry: String, now: LocalDateTime): Long =
        dao.insert(ReflectionEntity(worry = worry.oneLine(), createdAt = now.toString()))

    suspend fun saveAnswers(id: Long, yours: List<String>, notYours: List<String>, canDo: String, setDown: String) =
        dao.updateAnswers(id, yours.joinLines(), notYours.joinLines(), canDo.trim(), setDown.trim())

    suspend fun complete(id: Long, now: LocalDateTime) = dao.updateCompletedAt(id, now.toString())

    suspend fun addNote(id: Long, text: String, now: LocalDateTime) {
        dao.insertNote(ReflectionNoteEntity(reflectionId = id, text = text.trim(), createdAt = now.toString()))
    }

    suspend fun setDown(id: Long, now: LocalDateTime) = dao.updateSetDownAt(id, now.toString())

    suspend fun pickUp(id: Long) = dao.updateSetDownAt(id, null)

    suspend fun delete(id: Long) = dao.delete(id)

    suspend fun deleteAll() = dao.deleteAll()

    private fun ReflectionWithNotes.toDomain() = Reflection(
        id = reflection.id,
        worry = reflection.worry,
        yours = reflection.yours.splitLines(),
        notYours = reflection.notYours.splitLines(),
        canDo = reflection.canDo,
        setDown = reflection.setDown,
        notes = notes
            .map { ReflectionNote(it.id, it.text, LocalDateTime.parse(it.createdAt)) }
            .sortedBy { it.createdAt },
        createdAt = LocalDateTime.parse(reflection.createdAt),
        completedAt = reflection.completedAt?.let(LocalDateTime::parse),
        setDownAt = reflection.setDownAt?.let(LocalDateTime::parse)
    )
}

/** Lines are stored newline-joined, so each one must itself be a single trimmed line. */
private fun String.oneLine(): String = replace(Regex("\\s*\\R\\s*"), " ").trim()

private fun List<String>.joinLines(): String = map { it.oneLine() }.filter { it.isNotEmpty() }.joinToString("\n")

private fun String.splitLines(): List<String> = if (isEmpty()) emptyList() else split("\n")
