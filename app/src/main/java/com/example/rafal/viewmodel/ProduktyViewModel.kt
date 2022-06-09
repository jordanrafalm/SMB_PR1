package com.example.rafal.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.rafal.room.Produkt
import com.example.rafal.room.ProduktyRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

class ProduktyViewModel(application: Application):
AndroidViewModel(application)  {
    private var produktyRepository: ProduktyRepository =
        ProduktyRepository(application)

    private var allProdukty: Deferred<LiveData<List<Produkt>>> =
        produktyRepository.getAllProduktyAsync()

    fun insertProdukt(produkt: Produkt) {

        produktyRepository.insertProdukt(produkt)
    }

    fun updateProdukt(produkt: Produkt){

        produktyRepository.updateProdukt(produkt)
    }
    fun deleteProdukty(produkt: Produkt){

        produktyRepository.deleteProdukt(produkt)

}

    fun getAllProdukty(): LiveData<List<Produkt>> = runBlocking {
        allProdukty.await()
    }

    fun deleteAllRows(){
        produktyRepository.deleteAllRows()
    }
    }