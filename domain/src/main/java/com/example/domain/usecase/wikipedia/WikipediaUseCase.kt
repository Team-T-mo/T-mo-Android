package com.example.domain.usecase.wikipedia

import com.example.domain.repository.WikipediaRepository
import javax.inject.Inject

class WikipediaUseCase @Inject constructor(
    private val wikipediaRepository: WikipediaRepository
) {
    suspend operator fun invoke(title: String) = wikipediaRepository.wikipedia(title)
}