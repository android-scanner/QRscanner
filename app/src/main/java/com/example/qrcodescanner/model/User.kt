package com.example.qrcodescanner.model

data class User(
    var id: Int,
    var nom: String,
    var prenom: String,
    var age: Int,
    var nbrvacc: Int,
    var typevacc: String,
    var nometab: String,
    var qrcode: String,
    var cin: String
)