package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var oprs:MutableList<Char> = mutableListOf()
    var numeros:MutableList<Button> = mutableListOf()
    var nums:MutableList<Double> = mutableListOf()
    val oprList:Array<Char> = arrayOf('-','+','x','/')
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

        btnIgual = findViewById(R.id.btnIgual)
        btnMenos = findViewById(R.id.btnMenos)
        btnMas = findViewById(R.id.btnMas)
        btnDiv = findViewById(R.id.btnDiv)
        btnPor = findViewById(R.id.btnX)
        btnReset = findViewById(R.id.btnReset)

        txtResultado = findViewById(R.id.txtResultado)
        Log.i("txtResultado",txtResultado?.text.toString())
        if (nums.isEmpty()){
                Log.i("numeros",nums.toString() )
                Log.i("tamaño numeros",nums.size.toString())
            }
    }
    fun Evaluar(nums:MutableList<Double>, oprs:MutableList<Char>):String{
        var resultado:Double = nums[0]
        if (nums.size >= 2){
            for (x in oprs.indices){
                when (oprs[x]){
                    '+' -> resultado += nums[x+1]
                    '-' -> resultado -= nums[x+1]
                    'x' -> resultado *= nums[x+1]
                    '/' -> resultado /= nums[x+1]
                }
            }
        }
        else if (nums.isNotEmpty()){
            when (oprs[0]){
                '+' -> resultado = nums[0] + nums[0]
                '-' -> nums[0] - nums[0]
                'x' -> nums[0] * nums[0]
                '/' -> nums[0] / nums[0]
            }
        }
        else return "0.0"
        return resultado.toString()

    }
    fun Calcular(view: View){
        val boton = view as Button
        val textoBoton:String = boton.text.toString()
        var mostrar = txtResultado?.text.toString()
        if ( textoBoton.toCharArray()[0] in oprList){
            if (nums.isEmpty()){
                nums.add(txtResultado?.text.toString().toDouble())
                oprs.add(textoBoton.toCharArray()[0])
            }
            else if (nums.size > oprs.size){
                oprs.add(textoBoton.toCharArray()[0])
                nums.add(txtResultado?.text.toString().toDouble())
            }
            else{
                oprs[oprs.lastIndex] = textoBoton.toCharArray()[0]
            }
            txtResultado?.text = oprs.last().toString()
        }
        else if (textoBoton != "Reset" && textoBoton != "="){
            val concatenar = mostrar + textoBoton
            mostrar = Limpieza(concatenar)
            txtResultado?.text  = mostrar
        }
        if (textoBoton == "="){
            txtResultado?.text  = Evaluar(nums, oprs)
        }
        else if (textoBoton == "Reset") txtResultado?.text = "0.0"
    }
    fun Limpieza(str:String):String{
        var i = 0
        val sb = StringBuffer(str)
        while (i < str.length && (str[i] == '0' || str[i] == '.' || str[i] in oprs)) {
            i++
            sb.replace(0,i,"")
        }
        return sb.toString()
    }
}