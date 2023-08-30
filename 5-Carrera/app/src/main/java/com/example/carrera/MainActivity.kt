package com.example.carrera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var corredor = mutableListOf("run","run","jump","run")
        var carretera:String = "__|_"
        println(Carrera(corredor,carretera))
    }

    fun Carrera(corredor:List<String>, carretera:String):Map<Boolean,String>{
        var resultado:Boolean = true
        //var posTrack = ListOf<Char>('_'
        var cambio = StringBuilder(carretera)
        for (s in corredor.indices){
            if ((corredor[s] == "run" && carretera[s] == '|') || (corredor[s] == "jump" && carretera[s] == '_')){
                resultado = false
                if (carretera[s] == '_'){
                    cambio[s] = 'x'
                }
                else{
                    //carretera.replace(s,'\\')
                    cambio[s] = '\\'
                }
            }
        }
        var nuevaCarretera = cambio.toString()
        var myMap = mapOf<Boolean,String>(resultado to nuevaCarretera)
        return myMap
    }
}