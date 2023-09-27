package com.example.data.remote.datasource.search

import com.example.data.remote.dto.search.SearchResponse
import kotlinx.coroutines.flow.Flow

interface SearchDataSource {
    suspend fun search(query: String): Flow<SearchResponse>
}