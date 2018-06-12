package com.example.tibu.sistemadeurgencias.vista

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tibu.sistemadeurgencias.R

import com.example.tibu.sistemadeurgencias.mundo.SistemaDeEmergencias
import java.lang.Exception

class AgregarAmbulancia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_ambulancia)

        val botonRegresar = findViewById<Button>(R.id.regresarAmb)
        botonRegresar.setOnClickListener {
            finish()
        }

        val botonAgregar = findViewById<Button>(R.id.agregarAmb)
        botonAgregar.setOnClickListener {

            val cod = findViewById<EditText>(R.id.codigoAmb)
            val calleAmb = findViewById<EditText>(R.id.calleAmb)
            val carreraAmb = findViewById<EditText>(R.id.carreraAmb)

            try {
                val cod = cod.text.toString().toInt()
                val calle= calleAmb.text.toString().toInt()
                val carrera= carreraAmb.text.toString().toInt()


                if (SistemaDeEmergencias.existeAbulancia(cod)) {
                    throw Exception("la ambulancia con codigo $cod ya existe")
                } else {
                    SistemaDeEmergencias.agregarAmbulancia(cod,calle,carrera)
                    Toast.makeText(this,
                            "cuenta agregada con exito. hay ${SistemaDeEmergencias.cantidadAmbulancias}", Toast.LENGTH_LONG).show()
                }
            }catch (e:Exception){}
        }
    }
}

