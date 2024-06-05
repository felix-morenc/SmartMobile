package com.example.tindershoppingapp.services

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.tindershoppingapp.modules.Clothing
import com.example.tindershoppingapp.modules.TotalPrice
import com.example.tindershoppingapp.modules.User
import org.json.JSONObject
import java.io.Serializable

class APIService : Serializable {

    private var description = ""
    var clothing = Clothing("","",0.0,"")
    var totalPrice: TotalPrice = TotalPrice(0.0)
    var message: com.example.tindershoppingapp.modules.Message = com.example.tindershoppingapp.modules.Message("Hello")
    var user = User("ASD","ASD","0889209984")

    fun getClothingFor1(context: Context){
        val url ="https://tinder-shopping-app-v1.herokuapp.com/randomCloting/1"
        getClothing(url, context)
    }

    fun getClothingFor2(context: Context){
        val url ="https://tinder-shopping-app-v1.herokuapp.com/randomCloting/2"
        getClothing(url, context)
    }

    private fun getClothing(url: String, context: Context){
        val queue = Volley.newRequestQueue(context)
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url,null,
            { response ->
                description = response.getString("description")
                val imageLink = response.getString("imageLink")
                val type = response.getString("type")
                val price = response.getDouble("price")
                clothing = Clothing(description,imageLink,price,type)
            },
            {
            }
        )
            queue.add(jsonObjectRequest)
    }

    fun calculatePrice(context: Context, quantity: Int){
        val queue = Volley.newRequestQueue(context)
        val jsonBody = mapOf("type" to clothing.type,"price" to clothing.price,"description" to clothing.description,"imageLink" to clothing.imageLink)
        val url = "https://tinder-shopping-app-v1.herokuapp.com/price/$quantity"
        val jsonStringRequest = JsonObjectRequest(
            Request.Method.POST, url, JSONObject(jsonBody),
            { response ->
                val tp = response.getDouble("totalPrice")
                totalPrice.totalPrice = tp
            },
            {
            }
        )
        queue.add(jsonStringRequest)
    }

    fun receiveMessage(totalPrice: Double, context: Context){
        val queue = Volley.newRequestQueue(context)
        val url = "https://tinder-shopping-app-v1.herokuapp.com/message"

        val clothingMap = mapOf("type" to clothing.type,"price" to clothing.price,"description" to clothing.description,"imageLink" to clothing.imageLink)
        val userMap = mapOf("Address" to user.Address,"IBAN" to user.IBAN,"Phone" to user.Phone)
        val jsonBody = mapOf("clothing" to clothingMap,"quantity" to 2,"totalPrice" to totalPrice,"user" to userMap)
        val jsonStringRequest = JsonObjectRequest(
            Request.Method.POST, url, JSONObject(jsonBody),
            { response ->
                message.message = response.getString("message")
            },
            {
            }
        )
        queue.add(jsonStringRequest)
    }

}