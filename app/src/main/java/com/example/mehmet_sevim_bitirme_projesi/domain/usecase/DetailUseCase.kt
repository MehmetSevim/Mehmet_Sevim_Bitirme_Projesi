package com.example.mehmet_sevim_bitirme_projesi.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.DetailRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailUseCase @Inject constructor (private val detailRepository: DetailRepository) {
    private  val _travelList = MutableLiveData<HomeScreenTravelListItem>()
    val travelList : LiveData<HomeScreenTravelListItem> = _travelList

     fun getTravelListById(id:String){
        detailRepository.getTravelListById(id).enqueue(object :
            Callback<HomeScreenTravelListItem> {
            override fun onResponse(call : Call<HomeScreenTravelListItem>, response: Response<HomeScreenTravelListItem>){
                _travelList.value=response.body()
            }



            override fun onFailure(call: Call<HomeScreenTravelListItem>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}