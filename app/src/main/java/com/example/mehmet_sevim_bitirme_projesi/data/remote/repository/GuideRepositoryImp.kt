package com.example.mehmet_sevim_bitirme_projesi.data.remote.repository

import com.example.mehmet_sevim_bitirme_projesi.data.remote.ApiService
import com.example.mehmet_sevim_bitirme_projesi.domain.model.guide.GuideIcon
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.GuideRepository
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.SearchReposiyory
import retrofit2.Call

class GuideRepositoryImp (private val apiService: ApiService): GuideRepository {
    override fun getAllTravelList(): Call<List<HomeScreenTravelListItem>> {
        return apiService.getAllTravelList()
    }

    override fun getAllCategories(): Call<List<GuideIcon>> {
        return apiService.getAllCategories()
    }
}