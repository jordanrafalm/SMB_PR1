package com.example.rafal.room


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "produkty_table")
data class Produkt (var nazwa: String,
                     var cena: String,
                    var ilosc: String){

    @PrimaryKey(autoGenerate = true)
    var user_id: Int = 0
}