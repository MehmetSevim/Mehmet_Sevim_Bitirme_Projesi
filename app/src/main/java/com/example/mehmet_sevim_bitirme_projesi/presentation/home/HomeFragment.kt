package com.example.mehmet_sevim_bitirme_projesi.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.adapters.HomeScreenTravelListAdapter
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var fragmentHomeBinding: FragmentHomeBinding
    private val homeTravelListModel by viewModels<HomeTravelListModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding =  FragmentHomeBinding.inflate(inflater)
        return fragmentHomeBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        homeTravelListModel.getAllTravelList().observe(viewLifecycleOwner){
            Log.v("Homeicinde",it.toString())
            fragmentHomeBinding.apply {
                val layoutManager = GridLayoutManager(
                    activity,
                    1,
                    GridLayoutManager.HORIZONTAL,
                    false

                )
                rcyc.layoutManager = layoutManager
                val homeScreenTravelListAdapter =HomeScreenTravelListAdapter(it){

                }
                setVariable(BR.adapter,homeScreenTravelListAdapter)

            }
        }

    }




}