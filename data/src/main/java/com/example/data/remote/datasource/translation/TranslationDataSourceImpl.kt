package com.example.data.remote.datasource.translation

import com.example.data.remote.api.TranslationApi
import com.example.data.remote.datasource.translation.TranslationDataSource
import com.example.data.remote.dto.TranslationRequest
import com.example.data.remote.dto.TranslationResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class TranslationDataSourceImpl @Inject constructor(
    @Named("TranslationApi") private val translationApi: TranslationApi
): TranslationDataSource {
    override suspend fun translation(
        sourceLanguage: String,
        targetLanguage: String,
        text: String
    ): Flow<TranslationResponse> {
        return flow {
            try {
                val response = translationApi.translateText(TranslationRequest(sourceLanguage, targetLanguage, text))
                emit(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}