package com.example.losanillosdelpoder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.derecha)
        val ataque:Map<String,Int> = mapOf(
            "CristinaK" to 7,
            "Kirchner" to 0,
            "Alberto" to -1,
            "Massa" to (1..5).random(),
            "Gravois" to 2,
            "Milei" to 6,
            "Macri" to 4,
            "Bullrich" to 4,
            "larreta" to 0,
            "Marra" to 2
        )
        var indice:Int = 0
        var guerreros:MutableList<Guerreros> = mutableListOf()
        for (x in ataque.keys){
            indice += 1
            if (indice > 5){
                guerreros.add(Guerreros(ataque.getValue(x), true,(1..4).random()))
            }
            else{
                guerreros.add(Guerreros(ataque.getValue(x), false,(1..4).random()))
            }
        }
        println(Pelea(guerreros))
    }

    fun Pelea(guerreros:MutableList<Guerreros>):String{
        var resultado:Int = 0
        var poderBuenos:Int = 0
        var poderMalos:Int = 0
        for (i in guerreros){
            if (i.corazon){
                poderBuenos += i.ataque
            }
            else{
                poderMalos += i.ataque
            }
        }
        resultado = poderBuenos - poderMalos

        return if (resultado == 0) "Fue un empate"
        else if (resultado < 0){
            "Ganaron los Malos"
        }
        else "Ganaron los Buenos"
    }

}
