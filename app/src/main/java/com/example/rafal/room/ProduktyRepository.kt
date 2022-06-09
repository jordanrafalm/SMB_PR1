package com.example.rafal.room

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*


class ProduktyRepository (application: Application) {


    private var produktyDao: ProduktyDao

    init {
        val database = ProduktyDatabase.getInstance(application.applicationContext)

        produktyDao = database!!.produktyDao()

    }


    
    fun insertProdukt(produkt: Produkt) =
        CoroutineScope(Dispatchers.IO).launch {
            produktyDao.insert(produkt)
        }
    fun updateProdukt(produkt: Produkt) =
        CoroutineScope(Dispatchers.IO).launch {
            produktyDao.update(produkt)
        }
    fun deleteProdukt(produkt: Produkt) =
        CoroutineScope(Dispatchers.IO).launch {
            produktyDao.delete(produkt)
        }

    fun getAllProduktyAsync(): Deferred<LiveData<List<Produkt>>> =
        CoroutineScope(Dispatchers.IO).async {
            produktyDao.getAllProdukty()
        }

    fun deleteAllRows()=
        CoroutineScope(Dispatchers.IO).launch {
            produktyDao.deleteAllRows()
        }


        }