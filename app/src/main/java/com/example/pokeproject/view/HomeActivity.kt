package com.example.pokeproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokeproject.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //instantiate fragments
        val onePokemonFragment = OnePokemonFragment()

        //set listener for searchOne button
        searchOne.setOnClickListener{
            //replace() switches fragment displayed based on arg passed through
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.pokemonFragment, onePokemonFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}