package com.example.domain.usecase

import com.example.domain.repository.DetailSearchRepository
import javax.inject.Inject

class DetailSearchUseCase @Inject constructor(
    private val detailSearchRepository: DetailSearchRepository
) {
    suspend operator fun invoke(id: Int) = detailSearchRepository.detailSearch(id)
}