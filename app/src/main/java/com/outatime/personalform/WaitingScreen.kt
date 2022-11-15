package com.outatime.personalform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.outatime.personalform.databinding.ActivityWaitingScreenBinding
import kotlin.concurrent.thread

class WaitingScreen : AppCompatActivity() {
    private lateinit var bindingWS: ActivityWaitingScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingWS = ActivityWaitingScreenBinding.inflate(layoutInflater)
        setContentView(bindingWS.root)

        thread {
            Thread.sleep(5000)

            //Explicit intent
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}