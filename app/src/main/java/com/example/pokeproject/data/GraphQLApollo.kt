package com.example.pokeproject.data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Input
import com.example.pokeproject.PokemonQuery


object GraphQLApollo {
    private fun apolloClient() : ApolloClient = ApolloClient.Builder().serverUrl(BASE_URL).build()

    fun pokemonQuery(id: Int) = apolloClient().query(PokemonQuery(id))

}
