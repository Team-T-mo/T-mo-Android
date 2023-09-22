package com.example.data.repository

import com.example.data.remote.datasource.translation.TranslationDataSource
import com.example.data.remote.dto.toEntity
import com.example.domain.entity.TranslationEntity
import com.example.domain.repository.TranslationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TranslationRepositoryImpl @Inject constructor(
    private val translationDataSource: TranslationDataSource
): TranslationRepository {
    override suspend fun translation(
        sourceLanguage: String,
        targetLanguage: String,
        text: String
        ): Flow<TranslationEntity> {
        return translationDataSource.translation(sourceLanguage, targetLanguage, text).map { it.toEntity() }
    }
}