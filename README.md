# PokeProject

README.rtf file in the root folder of the project contains the full documentation, including screenshots and correct formatting for this project

For this Android application "PokeProject", I used the MVP (Model, View, presenter) architecture pattern

The purpose of the App is to allow users to search for an individual Pokemon via their Pokemon ID and display the following information-
-Pokemon Name, Pokemon Genus/type, Pokemon Height, Pokemon Weight

Required Activity 1/2 - MainActivity.kt
The Main Activity allows users to enter a username of their choosing and their favorite Pokemon. 
Required -Shared Preference – StartDashActivity.kt  Presenter Folder
The data entered in the Username and Favorite Pokemon TextEdit fields are saved using shared preferences. Then, an Intent is used to activate the second activity as well as pass through the shared preference data when the “Login” button is clicked

![image](https://user-images.githubusercontent.com/82184348/159145617-c1169ba2-3454-405f-8f4b-4c0e146082fe.png)
![image](https://user-images.githubusercontent.com/82184348/159145628-6e8136a1-aded-4370-850c-9db65d2f8bc3.png)


Required Activity 2/2 -DashActivity.kt  View Folder
This is where they enter a Pokemon ID of their choice. It will populate the data of the Pokemon associated in a fragment located on the bottom portion of the activity when the “Search” button is clicked 

Required -Shared Preference – GetSharedPreferences.kt  Presenter Folder
The shared preference data is retrieved and set to the TextView components on the top left of the screen

Required -GraphQL API – PokemonQuery.graphql / schema.graphqls  graphql directory
From the provided API’s, DexAPI was used for this project.  https://dex-server.herokuapp.com/

Required -Fragment- PokemonFragment.kt  View Folder
DashActivity contains the a blank place holder fragment until it is replaced by fragment PokemonFragment in which the data of the API query is displayed. ShowPokemonfragment.kt – Presenter Folder executes the query using GraphQl and the data is saved to the Model OnePokemon.kt – Model Folder and then set to the appropriate TextView components inside the PokemonFragment

![image](https://user-images.githubusercontent.com/82184348/159145645-678cf0d3-c902-4aed-8958-6a47476d44e8.png)
![image](https://user-images.githubusercontent.com/82184348/159145657-b7a0b918-92ed-4ce5-abdb-07f94449a75b.png)


As previously stated, MVP was used in the designing of this app’s architecture. After learning how to implement every functional requirement for the app, which was initially coded into each activity. I restructured everything into a MVP architecture, effectively separating functionality from their perspective views/Activities. This results in not only cleaner and well-structured code, but also a workable/scalable design as any update or implementation needed to be added can be done so in a concise manner. This is because the structure of the project leaves little room for confusion as to what goes where and what file oversees what. 
The current workflow is as follows,

MainActivity.kt is activated, User enters data and the Login button is pushed  StartDashActivity.kt is called to save user data and activate DashActivity.kt  DashActivity.kt is activated and GetSharedPreferences.kt is called to get/set and display user data. DashActivity.kt is also currently displaying a place holder fragment which is blank  User enters an ID/clicks the “Search” button and ShowPokemonFragment.kt is called. PokemonFragment.kt replaces the place holder fragment. Then the graphQL query is executed and the data from the query is saved to a OnePokemon.kt model. The data from the model is then set to the TextViews in the PokemonFragment.kt layout and displayed. 
