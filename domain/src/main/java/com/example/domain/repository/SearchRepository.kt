package com.example.domain.repository

import com.example.domain.entity.search.SearchEntity
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun search(query: String): Flow<SearchEntity>
}