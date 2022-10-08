package com.example.mehmet_sevim_bitirme_projesi.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.adapters.HomeScreenTravelListAdapter
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentHomeBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var homeTravelListModel : HomeTravelListModel
    private lateinit var allTravelList:List<HomeScreenTravelListItem>
    private lateinit var homeScreenTravelListAdapter : HomeScreenTravelListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding =  FragmentHomeBinding.inflate(inflater)
        return fragmentHomeBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        allTravelList= listOf()
        homeTravelListModel = ViewModelProvider(this).get(HomeTravelListModel::class.java)
        getAllTravelList()
        initListeners()
    }

    private fun getAllTravelList() {
        homeTravelListModel.getAllTravelList().observe(viewLifecycleOwner){
           allTravelList=it
           setRecyclerAdapter(allTravelList)

        }
    }

    private fun getAllHotel(){
        homeTravelListModel.getAllHotel().observe(viewLifecycleOwner) {
             allTravelList=it
            setRecyclerAdapter(allTravelList)

        }
    }

    private fun getAllFlight(){
        homeTravelListModel.getAllFlight().observe(viewLifecycleOwner){
           allTravelList=it
            setRecyclerAdapter(allTravelList)
        }

    }

    private fun getAllTransportation(){
        homeTravelListModel.getAllTransportation().observe(viewLifecycleOwner){
            allTravelList=it
            setRecyclerAdapter(allTravelList)
        }
    }

    private fun initListeners() {
        fragmentHomeBinding.apply {
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when(tab?.position){
                        0 -> getAllTravelList()
                        1 -> getAllFlight()
                        2 -> getAllHotel()
                        3 -> getAllTransportation()
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })


        }

    }

    private fun setRecyclerAdapter(list:List<HomeScreenTravelListItem>){
        fragmentHomeBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.HORIZONTAL,
                false

            )
            rcyc.layoutManager = layoutManager
            homeScreenTravelListAdapter =HomeScreenTravelListAdapter(list){

            }
            setVariable(BR.adapter,homeScreenTravelListAdapter)
            homeScreenTravelListAdapter.notifyDataSetChanged()
        }
    }
}