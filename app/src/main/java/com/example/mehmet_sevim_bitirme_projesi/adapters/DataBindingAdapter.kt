package com.example.mehmet_sevim_bitirme_projesi.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class DataBindingAdapter {

    /* fun ImageView.setImageResource(resource: Int){
         setImageResource(resource)
     }*/

    companion object {
        @JvmStatic @BindingAdapter("imageresource")
        fun setImageResource(imageView: ImageView,resource: Int){
            imageView.setImageResource(resource)
        }
    }
}