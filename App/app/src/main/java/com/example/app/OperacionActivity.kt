package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class OperacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)

        val operacion = intent.getStringExtra("operacion")
        val num1EditText = findViewById<EditText>(R.id.num1)
        val num2EditText = findViewById<EditText>(R.id.num2)
        val resultadoTextView = findViewById<TextView>(R.id.resultado)
        val btnOperar = findViewById<Button>(R.id.btnOperar)

        btnOperar.setOnClickListener {
            val num1 = num1EditText.text.toString().toDoubleOrNull()
            val num2 = num2EditText.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val resultado = when (operacion) {
                    "sumar" -> num1 + num2
                    "restar" -> num1 - num2
                    "multiplicar" -> num1 * num2
                    "dividir" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                    else -> Double.NaN
                }

                // Formatear el resultado
                val resultadoFormateado = if (resultado % 1 == 0.0) resultado.toInt() else resultado

                // Mostrar el resultado
                resultadoTextView.text = resultadoFormateado.toString()
            } else {
                resultadoTextView.text = "Error"
            }
        }
    }
}
