package com.example.qrcodescanner.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcodescanner.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        val button = findViewById<Button>(R.id.btnScan)
        button.setOnClickListener {
            val intent = Intent(this, ScannerActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnCIN).setOnClickListener {
            val intent = Intent(this, CinActivity::class.java)
            startActivity(intent)
        }
    }
}