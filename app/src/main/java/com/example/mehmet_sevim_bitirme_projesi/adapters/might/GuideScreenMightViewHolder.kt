package com.example.mehmet_sevim_bitirme_projesi.adapters.might

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.databinding.MightItemBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class GuideScreenMightViewHolder(var travelBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(travelBinding.root) {
    fun onBind(
        homescreenTravelListItem: HomeScreenTravelListItem,
        onItemClickHandler: (homescreenTravelListItem: HomeScreenTravelListItem) -> Unit
    ) {
        val travelBind = travelBinding as MightItemBinding
        travelBind.apply {
            root.setOnClickListener { onItemClickHandler(homescreenTravelListItem) }
            setVariable(BR.homescreenTravelListItem, homescreenTravelListItem)
            setImageFromApi(homescreenTravelListItem.images[0].url,mightImageView )

        }
    }

    fun setImageFromApi(imgSourceUrl: String, imageView: ShapeableImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .into(imageView);
    }


}