package com.example.domain.repository

import com.example.domain.entity.TranslationEntity
import kotlinx.coroutines.flow.Flow

interface TranslationRepository {
    suspend fun translation(
        sourceLanguage: String,
        targetLanguage: String,
        text: String
    ): Flow<TranslationEntity>
}