package com.example.domain.usecase

import com.example.domain.repository.TranslationRepository
import javax.inject.Inject

class TranslationUseCase @Inject constructor(
    private val translationRepository: TranslationRepository
) {
    suspend operator fun invoke(
        sourceLanguage: String,
        targetLanguage: String,
        text: String
    ) = translationRepository.translation(sourceLanguage, targetLanguage, text)
}