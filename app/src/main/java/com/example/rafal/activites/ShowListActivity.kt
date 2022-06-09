package com.example.rafal.activites;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rafal.R
import com.example.rafal.adapters.DaoAdapter
import com.example.rafal.room.Produkt
import com.example.rafal.viewmodel.ProduktyViewModel

class ShowListActivity : AppCompatActivity() {
    private lateinit var viewModel: ProduktyViewModel
    private lateinit var daoAdapter: DaoAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var listOfProdukty: LiveData<List<Produkt>>

    override fun onCreate(savedInstanceState: Bundle?)  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_show_list)



    viewModel = ViewModelProvider.AndroidViewModelFactory
    .getInstance(application)
    .create(ProduktyViewModel::class.java)

    recyclerView = findViewById(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(applicationContext)

    listOfProdukty = viewModel.getAllProdukty()
    listOfProdukty.observe(this, Observer {
        if (it.isNotEmpty()) {
            daoAdapter = DaoAdapter(it)
            recyclerView.adapter = daoAdapter
        }
    })
}




}