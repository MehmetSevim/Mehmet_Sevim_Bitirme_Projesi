package com.example.mehmet_sevim_bitirme_projesi.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.HomeTravelListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeTravelListModel @Inject constructor(
    private val homeTravelListUseCase: HomeTravelListUseCase

    ):ViewModel() {

       init {
           getAllTravelList()
       }

        fun getAllTravelList(): LiveData<List<HomeScreenTravelListItem>> {
            with(homeTravelListUseCase){
                getAllTravelList()
                return travelList
            }
        }

        fun getAllFlight(): LiveData<List<HomeScreenTravelListItem>> {
            with(homeTravelListUseCase){
                getAllFlights()
                return flightList
            }
        }

        fun getAllHotel(): LiveData<List<HomeScreenTravelListItem>> {
            with(homeTravelListUseCase){
                getAllHotel()
                return hotelList
            }
        }


        fun getAllTransportation(): LiveData<List<HomeScreenTravelListItem>> {
            with(homeTravelListUseCase){
                getAllTransportation()
                return transportationList
            }
        }




}