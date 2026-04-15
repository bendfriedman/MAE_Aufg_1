package com.example.uebung1_aufgabe2_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.uebung1_aufgabe2_1.ui.theme.Uebung1_Aufgabe2_1Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Uebung1_Aufgabe2_1Theme {
                CreateUI()
            }
        }
    }
}

@Composable
fun CreateUI() {
    val colors = listOf(
        Color.White,
        Color(0xFFc1c100),
        Color(0xFF00c1c1),
        Color(0xFF00c100),
        Color(0xFFc200c1),
        Color(0xFFc10100),
        Color(0xFF0000c0),
        Color.Black
    )
    Row(
       modifier = Modifier.fillMaxSize()
    ) {
        colors.forEach { color ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(color)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateUIPreview() {
    Uebung1_Aufgabe2_1Theme {
        CreateUI()
    }
}