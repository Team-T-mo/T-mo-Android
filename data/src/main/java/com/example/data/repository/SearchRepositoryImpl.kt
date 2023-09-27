package com.example.data.repository

import com.example.data.remote.datasource.search.SearchDataSource
import com.example.domain.entity.search.SearchEntity
import com.example.data.remote.dto.search.toEntity
import com.example.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource
): SearchRepository {
    override suspend fun search(query: String): Flow<SearchEntity> {
        return searchDataSource.search(query).map { it.toEntity() }
    }
}