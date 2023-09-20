package com.example.horoscopochino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import com.example.horoscopochino.ui.theme.HoroscopoChinoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
@Preview
@Composable
fun MainScreen(){
    Column {
        Texts()
        Inputs()
        Images()
    }
}

@Composable
fun Texts(){
    Text(text = "Cual es tu año de nacimiento?")
}

@Composable
fun Inputs(){
    TextField(value = , onValueChange = )

}

@Composable
fun Images(img:Painter){
    Image(painter = img, contentDescription = )
}