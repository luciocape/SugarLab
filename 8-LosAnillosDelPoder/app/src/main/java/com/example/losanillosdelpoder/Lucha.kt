package com.example.losanillosdelpoder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Lucha: AppCompatActivity() {
    //Derecha
    var btnMilei: ImageButton? = null
    var btnBullrich: ImageButton? = null
    var btnLarreta: ImageButton? = null
    var btnMarra: ImageButton? = null
    var btnMacri: ImageButton? = null
    val ataque: Map<String, Int> = mapOf(
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
    var guerreros: MutableList<Guerreros> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lucha)


        //println(Pelea(guerreros))

    }
    fun Pelea(view: View){
        var resultado:Int = 0
        var poderBuenos:Int = 0
        var poderMalos:Int = 0
        for (i in guerreros){
            if (i.corazon){
                poderBuenos += i.ataque * i.cant
            }
            else{
                poderMalos += i.ataque * i.cant
            }
        }
        resultado = poderBuenos - poderMalos
        if (resultado == 0){
            Toast.makeText(this, "Fue un empate", Toast.LENGTH_SHORT).show()
        }
        else if (resultado < 0){
            Toast.makeText(this, "Gano la izquierda", Toast.LENGTH_SHORT).show()
        }
        else Toast.makeText(this,"Gano la derecha", Toast.LENGTH_SHORT).show()
    }
    fun Regresar(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
    }
}
