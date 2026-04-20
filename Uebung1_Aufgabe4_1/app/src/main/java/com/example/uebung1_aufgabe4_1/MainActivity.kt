package com.example.uebung1_aufgabe4_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculator()
        }
    }
}

@Composable
fun Calculator() {

    val display1= remember { mutableStateOf("") }
    val display2 = remember { mutableStateOf("") }
    val firstOperand = remember { mutableDoubleStateOf(0.0) }
    val secondOperand = remember { mutableDoubleStateOf(0.0) }
    val operator = remember { mutableStateOf("") }
    val result = remember { mutableDoubleStateOf(0.0) }


    fun onEquals() {
        secondOperand.doubleValue = display2.value.toDouble()
        when (operator.value) {
            "/" -> result.doubleValue = firstOperand.doubleValue / secondOperand.doubleValue
            "*" -> result.doubleValue = firstOperand.doubleValue * secondOperand.doubleValue
            "-" -> result.doubleValue = firstOperand.doubleValue - secondOperand.doubleValue
            "+" -> result.doubleValue = firstOperand.doubleValue + secondOperand.doubleValue
        }
        firstOperand.doubleValue = result.doubleValue
        display1.value = result.doubleValue.toString()
        display2.value = ""
        operator.value = ""

    }

    fun onNumber(number: String) {
        if(display1.value.isNotEmpty() && operator.value.isEmpty()) {
            display1.value = ""
            firstOperand.doubleValue = 0.0
        }
        display2.value += number
        secondOperand.doubleValue = display2.value.toDouble()
    }

    fun onOperator(op: String) {
        if(display2.value.isEmpty()) {

           // multiple operands in a row
           if(display1.value.isNotEmpty()) {
               display1.value = " ${firstOperand.doubleValue} $op "
               operator.value = op
               return
           }
           return
        }

        if(display1.value.isEmpty()) {
            firstOperand.doubleValue = secondOperand.doubleValue
            display1.value = " ${firstOperand.doubleValue} $op "
            display2.value = ""
        } else {
            onEquals()
            display1.value = " ${firstOperand.doubleValue} $op "
        }
        operator.value = op
    }

    fun onClear() {
        display1.value = ""
        display2.value = ""
        firstOperand.doubleValue = 0.0
        operator.value = ""
    }

    fun onClearEntry() {
        display2.value = ""
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = display1.value.ifEmpty { "" },
            fontSize = 28.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Text(
            text = display2.value.ifEmpty { "0" },
            fontSize = 36.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        val buttons = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("0", "C", "CE", "+"),
        )
        buttons.forEach { row ->
            Row(modifier = Modifier.fillMaxWidth()) {
                row.forEach { buttonText ->
                    Button(onClick = {
                        when (buttonText) {
                            "+", "-", "*", "/" -> onOperator(buttonText)
                            "C" -> onClear()
                            "CE" -> onClearEntry()
                            "=" -> onEquals()
                            else -> onNumber(buttonText)
                        }

                    },
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        Text(buttonText)
                    }
                }
            }
        }

        Button(
            onClick = {onEquals()},
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Text("=")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculator()
}