package com.example.pokemonbattle.Main

import android.media.Image
import android.widget.ImageButton
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokemonbattle.Main.ApiCall.PokeViewModel
import com.example.pokemonbattle.R

//Variables
var mochila:Int = 0

@Composable
fun MainScreen(viewModel: PokeViewModel){
    val state = viewModel
    Column{
        AnimatedVisibility(visible = mochila % 2 == 0) {
            LlamadaApi(viewModel = state)
        }
        AtaquesYMochila()
    }

}
//Componentes
@Composable
fun LlamadaApi(viewModel: PokeViewModel){
    val state = viewModel.state
    if (state.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
    Row (modifier = Modifier.size(500.dp),  horizontalArrangement= Arrangement.Center){
        if (state.pokemons.isNotEmpty()){
            LazyColumn(modifier = Modifier){
                items(state.pokemons){
                    Text(it.name, modifier = Modifier.size(100.dp))

                    AsyncImage(
                        model = it.front_default,
                        contentDescription = "pokemon",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AtaquesYMochila(){
    Row(modifier = Modifier
        .height(200.dp)) {
        Image(painter = painterResource(R.drawable.mochila) , contentDescription = "Mochila", modifier = Modifier.width(100.dp).clickable { mochilaPress() } )
        Row () {
            Ataques()
            Ataques()
        }
    }
}

@Composable
fun Ataques(){
    Column(modifier = Modifier.height(200.dp)) {
        Button(onClick = { /*TODO*/ }, modifier = Modifier) {
            Text("Ataque")
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier) {
            Text("Ataque")
        }
    }
}
/*
@Composable
fun BatallaPokemon(){

}

 */

//Funciones
fun mochilaPress(){
    mochila += 1
}



