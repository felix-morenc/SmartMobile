package com.example.tindershoppingapp.activities
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.example.tindershoppingapp.R
import com.example.tindershoppingapp.services.APIService
import com.example.tindershoppingapp.services.SMSManager
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ThirdPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_page)

        // Get Items
        supportActionBar?.hide()
        val input: NumberPicker = findViewById(R.id.inputQuantity)
        val apiService = intent.getSerializableExtra("object") as APIService
        val cvProcess: CardView = findViewById(R.id.cvProgress)
        val textView9: TextView = findViewById(R.id.textView9)
        val imageView: ImageView = findViewById(R.id.imageView)
        val textView: TextView = findViewById(R.id.textView8)
        val newBtn:Button = findViewById(R.id.newBtn)
        val btnBuy: Button = findViewById(R.id.btnBuy)
        val smsManager = SMSManager(this,apiService,this@ThirdPage)
        val oldCvProcess: CardView= cvProcess
        // Give Values
        input.maxValue=15
        input.minValue=1
        input.value=1
        Picasso.get().load(apiService.clothing.imageLink).into(imageView)
        textView9.text = apiService.clothing.price.toString()

        // Call methods
        getTotalPrice(apiService, input.value )

        newBtn.setOnClickListener {
            getNewClothing(apiService)
        }
        btnBuy.setOnClickListener {
            prgoressBarUpdate(textView,cvProcess)
            openPopUp(apiService,smsManager,input, textView,cvProcess)
        }
    }

    private fun getNewClothing(apiService: APIService){
        loadClothing(apiService)
        GlobalScope.launch {
            Thread.sleep(100)
            if(apiService.clothing.price.equals(12.52)){
                val intent = Intent(this@ThirdPage, SecondPage::class.java)
                intent.putExtra("object", apiService)
                startActivity(intent)
            }
            else{
                val intent = Intent(this@ThirdPage, SecondClothing::class.java)
                intent.putExtra("object", apiService)
                startActivity(intent)
            }
        }
    }

    private fun loadClothing(apiService: APIService){
        if(apiService.clothing.price.equals(12.52)){
            apiService.getClothingFor2(this)
        }
        else{
            apiService.getClothingFor1(this)
        }
    }

    private fun getTotalPrice(apiService: APIService, quantity: Int){
        apiService.calculatePrice(this, quantity)
    }

    private fun receiveMessage(apiService: APIService){
        apiService.receiveMessage(apiService.totalPrice.totalPrice,this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    this,
                    "You have required permission to send a message",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "You don't have required permission to send a message",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun prgoressBarUpdate(textView: TextView, cardView: CardView){
        textView.text="Step 4/4"
        val parrent = cardView.parent as CardView
        val layoutParams: ViewGroup.LayoutParams = cardView.getLayoutParams()
        layoutParams.width = parrent.width
        cardView.setLayoutParams(layoutParams)
    }

    private fun progressBarDowngrade(textView: TextView, cardView: CardView){
        textView.text="Step 3/4"
        val layoutParams: ViewGroup.LayoutParams = cardView.getLayoutParams()
        layoutParams.width = cardView.width-120
        cardView.setLayoutParams(layoutParams)
    }

    private fun openPopUp(apiService: APIService,smsManager: SMSManager, input: NumberPicker,textView: TextView, cardView: CardView){
        val builder = AlertDialog.Builder(this)
        val totalPrice = apiService.clothing.price*input.value
        apiService.totalPrice.totalPrice=totalPrice
        receiveMessage(apiService)
        builder.setTitle("You will pay: $totalPrice$")
        builder.setPositiveButton("Confirm") { _, _ ->
            val intent = Intent(this@ThirdPage, MainActivity::class.java)
            startActivity(intent)
            smsManager.sendSMS()
        }
        builder.setNegativeButton("Decline") { dialog, _ ->
            dialog.dismiss()
        }
        builder.setOnDismissListener {
            progressBarDowngrade(textView, cardView)
        }
        val dialog: AlertDialog= builder.create()
        dialog.show()
    }
}