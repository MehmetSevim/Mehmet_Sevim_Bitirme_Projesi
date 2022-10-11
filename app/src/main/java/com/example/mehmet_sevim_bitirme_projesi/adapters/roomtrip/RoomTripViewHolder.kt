package com.example.mehmet_sevim_bitirme_projesi.adapters.roomtrip

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomEntitiy
import com.example.mehmet_sevim_bitirme_projesi.databinding.TripsItemBinding
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class RoomTripViewHolder (var travelBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(travelBinding.root) {
    fun onBind(
        room: RoomEntitiy,
        onItemClickHandler: (roomEntitiy: RoomEntitiy) -> Unit
    ) {
        val travelBind = travelBinding as TripsItemBinding
        travelBind.apply {

            setVariable(BR.homescreenTravelListItem, room)
            setImageFromApi(room.url,imageView4)

        }
    }

    fun setImageFromApi(imgSourceUrl: String, imageView: ShapeableImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .placeholder(R.drawable.ic_loading_screen)
            .into(imageView);
    }


}