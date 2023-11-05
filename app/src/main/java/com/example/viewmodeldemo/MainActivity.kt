package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.tvCount)
        val button = findViewById<Button>(R.id.btnCount)

        textView.text = count.toString()

        button.setOnClickListener{
            ++count
            textView.text = count.toString()
        }
    }
}