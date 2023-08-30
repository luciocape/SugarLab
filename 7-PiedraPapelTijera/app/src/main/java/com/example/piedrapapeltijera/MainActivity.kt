package com.example.piedrapapeltijera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jugadas:Array<Array<String>> = arrayOf(
            arrayOf("piedra","papel"),
            arrayOf("tijera","papel",),
            arrayOf("tijera","tijera")
        )
        println(Partido(jugadas))
    }
    fun Partido(jugadas:Array<Array<String>>):String{
        val movimientos:Array<String> = arrayOf("papel","tijera","piedra")
        var resultado:Int = 0
        for (a in jugadas){
            if (movimientos.indexOf(a[0]) > movimientos.indexOf(a[1])){
                resultado += 1
                println(resultado)
            }
            else if (movimientos.indexOf(a[0]) < movimientos.indexOf(a[1])){
                resultado -= 1
                println(resultado)
            }
        }
        return if (resultado == 0) "Fuen un empate"
        else if (resultado > 0) "Gano el Jugador 1"
        else "Gano el jugador 2"
    }
}

