package com.example.losanillosdelpoder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Izquierda: AppCompatActivity() {
    //Navegación layouts
    var btnIzquierda: Button? = null
    var btnLucha: Button? = null
    var btnDerecha: Button? = null
    var btnVolver: Button? = null
    //Selección candidatos
    var btnMassa: ImageButton? = null
    var btnAlberto: ImageButton? = null
    var btnCristina: ImageButton? = null
    var btnGrabois: ImageButton? = null
    var btnKirchner: ImageButton? = null
    var guerreros: MutableList<Guerreros> = mutableListOf()
    var btnReiniciar: ImageButton? = null
    //Poder de influencia
    val ataque: Map<String, Int> = mapOf(
        "Cristina" to 7,
        "Kirchner" to 0,
        "Alberto" to -1,
        "Massa" to (1..5).random(),
        "Grabois" to 2
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.izquierda)
        //Candidatos
        btnMassa = findViewById(R.id.btnMassa)
        btnCristina = findViewById(R.id.btnCristina)
        btnAlberto = findViewById(R.id.btnKirchner)
        btnGrabois = findViewById(R.id.btnGrabois)
        btnKirchner = findViewById(R.id.btnAlberto)
        //Navegación layouts
        btnIzquierda = findViewById(R.id.btnIzquierda)
        btnLucha = findViewById(R.id.btnLucha)
        btnDerecha = findViewById(R.id.btnDerecha)
        btnVolver = findViewById(R.id.btnVolver2)
        //Extras
        btnReiniciar = findViewById(R.id.btnReiniciar3)
    }

    //Navegación layouts
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
    fun Volver(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
    }
    //Selección candidatos
    fun CallIzquierda(view:View){
        Toast.makeText(this, view.contentDescription.toString(), Toast.LENGTH_SHORT).show()
        if (guerreros.size == 0) {
            guerreros = mutableListOf(Guerreros(
                ataque.getValue(view.contentDescription.toString()),
                true,
                1,
                view.contentDescription.toString()
            ))
        }
        else{
            for (e in guerreros.indices) {
                if (guerreros[e].nombre == view.contentDescription.toString()) {
                    guerreros[e].cant += 1
                    return
                } else if (e + 1 != guerreros.size) {
                    continue
                } else if (e == 0) {
                    guerreros.add(
                        Guerreros(
                            atk = ataque.getValue(view.contentDescription.toString()),
                            false,
                            1,
                            nmb = view.contentDescription.toString()
                        )
                    )
                } else Toast.makeText(
                    this,
                    "Ya no se pueden elegir otros candidatos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    fun Reiniciar(view:View){
        guerreros.removeIf { it.corazon == false}
        println(guerreros)
    }

}