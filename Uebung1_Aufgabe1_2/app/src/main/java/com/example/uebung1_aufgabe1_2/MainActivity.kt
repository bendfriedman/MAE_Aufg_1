package com.example.uebung1_aufgabe1_2

import android.os.Bundle
import android.text.Html.fromHtml
import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.RelativeSizeSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textDiffSize)
        val text = "Lorem ipsum dolor sit amet"
        val spannable = SpannableString(text)
        // text kleiner
        spannable.setSpan(
            RelativeSizeSpan(0.8f),  // 80%
            0,
            5,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        // text größer
        spannable.setSpan(
            RelativeSizeSpan(1.5f),  // 150%
            6,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannable

        val textLink = findViewById<TextView>(R.id.textLink)
        textLink.text = fromHtml(getString(R.string.link_text))
        textLink.movementMethod = LinkMovementMethod.getInstance()

    }


}