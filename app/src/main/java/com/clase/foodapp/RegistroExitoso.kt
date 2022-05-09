package com.clase.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class RegistroExitoso : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_exitoso)

        val backButton = findViewById<ImageButton>(R.id.BackRegistroFinal)
        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}