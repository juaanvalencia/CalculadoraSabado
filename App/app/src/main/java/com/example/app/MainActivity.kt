package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculando los botones a sus IDs
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)

        // Configurando los listeners de los botones
        btnSumar.setOnClickListener {
            // Inicia la actividad de suma
            startOperacionActivity("sumar")
        }

        btnRestar.setOnClickListener {
            // Inicia la actividad de resta
            startOperacionActivity("restar")
        }

        btnMultiplicar.setOnClickListener {
            // Inicia la actividad de multiplicación
            startOperacionActivity("multiplicar")
        }

        btnDividir.setOnClickListener {
            // Inicia la actividad de división
            startOperacionActivity("dividir")
        }
    }

    private fun startOperacionActivity(operacion: String) {
        val intent = Intent(this, OperacionActivity::class.java)
        intent.putExtra("operacion", operacion)
        startActivity(intent)
    }
}
