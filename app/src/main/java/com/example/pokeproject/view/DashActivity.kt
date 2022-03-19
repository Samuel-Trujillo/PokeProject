package com.example.pokeproject.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pokeproject.R
import com.example.pokeproject.presenter.GetSharedPreferences
import kotlinx.android.synthetic.main.activity_dash.*

import com.example.pokeproject.presenter.ShowPokemonFragment

class DashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        //instantiating GetSharedPreferences to "get/set Shared preferences"
        val initGetSharedPreferences = GetSharedPreferences()
        //getting/setting shared preferences
        initGetSharedPreferences.getSharedPreferences(this)

        //instantiating ShowPokemonFragment
        val initPokemonFragment = ShowPokemonFragment()

        //setting on click listener
        val showPokemon = findViewById<Button>(R.id.searchOne)
        showPokemon.setOnClickListener{
            initPokemonFragment.showPokemonFragment(this)

        }
    }
}