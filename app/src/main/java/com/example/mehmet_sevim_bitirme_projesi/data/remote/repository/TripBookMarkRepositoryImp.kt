package com.example.mehmet_sevim_bitirme_projesi.data.remote.repository

import com.example.mehmet_sevim_bitirme_projesi.data.remote.ApiService
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.TripBookMarkRepository
import retrofit2.Call


class TripBookMarkRepositoryImp (private val apiService: ApiService): TripBookMarkRepository {
    override fun getAllTravelList(): Call<List<HomeScreenTravelListItem>> {
        return apiService.getAllTravelList()
    }
}