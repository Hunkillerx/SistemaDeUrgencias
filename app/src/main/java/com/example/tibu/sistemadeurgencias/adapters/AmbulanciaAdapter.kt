package com.example.tibu.sistemadeurgencias.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.tibu.sistemadeurgencias.R
import com.example.tibu.sistemadeurgencias.R.drawable.ambulancia
import com.example.tibu.sistemadeurgencias.mundo.Ambulancia


class AmbulanciaAdapter(private var activity: Activity, private var ambulancia1: Array<Ambulancia>) : BaseAdapter(){

    private class ViewHolder(row: View?) {
        var idAmbulancia: TextView? = null
        var calleAmbulancia: TextView? = null
        var carreraAmbulancia: TextView? = null

        init {
            this.idAmbulancia = row?.findViewById<TextView>(R.id.id_ambulancia)
            this.calleAmbulancia = row?.findViewById<TextView>(R.id.calle_ambulancia)
            this.carreraAmbulancia = row?.findViewById<TextView>(R.id.carrera_ambulancia)
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.ambulancias_list_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var Ambulancia = ambulancia1[position]
        viewHolder.idAmbulancia?.text = Ambulancia.darCodigo().toString()
        viewHolder.calleAmbulancia?.text = Ambulancia.darUbicacion().darcalle().toString()
        viewHolder.carreraAmbulancia?.text = Ambulancia.darUbicacion().darcarrera().toString()

        return view as View
    }

    override fun getItem(i: Int): Ambulancia {
        return ambulancia1[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return ambulancia1.size
    }
}