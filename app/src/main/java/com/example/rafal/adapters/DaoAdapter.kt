package com.example.rafal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rafal.R
import com.example.rafal.room.Produkt

class DaoAdapter(private val listOfProdukty: List<Produkt>):RecyclerView.Adapter<DaoAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.produkty_row,parent, false)
        return MyViewHolder(row)
    }

    override fun getItemCount(): Int {
        return listOfProdukty.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nazwaTextView.text = listOfProdukty[position].nazwa
        holder.cenaTextView.text = listOfProdukty[position].cena
        holder.iloscTextView.text = listOfProdukty[position].ilosc
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nazwaTextView: TextView = view.findViewById(R.id.row_nazwa)
        val cenaTextView: TextView = view.findViewById(R.id.row_cena)
        val iloscTextView: TextView = view.findViewById(R.id.row_ilosc)


    }

}
