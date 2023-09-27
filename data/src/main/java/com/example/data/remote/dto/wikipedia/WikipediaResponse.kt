package com.example.data.remote.dto.wikipedia

import com.example.domain.entity.wikipedia.WikipediaEntity
import com.google.gson.annotations.SerializedName

data class WikipediaResponse(
    @SerializedName("batchcomplete") val batchComplete: String,
    @SerializedName("query") val query: Query
)

data class Query(
    @SerializedName("pages") val pages: Map<String, Page>
)

data class Page(
    @SerializedName("pageid") val pageId: Int,
    @SerializedName("ns") val ns: Int,
    @SerializedName("title") val title: String,
    @SerializedName("extract") val extract: String
)

fun WikipediaResponse.toEntity(): WikipediaEntity {
    val firstPage = query.pages.values.firstOrNull()
    val content = firstPage?.extract ?: ""
    return WikipediaEntity(
        content = content
    )
}