package com.example.data.repository

import com.example.data.remote.datasource.wikipedia.WikipediaDataSource
import com.example.data.remote.dto.toEntity
import com.example.domain.entity.WikipediaEntity
import com.example.domain.repository.WikipediaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WikipediaRepositoryImpl @Inject constructor(
    private val wikipediaDataSource: WikipediaDataSource
): WikipediaRepository {
    override suspend fun wikipedia(title: String): Flow<WikipediaEntity> {
        return wikipediaDataSource.wikipedia(title).map { it.toEntity() }
    }
}