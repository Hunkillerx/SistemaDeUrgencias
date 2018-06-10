package com.example.tibu.sistemadeurgencias.vista

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tibu.sistemadeurgencias.R
import com.example.tibu.sistemadeurgencias.mundo.SistemaDeEmergencias

class AgregarAccidentado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_accidentado)

        val botonRegresar = findViewById<Button>(R.id.regresarAcc)
        botonRegresar.setOnClickListener {
            finish()
        }

        val botonAgregar = findViewById<Button>(R.id.agregarAcc)
        botonAgregar.setOnClickListener {
            val txtNombre = findViewById<EditText>(R.id.textNameAcc)
            val txtaccidente = findViewById<EditText>(R.id.textTipAcc)
            val txtxacc = findViewById<EditText>(R.id.textXAcc)
            val txtyacc = findViewById<EditText>(R.id.textYAcc)

            try {
                val nom = txtNombre.text.toString().toUpperCase()
                val acc = txtaccidente.text.toString().toUpperCase()
                val x = txtxacc.text.toString().toInt()
                val y = txtyacc.text.toString().toInt()


                if (SistemaDeEmergencias.existeAccidentado(nom)) {
                    throw Exception("el nombre $nom ya existe")
                } else {
                    SistemaDeEmergencias.agregarAccidentado(nom,acc,x,y)
                    Toast.makeText(this,
                            "cuenta agregada con axito. hay ${SistemaDeEmergencias.cantidadAccidentados}", Toast.LENGTH_LONG).show()
                }
            }catch (e:Exception){}
        }
    }
}
