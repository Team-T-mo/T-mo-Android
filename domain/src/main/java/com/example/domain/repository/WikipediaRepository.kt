package com.example.domain.repository

import com.example.domain.entity.wikipedia.WikipediaCategoryEntity
import com.example.domain.entity.wikipedia.WikipediaEntity
import kotlinx.coroutines.flow.Flow

interface WikipediaRepository {
    suspend fun wikipedia(title: String): Flow<WikipediaEntity>

    suspend fun wikipediaCategory(title: String): Flow<WikipediaCategoryEntity>
}