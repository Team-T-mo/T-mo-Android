package com.example.data.remote.dto

import com.example.domain.entity.TranslationEntity
import com.google.gson.annotations.SerializedName

data class TranslationResponse(
    @SerializedName("message") val message: Message
)

data class Message(
    @SerializedName("@type") val type: String,
    @SerializedName("@service") val service: String,
    @SerializedName("@version") val version: String,
    @SerializedName("result") val result: Result
)

data class Result(
    @SerializedName("srcLangType") val srcLangType: String,
    @SerializedName("tarLangType") val tarLangType: String,
    @SerializedName("translatedText") val translatedText: String
)

fun TranslationResponse.toEntity(): TranslationEntity{
    return TranslationEntity(
        translatedText = message.result.translatedText
    )
}