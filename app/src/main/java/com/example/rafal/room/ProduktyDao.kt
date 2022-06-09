package com.example.rafal.room


import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ProduktyDao {
    @Insert
     fun insert (produkt: Produkt)

     @Update
     fun update(produkt: Produkt)

     @Delete
     fun delete(produkt: Produkt)

     @Query("SELECT * FROM produkty_table")
     fun getAllProdukty(): LiveData<List<Produkt>>


     @Query("DELETE FROM produkty_table")
     fun deleteAllRows()




}