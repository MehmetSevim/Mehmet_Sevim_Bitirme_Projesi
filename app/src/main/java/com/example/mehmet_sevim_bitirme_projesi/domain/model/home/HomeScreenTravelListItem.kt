package com.example.mehmet_sevim_bitirme_projesi.domain.model.home

data class HomeScreenTravelListItem(
    val category: String,
    val city: String,
    val country: String,
    val description: String,
    val id: String,
    val images: List<Image>,
    val isBookmark: Boolean,
    val title: String
)