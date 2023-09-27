package com.example.data.remote.api

import com.example.data.remote.dto.wikipedia.WikipediaCategoryResponse
import com.example.data.remote.dto.wikipedia.WikipediaResponse
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

    @GET("w/api.php")
    suspend fun wikipediaCategory(
        @Query("action") action: String = "query",
        @Query("format") format: String = "json",
        @Query("prop") prop: String = "revisions",
        @Query("rvprop") rvprop: String = "content",
        @Query("titles") titles: String
    ): WikipediaCategoryResponse
}