package com.example.pokeproject.model

import android.content.Context
import android.content.SharedPreferences

class UserSharedPreference(context: Context){

    private val preferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE)

    fun updateUserInfo(userDisplay: UserInfo){
        //editing key value pairs
        preferences.edit().putString("kUserName", userDisplay.uuName).commit()
        preferences.edit().putString("kFavoritePokemon", userDisplay.uuPoke).commit()

        //retrieving key value pairs
        preferences.getString("kUsername", "username")
        preferences.getString("kFavoritePokemon", "favPokemon")

    }
}
