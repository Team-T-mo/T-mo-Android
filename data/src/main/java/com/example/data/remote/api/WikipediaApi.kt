package com.example.data.remote.api

import com.example.data.remote.dto.WikipediaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WikipediaApi {

    @GET("w/api.php")
    suspend fun wikipedia(
        @Query("action") action: String = "query",
        @Query("format") format: String = "json",
        @Query("prop") prop: String = "extracts",
        @Query("explaintext") explaintext: Boolean = true,
        @Query("titles") titles: String
    ): WikipediaResponse
}