package com.example.domain.repository

import com.example.domain.entity.detail_search.DetailSearchEntity
import kotlinx.coroutines.flow.Flow


interface DetailSearchRepository {
    suspend fun detailSearch(id: Int): Flow<DetailSearchEntity>
}