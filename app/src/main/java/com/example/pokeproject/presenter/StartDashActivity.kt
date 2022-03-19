package com.example.pokeproject.presenter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.pokeproject.MainActivity
import com.example.pokeproject.view.DashActivity
import kotlinx.android.synthetic.main.activity_main.*

class StartDashActivity {
    fun startDashActivity(mainActivity: MainActivity){

        //taking text from EditText fields saving them to strings
        val userNameText: String = mainActivity.userName.text.toString()
        val favPokeText: String = mainActivity.favoritePokeInput.text.toString()
        //declaring val type of SharedPreference to manipulate data
        val preferences: SharedPreferences =
            mainActivity.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        //using editor to apply/save the Strings input
        editor.apply {
            putString("uuName", userNameText)
            putString("uuPoke", favPokeText)
        }.apply()
        //using an Intent to trigger onCreate method for HomeActivity
        val dashIntent = Intent(mainActivity, DashActivity::class.java).also {
            it.putExtra("uuName", userNameText).putExtra("uuPoke", favPokeText)
            mainActivity.startActivity(it)
        }
    }
}
