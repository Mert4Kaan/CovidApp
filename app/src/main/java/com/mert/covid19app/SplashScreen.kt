package com.mert.covid19app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        btnStart.setOnClickListener {
            var Intent = Intent(this@SplashScreen,MainActivity::class.java)
            startActivity(Intent)
        }
    }
}
