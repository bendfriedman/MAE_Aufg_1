package com.example.uebung1_aufgabe3_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TempConverter()
        }
    }
}

@Composable
fun TempConverter() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val input = remember { mutableStateOf("") }
        val result = remember { mutableStateOf("") }

        TextField (
            value = input.value,
            onValueChange = {
                input.value = it
            },
            label = {Text("Value")},
            placeholder = {Text("Enter Value")}
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val fahrenheit = input.value.toDoubleOrNull()
            if (fahrenheit != null) {
                val res: Double = (fahrenheit - 32.0) * 5.0 / 9.0
                result.value = "%.2f °C".format(res)
            } else {
                result.value = "Missing input!"
            }
        }) {
            Text("Fahrenheit to Celsius")
        }
        Button(onClick = {
            val celsius = input.value.toDoubleOrNull()
            if (celsius != null) {
                val res: Double = (celsius * 9.0) / 5.0 + 32
                result.value = "%.2f °F".format(res)
            } else {
                result.value = "Missing input!"
            }
        }) {
            Text("Celsius to Fahrenheit ")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Result: " + result.value)
    }
}

@Preview(showBackground = true)
@Composable
fun CreateUIPreview() {
    TempConverter()
}