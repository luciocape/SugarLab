package com.example.pokemonbattle.Main.ApiCall

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonbattle.Main.Data.PokemonData
import kotlinx.coroutines.launch

class PokeViewModel(
    private val repository: Repository = Repository(PokeApiService.instance)
):ViewModel() {
    var state by mutableStateOf(MainState())
        private set
    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val listaPokemons:MutableList<PokemonData> = mutableListOf()
            repository.getPokemonName().onSuccess {
                for (e in 0..3){
                    listaPokemons.add(PokemonData(name = it[e].name))
                }
                state = state.copy(
                    pokemons = listaPokemons
                )
                Log.i("onSuccess", it.toString())
                Log.i("onSuccess(state)", state.pokemons.toString())

            }
                .onFailure {
                Log.i("onFailure",it.toString())
            }

            repository.getPokemonImage().onSuccess {
                for (e in 0..3){
                    listaPokemons[e].front_default = it[e].sprites.front_default
                    listaPokemons[e].back_default = it[e].sprites.back_default
                }
                state = state.copy(
                    pokemons =  listaPokemons
                )
                Log.i("onSuccess", it.toString())
                Log.i("onSuccess(state)", state.pokemons.toString())
            }.onFailure {
                Log.i("onFailure",it.toString())
            }

            repository.getPokemonTypes().onSuccess {
                state = state.copy(
                    pokemonsTypes = it
                )
                Log.i("onSuccess", it.toString())
                Log.i("onSuccess(state)", state.pokemons.toString())
            }.onFailure {
                Log.i("onFailure",it.toString())
            }
            state = state.copy(isLoading = false)
        }
    }
}