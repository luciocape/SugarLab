package com.example.batallapokemon

import com.example.batallapokemon.PokeApi.Companion.instance

class ViewModel {
    val state = instance
    state = state.copy()
}