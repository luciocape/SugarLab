package com.example.fizzbuzz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FizzBuss()
    }

    val c:Int = 0
    fun FizzBuss(){
        for (x in 1..100){
            if (x%3 == c && x%5 == c){
                println("fizzbuss")
            }
            else if(x%3 == c){
                println("fizz")
            }
            else if(x%5 == c){
                println("buss")
            }
            else{
                println(x)
            }
        }
    }
}