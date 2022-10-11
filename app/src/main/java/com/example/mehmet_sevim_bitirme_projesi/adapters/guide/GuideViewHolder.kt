package com.example.mehmet_sevim_bitirme_projesi.adapters.guide

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.BR
import com.example.mehmet_sevim_bitirme_projesi.databinding.GuideCategoriesItemBinding
import com.example.mehmet_sevim_bitirme_projesi.databinding.MightItemBinding
import com.example.mehmet_sevim_bitirme_projesi.domain.model.guide.GuideIcon
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.HomeScreenTravelListItem

class GuideViewHolder (var travelBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(travelBinding.root) {
    fun onBind(
        guideIcon: GuideIcon,
        onItemClickHandler: (guideIcon: GuideIcon) -> Unit
    ) {
        val travelBind = travelBinding as GuideCategoriesItemBinding
        travelBind.apply {
            root.setOnClickListener { onItemClickHandler(guideIcon) }
            setVariable(BR.guideCategories, guideIcon)

        }
    }
}