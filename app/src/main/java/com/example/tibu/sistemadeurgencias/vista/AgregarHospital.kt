package com.example.tibu.sistemadeurgencias.vista

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tibu.sistemadeurgencias.R
import com.example.tibu.sistemadeurgencias.mundo.SistemaDeEmergencias
import java.lang.Exception


class AgregarHospital : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_hospital)

        val botonRegresar = findViewById<Button>(R.id.regresarhosp)
        botonRegresar.setOnClickListener {
            finish()
        }

        val botonAgregar = findViewById<Button>(R.id.agregarHosp)
        botonAgregar.setOnClickListener {
            val cod = findViewById<EditText>(R.id.codhosp)
            val nom = findViewById<EditText>(R.id.nomhosp)
            val tipoacc1 = findViewById<EditText>(R.id.acc1hosp)
            val tipoacc2 = findViewById<EditText>(R.id.acc2hosp)
            val xAmb = findViewById<EditText>(R.id.callehosp)
            val yAmb = findViewById<EditText>(R.id.carrerahosp)

            try {
                val cod = cod.text.toString().toInt()
                val nom = nom.text.toString().toUpperCase()
                val acc1 = tipoacc1.text.toString().toUpperCase()
                val acc2 = tipoacc2.text.toString().toUpperCase()
                val x = xAmb.text.toString().toInt()
                val y = yAmb.text.toString().toInt()


                if (SistemaDeEmergencias.existeHospital(cod)) {
                    throw Exception("el hospital con codigo $cod ya existe")
                } else {
                    SistemaDeEmergencias.agregarHospital(cod, nom, acc1, acc2, x, y)
                    Toast.makeText(this,
                            "cuenta agregada con axito. hay ${SistemaDeEmergencias.cantidadHospitales}", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
            }
        }

    }
}
