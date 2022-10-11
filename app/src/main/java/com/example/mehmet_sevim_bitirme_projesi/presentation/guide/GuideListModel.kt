package com.example.mehmet_sevim_bitirme_projesi.presentation.guide

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mehmet_sevim_bitirme_projesi.domain.model.guide.GuideIcon
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.GuideUseCase
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuideListModel @Inject constructor(private val guideUseCase: GuideUseCase
): ViewModel()  {

    fun getAllTravel(): LiveData<List<HomeScreenTravelListItem>> {
        with(guideUseCase){
            getAllTravelList()
            return travelList
        }
    }

    fun getAllCategories(): LiveData<List<GuideIcon>>{
        with(guideUseCase){
            getAllCategories()
            return guideList
        }
    }
}