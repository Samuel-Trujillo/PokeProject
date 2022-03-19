package com.example.pokeproject.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pokeproject.R
import kotlinx.android.synthetic.main.activity_dash.*

import com.example.pokeproject.presenter.ShowPokemonFragment

class DashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        //getting/assigning data transferred through dashIntent
        val uuNameDisplay = intent.getStringExtra("uuName")
        val uuPokeDisplay = intent.getStringExtra("uuPoke")

        //setting TextView Text to the data pulled saved to the variables above
        val tvNameDisplay = displayUserName.apply {
            text = uuNameDisplay
        }
        val tvPokeDisplay = displayFavoritePokemon.apply {
            text = uuPokeDisplay
        }

        //instantiating ShowPokemonFragment
        val initPokemonFragment = ShowPokemonFragment()

        //setting on click listener
        val showPokemon = findViewById<Button>(R.id.searchOne)
        showPokemon.setOnClickListener{
            initPokemonFragment.showPokemonFragment(this)
        }
    }
}