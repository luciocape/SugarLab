package com.example.trickortriet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //Declaro las variables de mis elementos View
        var txtNombre:EditText? = null
        var txtEdad:EditText? = null
        var txtAltura:EditText? = null
        var btnAñadir:Button? = null
        var btnTrick:Button? = null
        var btnTreat:Button? = null
        //Resultado
            var lytResultado:LinearLayout? = null
            var txtResultado:TextView? = null

    //Resultado del formulario
        var resultadoF:MutableList<MutableMap<String,String>> = mutableListOf()
    //Lista de sustos
        var sustosL = listOf(R.drawable.bruja,R.drawable.fantasma,R.drawable.parca,R.drawable.zombie)
        var sustoss = listOf("rarr","booo","aahhh","uuhhuuh")
    //Lista de dulces
        var dulcesL = listOf(R.drawable.caramelo1,R.drawable.caramelo2,R.drawable.caramelo3,R.drawable.caramelo4)
        var dulces = listOf("choco","chicle","caramelo","chupaleta")
    //Comprobación de que se paso por el formulario
        var formularioP:Boolean = false

    //Creo una imageView
        var imageView:ImageView? = null
    // Calcula la densidad de píxeles para convertir dp a píxeles
        //val density = resources.displayMetrics.density
        val sizeInDp = 50 // Tamaño deseado en dp
        //val sizeInPixels = (sizeInDp * density).toInt()

    // Establece parámetros de diseño para el ImageView con un tamaño de 50dp
        //val layoutParams = LinearLayout.LayoutParams(sizeInPixels, sizeInPixels)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Indico a las variables cual es su elemento dentro del layout
            txtNombre = findViewById(R.id.txtNombre)
            txtEdad = findViewById(R.id.txtEdad)
            txtAltura = findViewById(R.id.txtAltura)
            btnAñadir = findViewById(R.id.btnAñadir)
            btnTrick = findViewById(R.id.btnTrick)
            btnTreat = findViewById(R.id.btnTreat)
            //lytResultado = findViewById(R.id.lytResultado)
            txtResultado = findViewById(R.id.txtResultado)
        imageView = ImageView(this)
    }
    //Pido los valores ingresados en el formulario
    fun formulario(view: View){
        val texto:MutableList<String> = mutableListOf()
        texto.add(txtNombre?.text.toString())
        texto.add(txtEdad?.text.toString())
        texto.add(txtAltura?.text.toString())
        resultadoF.add(
            mutableMapOf(
            "Nombre" to texto[0],
            "Edad" to texto[1],
            "Altura" to texto[2]
        ))
        //Se paso por el formulario
            formularioP = true
    }
    //Devuelve sustos
    fun trick(view:View){
        var cantSustos:Int = 0
        if (formularioP){
            for (e in resultadoF){
                cantSustos += e["Nombre"]!!.length / 2
                if (e["Edad"]!!.toInt() % 2 == 0){
                    cantSustos += 2
                }
                cantSustos += (e["Altura"]!!.toInt() / 100) * 3
            }
        }
        imprimirResultado(cantSustos,true)
        formularioP = false
        resultadoF = mutableListOf()
    }
    //Devuelve dulces
    fun treat(view: View){
        var cantSustos:Int = 0
        if (formularioP){
            for (e in resultadoF){
                if (e["Edad"]!!.toInt() > 10){
                    e["Edad"] = "10"
                }
                if (e["Altura"]!!.toInt() > 150){
                    e["Altura"] = "150"
                }
                cantSustos += e["Nombre"]!!.length
                cantSustos = e["Edad"]!!.toInt() / 3
                cantSustos += (e["Altura"]!!.toInt() / 50)
            }
        }
        imprimirResultado(cantSustos,false)
        formularioP = false
        resultadoF = mutableListOf()
    }
    //Imprime los resultados
    fun imprimirResultado(cantSustos:Int = 0, sustos:Boolean){
        var resultado:String = ""
        for (e in 0..cantSustos){
            if (sustos){
                //imageView.setImageResource(sustosL[(0..3).random()])
                //lytResultado?.addView(imageView,layoutParams)
                resultado += sustoss[(0..3).random()]
            }
            else{
                //imageView.setImageResource(dulcesL[(0..3).random()])
                //lytResultado?.addView(imageView,layoutParams)
                resultado += dulces[(0..3).random()]
            }
        }
        txtResultado?.text = resultado
    }
}