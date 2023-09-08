package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var opr:Char = '+'
    var mostrar:String = "0.0"
    var numeros:MutableList<Button> = mutableListOf()
    var nums:MutableList<String> = mutableListOf("0")
    val oprList:Array<Char> = arrayOf('-','+','x','/')
    var operación:Boolean = false
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
    fun Evaluar(nums:MutableList<String>, opr:Char):String{
        var resultado = "0"
        for (x in nums){
            when (opr){
                '+' ->

                '-' -> return (num1 - num2).toString()
                'x' -> return (num1 * num2).toString()
                '/' -> return (num1 / num2).toString()
            }
        }

        return "0.0"
    }
    fun Calcular(view: View){
        val boton = view as Button
        val textoBoton:String = boton.text.toString()
        mostrar = txtResultado?.text.toString()

        if (textoBoton.toCharArray()[0] in oprList){
            opr = textoBoton.toCharArray()[0]
            nums.add(txtResultado?.text.toString())
            txtResultado?.text = opr.toString()
        }
        else if (textoBoton != "Reset" && textoBoton != "="){
            val concatenar = mostrar + textoBoton
            mostrar = QuitarCerosIzquierda(concatenar)
            txtResultado?.text  = mostrar
        }
        if (boton.text.toString() == "="){
            txtResultado?.text  = Evaluar(nums, opr)
        }
    }
    fun QuitarCerosIzquierda(str:String):String{
        var i = 0
        val sb = StringBuffer(str)
        while (i < str.length && (str[i] == '0' || str[i] == '.')) {
            i++
            sb.replace(0,i,"")
        }
        return sb.toString()
    }
}