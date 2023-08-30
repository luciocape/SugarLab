package com.example.conjuntos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a:Array<String> = arrayOf("hola","chau","adios","chau")
        var b:Array<String> = arrayOf("mama","chau","adios","chau")
        println(Similitud(a, b, true))
    }

    fun Similitud(a:Array<String>,b:Array<String>,bool:Boolean):MutableList<String>{
        var resultado:MutableList<String> = mutableListOf()
        if (bool){
            for (x in a.indices) {
                if (a[x] in b && a[x] !in resultado) {
                    resultado.add(a[x])
                }
                if (b[x] in a && b[x] !in resultado){
                    resultado.add(b[x] )
                }
            }
        }
        else{
            for (x in a.indices) {
                if (a[x] !in b && a[x] !in resultado) {
                    resultado.add(a[x])
                }
                if (b[x] !in a && b[x] !in resultado){
                    resultado.add(b[x] )
                }
            }
        }
        return resultado
    }
}