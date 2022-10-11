package com.example.mehmet_sevim_bitirme_projesi.adapters.nearby

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomDB
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomEntitiy
import com.example.mehmet_sevim_bitirme_projesi.databinding.NearbyAttractionItemBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class SearchScreenNearbyViewHolder(var travelBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(travelBinding.root) {
    var list = arrayListOf<RoomEntitiy>()
    fun onBind(
        homescreenTravelListItem: HomeScreenTravelListItem,
        onItemClickHandler: (homescreenTravelListItem: HomeScreenTravelListItem) -> Unit
    ) {

        var select = false
        val travelBind = travelBinding as NearbyAttractionItemBinding
        travelBind.apply {
            root.setOnClickListener { onItemClickHandler(homescreenTravelListItem) }
            bookMarkCheckImageButton.setOnClickListener {
                val getTripsDatabase = RoomDB.getTripsDatabase(root.context)
                if (!select) {
                    bookMarkCheckImageButton.setImageResource(R.drawable.bookmark_checked_svg)
                    homescreenTravelListItem.apply {

                        val tripModel = RoomEntitiy(
                            id = id.toInt(),
                            city = city,
                            country = country,
                            category = category,
                            description = description,
                            isBookmark = isBookmark.toString(),
                            title = title,
                            url = images[0].url
                        )
                        getTripsDatabase?.tripDao()?.addTrip(tripModel)
                    }


                } else {
                    homescreenTravelListItem.apply {
                        bookMarkCheckImageButton.setImageResource(R.drawable.bookmark_add_icon_svg)
                        val tripModel = RoomEntitiy(
                            id = id.toInt(),
                            city = city,
                            country = country,
                            category = category,
                            description = description,
                            isBookmark = isBookmark.toString(),
                            title = title,
                            url = images[0].url
                        )
                        getTripsDatabase?.tripDao()?.deleteTrip(tripModel)
                    }

                }

                select = !select
            }
            setVariable(BR.homescreenTravelListItem, homescreenTravelListItem)
            setImageFromApi(homescreenTravelListItem.images[0].url, seachScreenNearbyImageView)

        }
    }


    fun setImageFromApi(imgSourceUrl: String, imageView: ShapeableImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .placeholder(R.drawable.loading_icon)
            .into(imageView)
    }


}