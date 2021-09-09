package com.example.qrcodescanner.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcodescanner.R
import com.example.qrcodescanner.databinding.ActivityCinBinding

const val intentCin = "cin"

class CinActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cinTxt = binding.txtBoxCIN
        val submitBtn = binding.btnSubmitCIN
        cinTxt.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                submitBtn.isEnabled = s.toString().trim { it <= ' ' }.isNotEmpty()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })
        submitBtn.setOnClickListener {
            val intent = Intent(this, VaccineInfoActivity::class.java)
            intent.putExtra(intentRequest, cinTxt.text.toString())
            intent.putExtra(intentType, intentCin)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_acceuil -> {
                goToWelcomeActivityActivity()
                finish()
            }
            R.id.nav_quitter -> {
                goToExitActivity()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToWelcomeActivityActivity() {
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
    }

    private fun goToExitActivity() {
        finishAffinity()
    }


}