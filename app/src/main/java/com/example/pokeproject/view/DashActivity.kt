package com.example.pokeproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.pokeproject.R
import kotlinx.android.synthetic.main.activity_dash.*

class DashActivity : AppCompatActivity() {

    //setting fragment loaded as default to true in case I make another frag
    var isFragmentLoaded = true
    //creating my fragment manager
    val manager = supportFragmentManager

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

        //replacing my fragment holder with actual data
        fun showPokemonFragment(){
            //will need to Modularize this to follow MVP
            val transaction = manager.beginTransaction()
            //setting fragment to replace placeholder
            val fragment = PokemonFragment()
            //the actual replacing
            transaction.replace(R.id.fragmentHolder, fragment)
            //adding back button functionality to not close app
            transaction.addToBackStack(null)
            //saving/applying changes
            transaction.commit()
            //used only if i need to make another frag
            isFragmentLoaded = true
        }

        //setting on click listener
        val showPokemon = findViewById<Button>(R.id.searchOne)
        showPokemon.setOnClickListener{
            showPokemonFragment()

        }


    }
}