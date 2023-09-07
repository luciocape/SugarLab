package com.example.losanillosdelpoder

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Izquierda: AppCompatActivity() {
    //Extras
    var background: MutableList<Boolean> = mutableListOf()
    var candidato:String? = null
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
    var guerreros: MutableList<Guerreros>? = mutableListOf()
    var btnReiniciar: ImageButton? = null
    var imgSeleccion: ImageView? = null
    var imgSeleccion2: ImageView? = null

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
        imgSeleccion = findViewById(R.id.imgSeleccion)
        imgSeleccion2 = findViewById(R.id.imgSeleccion2)
        //Navegación layouts
        btnIzquierda = findViewById(R.id.btnIzquierda)
        btnLucha = findViewById(R.id.btnLucha)
        btnDerecha = findViewById(R.id.btnDerecha)
        btnVolver = findViewById(R.id.btnVolver2)
        //Extras
        btnReiniciar = findViewById(R.id.btnReiniciar3)

        imgSeleccion?.setBackgroundResource(R.drawable.lapida)
        imgSeleccion2?.setBackgroundResource(R.drawable.lapida)

        background = getIntent().getBooleanArrayExtra("background")?.toMutableList() ?: mutableListOf(false,false,false,false)
        guerreros = getIntent().getSerializableExtra("guerreros") as MutableList<Guerreros>?
        if (guerreros != null) {
            for (e in guerreros!!.indices) {
                Seleccion(guerreros!![e].nombre, e)
            }
        }
    }

    //Navegación layouts
    fun irIzquierda(view: View) {
        val intent = Intent(this, Izquierda::class.java).apply { }
        intent.putExtra("guerreros", ArrayList(guerreros))
        intent.putExtra("background", ArrayList(background))
        startActivity(intent)
    }

    fun irLucha(view: View) {
        val intent = Intent(this, Lucha::class.java).apply { }
        intent.putExtra("guerreros", ArrayList(guerreros))
        intent.putExtra("background", ArrayList(background))
        startActivity(intent)
    }

    fun irDerecha(view: View) {
        val intent = Intent(this, Derecha::class.java).apply { }
        intent.putExtra("guerreros", ArrayList(guerreros))
        intent.putExtra("background", ArrayList(background))
        startActivity(intent)
    }

    fun Volver(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)
    }

    //Selección candidatos
    fun Seleccion(candidato: String, image: Int) {
        if (image == 0) {
            when (candidato) {
                "Massa" -> {
                    imgSeleccion?.setBackgroundResource(R.drawable.massa)
                    background[0] = true
                }

                "Cristina" -> {
                    imgSeleccion?.setBackgroundResource(R.drawable.cristina)
                    background[0] = true
                }

                "Alberto" -> {
                    imgSeleccion?.setBackgroundResource(R.drawable.alberto)
                    background[0] = true
                }

                "Grabois" -> {
                    imgSeleccion?.setBackgroundResource(R.drawable.grabois)
                    background[0] = true
                }

                "Kirchner" -> {
                    imgSeleccion?.setBackgroundResource(R.drawable.lapida)
                    background[0] = true
                }

            }
        } else if (image == 1) {
            when (candidato) {
                "Massa" -> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.massa)
                    background[1] = true
                }

                "Cristina" -> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.cristina)
                    background[1] = true
                }

                "Grabois" -> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.grabois)
                    background[1] = true
                }

                "Kirchner" -> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.kirchner_s)
                    background[1] = true
                }

                "Alberto" -> {
                    imgSeleccion2?.setBackgroundResource(R.drawable.alberto)
                    background[1] = true
                }

            }
        }
    }
    fun CallIzquierda(view:View){
        candidato = view.contentDescription.toString()
        Toast.makeText(this, view.contentDescription.toString(), Toast.LENGTH_SHORT).show()
        if (guerreros == null) {
            guerreros = mutableListOf(Guerreros(
                ataque.getValue(candidato!!),
                false,
                1,
                candidato!!
            ))
            Seleccion(candidato!!,0)
        }
        else{
            var found = false
            for (e in guerreros!!.indices) {
                if (guerreros!![e].nombre == view.contentDescription.toString()) {
                    guerreros!![e].cant += 1
                    found = true
                    break
                }
            }
            if (!found && (!background[0] || !background[1])){
                guerreros!!.add(
                    Guerreros(
                        ataque.getValue(candidato!!),
                        false,
                        1,
                        nmb = candidato!!
                    )
                )
                if (!background[0]){
                    Seleccion(candidato!!,0)
                }
                else if (!background[1]){
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
    /*fun CallIzquierda(view: View) {
        Toast.makeText(this, view.contentDescription.toString(), Toast.LENGTH_SHORT).show()
        if (guerreros?.size == 0) {
            guerreros = mutableListOf(
                Guerreros(
                    ataque.getValue(view.contentDescription.toString()),
                    true,
                    1,
                    view.contentDescription.toString()
                )
            )
            Seleccion(view.contentDescription.toString(), 0)
        } else {
            for (e in guerreros?.indices!!) {
                if (guerreros!![e].nombre == view.contentDescription.toString()) {
                    guerreros!![e].cant += 1
                    return
                } else if (e + 1 != guerreros!!.size) {
                    continue
                } else if (!background.get(1)) {
                    guerreros!!.add(
                        Guerreros(
                            atk = ataque.getValue(view.contentDescription.toString()),
                            true,
                            1,
                            nmb = view.contentDescription.toString()
                        )
                    )
                    if (!background.get(0)) {
                        Seleccion(view.contentDescription.toString(), 0)
                    } else {
                        Seleccion(view.contentDescription.toString(), 1)
                    }
                } else Toast.makeText(
                    this,
                    "Ya no se pueden elegir otros candidatos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

     */

    fun Reiniciar(view: View) {
        guerreros?.removeIf { !it.corazon }
        println(guerreros)
        imgSeleccion?.setBackgroundResource(R.drawable.lapida)
        imgSeleccion2?.setBackgroundResource(R.drawable.lapida)
        background[0] = false
        background[1] = false
    }
}


