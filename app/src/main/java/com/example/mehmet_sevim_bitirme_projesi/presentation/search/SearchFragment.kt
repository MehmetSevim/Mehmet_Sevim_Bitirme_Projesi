package com.example.mehmet_sevim_bitirme_projesi.presentation.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.HomeScreenTravelListAdapter
import com.example.mehmet_sevim_bitirme_projesi.adapters.destinations.SearchScreenDestinationsAdapter
import com.example.mehmet_sevim_bitirme_projesi.adapters.nearby.SearchScreenNearbyAdapter
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentSearchBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.presentation.guide.GuideListModel
import com.example.mehmet_sevim_bitirme_projesi.presentation.home.HomeFragmentDirections
import com.example.mehmet_sevim_bitirme_projesi.presentation.home.HomeTravelListModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.Provider

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var fragmentSearchBinding: FragmentSearchBinding
    private val searchListModel by viewModels<SearchListModel>()
    private lateinit var allTravelList:List<HomeScreenTravelListItem>

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSearchBinding=FragmentSearchBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return fragmentSearchBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllDestination()
        getAllNearby()



    }



    private fun getAllDestination(){

        searchListModel.getAllTravelList().observe(viewLifecycleOwner){
            allTravelList=it.filter{ m -> m.category=="topdestination"}
              setRecyclerAdapterDestination(allTravelList)
        }


    }

    private fun getAllNearby(){
        searchListModel.getAllTravelList().observe(viewLifecycleOwner){
            allTravelList=it.filter{ m -> m.category=="mightneed"}
            setRecyclerAdapterNearby(allTravelList)
        }


    }


    private fun setRecyclerAdapterDestination(list:List<HomeScreenTravelListItem>){
        fragmentSearchBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.HORIZONTAL,
                false

            )
            destinationsRecyclerView.layoutManager = layoutManager
            val searchScreenDestinationsAdapter = SearchScreenDestinationsAdapter(list){
                setDetailScreen(it.id)
            }

            setVariable(BR.adapterDestinations,searchScreenDestinationsAdapter)
            searchScreenDestinationsAdapter.notifyDataSetChanged()

        }
    }

    private fun setRecyclerAdapterNearby(list:List<HomeScreenTravelListItem>){
        fragmentSearchBinding.apply {
            val layoutManager = GridLayoutManager(
                activity,
                1,
                GridLayoutManager.VERTICAL,
                false

            )
            nearbyRecyclerView.layoutManager = layoutManager
            val searchScreenNearbyAdapter = SearchScreenNearbyAdapter(list){
                setDetailScreen(it.id)

            }
            setVariable(BR.adapterNearby,searchScreenNearbyAdapter)
            searchScreenNearbyAdapter.notifyDataSetChanged()

        }
    }
    private fun setDetailScreen(id:String)
    {
        val action =
            SearchFragmentDirections.actionSearchFragmentToDetailActivity(id = id)
        findNavController().navigate(action)

    }

}