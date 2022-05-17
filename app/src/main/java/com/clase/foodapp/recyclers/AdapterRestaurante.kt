package com.clase.foodapp.recyclers

import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.clase.foodapp.R

class AdapterRestaurante (val restauranteList: ArrayList<Restaurante>) : RecyclerView.Adapter<AdapterRestaurante.ViewHolder>(){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(publicacion: Restaurante){
            val nombre = itemView.findViewById(R.id.NombreRestaurante) as TextView
            val usuario = itemView.findViewById(R.id.Categoria) as TextView

            nombre.text = publicacion.NombreRestaurante.toString()
            usuario.text = publicacion.Categoria.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurante, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(restauranteList[position])
    }

    override fun getItemCount(): Int {
        return restauranteList.size
    }

}