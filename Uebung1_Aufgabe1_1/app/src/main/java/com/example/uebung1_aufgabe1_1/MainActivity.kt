package com.example.uebung1_aufgabe1_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uebung1_aufgabe1_1.ui.theme.Uebung1_Aufgabe1_1Theme

private const val GREETING_MSG = "Lorem ipsum dolor sit amet"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Uebung1_Aufgabe1_1Theme {
                    Greeting(msg = GREETING_MSG)
            }
        }
    }
}

@Composable
fun Greeting(msg: String) {
    Column(modifier = Modifier.padding(top = 18.dp, start = 8.dp)) {
        Text(
            msg
        )
        Text(
            msg,
            color = Color.Red
        )
        Text(
            msg,
            color = Color.Blue
        )
        Text(
            msg,
            fontStyle = FontStyle.Italic
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 24.sp)) {
                    append(msg.take(2))
                }
                withStyle(style = SpanStyle(fontSize = 8.sp)) {
                    append(msg.drop(2).dropLast(2))
                }
                withStyle(style = SpanStyle(fontSize = 24.sp)) {
                    append(msg.takeLast(2))
                }
            }
        )
        Text(
            msg,
            fontFamily = FontFamily.Monospace
        )
        AnnotatedHtmlStringWithLink()
    }
}

@Composable
fun AnnotatedHtmlStringWithLink(
    htmlText: String = """
           <a href="https://decksray.com"> $GREETING_MSG </a>""".trimIndent()
) {
    Text(
        AnnotatedString.fromHtml(
            htmlText,
            linkStyles = TextLinkStyles(
                style = SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    fontStyle = FontStyle.Italic,
                    color = Color.Blue
                )
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Uebung1_Aufgabe1_1Theme {
        Greeting(GREETING_MSG)
    }
}