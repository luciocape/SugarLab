package com.example.batallapokemon


class Pokemon(nmb:String,tpo:String,atk:Int,dfs:Int):interfazPokemon {
    override var nombre: String = nmb
    override var tipo: String = tpo
    override var nivel: Int = 1
    override var ataque: Int = atk
    override var defensa: Int = dfs
    override var vida: Int = 100
}