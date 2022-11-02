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

        binding.etBirthday.setOnClickListener{
            showDatePickerDialog()
        }
    }

    fun click(view: View) {

    }

    /*fun chooseDate(){
        binding.etBirthday.setOnClickListener{
            showDatePickerDialog()
        }
    }*/

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment{day, month, year -> onDateSelected(day, month, year)}

        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int){

    }
}