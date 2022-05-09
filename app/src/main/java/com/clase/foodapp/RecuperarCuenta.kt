package com.clase.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class RecuperarCuenta : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recuperar_cuenta)

        val backRecup = findViewById<ImageButton>(R.id.BackRecupCuenta)
        backRecup.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}