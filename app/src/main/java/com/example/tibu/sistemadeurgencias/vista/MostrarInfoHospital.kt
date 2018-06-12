package com.example.tibu.sistemadeurgencias.vista

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.tibu.sistemadeurgencias.R
import com.example.tibu.sistemadeurgencias.mundo.SistemaDeEmergencias
import kotlinx.android.synthetic.main.activity_mostrar_info_hospital.*

class MostrarInfoHospital : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_info_hospital)

        val botonBuscar = findViewById<Button>(R.id.button_buscar)
        botonBuscar.setOnClickListener {
            val num = findViewById<EditText>(R.id.Id_Hospital).toString().toInt()
            val hospital = SistemaDeEmergencias.obtenerDatosHospital(num)

            var txt_nombre = findViewById<EditText>(R.id.text_nom)
            txt_nombre.setText(hospital!!.darNombre())

            var txt_ubicacion = findViewById<EditText>(R.id.text_ubicacion)
            txt_ubicacion.setText("Calle " + hospital.darUbicacion().darcalle() + " "
                    + "Carrera " + hospital.darUbicacion().darcarrera())

            var txt_acci1 = findViewById<EditText>(R.id.text_acci1)
            txt_acci1.setText(hospital!!.darPrimerAcc())

            var txt_acci2 = findViewById<EditText>(R.id.text_acci2)
            txt_acci2.setText(hospital!!.darSegundoAcc())

        }
    }
}
