package com.example.tindershoppingapp.modules

import java.io.Serializable

data class User(
    val Address: String,
    val IBAN: String,
    val Phone: String
) : Serializable