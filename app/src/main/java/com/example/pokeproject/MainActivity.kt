package com.example.pokeproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set preferences, //builtInFunction("preferanceName", "PreferanceSharingSetting")
        val userPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        //set edit function
        val editPref = userPreferences.edit()

        signIn.setOnClickListener{
            //Setting data input in EditTexts
            val userName = userName.text.toString()
            val favoritePoke = favoritePokeInput.text.toString()

            //using assigned editor to apply shared preference data with Key,Value pairs
            editPref.apply {
                //defining Key, Value pairs
                putString("userName", userName)
                putString("favoritePoke", favoritePoke)
                //saving/setting data input
                apply()

            }

        }
    }

}