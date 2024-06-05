package com.example.tindershoppingapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.tindershoppingapp.services.APIService
import com.example.tindershoppingapp.R

class MainActivity : AppCompatActivity() {

    private var apiService = APIService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val cardView: CardView = findViewById(R.id.cvShirt)

        loadClothing(apiService)
        cardView.setOnClickListener{
            val intent = Intent(this@MainActivity, SecondPage::class.java)
            intent.putExtra("object", apiService)
            startActivity(intent)
        }
    }

    private fun loadClothing(apiService: APIService){
        apiService.getClothingFor1(this)
    }

}