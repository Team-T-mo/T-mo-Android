package com.example.data.remote.api

import com.example.data.remote.dto.detail_search.DetailSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailSearchApi {

    @GET("taxa/{id}")
    suspend fun detailSearch(
        @Path("id") id: Int
    ): DetailSearchResponse
}