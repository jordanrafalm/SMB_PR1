package com.example.rafal.activites
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rafal.databinding.ActivityMainBinding
import com.example.rafal.room.Produkt
import com.example.rafal.viewmodel.ProduktyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.produkty_row.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ProduktyViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pref = getPreferences(Context.MODE_PRIVATE)
        val textsize = pref.getFloat("TEXTSIZE", 10F)
        val textcolor = pref.getInt("TEXTCOLOR", Color.WHITE)

        insertBT.setTextColor(textcolor)
        showListBT.setTextColor(textcolor)
        clearDataBT.setTextColor(textcolor)
        insertBT.setTextSize(textsize)
        showListBT.setTextSize(textsize)
        clearDataBT.setTextSize(textsize)




        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(ProduktyViewModel::class.java)

        insertBT.setOnClickListener {
            var message =
                Toast.makeText(applicationContext, "produkt został dodany", Toast.LENGTH_SHORT)
            val nazwa: String = nazwaET.text.toString()
            val cena: String = cenaET.text.toString()
            val ilosc: String = iloscET.text.toString()

            val produkt = Produkt(nazwa, ilosc, cena)
            viewModel.insertProdukt(produkt)

            message.show()
        }


        showListBT.setOnClickListener {
            val intent = Intent(
                applicationContext,
                ShowListActivity::class.java
            )
            startActivity(intent)
        }
        clearDataBT.setOnClickListener {
            var message = Toast.makeText(
                applicationContext,
                "lista zakupów została wyczyszczona",
                Toast.LENGTH_SHORT
            )
            viewModel.deleteAllRows()
            message.show()
        }


    }


    fun ustawcolor(view: android.view.View) {
        val pref = getPreferences(Context.MODE_APPEND)
        val editor = pref.edit()

        insertBT.setTextColor(Color.YELLOW)
        showListBT.setTextColor(Color.YELLOW)
        clearDataBT.setTextColor(Color.YELLOW)
        editor.putInt("TEXTCOLOR", Color.YELLOW.toString().toInt())
        editor.commit()


        val toast = Toast.makeText(applicationContext, "zmieniono kolor", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 140)
        toast.show()

    }

    fun ustawsize(view: android.view.View) {
        val pref = getPreferences(Context.MODE_APPEND)
        val editor = pref.edit()

        insertBT.setTextSize(0, 66F)
        showListBT.setTextSize(0, 66F)
        clearDataBT.setTextSize(0, 66F)
        editor.putFloat("TEXTSIZE", 22.toFloat())
        editor.commit()


        val toast =
            Toast.makeText(applicationContext, "zmieniono rozmiar czcionki", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 140)
        toast.show()


    }


}

