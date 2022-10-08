package com.example.mehmet_sevim_bitirme_projesi.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.HomeTravelListUseCase
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchListModel @Inject constructor(private val searchListUseCase: SearchUseCase
): ViewModel()  {


    fun getAllTravelList(): LiveData<List<HomeScreenTravelListItem>> {
        with(searchListUseCase){
            getAllTravelList()
            return travelList
        }
    }

}