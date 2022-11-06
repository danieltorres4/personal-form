package com.outatime.personalform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.outatime.personalform.databinding.ActivityMainBinding

class ShowInfoTest : AppCompatActivity() {

    private lateinit var testBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(testBinding.root)

        val bundle = intent.extras

        var name = bundle?.getString("name","")
        var birthday = bundle?.getString("birthday", "")
        var accountNumber = bundle?.getString("accountNumber","")
        var email = bundle?.getString("email","")


    }
}