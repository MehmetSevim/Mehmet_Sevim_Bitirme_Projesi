package com.example.mehmet_sevim_bitirme_projesi.adapters.might

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.destinations.SearchScreenDestinationsViewHolder
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem

class GuideScreenMightAdapter (private val list: List<HomeScreenTravelListItem>,
                               private val onItemClickHandler: (homescreenTravelListItem: HomeScreenTravelListItem) -> Unit):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.might_item,parent,false
        )
        return GuideScreenMightViewHolder(travelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GuideScreenMightViewHolder).onBind(list.get(position),onItemClickHandler)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}