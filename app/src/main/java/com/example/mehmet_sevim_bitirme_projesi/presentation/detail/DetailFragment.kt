package com.example.mehmet_sevim_bitirme_projesi.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mehmet_sevim_bitirme_projesi.databinding.FragmentDetailBinding
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var fragmentDetailBinding: FragmentDetailBinding
    private val detailModel by viewModels<DetailModel>()
    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentDetailBinding=FragmentDetailBinding.inflate(inflater)
        return fragmentDetailBinding.root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.id.toString()
        setDetailScreen(id)

    }
    fun setDetailScreen(id : String ){
        detailModel.getTravelListById(id).observe(viewLifecycleOwner){
            fragmentDetailBinding.apply {
                detailScreenTitle.text=it.title
                detailScreenItemLocation.text=it.city +" , "+ it.country
                detailScreenDescription.text=it.description
                setImageFromApi(it.images[0].url,DetailScreenPlanetsImage)
            }

        }
    }

    fun setImageFromApi(imgSourceUrl: String, imageView: ImageView) {
        Picasso.get()
            .load(imgSourceUrl)
            .resize(100, 100)
            .centerCrop()
            .into(imageView);
    }

    }


