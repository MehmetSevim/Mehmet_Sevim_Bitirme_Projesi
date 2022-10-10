package com.example.mehmet_sevim_bitirme_projesi.presentation.tripandbookmark.bottomsheet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentBottomSheetBinding
import com.example.mehmet_sevim_bitirme_projesi.presentation.searchresult.SearchResultModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BottomSeetFragment :  BottomSheetDialogFragment() {

   private val bottomSheetModel by viewModels<BottomSheetFragmentModel>()
   private lateinit var fragmentBottomSheetBinding: FragmentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBottomSheetBinding = FragmentBottomSheetBinding.inflate(inflater)
        return fragmentBottomSheetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllTravels()
    }

    private fun getAllTravels(){
        bottomSheetModel.getAllTravel().observe(viewLifecycleOwner){
          Log.v("Mehmet",it.toString())
        }

    }

}