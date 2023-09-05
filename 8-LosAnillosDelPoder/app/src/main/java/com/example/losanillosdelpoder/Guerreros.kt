package com.example.losanillosdelpoder

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class Guerreros(atk:Int, crz:Boolean,cant:Int,nmb:String)  : Parcelable {
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readInt() ?: 0,
            parcel.readBoolean() ?:false,
            parcel.readInt() ?:0,
            parcel.readString()?:""
    )

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(ataque)
        parcel.writeBoolean(corazon)
        parcel.writeInt(cant)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Guerreros> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Guerreros {
            return Guerreros(parcel)
        }

        override fun newArray(size: Int): Array<Guerreros?> {
            return arrayOfNulls(size)
        }
    }
    val nombre:String = nmb
    val corazon:Boolean = crz
    val ataque: Int = atk
    var cant: Int = cant
}