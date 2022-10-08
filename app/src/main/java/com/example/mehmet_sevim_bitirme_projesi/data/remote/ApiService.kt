package com.example.mehmet_sevim_bitirme_projesi.data.remote

import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("AllTravelList")
    fun getAllTravelList(): Call<List<HomeScreenTravelListItem>>

    @GET("AllTravelList/{id}")
     fun getTravelListById(
        @Path(value = "id", encoded = false) id: String,

        ) : Call<HomeScreenTravelListItem>
}