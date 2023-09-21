package com.example.data.remote.datasource

import com.example.data.remote.api.DetailSearchApi
import com.example.data.remote.dto.DetailSearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailSearchDataSourceImpl @Inject constructor(
    private val detailSearchApi: DetailSearchApi
): DetailSearchDataSource {

    override suspend fun detailSearch(id: Int): Flow<DetailSearchResponse> {
        return flow {
            try {
                val response = detailSearchApi.detailSearchMushrooms(id)
                emit(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}