package com.example.pokeproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.pokeproject.R
import kotlinx.android.synthetic.main.activity_dash.*

class DashActivity : AppCompatActivity() {

    var isFragmentLoaded = true
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        fun showPokemonFragment(){
            val transaction = manager.beginTransaction()
            val fragment = PokemonFragment()
            transaction.replace(R.id.fragmentHolder, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
            isFragmentLoaded = true
        }

        val showPokemon = findViewById<Button>(R.id.searchOne)
        showPokemonFragment()
        showPokemon.setOnClickListener{
            showPokemonFragment()

        }


    }
}