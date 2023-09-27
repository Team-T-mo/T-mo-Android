package com.example.data.remote.datasource.detail_search

import com.example.data.remote.api.DetailSearchApi
import com.example.data.remote.dto.detail_search.DetailSearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailSearchDataSourceImpl @Inject constructor(
    private val detailSearchApi: DetailSearchApi
): DetailSearchDataSource {

    override suspend fun detailSearch(id: Int): Flow<DetailSearchResponse> {
        return flow {
            try {
                val response = detailSearchApi.detailSearch(id)
                emit(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}