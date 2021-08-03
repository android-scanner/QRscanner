package com.example.qrcodescanner.ui

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIEndPoint {
    @GET("usersByQrcode/{qrCode}")
    fun getUserByQrcode(@Path("qrCode") qrcode: String): Call<ArrayList<User>>

    @GET("usersByCIN/{CIN}")
    fun getUserByCIN(@Path("CIN") cin: String): Call<ArrayList<User>>

    /**@GET("users")
    fun getUsers() :Call<ArrayList<User>>**/
}