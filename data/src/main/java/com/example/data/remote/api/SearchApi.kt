package com.example.data.remote.api

import com.example.data.remote.dto.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("search")
    suspend fun searchMushrooms(
        @Query("q") query: String
    ): SearchResponse

}