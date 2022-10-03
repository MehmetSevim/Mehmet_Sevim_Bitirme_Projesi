package com.example.mehmet_sevim_bitirme_projesi.domain.model.home

data class Image(
    val altText: Any,
    val height: Int,
    val width: Int,
    val url: String,
    val isHeroImage: Boolean
)