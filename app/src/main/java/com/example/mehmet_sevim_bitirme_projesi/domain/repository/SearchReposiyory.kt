package com.example.mehmet_sevim_bitirme_projesi.domain.repository

import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import retrofit2.Call

interface SearchReposiyory {
    fun getAllTravelList(): Call<List<HomeScreenTravelListItem>>
}