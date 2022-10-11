package com.example.mehmet_sevim_bitirme_projesi.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.adapters.detail.DetailScreenImageAdapter
import com.example.mehmet_sevim_bitirme_projesi.adapters.might.GuideScreenMightAdapter
import com.example.mehmet_sevim_bitirme_projesi.databinding.ActivityDetailBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentDetailBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.Image
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var activityDetailBinding: ActivityDetailBinding
    private lateinit var detailScreenImageAdapter: DetailScreenImageAdapter
    private val detailModel by viewModels<DetailModel>()
    private val args: DetailFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail)

        val id = args.id.toString()
        setDetailScreen(id)
    }




    fun setDetailScreen(id : String ){
        detailModel.getTravelListById(id).observe(this){
            activityDetailBinding.apply {
                detailScreenTitle.text=it.title
                detailScreenItemLocation.text=it.city +" , "+ it.country
                detailScreenDescription.text=it.description
                setImageFromApi(it.images[0].url,DetailScreenPlanetsImage)
            }
            setDetailImageRecyclerAdapter(it.images)

        }
    }

    fun setImageFromApi(imgSourceUrl: String, imageView: ImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .placeholder(R.drawable.loading_icon)
            .into(imageView)
    }

    private fun setDetailImageRecyclerAdapter(list:List<Image>){
        activityDetailBinding.apply {
            val layoutManager = GridLayoutManager(
                this@DetailActivity,
                1,
                GridLayoutManager.HORIZONTAL,
                false

            )
            detailImageRcycler.layoutManager = layoutManager
            detailScreenImageAdapter = DetailScreenImageAdapter(list){
               setImageFromApi(it.url,DetailScreenPlanetsImage)
            }
            setVariable(BR.adapterDetailImage,detailScreenImageAdapter)
        }
    }

}
