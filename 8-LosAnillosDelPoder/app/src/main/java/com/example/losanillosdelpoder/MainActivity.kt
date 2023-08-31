package com.example.losanillosdelpoder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    //Derecha

    val btnBullrich:ImageButton? = null
    val btnLarreta:ImageButton? = null
    val btnMarra:ImageButton? = null
    val btnMacri:ImageButton? = null
    //Izquierda
    val btnMassa:ImageButton? = null
    val btnAlberto:ImageButton? = null
    val btnCristina:ImageButton? = null
    val btnGrabois:ImageButton? = null
    val btnKirchner:ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.derecha)
        setContentView(R.layout.izquierda)
        setContentView(R.layout.lucha)
        /*val ataque:Map<String,Int> = mapOf(
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
        var indice:Int = 0
        var guerreros:MutableList<Guerreros> = mutableListOf()
        for (x in ataque.keys){
            indice += 1
            if (indice > 5){
                guerreros.add(Guerreros(ataque.getValue(x), true,(1..4).random()))
            }
            else{
                guerreros.add(Guerreros(ataque.getValue(x), false,(1..4).random()))
            }
        }
        println(Pelea(guerreros))*/
        var btnMilei: ImageButton = findViewById(R.id.btnMilei)
        btnMilei.setOnClickListener(CallMilei())

    }
    fun CallMilei(view:View){

        btnBullrich = findViewById(R.id.btnBullrich)
        btnLarreta = findViewById(R.id.btnLarreta)
        btnMarra = findViewById(R.id.btnMarra)
        btnMacri = findViewById(R.id.btnMacri)
        kotlin.io.println(view.id.toString())
        println("hola")
        //guerreros.add(Guerreros(ataque.getValue("Milei"), true,(1..4).random()))
    }
    fun Pelea(guerreros:MutableList<Guerreros>):String{
        var resultado:Int = 0
        var poderBuenos:Int = 0
        var poderMalos:Int = 0
        for (i in guerreros){
            if (i.corazon){
                poderBuenos += i.ataque
            }
            else{
                poderMalos += i.ataque
            }
        }
        resultado = poderBuenos - poderMalos

        return if (resultado == 0) "Fue un empate"
        else if (resultado < 0){
            "Ganaron los Malos"
        }
        else "Ganaron los Buenos"
    }

}
