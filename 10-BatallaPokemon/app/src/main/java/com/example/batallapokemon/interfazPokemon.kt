package com.example.batallapokemon

import android.view.View
import android.widget.Button

interface InterfazPokemon {
    abstract val sprites: Any
    abstract val types: Any
    var nombre:String
    var tipo:String
    var nivel:Int
    var ataque:Int
    var defensa:Int
    var vida:Int
    fun atacar(atkDefensor:Int,nvlDefensor:Int, tpoDefensor:String, pokemon: Pokemon, elementos:Array<String>):Double{
        var efectividad = 1.0
        when (elementos.indexOf(tipo) - elementos.indexOf(pokemon.tipo)){
            1 -> efectividad *= 0.5
            3 -> efectividad *= 2
            -1 -> efectividad *= 2
            -3 -> efectividad *= 0.5
        }
        var daño:Double = nivel * 0.3 * 50 * (ataque / pokemon.defensa) * efectividad
        return daño
    }
}