package com.example.batallapokemon

import com.example.batallapokemon.Result
import retrofit2.Response

class Repository (private val api:PokeApiService){
    suspend fun getPokemonById():Result<PokemonData>{
        return try {
            val response:PokemonData = api.getPokemonById((0..1010).random()).data
            Result.success(response)
        }catch (e:Exception){
            Result.failure(e)
        }
    }
}