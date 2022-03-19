package com.example.pokeproject.presenter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.pokeproject.MainActivity
import com.example.pokeproject.R
import com.example.pokeproject.view.DashActivity
import kotlinx.android.synthetic.main.activity_main.*

//Attempt to restructure/modularize into MVP
//1. trying to remove declaring Intent/switching activities and passing shared preferences functionality from MainActivity into the presenter folder
//Dash Activity starts just fine, but shared preferences passes through string of object and not text of string

//class StartDashActivity {
//
//    fun startDashActivity(context: Context){
//
//
//        //taking text from EditText fields saving them to strings
//        val userNameTextView = R.id.userName as EditText
//        val userNameText = Toast.makeText(context, userNameTextView.text, Toast.LENGTH_LONG).toString()
//        val favPokeText : String = R.id.favoritePokeInput.toString()
//        val preferences : SharedPreferences = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
//        val editor = preferences.edit()
//        //using editor to apply/save the Strings input
//        editor.apply{
//            putString("uuName", userNameText)
//            putString("uuPoke", favPokeText)
//        }.apply()
//        //using an Intent to trigger onCreate method for HomeActivity
//        val dashIntent = Intent(context, DashActivity::class.java).also {
//            it.putExtra("uuName", userNameText).putExtra("uuPoke", favPokeText)
//            context.startActivity(it)
//        }
//    }
//
//}
