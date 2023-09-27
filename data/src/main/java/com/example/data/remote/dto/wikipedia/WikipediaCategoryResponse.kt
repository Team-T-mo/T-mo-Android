package com.example.data.remote.dto.wikipedia

import com.example.domain.entity.wikipedia.WikipediaCategoryEntity
import com.google.gson.annotations.SerializedName

data class WikipediaCategoryResponse(
    @SerializedName("batchcomplete") val batchComplete: String,
    @SerializedName("query") val query: QueryData
)

data class QueryData(
    @SerializedName("pages") val pages: Map<String, PageData>
)

data class PageData(
    @SerializedName("pageid") val pageId: Int,
    @SerializedName("ns") val namespace: Int,
    @SerializedName("title") val pageTitle: String,
    @SerializedName("revisions") val revisionList: List<RevisionData>
)

data class RevisionData(
    @SerializedName("contentformat") val contentFormat: String,
    @SerializedName("contentmodel") val contentModel: String,
    @SerializedName("*") val pageContent: String // JSON 키 '*'에 해당하는 필드명은 '*'로 설정
)

fun WikipediaCategoryResponse.toEntity(): WikipediaCategoryEntity {
    val firstPage = query.pages.values.firstOrNull()
    val firstRevision = firstPage?.revisionList?.firstOrNull()
    val content = firstRevision?.pageContent ?: ""
    return WikipediaCategoryEntity(
        content = content
    )
}
