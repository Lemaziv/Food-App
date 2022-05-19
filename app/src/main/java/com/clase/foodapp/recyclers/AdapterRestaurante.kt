package com.clase.foodapp.recyclers

import android.content.Context
import android.net.Uri
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.clase.foodapp.R
import com.clase.foodapp.databinding.RestauranteBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.withContext

class AdapterRestaurante (val restauranteList: ArrayList<Restaurante>) : RecyclerView.Adapter<AdapterRestaurante.ViewHolder>(){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(publicacion: Restaurante){
            val nombre = itemView.findViewById(R.id.NombreRestaurante) as TextView
            val usuario = itemView.findViewById(R.id.Categoria) as TextView
            val imagen = itemView.findViewById(R.id.imgPicasso) as ImageView

            nombre.text = publicacion.NombreRestaurante.toString()
            usuario.text = publicacion.Categoria.toString()
            Picasso.get().load(publicacion.Logo).into(imagen)
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