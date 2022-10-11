package com.example.mehmet_sevim_bitirme_projesi.adapters.room

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomDB
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomEntitiy
import com.example.mehmet_sevim_bitirme_projesi.databinding.BookmarkItemBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.DetailsImageItemBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.NearbyAttractionItemBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.TripsItemBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.Image
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class RoomViewHolder  (var travelBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(travelBinding.root) {
    fun onBind(
        room: RoomEntitiy,
        onItemClickHandler: (roomEntitiy: RoomEntitiy) -> Unit
    ) {
        val travelBind = travelBinding as BookmarkItemBinding

        travelBind.apply {
            val getTripsDatabase = RoomDB.getTripsDatabase(root.context)
            root.setOnClickListener { onItemClickHandler(room) }
            setVariable(BR.adapterBookmark, room)
            setImageFromApi(room.url, seachScreenNearbyImageView)
            bookMarkCheckImageButton.setOnClickListener {
                room.apply {
                    bookMarkCheckImageButton.setImageResource(R.drawable.bookmark_add_icon_svg)
                    val tripModel = RoomEntitiy(
                        id = id.toInt(),
                        city = city,
                        country = country,
                        category = category,
                        description = description,
                        isBookmark = isBookmark.toString(),
                        title = title,
                        url = url
                    )
                    getTripsDatabase?.tripDao()?.deleteTrip(tripModel)
                }
            }

        }
    }

    fun setImageFromApi(imgSourceUrl: String, imageView: ShapeableImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .placeholder(R.drawable.ic_loading_screen)
            .into(imageView);
    }


}