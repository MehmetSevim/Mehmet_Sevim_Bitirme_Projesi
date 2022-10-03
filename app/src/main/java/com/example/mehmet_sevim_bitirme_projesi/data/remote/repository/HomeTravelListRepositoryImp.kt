package com.example.mehmet_sevim_bitirme_projesi.data.remote.repository

import com.example.mehmet_sevim_bitirme_projesi.data.remote.ApiService
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.HomeTravelListRepository
import retrofit2.Call

class HomeTravelListRepositoryImp (private val apiService: ApiService):HomeTravelListRepository{
    override fun getAllTravelList(): Call<List<HomeScreenTravelListItem>> {
        return apiService.getAllTravelList()
    }
}