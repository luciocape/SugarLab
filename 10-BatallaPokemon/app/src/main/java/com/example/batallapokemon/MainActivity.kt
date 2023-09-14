package com.example.batallapokemon

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TableLayout
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {
    var btnMochila: ImageButton? = null
    var layMochila: TableLayout? = null
    var btnEvee: ImageButton? = null
    var btnUmbreon: ImageButton? = null
    var btnMeawth: ImageButton? = null
    var btnSnorlax: ImageButton? = null
    var imgAliado: ImageView? = null
    var imgEnemigo: ImageView? = null

    var equipo1: MutableList<Pokemon> = mutableListOf()
    var equipo2: MutableList<Pokemon> = mutableListOf()
    var elementos: Array<String> = arrayOf("agua", "fuego", "madera", "electricidad")
    var bag: Int = 0
    var pokeElegido: String = "snorlax"
    var pokeNoElegido: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMochila = findViewById(R.id.btnMochila)
        layMochila = findViewById(R.id.layMochila)
        btnEvee = findViewById(R.id.btnEvee)
        btnMeawth = findViewById(R.id.btnMeawth)
        btnUmbreon = findViewById(R.id.btnUmbreon)
        btnSnorlax = findViewById(R.id.btnSnorlax)
        imgAliado = findViewById(R.id.imgAliado)
        imgEnemigo = findViewById(R.id.imgEnemigo)

        val poke1 = btnEvee as ImageButton
        val poke2 = btnUmbreon as ImageButton
        val poke3 = btnMeawth as ImageButton
        val poke4 = btnSnorlax as ImageButton
        pokeNoElegido = mutableListOf(
            poke1.contentDescription.toString(),
            poke4.contentDescription.toString(),
            poke3.contentDescription.toString(),
            poke4.contentDescription.toString()
        )
    }

    fun mochila(view: View) {
        if (bag % 2 == 0) {
            layMochila?.visibility = View.VISIBLE
        } else {
            layMochila?.visibility = View.GONE
        }
        bag += 1
    }

    fun seleccionPokemon(view: View) {
        val boton = view as ImageButton
        val textoBoton = boton.contentDescription.toString()
        boton.setBackgroundColor(Color.parseColor("#5A2929"))
        when (pokeElegido) {
            "evee" -> {
                btnEvee?.setBackgroundColor(Color.parseColor("#D5D6D6"))
            }

            "snorlax" -> {
                btnSnorlax?.setBackgroundColor(Color.parseColor("#D5D6D6"))
            }

            "meawth" -> {
                btnMeawth?.setBackgroundColor(Color.parseColor("#D5D6D6"))
            }

            "umbreon" -> {
                btnUmbreon?.setBackgroundColor(Color.parseColor("#D5D6D6"))
            }

        }
        pokeElegido = textoBoton

    }

    fun elegirPokemon(view: View) {
        pokeNoElegido.removeIf { it == pokeElegido}
        if (equipo1.size < 2) {
            equipo1.add(Pokemon(pokeElegido, "madera", 2, 1))
            when (equipo1[equipo1.size-1].nombre) {
                "evee" -> {
                    imgAliado?.setBackgroundResource(R.drawable.evee)
                }
                "snorlax" -> {
                    imgAliado?.setImageResource(R.drawable.snorlax)
                }
                "meawth" -> {
                    imgAliado?.setImageResource(R.drawable.meawth)
                }
                "umbreon" -> {
                    imgAliado?.setImageResource(R.drawable.umbreon)
                }
            }
        } else {
            equipo2.add(Pokemon(pokeNoElegido[0], "madera", 2, 1))
            equipo2.add(Pokemon(pokeNoElegido[1], "madera", 2, 1))
            println(equipo2)
            when (pokeNoElegido[pokeNoElegido.size-1]) {
                "evee" -> {
                    imgEnemigo?.setImageResource(R.drawable.evee)
                }
                "snorlax" -> {
                    imgEnemigo?.setImageResource(R.drawable.snorlax)
                }
                "meawth" -> {
                    imgEnemigo?.setImageResource(R.drawable.meawth)
                }
                "umbreon" -> {
                    imgEnemigo?.setImageResource(R.drawable.umbreon)
                }
            }
        }
    }
}