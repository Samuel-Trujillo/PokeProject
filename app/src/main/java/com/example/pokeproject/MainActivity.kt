package com.example.pokeproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokeproject.model.UserInfo
import com.example.pokeproject.model.UserSharedPreference
import com.example.pokeproject.view.DashActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var uuinfo: UserSharedPreference
    private lateinit var newUserInfo: UserInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Navigating to DashActivity
        //Setting OnClickListener when signIn button is clicked
        signIn.setOnClickListener{
            //using an Intent to trigger onCreate method for HomeActivity
            val dashIntent = Intent(this, DashActivity::class.java)
            startActivity(dashIntent)

            uuinfo.updateUserInfo(newUserInfo)
            println("hello")
        }
    }
}