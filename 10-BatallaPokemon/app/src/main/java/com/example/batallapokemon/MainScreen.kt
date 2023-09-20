package com.example.batallapokemon

import android.compose.runtime.Composable
import android.graphics.Color
import android.widget.ImageView
import java.lang.reflect.Modifier

@Preview
@Composable
fun mainScreen(viewModel: PokeViewModel){
    viewModel
    batalla(modifier = Modifier.background(Color.GREEN))
    mochila(modifier = Modifier.background(Color.GRAY))
}

@Composable
fun batalla(){
    column(){
        ImageView
    }
}