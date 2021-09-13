package com.example.qrcodescanner.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcodescanner.databinding.ActivityWelcomeScreenBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnScan.setOnClickListener {
            val intent = Intent(this, ScannerActivity::class.java)
            startActivity(intent)
        }
        binding.btnCIN.setOnClickListener {
            val intent = Intent(this, CinActivity::class.java)
            startActivity(intent)
        }
    }
}