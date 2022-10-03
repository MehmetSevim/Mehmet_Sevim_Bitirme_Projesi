package com.example.mehmet_sevim_bitirme_projesi.data.remote

import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("AllTravelList")
    fun getAllTravelList(): Call<List<HomeScreenTravelListItem>>
}