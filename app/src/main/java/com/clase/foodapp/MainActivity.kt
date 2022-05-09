package com.clase.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iniSesion = findViewById<Button>(R.id.ButtonIS)
        iniSesion.setOnClickListener {
            startActivity(Intent(this, Menu_Principal::class.java))
        }

        val recupCuenta = findViewById<Button>(R.id.ButtonRecuperarCuenta)
        recupCuenta.setOnClickListener {
            startActivity(Intent(this, RecuperarCuenta::class.java))
        }

        val preregistro = findViewById<Button>(R.id.ButtonRegistrarse)
        preregistro.setOnClickListener {
            startActivity(Intent(this, Registro::class.java))
        }
    }
}