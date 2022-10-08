package com.example.mehmet_sevim_bitirme_projesi.data.remote.repository

import com.example.mehmet_sevim_bitirme_projesi.data.remote.ApiService
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.DetailRepository

import retrofit2.Call

class DetailRepositoryImp (private val apiService: ApiService): DetailRepository {

       override  fun getTravelListById(id: String): Call<HomeScreenTravelListItem> {
        return apiService.getTravelListById(id)
    }


}