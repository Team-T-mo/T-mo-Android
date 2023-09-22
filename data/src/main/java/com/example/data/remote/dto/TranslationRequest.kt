package com.example.data.remote.dto

data class TranslationRequest(
    val source: String,
    val target: String,
    val text: String
)
