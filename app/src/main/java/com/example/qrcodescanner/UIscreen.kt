package com.example.qrcodescanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
            R.id.nav_acceuil -> Toast.makeText(this,getString(R.string.home), Toast.LENGTH_SHORT).show()
            R.id.nav_quitter -> Toast.makeText(this,getString(R.string.exit), Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }
}