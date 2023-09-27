package com.example.data.remote.api

import com.example.data.remote.dto.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("search")
    suspend fun search(
        @Query("q") query: String
    ): SearchResponse

}