package com.example.batallapokemon

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    companion object{
        val instance = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build().create(PokeApiService::class.java)
    }
    @GET("{pokeId}")
    suspend fun getPokemonById(@Path("pokeId") pokeId: Int):PokemonResponse

}