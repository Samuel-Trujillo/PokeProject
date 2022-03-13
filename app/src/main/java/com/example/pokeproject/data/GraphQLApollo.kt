package com.example.pokeproject.data

import com.apollographql.apollo3.ApolloClient

object GraphQLApollo {
    private fun apolloClient() : ApolloClient = ApolloClient.Builder().serverUrl(BASE_URL).build()
}
