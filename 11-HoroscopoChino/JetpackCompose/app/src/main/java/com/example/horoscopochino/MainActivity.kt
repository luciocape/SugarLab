package com.example.horoscopochino

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.findViewTreeViewModelStoreOwner
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
    var resultado:String
    Column(modifier = Modifier
        .fillMaxSize()
        .requiredSize(500.dp)) {
        Texts()
        resultado = inputs()
        if (resultado != ""){
            when (resultado.toInt() % 12){
                    0 -> resultado = "Rata"
                    1 -> resultado = "Bufalo"
                    2 -> resultado = "Tigre"
                    3 -> resultado = "Conejo"
                    4 -> resultado = "Dragon"
                    5 -> resultado = "Serpiente"
                    6 -> resultado = "Caballo"
                    7 -> resultado = "Cabra"
                    8 -> resultado = "Mono"
                    9 -> resultado = "Gallo"
                    10 -> resultado = "Perro"
                    11 -> resultado = "Cerdo"
            }

        Resultado(resultado = resultado.to)
    }
}

@Composable
fun Texts(){
    Text(text = "Cual es tu año de nacimiento?")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputs():String{
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Year of birth") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        },
        modifier = Modifier.layoutId(1)
    )
    var texto:TextView = find
    return
}

@Composable
fun Resultado(resultado:String){
    Text(text = resultado )
}