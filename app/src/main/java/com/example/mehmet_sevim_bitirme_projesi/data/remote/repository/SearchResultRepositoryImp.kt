package com.example.mehmet_sevim_bitirme_projesi.data.remote.repository

import com.example.mehmet_sevim_bitirme_projesi.data.remote.ApiService
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.SearcResulRepository
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.SearchReposiyory

import retrofit2.Call

class SearchResultRepositoryImp (private val apiService: ApiService): SearcResulRepository {
    override fun getSearchResult(searchText: String): Call<List<HomeScreenTravelListItem>> {
        return apiService.getSearchResult(searchText)
    }
}