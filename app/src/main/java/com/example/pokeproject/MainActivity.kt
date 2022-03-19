package com.example.pokeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokeproject.presenter.StartDashActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //instantiating StartDashActivity
        val initDashActivity = StartDashActivity()
        //Setting OnClickListener when signIn button is clicked
        signIn.setOnClickListener {
            initDashActivity.startDashActivity(this)
        }
    }
}
