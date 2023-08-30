package com.example.anagrama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Anagrama("ave","vea")

    }

    fun Anagrama(a:String, b:String){
        var resultado:String = "No es un anagrama"
        if (a.length == b.length && a != b){
            for (x in a){
                if (x in b){
                    resultado = "Es un anagrama"
                }
                else{
                    continue
                }
            }
        }
        println(resultado)
    }
}