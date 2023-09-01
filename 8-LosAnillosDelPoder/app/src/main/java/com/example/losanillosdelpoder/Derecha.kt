package com.example.losanillosdelpoder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class Derecha:AppCompatActivity(){
    var tim:Int = 0
    //Posibles candidatos Derecha
    var btnMilei:ImageButton? = null
    var btnBullrich:ImageButton? = null
    var btnLarreta:ImageButton? = null
    var btnMarra:ImageButton? = null
    var btnMacri:ImageButton? = null
    //Candidatos Derecha
    var guerreros:MutableList<Guerreros> = mutableListOf()
    //Poder de influencia
    val ataque:Map<String,Int> = mapOf(
        "Cristina" to 7,
        "Kirchner" to 0,
        "Alberto" to -1,
        "Massa" to (1..5).random(),
        "Gravois" to 2,
        "Milei" to 6,
        "Macri" to 4,
        "Bullrich" to 4,
        "larreta" to 0,
        "Marra" to 2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.derecha)

        btnMilei = findViewById(R.id.btnMilei)
        btnBullrich = findViewById(R.id.btnBullrich)
        btnLarreta = findViewById(R.id.btnLarreta)
        btnMarra = findViewById(R.id.btnMarra)
        btnMacri = findViewById(R.id.btnMacri)
    }

    fun CallDerecha(view:View){
        println("Derecha")
        guerreros.add(Guerreros(ataque.getValue(view.contentDescription.toString()), true,(1..4).random(),view.contentDescription.toString()))
        Toast.makeText(this, guerreros[tim].nombre, Toast.LENGTH_SHORT).show()
    }

    fun Regresar(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
    }
}