package com.example.mehmet_sevim_bitirme_projesi.presentation.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.HomeScreenTravelListAdapter
import com.example.mehmet_sevim_bitirme_projesi.adapters.might.GuideScreenMightAdapter
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentGuideBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentHomeBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentSearchBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.presentation.search.SearchListModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideFragment : Fragment() {

    private lateinit var fragmentGuideBinding: FragmentGuideBinding
    private val guideListModel by viewModels<GuideListModel>()
    private lateinit var guideScreenMightAdapter: GuideScreenMightAdapter
    private lateinit var allTravelList:List<HomeScreenTravelListItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentGuideBinding = FragmentGuideBinding.inflate(inflater)
        return fragmentGuideBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllMight()
    }

    private fun getAllMight(){
        guideListModel.getAllTravel().observe(viewLifecycleOwner){
            allTravelList=it.filter{ m -> m.category=="mightneed"}
            setRecyclerAdapter(allTravelList)

        }

    }

    private fun getAllTopPick(){
        guideListModel.getAllTravel().observe(viewLifecycleOwner){
            allTravelList=it.filter{ m -> m.category=="toppick"}

        }

    }

    private fun setRecyclerAdapter(list:List<HomeScreenTravelListItem>){
        fragmentGuideBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.HORIZONTAL,
                false

            )
            guideScreenMightRcyclerView.layoutManager = layoutManager
            guideScreenMightAdapter = GuideScreenMightAdapter(list){

            }
            setVariable(BR.adapterMight,guideScreenMightAdapter)
        }
    }




}