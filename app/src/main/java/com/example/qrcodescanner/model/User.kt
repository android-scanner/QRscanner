package com.example.qrcodescanner.model

data class User(
    var id: Int,
    var nom: String,
    var prenom: String,
    var age: Int,
    var nbrVacc: Int,
    var typeVacc: String,
    var hospitalName: String,
    var qrCode: String,
    var cin: String
)