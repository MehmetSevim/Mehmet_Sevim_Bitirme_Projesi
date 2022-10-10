package com.example.mehmet_sevim_bitirme_projesi.presentation.tripandbookmark.bottomsheet

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.GuideUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomSheetFragmentModel @Inject constructor(private val guideUseCase: GuideUseCase
): ViewModel()  {

    fun getAllTravel(): LiveData<List<HomeScreenTravelListItem>> {
        with(guideUseCase){
            getAllTravelList()
            return travelList
        }
    }
}