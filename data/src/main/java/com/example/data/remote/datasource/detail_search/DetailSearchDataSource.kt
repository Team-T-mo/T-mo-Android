package com.example.data.remote.datasource.detail_search

import com.example.data.remote.dto.detail_search.DetailSearchResponse
import kotlinx.coroutines.flow.Flow

interface DetailSearchDataSource {
    suspend fun detailSearch(id: Int): Flow<DetailSearchResponse>
}