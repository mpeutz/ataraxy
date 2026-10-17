package com.ataraxy.app.data.repository

import com.ataraxy.app.data.local.dao.ControlItemDao
import com.ataraxy.app.data.local.entity.ControlItemEntity
import com.ataraxy.app.domain.model.ControlBucket
import com.ataraxy.app.domain.model.ControlItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ControlItemRepository @Inject constructor(
    private val controlItemDao: ControlItemDao
) {
    fun getActiveItems(): Flow<List<ControlItem>> =
        controlItemDao.getActiveItems().map { list -> list.map { it.toDomain() } }

    fun getInControlItems(): Flow<List<ControlItem>> =
        controlItemDao.getInControlItems().map { list -> list.map { it.toDomain() } }

    fun getCompletedItems(): Flow<List<ControlItem>> =
        controlItemDao.getCompletedItems().map { list -> list.map { it.toDomain() } }

    fun getReleasedItems(): Flow<List<ControlItem>> =
        controlItemDao.getReleasedItems().map { list -> list.map { it.toDomain() } }

    suspend fun upsert(item: ControlItem): Long =
        controlItemDao.upsert(item.toEntity())

    suspend fun archiveItem(id: Long) =
        controlItemDao.archiveItem(id)

    suspend fun updateBucket(id: Long, bucket: ControlBucket) =
        controlItemDao.updateBucket(id, bucket.name)

    suspend fun updateActionStep(id: Long, actionStep: String) =
        controlItemDao.updateActionStep(id, actionStep)

    suspend fun updateText(id: Long, text: String) =
        controlItemDao.updateText(id, text)

    suspend fun clearBucket(id: Long) =
        controlItemDao.clearBucket(id)

    suspend fun unarchiveItem(id: Long) =
        controlItemDao.unarchiveItem(id)

    suspend fun deleteById(id: Long) =
        controlItemDao.deleteById(id)

    suspend fun delete(item: ControlItem) =
        controlItemDao.delete(item.toEntity())

    suspend fun deleteAll() =
        controlItemDao.deleteAll()

    private fun ControlItemEntity.toDomain() = ControlItem(
        id = id,
        text = text,
        bucket = bucket?.let { runCatching { ControlBucket.valueOf(it) }.getOrNull() },
        actionStep = actionStep,
        createdAt = LocalDateTime.parse(createdAt),
        isArchived = isArchived
    )

    private fun ControlItem.toEntity() = ControlItemEntity(
        id = id,
        text = text,
        bucket = bucket?.name,
        actionStep = actionStep,
        createdAt = createdAt.toString(),
        isArchived = isArchived
    )
}
