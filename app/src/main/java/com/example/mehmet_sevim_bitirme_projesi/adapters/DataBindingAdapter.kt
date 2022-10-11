package com.example.mehmet_sevim_bitirme_projesi.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.mehmet_sevim_bitirme_projesi.R

class DataBindingAdapter {

    /* fun ImageView.setImageResource(resource: Int){
         setImageResource(resource)
     }*/

    companion object {
        @JvmStatic @BindingAdapter("imageresource")
        fun setImageResource(imageView: ImageView,resource: Int){
            imageView.setImageResource(resource)
        }

        @JvmStatic @BindingAdapter("iconresource")
        fun setIconResource(imageView: ImageView,resource: String){
            val imageResource = when (resource){
                "1" -> R.drawable.ic_taxi_blue
                "2" -> R.drawable.ic_car_blue
                "3" -> R.drawable.ic_search_blue
                "4" -> R.drawable.ic_restaurant
                "5" -> R.drawable.ic_resort
                "6" -> R.drawable.ic_mall
                "7" -> R.drawable.ic_slight
                else -> {R.drawable.bookmark_checked_svg}
            }

            imageView.setImageResource(imageResource)
        }

    }

}