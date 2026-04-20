package com.example.uebung1_aufgabe4_2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var firstOperand = 0.0
    private var secondOperand = 0.0
    private var operator = ""
    private var result = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val display1 = findViewById<TextView>(R.id.display1)
        val display2 = findViewById<TextView>(R.id.display2)

        fun onEquals() {
            secondOperand = display2.text.toString().toDoubleOrNull() ?: return
            when (operator) {
                "/" -> result = firstOperand / secondOperand
                "*" -> result = firstOperand * secondOperand
                "-" -> result = firstOperand - secondOperand
                "+" -> result = firstOperand + secondOperand
            }
            firstOperand = result
            display1.text = result.toString()
            display2.text = ""
            operator = ""
        }

        fun onNumber(number: String) {
            if (display1.text.isNotEmpty() && operator.isEmpty()) {
                display1.text = ""
                firstOperand = 0.0
            }
            display2.text = "${display2.text}$number"
            secondOperand = display2.text.toString().toDoubleOrNull() ?: 0.0
        }

        fun onOperator(op: String) {
            if (display2.text.isEmpty()) {
                if (display1.text.isNotEmpty()) {
                    display1.text = " ${firstOperand} $op "
                    operator = op
                }
                return
            }
            if (display1.text.isEmpty()) {
                firstOperand = secondOperand
                display1.text = " ${firstOperand} $op "
                display2.text = ""
            } else {
                onEquals()
                display1.text = " ${firstOperand} $op "
            }
            operator = op
        }

        fun onClear() {
            display1.text = ""
            display2.text = ""
            firstOperand = 0.0
            operator = ""
        }

        fun onClearEntry() {
            display2.text = ""
        }

        // Buttons verdrahten
        mapOf(
            R.id.btn0 to "0", R.id.btn1 to "1", R.id.btn2 to "2",
            R.id.btn3 to "3", R.id.btn4 to "4", R.id.btn5 to "5",
            R.id.btn6 to "6", R.id.btn7 to "7", R.id.btn8 to "8",
            R.id.btn9 to "9"
        ).forEach { (id, n) ->
            findViewById<Button>(id).setOnClickListener { onNumber(n) }
        }

        mapOf(
            R.id.btnAdd to "+", R.id.btnSub to "-",
            R.id.btnMul to "*", R.id.btnDiv to "/"
        ).forEach { (id, op) ->
            findViewById<Button>(id).setOnClickListener { onOperator(op) }
        }

        findViewById<Button>(R.id.btnEquals).setOnClickListener { onEquals() }
        findViewById<Button>(R.id.btnC).setOnClickListener { onClear() }
        findViewById<Button>(R.id.btnCE).setOnClickListener { onClearEntry() }
    }
}