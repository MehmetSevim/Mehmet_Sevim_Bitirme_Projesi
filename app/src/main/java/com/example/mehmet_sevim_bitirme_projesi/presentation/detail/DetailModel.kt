package com.example.mehmet_sevim_bitirme_projesi.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.DetailUseCase
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.GuideUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailModel @Inject constructor(private val detailUseCase: DetailUseCase
): ViewModel()  {

     fun getTravelListById(id : String): LiveData<HomeScreenTravelListItem> {
        with(detailUseCase){
            getTravelListById(id)
            return travelList
        }
    }
}