package com.example.conia_app.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.conia_app.EntidadRecycler.Ponencias
import com.example.conia_app.R

class AdapterCustomPonencias(items:ArrayList<Ponencias>): RecyclerView.Adapter<AdapterCustomPonencias.ViewHolder>()  {

    var items:ArrayList<Ponencias>? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCustomPonencias.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.template_ponencias, parent, false)

        val viewHolder = ViewHolder(vista)
        //Con esto renderizo la vista, pero no los elementos
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: AdapterCustomPonencias.ViewHolder, position: Int) {

        val item = items?.get(position)
        //mappeo los valores que tengo en holder
        holder.foto?.setImageResource(item?.imagen!!)
        holder.nombre?.text = item?.nombre
        holder.precio?.text = item?.precio.toString()
        holder.rating?.rating = item?.rating?.toFloat()!!
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        var vista = vista
        var foto: ImageView? = null
        var nombre: TextView? = null
        var precio: TextView? = null
        var rating: RatingBar? = null

        init {
            foto = vista.findViewById(R.id.iv_platillo)
            nombre = vista.findViewById(R.id.tv_nombreP)
            precio = vista.findViewById(R.id.tv_descripcion)
            rating = vista.findViewById(R.id.ratingBar)
        }
    }

}