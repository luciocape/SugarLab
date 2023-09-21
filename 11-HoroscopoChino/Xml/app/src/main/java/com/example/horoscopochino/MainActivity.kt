package com.example.horoscopochino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var txtInput:EditText? = null
    var txtResultado:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Asigno cada layout/view a su variable
        txtInput = findViewById(R.id.txtInput)
        txtResultado = findViewById(R.id.txtResultado)
    }

    fun RecivirAño(view: View){
        val text = txtInput?.text

        var resultado: String = ""
        when (text.toString().toInt() % 12){
            4 ->  resultado = "Rata"
            5 -> resultado = "Bufalo"
            6 -> resultado = "Tigre"
            7 -> resultado = "Conejo"
            8 -> resultado = "Dragon"
            9 -> resultado = "Serpiente"
            10 -> resultado = "Caballo"
            11 -> resultado = "Cabra"
            0 -> resultado = "Mono"
            1 -> resultado = "Gallo"
            2 -> resultado = "Perro"
            3 -> resultado = "Cerdo"
        }
        txtResultado?.text = resultado
    }
}