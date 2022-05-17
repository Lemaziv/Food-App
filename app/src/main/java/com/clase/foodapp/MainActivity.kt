package com.clase.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iniSesion = findViewById<Button>(R.id.ButtonIS)
        iniSesion.setOnClickListener{
            if (Categoria.text.isNotEmpty() && contraseña.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(Categoria.text.toString(),
                        contraseña.text.toString()).addOnCompleteListener {
                        if(it.isSuccessful){
                            startActivity(Intent(this, Menu_Principal::class.java))
                        } else {
                            showAlert()
                        }
                    }
            } else {
                showAlert()
            }
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

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}