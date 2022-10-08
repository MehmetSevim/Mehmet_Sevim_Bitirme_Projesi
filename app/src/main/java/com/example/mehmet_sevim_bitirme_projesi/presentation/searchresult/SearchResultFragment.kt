package com.example.mehmet_sevim_bitirme_projesi.presentation.searchresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mehmet_sevim_bitirme_projesi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }


}