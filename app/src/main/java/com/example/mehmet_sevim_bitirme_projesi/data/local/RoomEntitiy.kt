package com.example.mehmet_sevim_bitirme_projesi.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mehmet_sevim_bitirme_projesi.domain.model.home.Image
import javax.annotation.Nullable


@Entity(tableName = "roomEntitiy")
data class RoomEntitiy(

    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "city")
    var city: String,

    @ColumnInfo(name = "country")
    var country: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "isBookmark")
    var isBookmark: String,

    @ColumnInfo(name = "title")
    var title: String,

    @Nullable
    @ColumnInfo(name = "url")
    var url: String,

)
