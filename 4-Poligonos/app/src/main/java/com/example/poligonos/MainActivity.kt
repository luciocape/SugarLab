package com.example.poligonos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(AreaPoligono(poligono = "triangulo",base = 20, altura = 30))
    }

    fun AreaPoligono(base:Int,altura:Int, poligono:String):Int{
        when(poligono){
            "triangulo"->
                return base * altura/2
            "Cuadrado"->
                return base * altura
        }
        return 0
    }
}