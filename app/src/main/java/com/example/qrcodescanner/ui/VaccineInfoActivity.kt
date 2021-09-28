package com.example.qrcodescanner.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcodescanner.api.APIEndPoint
import com.example.qrcodescanner.R
import com.example.qrcodescanner.databinding.ActivityVaccineInfoBinding
import com.example.qrcodescanner.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class VaccineInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVaccineInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaccineInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val request = intent.getStringExtra(intentRequest)
        val type = intent.getStringExtra(intentType)


        getUserData(request.toString(), type.toString())

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


    private fun getUserData(request: String, type: String) {
        val baseURL = "https://vaccinapi.herokuapp.com/"
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(APIEndPoint::class.java)
        val call: Call<User> = if (type == "cin") {
            api.getUserByCIN(request)
        } else {
            api.getUserByQrcode(request)
        }

        call.enqueue(object : retrofit2.Callback<User?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                val userInfo = response.body()
                binding.txtViewFName.text = userInfo?.nom + " " + userInfo?.prenom
                binding.txtViewID.text = userInfo?.cin?.replace("\\s".toRegex(), "")
                binding.txtViewAge.text = userInfo?.age.toString()
                binding.txtViewHospital.text = userInfo?.hospitalName
                binding.txtViewVaccType.text = userInfo?.typeVacc
                binding.txtViewVaccNbr.text = userInfo?.nbrVacc.toString()
                binding.infoProgressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                cnxFailed()
            }
        })
    }

    fun cnxFailed() {
        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show()
        finish()
    }

}
