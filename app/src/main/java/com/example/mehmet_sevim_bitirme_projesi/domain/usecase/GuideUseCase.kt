package com.example.mehmet_sevim_bitirme_projesi.domain.usecase

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mehmet_sevim_bitirme_projesi.domain.model.guide.GuideIcon
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.repository.GuideRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GuideUseCase @Inject constructor (private val guideRepository: GuideRepository) {
    private  val _travelList = MutableLiveData<List<HomeScreenTravelListItem>>()
    val travelList : LiveData<List<HomeScreenTravelListItem>> = _travelList

    private  val _guideList = MutableLiveData<List<GuideIcon>>()
    val guideList : LiveData<List<GuideIcon>> = _guideList

    fun getAllTravelList(){
        guideRepository.getAllTravelList().enqueue(object :
            Callback<List<HomeScreenTravelListItem>> {
            override fun onResponse(call : Call<List<HomeScreenTravelListItem>>, response: Response<List<HomeScreenTravelListItem>>){
                _travelList.value=response.body()


            }

            override fun onFailure(call: Call<List<HomeScreenTravelListItem>>, t: Throwable) {

            }
        })
    }

    fun getAllCategories(){
        guideRepository.getAllCategories().enqueue(object :
        Callback<List<GuideIcon>> {
            override fun onResponse(
                call: Call<List<GuideIcon>>,
                response: Response<List<GuideIcon>>
            ) {
                _guideList.value=response.body()
            }

            override fun onFailure(call: Call<List<GuideIcon>>, t: Throwable) {

            }

        }
        )
    }
}