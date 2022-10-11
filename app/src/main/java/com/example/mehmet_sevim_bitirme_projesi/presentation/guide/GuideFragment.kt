package com.example.mehmet_sevim_bitirme_projesi.presentation.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.HomeScreenTravelListAdapter
import com.example.mehmet_sevim_bitirme_projesi.adapters.guide.GuideAdapter
import com.example.mehmet_sevim_bitirme_projesi.adapters.might.GuideScreenMightAdapter
import com.example.mehmet_sevim_bitirme_projesi.adapters.topPick.GuideScreenTopPicAdapter
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentGuideBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentHomeBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentSearchBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.guide.GuideIcon
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.presentation.home.HomeFragmentDirections
import com.example.mehmet_sevim_bitirme_projesi.presentation.search.SearchFragmentDirections
import com.example.mehmet_sevim_bitirme_projesi.presentation.search.SearchListModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideFragment : Fragment() {

    private lateinit var fragmentGuideBinding: FragmentGuideBinding
    private val guideListModel by viewModels<GuideListModel>()
    private lateinit var guideScreenMightAdapter: GuideScreenMightAdapter
    private lateinit var guideScreenTopPicAdapter: GuideScreenTopPicAdapter
    private lateinit var guideCategoryAdapter: GuideAdapter
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
        init()
        getAllMight()
        getAllTopPick()
        getAllCategories()

    }

    private fun init() {
        fragmentGuideBinding.apply {
            textField2.setEndIconOnClickListener {
                val searchString = guideSearchtextTextInput.text.toString()
                setSearchresult(searchString)
            }
        }
    }


    private fun setSearchresult(searchText:String){
        val searchAction =
            GuideFragmentDirections.actionGuideFragmentToSearchResultFragment(searchText = searchText)
        findNavController().navigate(searchAction)
    }

    private fun getAllMight(){
        guideListModel.getAllTravel().observe(viewLifecycleOwner){
            allTravelList=it.filter{ m -> m.category=="mightneed"}
            setMightRecyclerAdapter(allTravelList)

        }

    }

    private fun getAllTopPick(){
        guideListModel.getAllTravel().observe(viewLifecycleOwner){
            allTravelList=it.filter{ m -> m.category=="toppick"}
            setTopPicRecyclerAdapter(allTravelList)
        }

    }

    private fun getAllCategories(){
        guideListModel.getAllCategories().observe(viewLifecycleOwner){
            setCategoryrecyler(it)
        }

    }

    private fun setMightRecyclerAdapter(list:List<HomeScreenTravelListItem>){
        fragmentGuideBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.HORIZONTAL,
                false

            )
            guideScreenMightRcyclerView.layoutManager = layoutManager
            guideScreenMightAdapter = GuideScreenMightAdapter(list){
                setDetailScreen(it.id)
            }
            setVariable(BR.adapterMight,guideScreenMightAdapter)
        }
    }
    private fun setTopPicRecyclerAdapter(list:List<HomeScreenTravelListItem>){
        fragmentGuideBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.HORIZONTAL,
                false

            )
            topPicRecycler.layoutManager = layoutManager
            guideScreenTopPicAdapter = GuideScreenTopPicAdapter(list){
                setDetailScreen(it.id)
            }
            setVariable(BR.adaptertoppic,guideScreenTopPicAdapter)

        }
    }

    private fun setCategoryrecyler(list:List<GuideIcon>){
        fragmentGuideBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.HORIZONTAL,
                false

            )
            recyclerView3.layoutManager = layoutManager
            guideCategoryAdapter = GuideAdapter(list){
            }
            setVariable(BR.adaptercategories,guideCategoryAdapter)

        }
    }

    private fun setDetailScreen(id:String)
    {
        val action =
            GuideFragmentDirections.actionGuideFragmentToDetailActivity(id = id)
        findNavController().navigate(action)

    }



}