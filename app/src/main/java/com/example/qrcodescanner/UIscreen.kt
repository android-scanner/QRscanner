package com.example.qrcodescanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class UIscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_iscreen)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_acceuil -> {goToWelcomeActivityActivity()}
            R.id.nav_quitter -> {goToExitActivity()}

        }
        return super.onOptionsItemSelected(item)
    }

    fun goToWelcomeActivityActivity() {
        val intent = Intent(this, welcomescreen::class.java)
        startActivity(intent)
    }

    fun goToExitActivity() {
        finishAffinity()
    }

}
