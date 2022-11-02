package com.outatime.personalform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.outatime.personalform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun click(view: View) {

    }
}