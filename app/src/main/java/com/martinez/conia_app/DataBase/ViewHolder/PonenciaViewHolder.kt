package com.martinez.conia_app.DataBase.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.martinez.conia_app.DataBase.Entities.Ponencias
import kotlinx.android.synthetic.main.template_ponencias.view.*

class PonenciaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(ponencias: Ponencias?){
        with(ponencias!!){
            itemView.tv_nombreP.text = nombre
            itemView.tv_descripcion.text = descripcion
            //itemView.ratingBar.rating = rating.toFloat()
            //itemView.iv_ponente.setImageResource(imagen)
        }
    }
}