package com.example.iterationmaster

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    var btnReiniciar:Button? = null
    var btnIterar:Button? = null
    var txtResutado:TextView? = null
    var lytBackground:FrameLayout? = null

    var nums:MutableList<Short> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReiniciar = findViewById(R.id.btnReiniciar)
        btnIterar = findViewById(R.id.btnIterar)
        txtResutado = findViewById(R.id.txtResultado)
        lytBackground = findViewById(R.id.lytBackground)


        for (e in 1..100){
            nums.add(e.toShort())
        }
    }

    //Funcion principal
    fun iterationMaster(view: View){
        when ((0..2).random()){
            0 -> iteracion1()
            1 -> iteracion2()
            2 -> iteracion3()
        }
    }
    fun reset (view: View){
        txtResutado?.text = ""
    }
    //Funciones de iteración
    fun iteracion1(){
        var numsKnown:String = ""
        for (e in 1..100){
            numsKnown += "-" + e.toString()
            txtResutado?.text = numsKnown
            cambiarColor()
            //delay(100)
        }
    }
    fun iteracion2(){
        var numsKnown:String = ""
        for (e in nums){
            numsKnown += "-" + e.toString()
            txtResutado?.text = numsKnown
            cambiarColor()
            //delay(100)
        }
    }
    fun iteracion3(){
        var num:Int = 0
        var numsKnown:String = ""
        while(num != 101){
            num += 1
            numsKnown += "-" + num.toString()
            txtResutado?.text = numsKnown
            cambiarColor()
            //delay(100)
        }
    }
    fun cambiarColor(){
        when ((1..6).random()){
            1 -> lytBackground?.setBackgroundColor(Color.parseColor("#00235B"))
            2 -> lytBackground?.setBackgroundColor(Color.parseColor("#E21818"))
            3 -> lytBackground?.setBackgroundColor(Color.parseColor("#E9B824"))
            4 -> lytBackground?.setBackgroundColor(Color.parseColor("#FFED00"))
            5 -> lytBackground?.setBackgroundColor(Color.parseColor("#2EB086"))
            6 -> lytBackground?.setBackgroundColor(Color.parseColor("#004225"))
        }
    }
}