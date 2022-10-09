package com.example.mehmet_sevim_bitirme_projesi.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.HomeTravelListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeTravelListUseCase @Inject constructor(private val  homeTravelListRepository: HomeTravelListRepository){
    private  val _travelList = MutableLiveData<List<HomeScreenTravelListItem>>()
    val travelList : LiveData<List<HomeScreenTravelListItem>> = _travelList

    private val _flightList = MutableLiveData<List<HomeScreenTravelListItem>>()
    val flightList : LiveData<List<HomeScreenTravelListItem>> = _flightList

    private var _hotelList = MutableLiveData<List<HomeScreenTravelListItem>>()
    val hotelList : LiveData<List<HomeScreenTravelListItem>> = _hotelList

    private val _transportationList = MutableLiveData<List<HomeScreenTravelListItem>>()
    val transportationList : LiveData<List<HomeScreenTravelListItem>> = _transportationList



    fun getAllTravelList(){
        homeTravelListRepository.getAllTravelList().enqueue(object : Callback<List<HomeScreenTravelListItem>>{
            override fun onResponse(call : Call<List<HomeScreenTravelListItem>>, response: Response<List<HomeScreenTravelListItem>>){
                _travelList.value=response.body()
            }
            override fun onFailure(call: Call<List<HomeScreenTravelListItem>>, t: Throwable) {

            }
        })
    }
    fun getAllFlights(){
         _flightList.value=_travelList.value?.filter { m -> m.category=="flight"}

    }

    fun getAllHotel(){
        _hotelList.value=_travelList.value?.filter { m -> m.category=="hotel"}

    }

    fun getAllTransportation(){
         _transportationList.value=_travelList.value?.filter { m -> m.category=="transportation"}

    }





}