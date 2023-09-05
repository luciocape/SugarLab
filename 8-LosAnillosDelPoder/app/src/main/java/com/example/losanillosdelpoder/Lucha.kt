package com.example.losanillosdelpoder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Lucha: AppCompatActivity() {
    var imgSeleccion: ImageView? = null
    var imgSeleccion2: ImageView? = null
    var imgSeleccion3: ImageView? = null
    var imgSeleccion4: ImageView? = null
    var guerreros: MutableList<Guerreros> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lucha)

        imgSeleccion?.setBackgroundResource(R.drawable.lapida)
        imgSeleccion2?.setBackgroundResource(R.drawable.lapida)
        imgSeleccion3?.setBackgroundResource(R.drawable.lapida)
        imgSeleccion4?.setBackgroundResource(R.drawable.lapida)

        var guerreros = intent.getParcelableArrayListExtra<Guerreros>("guerreros") as MutableList<Guerreros>
        Seleccion(guerreros)
    }
    fun Seleccion(guerreros:MutableList<Guerreros>){
        for (x in 0..3){
            when (x){
                0 ->
                    when (guerreros[x].nombre){
                        "Milei"->
                            imgSeleccion?.setBackgroundResource(R.drawable.milei)
                        "Macri"->
                            imgSeleccion?.setBackgroundResource(R.drawable.macri)
                        "Marra"->
                            imgSeleccion?.setBackgroundResource(R.drawable.marra)
                        "Larreta"->
                            imgSeleccion?.setBackgroundResource(R.drawable.larreta)
                        "Bullrich"->
                            imgSeleccion?.setBackgroundResource(R.drawable.bullrich)
                    }
                1 ->
                    when (guerreros[x].nombre){
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
                2 ->
                    when (guerreros[x].nombre){
                        "Massa"->
                            imgSeleccion3?.setBackgroundResource(R.drawable.massa)
                        "Cristina"->
                            imgSeleccion3?.setBackgroundResource(R.drawable.cristina)
                        "Grabois"->
                            imgSeleccion3?.setBackgroundResource(R.drawable.grabois)
                        "Kirchner"->
                            imgSeleccion3?.setBackgroundResource(R.drawable.lapida)
                        "Alberto"->
                            imgSeleccion3?.setBackgroundResource(R.drawable.alberto)
                    }
                3 ->
                    when (guerreros[x].nombre){
                        "Massa"->
                            imgSeleccion4?.setBackgroundResource(R.drawable.massa)
                        "Cristina"->
                            imgSeleccion4?.setBackgroundResource(R.drawable.cristina)
                        "Grabois"->
                            imgSeleccion4?.setBackgroundResource(R.drawable.grabois)
                        "Kirchner"->
                            imgSeleccion4?.setBackgroundResource(R.drawable.lapida)
                        "Alberto"->
                            imgSeleccion4?.setBackgroundResource(R.drawable.alberto)
                    }
            }
        }
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


