package com.example.losanillosdelpoder

import com.example.losanillosdelpoder.Guerreros
import com.example.losanillosdelpoder.R

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Derecha : AppCompatActivity()  {
    //Extras
    var background: MutableList<Boolean> = mutableListOf()
    var candidato:String? = null
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
    var guerreros: MutableList<Guerreros>? = mutableListOf()
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
        guerreros = getIntent().getSerializableExtra("guerreros") as MutableList<Guerreros>?
        background = getIntent().getBooleanArrayExtra("background")?.toMutableList() ?: mutableListOf(false,false,false,false)
        if (guerreros != null){
            for (e in guerreros!!.indices){
                if (guerreros!![e].corazon){
                    Seleccion(guerreros!![e].nombre,e)
                }
            }
        }
    }

    //Navegación layouts
    fun IrLucha(view: View) {
        val intent = Intent(this, Lucha::class.java).apply { }
        intent.putExtra("guerreros",ArrayList(guerreros))
        intent.putExtra("background", ArrayList(background))
        startActivity(intent)
    }
    fun IrIzquierda(view: View) {
        val intent = Intent(this, Izquierda::class.java).apply { }
        intent.putExtra("guerreros", ArrayList(guerreros))
        intent.putExtra("background", ArrayList(background))
        startActivity(intent)
    }
    fun IrDerecha(view: View) {
        val intent = Intent(this,Derecha::class.java).apply { }
        intent.putExtra("guerreros", ArrayList(guerreros))
        intent.putExtra("background", ArrayList(background))
        startActivity(intent)
    }
    fun Volver(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
    }
    //Selección candidatos
    fun Seleccion(candidato:String, image:Int){
        if (image == 0){
            when (candidato){
                "Milei"-> {
                    imgSeleccion?.setBackgroundResource(R.drawable.milei)
                    background[2]=true
                }
                "Macri"-> {
                    imgSeleccion?.setBackgroundResource(R.drawable.macri)
                    background[2]=true
                }
                "Marra"->{
                    imgSeleccion?.setBackgroundResource(R.drawable.marra)
                    background[2]=true
                }
                "Larreta"-> {
                    imgSeleccion?.setBackgroundResource(R.drawable.larreta)
                    background[2]=true
                }

                "Bullrich"-> {
                    imgSeleccion?.setBackgroundResource(R.drawable.bullrich)
                    background[2]=true
                }
            }
        }
        else if(image == 1){
            when (candidato){
                "Milei"-> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.milei)
                    background[3]=true
                }

                "Macri"-> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.macri)
                    background[3]=true
                }

                "Marra"-> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.marra)
                    background[3]=true
                }

                "Larreta"-> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.larreta)
                    background[3]=true

                }

                "Bullrich"-> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.bullrich)
                    background[3]=true
                }
            }
        }
    }
    fun CallDerecha(view: View){
        candidato = view.contentDescription.toString()
        Toast.makeText(this, candidato!!, Toast.LENGTH_SHORT).show()
        if (guerreros == null) {
            guerreros = mutableListOf(Guerreros(
                ataque.getValue(candidato!!),
                true,
                1,
                candidato!!
            ))
            Seleccion(candidato!!,0)
        }
        else{
            var found = false
            for (e in guerreros!!.indices) {
                if (guerreros!![e].nombre == candidato) {
                    guerreros!![e].cant += 1
                    found = true
                    break
                }
            }
            if (!found && (!background[2] || !background[3])){
                guerreros!!.add(
                    Guerreros(
                        ataque.getValue(candidato!!),
                        true,
                        1,
                        nmb = candidato!!
                    )
                )
                if (!background[2]){
                    Seleccion(candidato!!,0)
                }
                else if (!background[3]){
                    Seleccion(candidato!!,1)
                }
            }
            else if (!found){
                Toast.makeText(
                    this,
                    "Ya no se pueden elegir otros candidatos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    fun Reiniciar(view:View){
        guerreros?.removeIf { it.corazon}
        imgSeleccion?.setBackgroundResource(R.drawable.lapida)
        imgSeleccion2?.setBackgroundResource(R.drawable.lapida)
        background[2]=false
        background[3]=false
    }
}
