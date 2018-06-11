package com.example.tibu.sistemadeurgencias.vista

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tibu.sistemadeurgencias.R
import com.example.tibu.sistemadeurgencias.vista.AgregarAmbulancia
import com.example.tibu.sistemadeurgencias.vista.AgregarHospital
import kotlinx.android.synthetic.main.activitdad_principal.*

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

        val botonVerAmbulancias = findViewById<Button>(R.id.verTodasAmbulancias)
        botonVerAmbulancias.setOnClickListener{
            val intent = Intent(this, verTodasAmbulancias :: class.java)
            startActivity(intent)
        }

        val botonVerHospitales = findViewById<Button>(R.id.verTodosHospitales)
        botonVerHospitales.setOnClickListener{
            val intent = Intent(this,verTodosHospitales :: class.java)
            startActivity(intent)
        }

    }
}
