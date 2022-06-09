package com.example.rafal.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Produkt::class], version = 3,exportSchema = false)
abstract class ProduktyDatabase: RoomDatabase() {
    abstract fun produktyDao(): ProduktyDao

    companion object {
        private var instance: ProduktyDatabase? = null

        fun getInstance(context: Context): ProduktyDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    ProduktyDatabase::class.java,
                    "produkty_table"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }


        fun deleteInstanceOfDatabase() {
            instance = null
        }
    }
}

