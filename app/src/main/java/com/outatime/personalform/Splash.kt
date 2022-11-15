package com.outatime.personalform

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.outatime.personalform.databinding.ActivitySplashBinding
import kotlin.concurrent.thread

class Splash : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var mp3: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mp3 = MediaPlayer.create(this, R.raw.song3)
        mp3.start()

        thread {
            Thread.sleep(3000)

            //Explicit intent
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
        mp3.pause()
    }

    override fun onRestart() {
        super.onRestart()
        mp3.start()
    }
}