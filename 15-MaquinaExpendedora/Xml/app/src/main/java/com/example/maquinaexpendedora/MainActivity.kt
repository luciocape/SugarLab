package com.example.maquinaexpendedora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var lytComprar:LinearLayout? = null
    var imgProducto:ImageView? = null
    var txtPrecio:TextView? = null
    var txtProducto:TextView? = null

    var producto:String = ""
    var compra:Int = 0
    var compras:MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lytComprar = findViewById(R.id.lytComprar)
        imgProducto = findViewById(R.id.imgProducto)
        txtProducto = findViewById(R.id.txtProducto)
        txtPrecio = findViewById(R.id.txtPrecio)
    }

    fun abrirCompra(view: View){

        if (compra % 2 == 0) {
            lytComprar?.visibility = View.VISIBLE
        } else {
            lytComprar?.visibility = View.GONE
        }
        compra += 1
        producto = view.contentDescription.toString()
        comprando(producto,view)
    }
    fun comprando(producto:String,view:View){
        when (producto){
            "Sprite" ->{view.setBackgroundResource(R.drawable.)}
            "Coca" ->{view.setBackgroundResource(R.drawable.)}
            "Pepsi" ->{view.setBackgroundResource(R.drawable.)}
            "Fanta" ->{view.setBackgroundResource(R.drawable.)}
            "7up" ->{view.setBackgroundResource(R.drawable.)}
            "Manaos" ->{view.setBackgroundResource(R.drawable.)}
            "PasoToros" ->{view.setBackgroundResource(R.drawable.)}
            "Guarana" ->{view.setBackgroundResource(R.drawable.)}
            "Japi" ->{view.setBackgroundResource(R.drawable.)}
            "Monster" ->{view.setBackgroundResource(R.drawable.)}
            "RedBull" ->{view.setBackgroundResource(R.drawable.)}
            "VillaVicencio" ->{view.setBackgroundResource(R.drawable.)}
        }
    }
    fun comprar(view: View) {
        compras.add(producto)
        val nuevoPrecio = (txtPrecio?.text.toString().replace("$","").toInt() - txtPrecio.toString().replace("$","").toInt()).toString() + "$"
        txtPrecio?.text = nuevoPrecio
    }
    fun misCompras(view: View){
        val intent = Intent(this, MisCompras::class.java).apply { }
        intent.putExtra("compras", ArrayList(compras))
        startActivity(intent)
    }
}
