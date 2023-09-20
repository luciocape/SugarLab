package com.example.pokemonbattle.Main.ApiCall

import com.example.pokemonbattle.Main.Data.PokemonData
import com.example.pokemonbattle.Main.Data.PokemonName
import com.example.pokemonbattle.Main.Data.PokemonSprites
import com.example.pokemonbattle.Main.Data.Resultado
import com.example.pokemonbattle.Main.Data.TypeList

data class MainState(
    val isLoading:Boolean = false,
    val pokemons:List<PokemonData> = emptyList(),
    val pokemonsTypes: List<Resultado> = emptyList()
    //val pokemonsName:List<PokemonName> = emptyList(),
    //val pokemonsSprites: List<PokemonSprites> = emptyList(),


)
