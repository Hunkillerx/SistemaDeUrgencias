package com.example.tibu.sistemadeurgencias.vista

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.tibu.sistemadeurgencias.R
import com.example.tibu.sistemadeurgencias.mundo.SistemaDeEmergencias
import org.w3c.dom.Text

class MostrarPacientes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pacientes)

        val botonBuscar = findViewById<Button>(R.id.button_buscar_paciente)
        botonBuscar.setOnClickListener{
            val cod = findViewById<EditText>(R.id.codigo_hospital)
            val cod2 = cod.text.toString().toInt()

            val lv = findViewById<ListView>(R.id.lista_pacientes)
            val arregloPacientes = SistemaDeEmergencias.obtenerPacientes(cod2)
            val adaptPacientes = ArrayAdapter(this,
                    android.R.layout.simple_expandable_list_item_1,
                    arregloPacientes)
            lv.adapter = adaptPacientes
        }
    }
}
