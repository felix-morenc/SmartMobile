package com.example.tindershoppingapp.modules

import java.io.Serializable

data class Clothing(
    var description: String,
    var imageLink: String,
    var price: Double,
    var type: String
) : Serializable