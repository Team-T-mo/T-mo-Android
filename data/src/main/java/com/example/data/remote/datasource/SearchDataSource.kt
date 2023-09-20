package com.example.data.remote.datasource

import com.example.data.remote.dto.SearchResponse
import com.example.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

interface SearchDataSource {
    suspend fun search(query: String): Flow<SearchResponse>
}