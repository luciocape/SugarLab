package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val oprList:Array<Char> = arrayOf('-','+','x','/')

    var opr:Char? = null
    var nums:MutableList<String> = mutableListOf("0.0")

    var numero1:Boolean = false
    var operando:Boolean = false

    var txtResultado:TextView ?= null
    var btn1:Button ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResultado = findViewById(R.id.txtResultado)
        btn1 = findViewById(R.id.btn1)
    }
    //Agregar números y limpiar ceros, puntos, operadores, etc. de atras
    fun limpieza(str:String):String{
        var i = 0
        val sb = StringBuffer(str)
        while (i < str.length && (str[i] == '0' || str[i] == '.' || str[i] in oprList)) {
            i++
            sb.replace(0,i,"")
        }
        return sb.toString()
    }
    fun agregarNumero(view: View){
        val boton = view as Button
        val textoBoton = boton.text.toString()
        //Si el hay un operador agregado se puede añadir un segundo número
        if  (operando){
            if (nums.size < 2){
                nums.add(textoBoton)
            }
            else {
                nums[1]+=textoBoton
            }
            nums[1]=limpieza(nums[1])
            val resultado = txtResultado?.text.toString() + nums[1]
            txtResultado?.text = resultado
        }
        else if(!numero1){
            nums[0]+=boton.text.toString()
            nums[0]=limpieza(nums[0])
            txtResultado?.text = nums[0]
        }
    }
    //Operación a realizar
    fun agregarOperador(view: View){
        val boton = view as Button
        val textoBoton = boton.text.toString()
        //Si todavía no hay un segundo número agregado
        if (nums.size == 1){
            opr = textoBoton.toCharArray()[0]
            operando = true
            val resultado = txtResultado?.text.toString() + opr.toString()
            txtResultado?.text = resultado
        }
    }
    //Evaluar expresión
    fun evaluar(view: View){
        var num1 = nums[0].toDouble()
        val num2 = nums[1].toDouble()
        when (opr){
            '+' -> num1 += num2
            '-' -> num1 -= num2
            'x' -> num1 *= num2
            '/' -> num1 /= num2
        }
        reset(view)
        nums.add(num1.toString())
    }
    //Devolver resultado
    fun igualar(view: View){
        if (opr != null){
            evaluar(view)
            txtResultado?.text = nums[0]
            numero1=true
        }

    }
    //Resetear calculadora
    fun reset(view: View){
        val boton = view as Button
        val textoBoton = boton.text.toString()
        nums.removeIf{it in nums}
        if (textoBoton == "Reset"){
            txtResultado?.text = "0.0"
            nums.add("0.0")
            numero1 = false
        }
        operando = false
        opr = null
    }

}