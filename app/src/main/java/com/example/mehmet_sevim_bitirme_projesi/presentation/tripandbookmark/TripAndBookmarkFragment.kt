package com.example.mehmet_sevim_bitirme_projesi.presentation.tripandbookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentSearchBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.presentation.home.HomeFragmentDirections
import com.example.mehmet_sevim_bitirme_projesi.presentation.search.SearchListModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripAndBookmarkFragment : Fragment() {

    private val tripBookMarkList by viewModels<TripBookMarkList>()
    private lateinit var allTravelList:List<HomeScreenTravelListItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trip_and_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllBookMark()
    }

    private fun getAllBookMark(){
        tripBookMarkList.getAllTravel().observe(viewLifecycleOwner){
            allTravelList=it.filter{ m -> m.isBookmark==true}

        }
    }


    private fun setDetailScreen(id:String)
    {
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailActivity(id = id)
        findNavController().navigate(action)

    }

}