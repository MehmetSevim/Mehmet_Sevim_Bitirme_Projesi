package com.example.mehmet_sevim_bitirme_projesi.adapters.guide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.might.GuideScreenMightViewHolder
import com.example.mehmet_sevim_bitirme_projesi.domain.model.guide.GuideIcon
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem

class GuideAdapter (private val list: List<GuideIcon>,
                    private val onItemClickHandler: (guideIcon: GuideIcon) -> Unit):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.guide_categories_item,parent,false
        )
        return GuideViewHolder(travelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GuideViewHolder).onBind(list.get(position),onItemClickHandler)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}