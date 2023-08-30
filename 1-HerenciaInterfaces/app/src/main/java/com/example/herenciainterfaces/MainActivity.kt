package com.example.herenciainterfaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val obj = MiClase()
        obj.show()
        obj.miVariable = "¡¡Cambié!!"
        obj.show()
    }

    interface MiInterfaz{
        var miVariable: String

        fun show(){
            println(miVariable)
        }
    }
    class MiClase : MiInterfaz{
        override var miVariable = "Yo soy la ORIGINAL"
    }
}