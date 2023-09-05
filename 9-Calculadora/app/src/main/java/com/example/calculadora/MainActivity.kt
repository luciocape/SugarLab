package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var numeros:MutableList<Button> = mutableListOf<Button>()

    var btnIgual:Button ?= null
    var btnMenos:Button ?= null
    var btnMas:Button ?= null
    var btnPor:Button ?= null
    var btnDiv:Button ?= null
    var btnReset:Button ?= null

    var txtResultado:TextView ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numeros.add(findViewById(R.id.btn0))
        numeros.add(findViewById(R.id.btn1))
        numeros.add(findViewById(R.id.btn2))
        numeros.add(findViewById(R.id.btn3))
        numeros.add(findViewById(R.id.btn4))
        numeros.add(findViewById(R.id.btn5))
        numeros.add(findViewById(R.id.btn6))
        numeros.add(findViewById(R.id.btn7))
        numeros.add(findViewById(R.id.btn8))
        numeros.add(findViewById(R.id.btn9))

        btnIgual = findViewById(R.id.btnIgual)
        btnMenos = findViewById(R.id.btnMenos)
        btnMas = findViewById(R.id.btnMas)
        btnDiv = findViewById(R.id.btnDiv)
        btnPor = findViewById(R.id.btnX)
        btnReset = findViewById(R.id.btnReset)

        txtResultado = findViewById(R.id.txtResultado)
    }
    fun Calcular(view: View){
        var boton = view as Button
        var textoBoton = boton.text.toString()
        var concatenar = txtResultado?.text.toString() + textoBoton

    }
}