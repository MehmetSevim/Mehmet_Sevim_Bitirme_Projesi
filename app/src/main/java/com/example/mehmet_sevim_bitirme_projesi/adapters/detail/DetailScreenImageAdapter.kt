package com.example.mehmet_sevim_bitirme_projesi.adapters.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.HomeScreenTravelListViewHolder
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.Image

class DetailScreenImageAdapter   (private val list: List<Image>,
                                  private val onItemClickHandler: (image: Image) -> Unit):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.details_image_item,parent,false
        )
        return DetailScreenImageViewHolder(travelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DetailScreenImageViewHolder).onBind(list.get(position),onItemClickHandler)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}