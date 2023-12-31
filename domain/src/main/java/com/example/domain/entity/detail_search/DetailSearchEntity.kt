package com.example.domain.entity.detail_search

data class DetailSearchEntity(
    val id: Int,
    val iconicTaxonId: Int,
    val iconicTaxonName: String,
    val isActive: Boolean,
    val name: String,
    val preferredCommonName: String,
    val rank: String,
    val rankLevel: Int,
    val ancestorIds: List<Int>,
    val colors: List<String>,
    val conservationStatus: String,
    val defaultPhotoUrl: String,
    val establishmentMeans: String,
    val establishmentMeansPlace: String,
    val observationsCount: Int,
    val preferredEstablishmentMeans: String,
    val wikipediaSummary: String
)

