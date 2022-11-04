package com.outatime.personalform

import android.content.Intent
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

        binding.tvBirthday.setOnClickListener{
            showDatePickeDialog()
        }
    }

    fun click(view: View) {
        val intent = Intent(this, ShowInfo::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)

    }

    private fun showDatePickeDialog() {
        var datePicker = DatePickerFragment{day, month, year -> onDateSelected(day, (month+1), year)}

        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int){
        binding.tvBirthday.setText("$day / $month / $year")
    }
}