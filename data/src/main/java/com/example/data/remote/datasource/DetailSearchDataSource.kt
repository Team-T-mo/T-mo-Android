package com.example.data.remote.datasource

import com.example.data.remote.dto.DetailSearchResponse
import kotlinx.coroutines.flow.Flow

interface DetailSearchDataSource {
    suspend fun detailSearch(id: Int): Flow<DetailSearchResponse>
}