package com.example.data.remote.dto

import com.example.domain.entity.DetailSearchEntity
import com.google.gson.annotations.SerializedName

data class DetailSearchResponse(
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
    @SerializedName("results") val results: List<Taxon>
)

data class Taxon(
    @SerializedName("id") val id: Int,
    @SerializedName("iconic_taxon_id") val iconicTaxonId: Int,
    @SerializedName("iconic_taxon_name") val iconicTaxonName: String,
    @SerializedName("is_active") val isActive: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("preferred_common_name") val preferredCommonName: String,
    @SerializedName("rank") val rank: String,
    @SerializedName("rank_level") val rankLevel: Int,
    @SerializedName("ancestor_ids") val ancestorIds: List<Int>,
    @SerializedName("colors") val colors: List<Color>,
    @SerializedName("conservation_status") val conservationStatus: ConservationStatus,
    @SerializedName("conservation_statuses") val conservationStatuses: List<ConservationStatus>,
    @SerializedName("default_photo") val defaultPhoto: Photo,
    @SerializedName("establishment_means") val establishmentMeans: EstablishmentMeans,
    @SerializedName("observations_count") val observationsCount: Int,
    @SerializedName("preferred_establishment_means") val preferredEstablishmentMeans: String,
    @SerializedName("wikipedia_summary") val wikipediaSummary: String,
    @SerializedName("wikipedia_url") val wikipediaUrl: String
)

data class Color(
    @SerializedName("id") val id: Int,
    @SerializedName("value") val value: String
)

data class ConservationStatus(
    @SerializedName("place_id") val placeId: Int,
    @SerializedName("place") val place: Place,
    @SerializedName("status") val status: String
)

data class Place(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("display_name") val displayName: String
)

data class Photo(
    @SerializedName("id") val id: Int,
    @SerializedName("attribution") val attribution: String,
    @SerializedName("license_code") val licenseCode: String,
    @SerializedName("url") val url: String,
    @SerializedName("medium_url") val mediumUrl: String,
    @SerializedName("square_url") val squareUrl: String
)

data class EstablishmentMeans(
    @SerializedName("establishment_means") val establishmentMeans: String,
    @SerializedName("place") val place: Place
)

fun DetailSearchResponse.toEntity(): DetailSearchEntity {
    val taxon = results.firstOrNull()
    return DetailSearchEntity(
        id = taxon?.id ?: 0,
        iconicTaxonId = taxon?.iconicTaxonId ?: 0,
        iconicTaxonName = taxon?.iconicTaxonName ?: "",
        isActive = taxon?.isActive ?: false,
        name = taxon?.name ?: "",
        preferredCommonName = taxon?.preferredCommonName ?: "",
        rank = taxon?.rank ?: "",
        rankLevel = taxon?.rankLevel ?: 0,
        ancestorIds = taxon?.ancestorIds ?: emptyList(),
        colors = taxon?.colors?.map { it.value } ?: emptyList(),
        conservationStatus = taxon?.conservationStatus?.status ?: "",
        defaultPhotoUrl = taxon?.defaultPhoto?.url ?: "",
        establishmentMeans = taxon?.establishmentMeans?.establishmentMeans ?: "",
        establishmentMeansPlace = taxon?.establishmentMeans?.place?.name ?: "",
        observationsCount = taxon?.observationsCount ?: 0,
        preferredEstablishmentMeans = taxon?.preferredEstablishmentMeans ?: "",
        wikipediaSummary = taxon?.wikipediaSummary ?: "",
        wikipediaUrl = taxon?.wikipediaUrl ?: ""
    )
}
