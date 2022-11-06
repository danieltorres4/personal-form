package com.outatime.personalform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.outatime.personalform.databinding.ActivityMainBinding
import com.outatime.personalform.databinding.ActivityShowInfoBinding
import kotlin.reflect.typeOf

class ShowInfo : AppCompatActivity() {

    private lateinit var binding2: ActivityShowInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityShowInfoBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        val bundle = intent.extras

        var name = bundle?.getString("name","")
        var birthday = bundle?.getString("birthday", "")
        var accountNumber = bundle?.getString("accountNumber","")
        var email = bundle?.getString("email","")
        var age = bundle?.getInt("age", 0)
        age.toString()

        binding2.tvShowName.text = getString(R.string.tv_result_name, name)
        binding2.tvShowBirthday.text = getString(R.string.tv_result_birthday, birthday)
        binding2.tvShowAn.text = getString(R.string.tv_result_an, accountNumber)
        binding2.tvShowEmail.text = getString(R.string.tv_result_email, email)
        binding2.tvShowAge.text = getString(R.string.tv_result_age, age)

        /*
        Toast.makeText(this, "Name: $name", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Birthday: $birthday", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Account number: $accountNumber", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Email: $email", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Age: $age", Toast.LENGTH_LONG).show()
         */

    }

    fun click(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }
}