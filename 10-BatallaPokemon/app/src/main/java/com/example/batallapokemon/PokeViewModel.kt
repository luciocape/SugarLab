package com.example.batallapokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory

class PokeViewModel(
    private val repository:Repository = Repository(PokeApiService.instance)
):ViewModel() {
    var state by mutableStateOf()
        private set
    init {
        viewModelFactory {
            repository.getPokemonById().onSuccess {

            }.onFailure {

            }
        }
    }
}