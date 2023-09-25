package com.example.pokemonbattle.Main

import android.graphics.Color
import android.media.Image
import android.text.BoringLayout
import android.view.View
import android.widget.ImageButton
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokemonbattle.Main.ApiCall.PokeViewModel
import com.example.pokemonbattle.R

//Variables
var mochilaOpen:Int = 0

@Composable
fun MainScreen(viewModel: PokeViewModel){
    val state = viewModel
    AtaquesYMochila()
    if(mochilaOpen % 2 != 0) {
        Column{
            Mochila(state)
        }
    }
}
//Componentes
@Composable
fun Mochila(viewModel: PokeViewModel){
    val state = viewModel.state

    if (state.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
    Row (modifier = Modifier
        .size(.dp)
        .background(color = androidx.compose.ui.graphics.Color.Companion.Blue),  horizontalArrangement= Arrangement.Center){
        for (e in state.pokemons){
            if (state.pokemons.indexOf(e) % 2 == 0) {
                Column() {
                    var colorBg = androidx.compose.ui.graphics.Color.Gray
                    AsyncImage(
                        model = e.front_default,
                        contentDescription = "pokemon",
                        modifier = Modifier
                            .size(100.dp)
                            .background(colorBg)
                            .clickable {
                                colorBg = androidx.compose.ui.graphics.Color.Red
                            }
                    )
                }
            }
            Column() {
                var colorBg = androidx.compose.ui.graphics.Color.Gray
                AsyncImage(
                    model = e.front_default,
                    contentDescription = "pokemon",
                    modifier = Modifier
                        .size(100.dp)
                        .background(colorBg)
                        .clickable { colorBg = androidx.compose.ui.graphics.Color.Red }
                )
            }
        }
    }
}
@Composable
fun AtaquesYMochila(){

    Row(modifier = Modifier
        .height(200.dp)) {
        Image(painter = painterResource(R.drawable.mochila) , contentDescription = "Mochila", modifier = Modifier
            .width(100.dp)
            .background(androidx.compose.ui.graphics.Color.Companion.Green)
            .clickable { mochilaOpen += 1 } )
        Row(){
            Ataques()
            Ataques()
        }
    }
}

@Composable
fun Ataques(){
    Column(modifier = Modifier.height(200.dp)) {
        Button(onClick = { /*TODO*/ }){
            Text("Ataque")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Ataque")
        }
    }
}

/*

@Composable
fun BatallaPokemon(){
    Column() {
        LinearProgressIndicator()

        AsyncImage(
            model =  ,
            contentDescription = "pokemon",
            modifier = Modifier.size(100.dp)
        )
        Button(onClick =

        }
        AsyncImage(
            model = ,
            contentDescription = "pokemon",
            modifier = Modifier.size(100.dp)
        )
        LinearProgressIndicator()
    }
}
 */


