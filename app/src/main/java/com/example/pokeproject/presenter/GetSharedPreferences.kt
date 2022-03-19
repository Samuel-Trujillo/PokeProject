package com.example.pokeproject.presenter

import com.example.pokeproject.view.DashActivity
import kotlinx.android.synthetic.main.activity_dash.*

class GetSharedPreferences {
    fun getSharedPreferences(dashActivitySp : DashActivity){

        //getting/assigning data transferred through dashIntent
        val uuNameDisplay = dashActivitySp.intent.getStringExtra("uuName")
        val uuPokeDisplay = dashActivitySp.intent.getStringExtra("uuPoke")

        //setting TextView Text to the data pulled saved to the variables above
        val tvNameDisplay = dashActivitySp.displayUserName.apply {
            text = uuNameDisplay
        }
        val tvPokeDisplay = dashActivitySp.displayFavoritePokemon.apply {
            text = uuPokeDisplay
        }
    }
}