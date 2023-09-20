package com.example.domain.usecase

import com.example.domain.repository.SearchRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository
){
    suspend fun getSearchList(query: String) = searchRepository.search(query)
}