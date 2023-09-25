package com.example.losanillosdelpoder

import android.os.Build
import java.io.Serializable

class Guerreros(atk:Int, crz:Boolean,cant:Int,nmb:String)  : Serializable {
    var nombre:String
    var corazon:Boolean
    var ataque: Int
    var cant: Int
    init {
        this.nombre = nmb
        this.ataque = atk
        this.corazon = crz
        this.cant = cant
    }
}