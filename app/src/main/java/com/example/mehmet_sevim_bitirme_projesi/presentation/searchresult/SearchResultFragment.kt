package com.example.mehmet_sevim_bitirme_projesi.presentation.searchresult

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.nearby.SearchScreenNearbyAdapter
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentSearchBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentSearchResultBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.usecase.SearchResultUseCase
import com.example.mehmet_sevim_bitirme_projesi.presentation.detail.DetailFragmentArgs
import com.example.mehmet_sevim_bitirme_projesi.presentation.search.SearchFragmentDirections
import com.example.mehmet_sevim_bitirme_projesi.presentation.search.SearchListModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultFragment : Fragment() {

    private lateinit var fragmentSearchResultBinding: FragmentSearchResultBinding
    private val searchResultModel by viewModels<SearchResultModel>()
    private lateinit var allTravelList:List<HomeScreenTravelListItem>
    private val args: SearchResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentSearchResultBinding = FragmentSearchResultBinding.inflate(inflater)
        return fragmentSearchResultBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val serachText = args.searchText
        getSearchResult(serachText)

    }




    private fun getSearchResult(searchText : String){
        searchResultModel.getSearchResult(searchText).observe(viewLifecycleOwner){
            setRecyclerAdapterSearchResult(it)
        }
    }
    private fun setRecyclerAdapterSearchResult(list:List<HomeScreenTravelListItem>){
        fragmentSearchResultBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.VERTICAL,
                false

            )
            searchResultRecyclerView.layoutManager = layoutManager
            val searchScreenNearbyAdapter = SearchScreenNearbyAdapter(list){
                setDetailScreen(it.id.toString())
            }
            setVariable(BR.adapterSearchResult,searchScreenNearbyAdapter)
            searchScreenNearbyAdapter.notifyDataSetChanged()

        }
    }

    private fun setDetailScreen(id:String)
    {
        val action =
            SearchResultFragmentDirections.actionSearchResultFragmentToDetailActivity(id = id)
        findNavController().navigate(action)

    }


}