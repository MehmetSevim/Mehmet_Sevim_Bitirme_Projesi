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
import androidx.navigation.fragment.findNavController
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.HomeScreenTravelListAdapter
import com.example.mehmet_sevim_bitirme_projesi.adapters.category.CategoryAdapter
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentHomeBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenCategoryButton
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private lateinit var homeTravelListModel : HomeTravelListModel
    private lateinit var allTravelList:List<HomeScreenTravelListItem>
    private lateinit var homeScreenTravelListAdapter : HomeScreenTravelListAdapter
    private lateinit var categoryAdapter: CategoryAdapter

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
        initHomeCategory()
        initListeners()
    }

    private fun initHomeCategory() {
      val list = listOf(
          HomeScreenCategoryButton("Flights",R.drawable.home_plane),
          HomeScreenCategoryButton("Hotels",R.drawable.home_hotel),
          HomeScreenCategoryButton("Cars",R.drawable.home_cars),
          HomeScreenCategoryButton("Taxi",R.drawable.home_taxi)
      )
        setCategoryRecyclerAdapter(list)
        
    }

    private fun getAllTravelList():List<HomeScreenTravelListItem>{
        homeTravelListModel.getAllTravelList().observe(viewLifecycleOwner){
           allTravelList=it
           setRecyclerAdapter(allTravelList)
        }
        return allTravelList
    }

    private fun getAllHotel():List<HomeScreenTravelListItem>{
        homeTravelListModel.getAllHotel().observe(viewLifecycleOwner) {
             allTravelList=it
        }
        return allTravelList
    }

    private fun getAllFlight():List<HomeScreenTravelListItem>{
        homeTravelListModel.getAllFlight().observe(viewLifecycleOwner){
           allTravelList=it
        }
        return allTravelList

    }

    private fun getAllTransportation():List<HomeScreenTravelListItem>{
        homeTravelListModel.getAllTransportation().observe(viewLifecycleOwner){
            allTravelList=it
            }
        return allTravelList
    }

    private fun initListeners() {
        fragmentHomeBinding.apply{

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                  when(tab?.position){
                        0 -> getAllTravelList()
                        1 -> getAllFlight()
                        2 -> getAllHotel()
                        3 -> getAllTransportation()
                    }
                    kotlin.run {
                        setRecyclerAdapter(allTravelList)


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
               setDetailScreen(it.id.toString())

            }
            setVariable(BR.adapter,homeScreenTravelListAdapter)
            homeScreenTravelListAdapter.notifyDataSetChanged()
        }
    }
    private fun setCategoryRecyclerAdapter(list:List<HomeScreenCategoryButton>){
        fragmentHomeBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.HORIZONTAL,
                false

            )
            categoryRecyclerView.layoutManager = layoutManager
            categoryAdapter =CategoryAdapter(list){
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
            }
            setVariable(BR.adapterCategory,categoryAdapter)
        }
    }
    private fun setDetailScreen(id:String)
    {
     val action =
         HomeFragmentDirections.actionHomeFragmentToDetailActivity(id = id)
        findNavController().navigate(action)

    }
}