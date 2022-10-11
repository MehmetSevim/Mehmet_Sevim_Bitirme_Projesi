package com.example.mehmet_sevim_bitirme_projesi.adapters.category

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.databinding.CategoryItemBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenCategoryButton

class CategoryViewHolder (var travelBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(travelBinding.root) {
    fun onBind(
        homeScreenCategoryButton: HomeScreenCategoryButton,
        onItemClickHandler: (homeScreenCategoryButton: HomeScreenCategoryButton) -> Unit
    ) {
        val travelBind = travelBinding as CategoryItemBinding
        travelBind.apply {
            root.setOnClickListener { onItemClickHandler(homeScreenCategoryButton) }
            setVariable(BR.homescreenCategory, homeScreenCategoryButton)


        }
    }
  }