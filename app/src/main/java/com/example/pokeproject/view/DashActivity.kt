package com.example.pokeproject.view

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Query
import com.example.pokeproject.PokemonQuery
import com.example.pokeproject.R
import kotlinx.android.synthetic.main.activity_dash.*
import com.example.pokeproject.data.apolloClient
import kotlinx.android.synthetic.main.fragment_pokemon.*

class DashActivity : AppCompatActivity() {

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

            val transaction = manager.beginTransaction()
            //setting fragment to replace placeholder
            val fragment = PokemonFragment()
            //the actual replacing
            transaction.replace(R.id.fragmentHolder, fragment)

            //setting query value
            var searchByIdQuery = inputID.text.toString()
            //casting inputID String to Integer
            var pokeIdValue = Integer.parseInt(searchByIdQuery)
            //passing through pokeIdValue into query
            lifecycleScope.launchWhenCreated {
                var idResponse = apolloClient.query(PokemonQuery(pokeIdValue)).execute()
                onePokeTextView.text = idResponse.data?.pokemon?.name.toString()
                onePokeTextViewGenus.text = idResponse.data?.pokemon?.genus.toString()
                onePokeTextViewHeight.text = idResponse.data?.pokemon?.height.toString()
                onePokeTextViewWeight.text = idResponse.data?.pokemon?.weight.toString()
            }
            //adding back button functionality to not close app
            transaction.addToBackStack(null)
            //saving/applying changes
            transaction.commit()
        }
        //setting on click listener
        val showPokemon = findViewById<Button>(R.id.searchOne)
        showPokemon.setOnClickListener{
            showPokemonFragment()
        }
    }
}