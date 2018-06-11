package com.example.tibu.sistemadeurgencias.vista

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.tibu.sistemadeurgencias.R
import com.example.tibu.sistemadeurgencias.mundo.SistemaDeEmergencias

class MostrarAmbulancias : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_ambulancias)

        val lv = findViewById<ListView>(R.id.lista_ambulancias)
        val arregloAmbulancias = SistemaDeEmergencias.obtenerCodigosAmbulancias()
        val adaptAmbulancias = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                arregloAmbulancias)
        lv.adapter = adaptAmbulancias
    }
}
