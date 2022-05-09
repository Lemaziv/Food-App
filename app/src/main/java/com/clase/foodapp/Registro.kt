package com.clase.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Registro : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        val preregistro = findViewById<Button>(R.id.RegistrarseFinal)
        preregistro.setOnClickListener {
            startActivity(Intent(this, RegistroExitoso::class.java))
        }
    }
}