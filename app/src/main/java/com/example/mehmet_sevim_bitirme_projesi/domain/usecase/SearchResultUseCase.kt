package com.example.mehmet_sevim_bitirme_projesi.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.GuideRepository
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.SearcResulRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SearchResultUseCase @Inject constructor (private val searcResulRepository: SearcResulRepository) {
    private  val _travelList = MutableLiveData<List<HomeScreenTravelListItem>>()
    val travelList : LiveData<List<HomeScreenTravelListItem>> = _travelList

    fun getSearchResult(searchText : String){
        searcResulRepository.getSearchResult(searchText).enqueue(object :
            Callback<List<HomeScreenTravelListItem>> {
            override fun onResponse(call : Call<List<HomeScreenTravelListItem>>, response: Response<List<HomeScreenTravelListItem>>){
                _travelList.value=response.body()
            }

            override fun onFailure(call: Call<List<HomeScreenTravelListItem>>, t: Throwable) {

            }
        })
    }
}