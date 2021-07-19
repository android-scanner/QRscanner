package com.example.qrcodescanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcomescreen)

        val button = findViewById<Button>(R.id.scanBtn)
        button.setOnClickListener {
            val intent = Intent(this,ScannerActivity::class.java)
            startActivity(intent)
        }
    }
}