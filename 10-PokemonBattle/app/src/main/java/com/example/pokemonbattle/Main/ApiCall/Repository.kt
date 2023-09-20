package com.example.pokemonbattle.Main.ApiCall

import com.example.pokemonbattle.Main.Data.PokemonData
import com.example.pokemonbattle.Main.Data.PokemonName
import com.example.pokemonbattle.Main.Data.PokemonSprites
import com.example.pokemonbattle.Main.Data.Resultado
import com.example.pokemonbattle.Main.Data.TypeList

class Repository (private val api: PokeApiService){

    val randomlist:MutableList<String> = mutableListOf()
    private fun RandomList(){
        for (x in 0..3){
            randomlist.add((1..1010).random().toString())
        }
    }
    suspend fun getPokemonName():Result<List<PokemonName>>{
        RandomList()
        return try {
            val response:MutableList<PokemonName> = mutableListOf()
            for (e in 0..3){
                response.add(api.getPokemonName(randomlist[e]))
            }
            Result.success(response)
        }catch (e:Exception){
            Result.failure(e)
        }
    }
    suspend fun getPokemonImage():Result<List<PokemonSprites>>{
        return try {

            val response:MutableList<PokemonSprites> = mutableListOf()
            for (e in 0..3){
                response.add(api.getPokemonImage(randomlist[e]))
            }
            Result.success(response)
        }catch (e:Exception){
            Result.failure(e)
        }
    }
    suspend fun getPokemonTypes():Result<List<Resultado>>{
        return try {
            var response:List<Resultado> = emptyList()

                response = api.getPokemonTypes().results
            Result.success(response)
        }catch (e:Exception){
            Result.failure(e)
        }
    }
}