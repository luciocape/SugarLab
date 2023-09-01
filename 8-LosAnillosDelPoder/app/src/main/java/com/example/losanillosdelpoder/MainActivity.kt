package com.example.losanillosdelpoder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Izquierda
        btnMassa = findViewById(R.id.btnBullrich)
        btnCristina = findViewById(R.id.btnLarreta)
        btnAlberto = findViewById(R.id.btnMarra)
        btnGrabois = findViewById(R.id.btnMacri)
        btnKirchner = findViewById(R.id.btnBullrich)

        //println(Pelea(guerreros))

    }
    fun abrirDerecha(view: View) {
        val intent = Intent(this, Derecha::class.java).apply { }
        startActivity(intent)
    }
}



    /*fun Pelea(guerreros:MutableList<Guerreros>):String{
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
*/
/*fun Candidatos(){

    var indice:Int = 0

    for (x in ataque.keys){
        indice += 1
        if (indice > 5){
            guerreros.add(Guerreros(ataque.getValue(x), true,(1..4).random()))
        }
        else{
            guerreros.add(Guerreros(ataque.getValue(x), false,(1..4).random()))
        }
    }
}
 */