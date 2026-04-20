package com.example.uebung1_aufgabe3_2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val buttonFtoC = findViewById<Button>(R.id.buttonFtoC)
        val buttonCtoF = findViewById<Button>(R.id.buttonCtoF)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonFtoC.setOnClickListener {
            val fahrenheit = editTextInput.text.toString().toDoubleOrNull()
            if (fahrenheit != null) {
                val res = (fahrenheit - 32.0) * 5.0 / 9.0
                textViewResult.text = "$res °C"
            } else {
                textViewResult.text = "Missing input!"
            }
        }

        buttonCtoF.setOnClickListener {
            val celsius = editTextInput.text.toString().toDoubleOrNull()
            if (celsius != null) {
                val res = celsius * 9.0 / 5.0 + 32.0
                textViewResult.text = "$res °F"
            } else {
                textViewResult.text = "Missing input!"
            }
        }
    }
}