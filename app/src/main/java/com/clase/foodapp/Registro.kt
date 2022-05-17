package com.clase.foodapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.registro.*

class Registro : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)

        RegistrarseFinal.setOnClickListener{
            if (NumRegistro.text.isNotEmpty() && ContraseñaRegistro.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(NumRegistro.text.toString(),
                        ContraseñaRegistro.text.toString()).addOnCompleteListener {
                        if(it.isSuccessful){
                            startActivity(Intent(this, RegistroExitoso::class.java))
                        } else {
                            showAlert()
                        }
                    }
            } else {
                showAlert()
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error registrando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}