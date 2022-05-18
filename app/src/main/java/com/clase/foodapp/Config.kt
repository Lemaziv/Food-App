package com.clase.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Config : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.config)

        val atras = findViewById<ImageButton>(R.id.backCarrito)
        atras.setOnClickListener {
            startActivity(Intent(this, Menu_Principal::class.java))
        }
    }
}