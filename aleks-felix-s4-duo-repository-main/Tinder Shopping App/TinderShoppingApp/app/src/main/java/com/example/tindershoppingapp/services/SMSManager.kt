package com.example.tindershoppingapp.services

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.SmsManager
import android.text.TextUtils
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.tindershoppingapp.activities.ThirdPage

class SMSManager(_context: Context, _apiService: APIService, _thirdPage: ThirdPage) {

    var context=_context
    private val apiService = _apiService
    private val thirdPage = _thirdPage
    private val permissionRequest = 101

    private fun myMessage() {

        val myNumber: String = apiService.user.Phone.trim()
        val myMsg: String = apiService.message.message.trim()
        if (myNumber == "" || myMsg == "") {
            Toast.makeText(context, "Field cannot be empty", Toast.LENGTH_SHORT).show()
        } else {
            if (TextUtils.isDigitsOnly(myNumber)) {
                val smsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(myNumber, null, myMsg, null, null)
                Toast.makeText(context, "Message Sent", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please enter the correct number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun sendSMS() {
        val permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS)
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            myMessage()
        } else {
            ActivityCompat.requestPermissions(
                thirdPage, arrayOf(Manifest.permission.SEND_SMS),
                permissionRequest
            )
        }
    }
}