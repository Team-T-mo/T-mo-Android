package com.example.data.remote.datasource.search

import com.example.data.remote.api.SearchApi
import com.example.data.remote.dto.search.SearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchDataSourceImpl @Inject constructor(
    private val searchApi: SearchApi
): SearchDataSource {
    override suspend fun search(query: String): Flow<SearchResponse> {
        return flow {
            try {
                val response = searchApi.search(query)
                emit(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}