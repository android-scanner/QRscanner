package com.example.qrcodescanner.ui


import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("USERS/")
    fun getdata(): Call<ArrayList<data>>
}

