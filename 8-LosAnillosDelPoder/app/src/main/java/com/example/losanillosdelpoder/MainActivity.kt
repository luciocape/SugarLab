package com.example.losanillosdelpoder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.losanillosdelpoder.Derecha

class MainActivity : AppCompatActivity() {
    var guerreros1: MutableList<Guerreros>? = mutableListOf()
    var background1: Array<Boolean> = arrayOf(false,false,false,false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)

    }
    fun abrirDerecha(view: View) {
        println("no llegue1")
        val intent = Intent(this, Derecha::class.java).apply { }
        intent.putExtra("guerreros", ArrayList(guerreros1))
        intent.putExtra("background", background1)
        println("no llegue1")
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