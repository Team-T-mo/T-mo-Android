package com.example.domain.usecase.wikipedia

import com.example.domain.repository.WikipediaRepository
import javax.inject.Inject

class WikipediaCategoryUseCase @Inject constructor(
    private val wikipediaRepository: WikipediaRepository
) {
    suspend operator fun invoke(title: String) = wikipediaRepository.wikipediaCategory(title)
}