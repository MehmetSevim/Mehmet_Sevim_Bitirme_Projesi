package com.example.mehmet_sevim_bitirme_projesi.presentation.tripandbookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.GuideUseCase
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.TripBookMarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TripBookMarkList @Inject constructor(private val tripBookMarkUseCase: TripBookMarkUseCase
): ViewModel() {

    fun getAllTravel(): LiveData<List<HomeScreenTravelListItem>> {
        with(tripBookMarkUseCase) {
            getAllTravelList()
            return travelList
        }
    }
}
