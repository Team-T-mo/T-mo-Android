package com.example.data.remote.api

import com.example.data.remote.dto.TranslationRequest
import com.example.data.remote.dto.TranslationResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface TranslationApi {

    @Headers(
        "X-Naver-Client-Id: 6ClIeSZGXr7JL9Es71tX",
        "X-Naver-Client-Secret: ws2kBIMopg"
    )
    @POST("v1/papago/n2mt")
    suspend fun translateText(
        @Body request: TranslationRequest
    ): TranslationResponse
}