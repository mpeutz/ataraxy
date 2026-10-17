package com.ataraxy.app.data.repository

import com.ataraxy.app.data.local.dao.VirtueDao
import com.ataraxy.app.data.local.entity.SubConceptEntity
import com.ataraxy.app.data.local.entity.VirtueEntity
import com.ataraxy.app.domain.model.SubConcept
import com.ataraxy.app.domain.model.Virtue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VirtueRepository @Inject constructor(
    private val virtueDao: VirtueDao
) {
    fun getAllVirtues(): Flow<List<Virtue>> =
        virtueDao.getAllVirtues().map { list -> list.map { it.toDomain() } }

    fun getVirtueById(id: String): Flow<Virtue?> =
        combine(
            virtueDao.getVirtueById(id),
            virtueDao.getSubConcepts(id)
        ) { virtue, concepts ->
            virtue?.toDomain(concepts)
        }

    private fun VirtueEntity.toDomain(subConcepts: List<SubConceptEntity> = emptyList()) = Virtue(
        id = id,
        name = name,
        latinName = latinName,
        symbol = symbol,
        definingQuote = definingQuote,
        definingQuoteAuthor = definingQuoteAuthor,
        subConcepts = subConcepts.map { it.toDomain() }
    )

    private fun SubConceptEntity.toDomain() = SubConcept(
        id = id,
        virtueId = virtueId,
        number = number,
        title = title,
        description = description
    )
}
