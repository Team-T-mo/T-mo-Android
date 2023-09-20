package com.example.data.remote.dto

import com.example.domain.entity.SearchEntity
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("results") val results: List<ResultItem>
)

data class ResultItem(
    @SerializedName("record") val record: Record
)

data class Record(
    @SerializedName("name") val name: String,
    @SerializedName("default_photo") val defaultPhoto: DefaultPhoto,
    @SerializedName("rank") val rank: String,
    @SerializedName("iconic_taxon_name") val iconicTaxonName: String,
    @SerializedName("is_active") val isActive: Boolean
)

data class DefaultPhoto(
    @SerializedName("url") val url: String
)

fun SearchResponse.toEntity(): SearchEntity {
    val record = results.firstOrNull()?.record // 첫 번째 ResultItem 사용
    return SearchEntity(
        id = totalResults,
        name = record?.name ?: "",
        rank = record?.rank ?: "",
        iconicTaxonName = record?.iconicTaxonName ?: "",
        isActive = record?.isActive ?: false,
        imageUrl = record?.defaultPhoto?.url ?: ""
    )
}
