package com.example.mehmet_sevim_bitirme_projesi.presentation.tripandbookmark

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_bitirme_projesi.MainActivity
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.nearby.SearchScreenNearbyAdapter
import com.example.mehmet_sevim_bitirme_projesi.adapters.room.RoomAdapter
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomDB
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomEntitiy
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentTripAndBookmarkBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.presentation.search.SearchListModel
import com.example.mehmet_sevim_bitirme_projesi.presentation.tripandbookmark.bottomsheet.BottomSeetFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripAndBookmarkFragment : Fragment(){

    private val tripBookMarkList by viewModels<TripBookMarkList>()
    private lateinit var allTravelList:List<HomeScreenTravelListItem>
    private lateinit var fragmentTripAndBookmarkBinding: FragmentTripAndBookmarkBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTripAndBookmarkBinding = FragmentTripAndBookmarkBinding.inflate(inflater)
        return fragmentTripAndBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()



    }

    private fun initListeners() {
        fragmentTripAndBookmarkBinding.apply{

            tripAndBookMarkTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when(tab?.position){
                        0 -> {
                            floatingActionButton.isVisible=true
                        }
                        1 -> {
                            getAllBookMark()
                            floatingActionButton.isVisible=false
                        }

                    }

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })


        }

    }

    private fun init() {
        fragmentTripAndBookmarkBinding.apply {
            var bottomSheetFragment = BottomSeetFragment()
            bottomSheetFragment.setStyle(
                DialogFragment.STYLE_NORMAL,
                R.style.ThemeOverlay_Demo_BottomSheetDialog
            )
            floatingActionButton.setOnClickListener {
                createBottomSheet(bottomSheetFragment)
            }
        }
    }

    private fun createBottomSheet(bottomSheetFragment:BottomSeetFragment){
        bottomSheetFragment.show(requireActivity().supportFragmentManager, "BottomSheetDialog")
    }


    private fun getAllBookMark(){
        tripBookMarkList.getAllTravel().observe(viewLifecycleOwner){
            allTravelList=it.filter{ m -> m.isBookmark==true}
            setRecyclerAdapterBookMark(allTravelList)

        }
    }

    private fun setRecyclerAdapterBookMark(list:List<HomeScreenTravelListItem>){
        fragmentTripAndBookmarkBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.VERTICAL,
                false

            )
            tripAnBookMarkRecyclerView.layoutManager = layoutManager
            val searchScreenNearbyAdapter = SearchScreenNearbyAdapter(list){
                setDetailScreen(it.id)

            }
            tripAnBookMarkRecyclerView.adapter=searchScreenNearbyAdapter
            searchScreenNearbyAdapter.notifyDataSetChanged()

        }
    }

    private fun setRecyclerAdapterTrip(list:List<RoomEntitiy>){
        fragmentTripAndBookmarkBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.VERTICAL,
                false

            )
            tripAnBookMarkRecyclerView.layoutManager = layoutManager
            val roomAdapter = RoomAdapter(list){


            }
            tripAnBookMarkRecyclerView.adapter=roomAdapter

        }
    }

    private fun setDetailScreen(id:String)
    {
        val action =
            TripAndBookmarkFragmentDirections.actionTripAndBookmarkFragmentToDetailActivity(id = id)
        findNavController().navigate(action)

    }

}