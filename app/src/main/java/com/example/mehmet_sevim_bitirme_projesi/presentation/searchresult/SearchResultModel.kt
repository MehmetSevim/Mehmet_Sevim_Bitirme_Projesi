package com.example.mehmet_sevim_bitirme_projesi.presentation.searchresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.SearchResultUseCase
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchResultModel @Inject constructor(private val searchResultUseCase: SearchResultUseCase
): ViewModel()  {


    fun getSearchResult(searchText : String): LiveData<List<HomeScreenTravelListItem>> {
        with(searchResultUseCase){
            getSearchResult(searchText)
            return travelList
        }
    }

}