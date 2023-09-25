package com.example.data.remote.datasource.wikipedia

import com.example.data.remote.api.WikipediaApi
import com.example.data.remote.dto.WikipediaResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class WikipediaDataSourceImpl @Inject constructor(
    @Named("WikipediaApi") private val wikipediaApi: WikipediaApi
): WikipediaDataSource {
    override suspend fun wikipedia(title: String): Flow<WikipediaResponse> {
        return flow {
            try {
                val response = wikipediaApi.wikipedia(titles = title)
                emit(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}