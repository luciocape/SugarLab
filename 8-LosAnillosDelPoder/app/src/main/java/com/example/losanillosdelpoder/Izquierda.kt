package com.example.losanillosdelpoder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Izquierda: AppCompatActivity() {
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
    //Izquierda

    var btnMassa: ImageButton? = null
    var btnAlberto: ImageButton? = null
    var btnCristina: ImageButton? = null
    var btnGrabois: ImageButton? = null
    var btnKirchner: ImageButton? = null
    var btnIzquierda: ImageButton? = null
    var btnDerecha: ImageButton? = null
    var btnLucha: ImageButton? = null
    var btnVolver: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.izquierda)

        //Izquierda
        btnMassa = findViewById(R.id.btnMassa)
        btnCristina = findViewById(R.id.btnCristina)
        btnAlberto = findViewById(R.id.btnKirchner)
        btnGrabois = findViewById(R.id.btnGrabois)
        btnKirchner = findViewById(R.id.btnAlberto)
        btnIzquierda = findViewById(R.id.btnAlberto)
        btnDerecha = findViewById(R.id.btnAlberto)
        btnLucha = findViewById(R.id.btnAlberto)
        btnVolver = findViewById(R.id.btnAlberto)

        //println(Pelea(guerreros))

    }
    fun irIzquierda(view: View) {
        val intent = Intent(this, Izquierda::class.java).apply { }
        startActivity(intent)
    }
    fun irLucha(view: View) {
        val intent = Intent(this, Lucha::class.java).apply { }
        startActivity(intent)
    }
    fun irDerecha(view: View) {
        val intent = Intent(this,Derecha::class.java).apply { }
        startActivity(intent)
    }
    fun Regresar(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
    }
}