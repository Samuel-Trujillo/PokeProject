package com.example.pokeproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokeproject.view.DashActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setting OnClickListener when signIn button is clicked
        signIn.setOnClickListener {
            startDashActivity()
        }
    }
        //Navigating to DashActivity
        fun startDashActivity(){
            //taking text from EditText fields saving them to strings
            val userNameText :String = userName.text.toString()
            val favPokeText : String = favoritePokeInput.text.toString()
            val preferences : SharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            //using editor to apply/save the Strings input
            editor.apply{
                putString("uuName", userNameText)
                putString("uuPoke", favPokeText)
            }.apply()
            //using an Intent to trigger onCreate method for HomeActivity
            val dashIntent = Intent(this, DashActivity::class.java).also {
                it.putExtra("uuName", userNameText).putExtra("uuPoke", favPokeText)
                startActivity(it)
            }
        }
}