package com.example.data.repository

import com.example.data.remote.datasource.detail_search.DetailSearchDataSource
import com.example.data.remote.dto.toEntity
import com.example.domain.entity.DetailSearchEntity
import com.example.domain.repository.DetailSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DetailSearchRepositoryImpl @Inject constructor(
    private val detailSearchDataSource: DetailSearchDataSource
): DetailSearchRepository {
    override suspend fun detailSearch(id: Int): Flow<DetailSearchEntity> {
        return detailSearchDataSource.detailSearch(id).map { it.toEntity() }
    }
}