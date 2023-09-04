package com.example.losanillosdelpoder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Derecha : AppCompatActivity()  {
    //Navegación layouts
    var btnIzquierda: Button? = null
    var btnLucha: Button? = null
    var btnDerecha: Button? = null
    var btnVolver: Button? = null
    //Selección candidatos
    var btnMilei: ImageButton? = null
    var btnBullrich: ImageButton? = null
    var btnLarreta: ImageButton? = null
    var btnMarra: ImageButton? = null
    var btnMacri: ImageButton? = null
    var guerreros:MutableList<Guerreros> = mutableListOf()
    var btnReiniciar: ImageButton? = null
    var imgSeleccion: ImageView? = null
    var imgSeleccion2: ImageView? = null
    //Poder de influencia
    val ataque:Map<String,Int> = mapOf(
        "Milei" to 6,
        "Macri" to 4,
        "Bullrich" to 4,
        "Larreta" to 0,
        "Marra" to 2
    )
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView (R.layout.derecha)
        //Candidatos
        btnMilei = findViewById(R.id.btnMilei)
        btnBullrich = findViewById(R.id.btnBullrich)
        btnMacri = findViewById(R.id.btnMacri)
        btnMarra = findViewById(R.id.btnMarra)
        btnLarreta = findViewById(R.id.btnLarreta)
        imgSeleccion = findViewById(R.id.imgSeleccion3)
        imgSeleccion2 = findViewById(R.id.imgSeleccion4)
        //Nacegación layouts
        btnIzquierda = findViewById(R.id.btnIzquierda2)
        btnLucha = findViewById(R.id.btnLucha2)
        btnDerecha = findViewById(R.id.btnDerecha2)
        btnVolver = findViewById(R.id.btnVolver)
        //Extras
        btnReiniciar = findViewById(R.id.btnReiniciar2)

        imgSeleccion?.setBackgroundResource(R.drawable.lapida)
        imgSeleccion2?.setBackgroundResource(R.drawable.lapida)
    }
    //Navegación layouts
    fun IrIzquierda(view: View) {
        val intent = Intent(this, Izquierda::class.java).apply { }
        startActivity(intent)
    }
    fun IrLucha(view: View) {
        val intent = Intent(this, Lucha::class.java).apply { }
        startActivity(intent)
    }
    fun IrDerecha(view: View) {
        val intent = Intent(this,Derecha::class.java).apply { }
        startActivity(intent)
    }
    fun Volver(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
    }
    //Selección candidatos
    fun Seleccion(view: View, image:Int){
        if (image == 1){

        }
        else{
            when (view.contentDescription.toString()){
                "Milei"->
                    imgSeleccion2?.setBackgroundResource(R.drawable.milei)
                "Macri"->
                    imgSeleccion2?.setBackgroundResource(R.drawable.macri)
                "Marra"->
                    imgSeleccion2?.setBackgroundResource(R.drawable.marra)
                "Larreta"->
                    imgSeleccion2?.setBackgroundResource(R.drawable.larreta)
                "Bullrich"->
                    imgSeleccion2?.setBackgroundResource(R.drawable.bullrich)
            }
        }

    }
    fun CallDerecha(view: View){
        Toast.makeText(this, view.contentDescription.toString(), Toast.LENGTH_SHORT).show()
        if (guerreros.size == 0) {
            guerreros = mutableListOf(Guerreros(
                ataque.getValue(view.contentDescription.toString()),
                true,
                1,
                view.contentDescription.toString()
            ))
            Seleccion(view,1)
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
                            true,
                            1,
                            nmb = view.contentDescription.toString()
                        )
                    )
                    Seleccion(view,2)
                } else Toast.makeText(
                    this,
                    "Ya no se pueden elegir otros candidatos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    fun Reiniciar(view:View){
        guerreros.removeIf { it.corazon}
        println(guerreros)
        imgSeleccion?.setBackgroundResource(R.drawable.lapida)
        imgSeleccion2?.setBackgroundResource(R.drawable.lapida)
    }
}