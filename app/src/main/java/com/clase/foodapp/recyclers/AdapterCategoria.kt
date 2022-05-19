package com.clase.foodapp.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clase.foodapp.R
import com.squareup.picasso.Picasso

class AdapterCategoria (val categoriaList: ArrayList<Categoria>) : RecyclerView.Adapter<AdapterCategoria.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(publicacion: Categoria){
            val imagen = itemView.findViewById(R.id.imgCategoria) as ImageView
            val nombre = itemView.findViewById(R.id.NombreCategoria) as TextView

            Picasso.get().load(publicacion.ImgCategoria).into(imagen)
            nombre.text = publicacion.NombreCategoria.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categoria, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categoriaList[position])
    }

    override fun getItemCount(): Int {
        return categoriaList.size
    }
}