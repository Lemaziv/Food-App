package com.clase.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Carrito : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.carrito)

        val back = findViewById<ImageButton>(R.id.backCarrito)
        back.setOnClickListener {
            startActivity(Intent(this, Menu_Principal::class.java))
        }

        val siguiente = findViewById<FloatingActionButton>(R.id.floatingListo)
        siguiente.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }
    }
}