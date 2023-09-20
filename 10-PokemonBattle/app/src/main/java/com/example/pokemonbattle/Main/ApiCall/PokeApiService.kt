package com.example.pokemonbattle.Main.ApiCall

import com.example.pokemonbattle.Main.Data.PokemonData
import com.example.pokemonbattle.Main.Data.PokemonName
import com.example.pokemonbattle.Main.Data.PokemonSprites
import com.example.pokemonbattle.Main.Data.TypeList
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface PokeApiService {
    companion object{
        val instance = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build().create(PokeApiService::class.java)
    }
    @GET("pokemon/{pokeId}")
    suspend fun getPokemonName(@Path("pokeId") pokeId: String): PokemonName

    @GET("pokemon-form/{pokeId}")
    suspend fun getPokemonImage(@Path("pokeId") pokeId: String): PokemonSprites

    @GET("type")
    suspend fun getPokemonTypes(): TypeList
}