package com.example.mehmet_sevim_bitirme_projesi.adapters.detail

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.databinding.DetailsImageItemBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.Image
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class DetailScreenImageViewHolder   (var travelBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(travelBinding.root) {
    fun onBind(
        image: Image,
        onItemClickHandler: (image: Image) -> Unit
    ) {
        val travelBind = travelBinding as DetailsImageItemBinding
        travelBind.apply {
            root.setOnClickListener { onItemClickHandler(image) }
            setVariable(BR.homescreenTravelListItem, image)
            setImageFromApi(image.url, detailsImageView)

        }
    }

    fun setImageFromApi(imgSourceUrl: String, imageView: ShapeableImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .into(imageView);
    }


}