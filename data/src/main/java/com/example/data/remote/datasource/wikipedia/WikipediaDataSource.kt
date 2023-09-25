package com.example.data.remote.datasource.wikipedia

import com.example.data.remote.dto.WikipediaResponse
import kotlinx.coroutines.flow.Flow

interface WikipediaDataSource {
    suspend fun wikipedia(title: String): Flow<WikipediaResponse>
}