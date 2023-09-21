package com.example.data.remote.api

import com.example.data.remote.dto.DetailSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailSearchApi {

    @GET("taxa/{id}")
    suspend fun detailSearchMushrooms(
        @Path("id") id: Int
    ): DetailSearchResponse
}