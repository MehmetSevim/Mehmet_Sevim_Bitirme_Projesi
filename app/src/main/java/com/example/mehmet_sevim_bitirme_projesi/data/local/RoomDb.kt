package com.example.mehmet_sevim_bitirme_projesi.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [RoomEntitiy::class], version = 1)
abstract class RoomDB : RoomDatabase() {

    abstract fun tripDao(): RoomDao?

    companion object {
        private var INSTANCE: RoomDB? = null

        @TypeConverters
        fun getTripsDatabase(context: Context): RoomDB? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "TripsDb"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE
        }

    }
}