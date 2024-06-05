package com.example.tindershoppingapp.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tindershoppingapp.services.APIService
import com.example.tindershoppingapp.R
import com.example.tindershoppingapp.modules.Clothing
import com.example.tindershoppingapp.services.OnSwipeTouchListener
import com.example.tindershoppingapp.services.SharedPreferencesService
import com.squareup.picasso.Picasso

class SecondClothing : AppCompatActivity() {

    private lateinit var layout: ConstraintLayout

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        supportActionBar?.hide()
        val apiService = intent.getSerializableExtra("object") as APIService
        val imageView2:ImageView = findViewById(R.id.imgDisplay)
        val textView2:TextView = findViewById(R.id.tvPrice)
        layout = findViewById(R.id.layout)
        val imageView: ImageView = findViewById(R.id.hintImage)
        val sharedPreferences: SharedPreferences = getSharedPreferences("Test", Context.MODE_PRIVATE)
        val clothing = apiService.clothing
        val sharedPreferencesService = SharedPreferencesService(sharedPreferences)
        loadObject(apiService,textView2,imageView2)
        loadClothing(apiService)
        checkPreferences(sharedPreferencesService,imageView)
        layout.setOnTouchListener(object : OnSwipeTouchListener(this@SecondClothing){
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                sharedPreferencesService.savePreferences("1")
                swipeRight(apiService,clothing)
            }
            override fun onSwipeRight() {
                super.onSwipeRight()
                sharedPreferencesService.savePreferences("1")
                swipeLeft(apiService)
            }
        })
    }

    private fun checkPreferences(sharedPreferencesService: SharedPreferencesService,imageView: ImageView){
        val isUsedBefore = sharedPreferencesService.loadPreferences()
        if(isUsedBefore){
            imageView.visibility= View.INVISIBLE
        }
        else{
            imageView.visibility= View.VISIBLE
        }
    }

    private fun loadObject(apiService: APIService, textView: TextView, imageView: ImageView){
        textView.text = apiService.clothing.price.toString()
        Picasso.get().load(apiService.clothing.imageLink).into(imageView)
    }

    private fun loadClothing(apiService: APIService){
        apiService.getClothingFor1(this)
    }

    private fun swipeRight(apiService: APIService,clothing:Clothing){
        apiService.clothing=clothing
        val intent = Intent(this@SecondClothing, ThirdPage::class.java)
        intent.putExtra("object", apiService)
        startActivity(intent)
    }

    private fun swipeLeft(apiService: APIService){
        val intent = Intent(this@SecondClothing, SecondPage::class.java)
        intent.putExtra("object", apiService)
        startActivity(intent)
    }
}