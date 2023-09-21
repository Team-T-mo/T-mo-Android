package com.example.domain.usecase

import com.example.domain.repository.DetailSearchRepository
import javax.inject.Inject

class DetailSearchUseCase @Inject constructor(
    private val detailSearchRepository: DetailSearchRepository
) {
    suspend fun getDetailSearch(id: Int) = detailSearchRepository.detailSearch(id)
}