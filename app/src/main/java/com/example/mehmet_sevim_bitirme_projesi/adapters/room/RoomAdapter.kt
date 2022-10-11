package com.example.mehmet_sevim_bitirme_projesi.adapters.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.mehmet_sevim_bitirme_projesi.R
import com.example.mehmet_sevim_bitirme_projesi.data.local.RoomEntitiy

class RoomAdapter (private val list: List<RoomEntitiy>,
                   private val onItemClickHandler: (roomEntitiy: RoomEntitiy) -> Unit):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.bookmark_item,parent,false
        )
        return RoomViewHolder(travelBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RoomViewHolder).onBind(list.get(position),onItemClickHandler)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}