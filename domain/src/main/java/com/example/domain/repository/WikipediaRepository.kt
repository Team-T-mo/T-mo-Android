package com.example.domain.repository

import com.example.domain.entity.WikipediaEntity
import kotlinx.coroutines.flow.Flow

interface WikipediaRepository {
    suspend fun wikipedia(title: String): Flow<WikipediaEntity>
}