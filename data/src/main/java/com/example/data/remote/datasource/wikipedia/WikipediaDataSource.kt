package com.example.data.remote.datasource.wikipedia

import com.example.data.remote.dto.wikipedia.WikipediaCategoryResponse
import com.example.data.remote.dto.wikipedia.WikipediaResponse
import kotlinx.coroutines.flow.Flow

interface WikipediaDataSource {
    suspend fun wikipedia(title: String): Flow<WikipediaResponse>

    suspend fun wikipediaCategory(title: String): Flow<WikipediaCategoryResponse>
}