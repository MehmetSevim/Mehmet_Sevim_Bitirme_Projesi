package com.example.mehmet_sevim_bitirme_projesi.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RoomDao {
    @Query("SELECT * FROM roomEntitiy ORDER BY id DESC")
    fun getFavourites() : List<RoomEntitiy>

    @Insert
    fun addTrip(tripModel : RoomEntitiy?)

    @Delete
    fun deleteTrip(tripModel: RoomEntitiy?)

}