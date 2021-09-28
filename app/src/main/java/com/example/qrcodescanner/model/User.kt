package com.example.qrcodescanner.model
import com.google.gson.annotations.SerializedName

data class User(
    var id: Int,
    var nom: String,
    var prenom: String,
    var age: Int,
    @SerializedName("nbrvacc")  var nbrVacc: Int,
    @SerializedName("typevacc")  var typeVacc: String,
    @SerializedName("nometab")  var hospitalName: String,
    @SerializedName("qrcode")  var qrCode: String,
    var cin: String
)