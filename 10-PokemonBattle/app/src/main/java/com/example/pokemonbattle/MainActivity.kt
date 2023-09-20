package com.example.pokemonbattle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.pokemonbattle.Main.MainScreen
import com.example.pokemonbattle.Main.ApiCall.PokeViewModel

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<PokeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel)
        }
    }
}