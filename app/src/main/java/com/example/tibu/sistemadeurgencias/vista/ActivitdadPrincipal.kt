package com.example.tibu.sistemadeurgencias.vista

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tibu.sistemadeurgencias.R

class ActivitdadPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitdad_principal)

        val botonAgregarHospital = findViewById<Button>(R.id.agregarHospital)
        botonAgregarHospital.setOnClickListener{
            val intent= Intent(this, AgregarHospital::class.java)
            startActivity(intent)
        }
        val botonAgregarAmbulancia = findViewById<Button>(R.id.agregarAmbulancia)
        botonAgregarAmbulancia.setOnClickListener{
            val intent= Intent(this, AgregarAmbulancia::class.java)
            startActivity(intent)
        }
        val botonAgregarAccidentado = findViewById<Button>(R.id.agregarAccidentado)
        botonAgregarAccidentado.setOnClickListener{
            val intent= Intent(this, AgregarAccidentado::class.java)
            startActivity(intent)
        }
    }
}
