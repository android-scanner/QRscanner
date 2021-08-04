package com.example.qrcodescanner.ui


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("usersByQrcode/{qrCode}")
    fun getdata(@Path("qrCode") qrcode: String): Call<data>

}

