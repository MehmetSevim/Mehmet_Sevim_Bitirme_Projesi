package com.example.mehmet_sevim_bitirme_projesi.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.HomeTravelListUseCase
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchListModel @Inject constructor(private val homeTravelListUseCase:  HomeTravelListUseCase
): ViewModel()  {


    init {
        getAllTravelList()
    }

    fun getAllTravelList(): LiveData<List<HomeScreenTravelListItem>> {
        with(homeTravelListUseCase){
            getAllTravelList()
            return travelList
        }
    }
    fun getAllDestinations(): LiveData<List<HomeScreenTravelListItem>> {
        with(homeTravelListUseCase){
            getAllDestinations()
            return destinations
        }
    }

    fun getAllNearby(): LiveData<List<HomeScreenTravelListItem>> {
        with(homeTravelListUseCase){
            getAllNearby()
            return nearby
        }
    }
}