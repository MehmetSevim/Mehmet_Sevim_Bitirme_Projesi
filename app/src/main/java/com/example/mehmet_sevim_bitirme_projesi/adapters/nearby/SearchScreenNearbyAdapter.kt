package com.example.mehmet_sevim_bitirme_projesi.adapters.nearby

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.destinations.SearchScreenDestinationsViewHolder
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem

class SearchScreenNearbyAdapter (private val list: List<HomeScreenTravelListItem>,
                                 private val onItemClickHandler: (homescreenTravelListItem: HomeScreenTravelListItem) -> Unit):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.nearby_attraction_item,parent,false
        )
        return SearchScreenNearbyViewHolder(travelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SearchScreenNearbyViewHolder).onBind(list.get(position),onItemClickHandler)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}