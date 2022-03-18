package com.example.pokeproject.presenter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.core.content.ContextCompat.startActivity
import com.example.pokeproject.MainActivity
import com.example.pokeproject.R
import com.example.pokeproject.view.DashActivity
import kotlinx.android.synthetic.main.activity_main.*

class StartDashActivity {

    fun startDashActivity(context: Context){

        val mainActivity = MainActivity()

        //taking text from EditText fields saving them to strings
        val userNameText :String = R.id.userName.toString()
        val favPokeText : String = R.id.favoritePokeInput.toString()
        val preferences : SharedPreferences = mainActivity.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
        val editor = preferences.edit()
        //using editor to apply/save the Strings input
        editor.apply{
            putString("uuName", userNameText)
            putString("uuPoke", favPokeText)
        }.apply()
        //using an Intent to trigger onCreate method for HomeActivity
        val dashIntent = Intent(context, DashActivity::class.java).also {
            it.putExtra("uuName", userNameText).putExtra("uuPoke", favPokeText)
            context.startActivity(it)
        }
    }

}
