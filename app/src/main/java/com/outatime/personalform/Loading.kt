package com.outatime.personalform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.outatime.personalform.databinding.ActivityLoadingBinding
import kotlin.concurrent.thread

class Loading : AppCompatActivity() {
    private lateinit var bindingWS: ActivityLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingWS = ActivityLoadingBinding.inflate(layoutInflater)
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