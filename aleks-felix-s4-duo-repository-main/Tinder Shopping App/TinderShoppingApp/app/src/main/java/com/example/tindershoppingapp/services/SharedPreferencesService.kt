package com.example.tindershoppingapp.services

import android.content.SharedPreferences

class SharedPreferencesService (private val sharedPreferences: SharedPreferences){
    private val keyPare = "status"
    private val defaultValue = 0

    fun savePreferences(input: String){
        val edit = sharedPreferences.edit()
        edit.putString(keyPare, input)
        edit.apply()
    }

    fun loadPreferences():Boolean{
        val status =  sharedPreferences.getString(keyPare, defaultValue.toString())
        return !status.equals("0")

    }
}