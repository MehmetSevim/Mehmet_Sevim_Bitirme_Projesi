package com.example.mehmet_sevim_bitirme_projesi.adapters.nearby

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.databinding.NearbyAttractionItemBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.TopDestinationsItemBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class SearchScreenNearbyViewHolder (var travelBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(travelBinding.root) {
    fun onBind(
        homescreenTravelListItem: HomeScreenTravelListItem,
        onItemClickHandler: (homescreenTravelListItem: HomeScreenTravelListItem) -> Unit
    ) {
        var select =false
        val travelBind = travelBinding as NearbyAttractionItemBinding
        travelBind.apply {
            root.setOnClickListener { onItemClickHandler(homescreenTravelListItem) }
            bookMarkCheckImageButton.setOnClickListener{
                if(select == false) bookMarkCheckImageButton.setImageResource(R.drawable.bookmark_checked_svg)
                else bookMarkCheckImageButton.setImageResource(R.drawable.bookmark_add_icon_svg)

                select = !select
            }
            setVariable(BR.homescreenTravelListItem, homescreenTravelListItem)
            setImageFromApi(homescreenTravelListItem.images[0].url, seachScreenNearbyImageView)

        }
    }


    fun setImageFromApi(imgSourceUrl: String, imageView: ShapeableImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .placeholder(R.drawable.ic_loading_screen)
            .into(imageView)
    }


}