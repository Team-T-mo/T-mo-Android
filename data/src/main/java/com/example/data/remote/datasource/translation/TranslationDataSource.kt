package com.example.data.remote.datasource.translation

import com.example.data.remote.dto.TranslationResponse
import kotlinx.coroutines.flow.Flow

interface TranslationDataSource {
    suspend fun translation(
        sourceLanguage: String,
        targetLanguage: String,
        text: String
    ): Flow<TranslationResponse>
}