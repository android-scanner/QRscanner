package com.example.qrcodescanner.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcodescanner.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VaccineInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine_info)
        fitshData()

        var nom = "IKHARAZE"
        var prenom = "Imad"

        findViewById<TextView>(R.id.labelName).setText(nom+" "+prenom)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_acceuil -> {
                goToWelcomeActivityActivity()
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
fun fitshData(){
    val url ="https://vaccinapi.herokuapp.com/"
    val retrofit= Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api: API = retrofit.create(API::class.java)
    val call = api.getdata()
    val item = call.enqueue(object : Callback<ArrayList<data>>{
        override fun onFailure(call: Call<ArrayList<data>>, t: Throwable) {
            connectionF()
        }

        override fun onResponse(call: Call<ArrayList<data>>, response: Response<ArrayList<data>>) {
            connectionG(response)
        }

    })



  }
    fun connectionF() {
        Toast.makeText(this, "Connection Failed", Toast.LENGTH_LONG).show()
    }
    fun connectionG(response: Response<ArrayList<data>>) {
        Toast.makeText(this, "Connection Succeed", Toast.LENGTH_LONG).show()
    }
}



