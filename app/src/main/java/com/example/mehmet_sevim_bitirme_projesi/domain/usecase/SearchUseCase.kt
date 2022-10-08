package com.example.mehmet_sevim_bitirme_projesi.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.SearchReposiyory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val searchReposiyory: SearchReposiyory) {
    private  val _travelList = MutableLiveData<List<HomeScreenTravelListItem>>()
    val travelList : LiveData<List<HomeScreenTravelListItem>> = _travelList

    private val _destinations = MutableLiveData<List<HomeScreenTravelListItem>>()
    val destinations : LiveData<List<HomeScreenTravelListItem>> = _destinations

    private var _nearby = MutableLiveData<List<HomeScreenTravelListItem>>()
    val nearby : LiveData<List<HomeScreenTravelListItem>> = _nearby

    fun getAllTravelList(){
        searchReposiyory.getAllTravelList().enqueue(object :
            Callback<List<HomeScreenTravelListItem>> {
            override fun onResponse(call : Call<List<HomeScreenTravelListItem>>, response: Response<List<HomeScreenTravelListItem>>){
                _travelList.value=response.body()
            }


            override fun onFailure(call: Call<List<HomeScreenTravelListItem>>, t: Throwable) {

            }
        })
    }

    fun getAllDestinations(){
        _destinations.value=_travelList.value?.filter { m -> m.category == "topdestination" }
    }

     fun getAllNearby(){
        _nearby.value=_travelList.value?.filter { m -> m.category == "nearby" }
    }
}