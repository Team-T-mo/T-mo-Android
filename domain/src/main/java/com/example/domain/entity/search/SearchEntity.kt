package com.example.domain.entity.search

data class SearchEntity(
    val id: Int,
    val name: String,
    val rank: String,
    val iconicTaxonName: String,
    val isActive: Boolean,
    val imageUrl: String,
)
