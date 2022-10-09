package com.example.mehmet_sevim_bitirme_projesi.adapters

import android.util.Log
import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.databinding.HomeScreenDealsItemBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.squareup.picasso.Picasso


class HomeScreenTravelListViewHolder
    (var travelBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(travelBinding.root) {
    fun onBind(
        homescreenTravelListItem: HomeScreenTravelListItem,
        onItemClickHandler: (homescreenTravelListItem: HomeScreenTravelListItem) -> Unit
    ) {
        val travelBind = travelBinding as HomeScreenDealsItemBinding
        travelBind.apply {
            root.setOnClickListener { onItemClickHandler(homescreenTravelListItem) }
            setVariable(BR.homescreenTravelListItem, homescreenTravelListItem)
                   setImageFromApi(homescreenTravelListItem.images[0].url, imageView2)

        }
    }

    fun setImageFromApi(imgSourceUrl: String, imageView: ImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .into(imageView);
    }


}