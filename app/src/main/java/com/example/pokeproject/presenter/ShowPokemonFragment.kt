package com.example.pokeproject.presenter

import androidx.lifecycle.lifecycleScope
import com.example.pokeproject.PokemonQuery
import com.example.pokeproject.R
import com.example.pokeproject.data.apolloClient
import com.example.pokeproject.model.OnePokemon
import com.example.pokeproject.view.DashActivity
import com.example.pokeproject.view.PokemonFragment
import kotlinx.android.synthetic.main.activity_dash.*
import kotlinx.android.synthetic.main.fragment_pokemon.*

class ShowPokemonFragment {
    fun showPokemonFragment(dashActivity: DashActivity){

        //setting my fragment manager
        val manager = dashActivity.supportFragmentManager
        val transaction = manager.beginTransaction()
        //setting fragment to replace placeholder
        val fragment = PokemonFragment()
        //the actual replacing
        transaction.replace(R.id.fragmentHolder, fragment)

        //setting query value
        var searchByIdQuery = dashActivity.inputID.text.toString()
        //casting inputID String to Integer
        var pokeIdValue = Integer.parseInt(searchByIdQuery)
        //passing through pokeIdValue into query
        dashActivity.lifecycleScope.launchWhenCreated {
            //setting ID search max as there are currently only 893 pokemon
            if (pokeIdValue >= 894){
                dashActivity.inputID.setError("There are only 893 Pokemon!")
            }
            else{
                //retrieving query data and setting it to the TextViews
                var idResponse = apolloClient.query(PokemonQuery(pokeIdValue)).execute()
                //instantiating OnePokemon to take in query data
                val pokemonResult = OnePokemon(
                    idResponse.data?.pokemon?.name.toString(),
                    idResponse.data?.pokemon?.genus.toString(),
                    idResponse.data?.pokemon?.height.toString(),
                    idResponse.data?.pokemon?.weight.toString()
                )
                //setting pokemon data to TextViews
                dashActivity.onePokeTextView.text = pokemonResult.pokeName
                dashActivity.onePokeTextViewGenus.text = pokemonResult.pokeGenus
                dashActivity.onePokeTextViewHeight.text = pokemonResult.pokeHeight
                dashActivity.onePokeTextViewWeight.text = pokemonResult.pokeWeight
            }
        }
        //adding back button functionality to not close app
        transaction.addToBackStack(null)
        //saving/applying changes
        transaction.commit()
    }
}