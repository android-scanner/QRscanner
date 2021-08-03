package com.example.qrcodescanner.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcodescanner.R
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

class VaccineInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vaccine_info)

        val request = intent.getStringExtra("request")
        val type = intent.getStringExtra("type")

        findViewById<TextView>(R.id.document_id_value).text = request

        getUserData(type.toString(), request.toString())

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


    private fun getUserData(type: String, request: String) {
        val BASE_URL = "http://localhost:8080/"
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api= retrofit.create(APIEndPoint::class.java)
        val call: Call<ArrayList<User>>
        if(type == "cin") {
            call = api.getUserByCIN(request)
        } else {
            call = api.getUserByQrcode(request)
        }

        call.enqueue(object : Callback<ArrayList<User>?> {
            override fun onResponse(
                call: Call<ArrayList<User>?>,
                response: Response<ArrayList<User>?>
            ) {
                Log.d("result", "yes")
            }

            override fun onFailure(call: Call<ArrayList<User>?>, t: Throwable) {
                Log.d("result", "No")
            }
        })
    }

}
