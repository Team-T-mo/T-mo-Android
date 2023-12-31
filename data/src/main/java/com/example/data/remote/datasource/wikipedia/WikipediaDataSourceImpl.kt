package com.example.data.remote.datasource.wikipedia

import com.example.data.remote.api.WikipediaApi
import com.example.data.remote.dto.wikipedia.WikipediaCategoryResponse
import com.example.data.remote.dto.wikipedia.WikipediaResponse
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

    override suspend fun wikipediaCategory(title: String): Flow<WikipediaCategoryResponse> {
        return flow {
            try {
                val response = wikipediaApi.wikipediaCategory(titles = title)
                emit(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}