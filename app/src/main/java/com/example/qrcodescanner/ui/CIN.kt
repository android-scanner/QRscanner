package com.example.qrcodescanner.ui

import android.R.attr.button
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.qrcodescanner.R


class CIN : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c_i_n)

        val cinTxt = findViewById<EditText>(R.id.CINTxtBox)
        val submitBtn = findViewById<Button>(R.id.SubmitBtn)
        cinTxt.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.length == 0) {
                    submitBtn.setEnabled(false)
                } else {
                    submitBtn.setEnabled(true)
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })
        submitBtn.setOnClickListener {
            val intent = Intent(this, VaccineInfoActivity::class.java)
            intent.putExtra("CIN", cinTxt.text);
            intent.putExtra("request", "cin")
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
        val intent = Intent(this, WelcomeScreen::class.java)
        startActivity(intent)
    }

    private fun goToExitActivity() {
        finishAffinity()
    }

}