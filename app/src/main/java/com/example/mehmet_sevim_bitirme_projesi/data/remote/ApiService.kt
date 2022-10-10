package com.example.mehmet_sevim_bitirme_projesi.data.remote

import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("alltravel")
    fun getAllTravelList(): Call<List<HomeScreenTravelListItem>>

    @GET("alltravel/{id}")
     fun getTravelListById(
        @Path(value = "id", encoded = false) id: String,

        ) : Call<HomeScreenTravelListItem>

    @GET("alltravel?")
    fun getSearchResult(@Query("search") searchText:String) : Call<List<HomeScreenTravelListItem>>

}