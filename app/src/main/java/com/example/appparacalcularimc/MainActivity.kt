package com.example.appparacalcularimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(view: View){
        var editEstatura : EditText = findViewById(R.id.editEstatura)
        var editEstaturaString : String = editEstatura.text.toString()
        var editPeso : EditText = findViewById(R.id.editPeso)
        var editPesoString : String = editPeso.text.toString()

        if(!editEstaturaString.isNullOrEmpty() && !editPesoString.isNullOrEmpty() ){
            val textView = findViewById<TextView>(R.id.txtIMC)//Get id of text view
            var IMC : Double = 0.0
            var peso = editPesoString.toDouble()
            var estatura = editEstaturaString.toDouble()
            IMC = (peso/(estatura*estatura))
            /*
            var textIMC =  when {
                IMC < 15 -> "Delgadez Muy Severa"

                IMC >= 15 &&  IMC <= 15.9 -> "Delgadez Severa"
                IMC in (15..16) -> "Delgadez Severa"
                IMC   > 15 , < 16 -> "Delgadez Severa"

                IMC > 40 -> "Obesidad Muy Severa"
                else -> "IMC fuera de conocimiento"
            }*/

            //Toast con mensaje
            var textIMC : String
            textIMC  = if (IMC < 15){
                "Delgadez Muy Severa"
            }
            else if (IMC >  15      &&  IMC     <= 15.9)        getString( R.string.IMC1)
            else if (IMC >= 16      &&  IMC     <= 18.4)        getString( R.string.IMC2)
            else if (IMC >= 18.5    &&  IMC     <= 24.9)        getString( R.string.IMC3)
            else if (IMC >= 25      &&  IMC     <= 29.9)        getString( R.string.IMC4)
            else if (IMC >= 30      &&  IMC     <= 34.9)        getString( R.string.IMC5)
            else if (IMC >= 35      &&  IMC     <= 39.9)        getString( R.string.IMC6)
            else if(IMC  >  40)                                 getString( R.string.IMC7)
            else                                                getString( R.string.IMC8)

            //TextView
            textView.setText("IMC "+IMC.toString()+" "+textIMC)//Se convierte el resultado a string y se escribe el valor a una textView
            var textViewValue = textView.text//Change text of textView

            //Toast
            val durationIMC = Toast.LENGTH_SHORT
            val toastIMC = Toast.makeText(applicationContext, textIMC, durationIMC)
            toastIMC.show()
        }
        else {//Campo vacio
            println("null or empty!")//Se imprime en consola si esta vacio
            val text = "Campo vacio!"//Mensaje de Error
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()//Se muestra el mensaje
        }
    }


}