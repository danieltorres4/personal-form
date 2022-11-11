package com.outatime.personalform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Toast
import com.outatime.personalform.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var name: String = ""
    var birthday: String = ""
    var accountNumber: String = ""
    var email: String = ""
    var age: Int = 0

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

        val param = Bundle()

        if(binding.tvName.text.isNotEmpty() && binding.tvBirthday.text.isNotEmpty() && binding.tvAccountNumber.text.isNotEmpty() && binding.tvEmail.text.isNotEmpty()){
            name = binding.tvName.text.toString()
            birthday = binding.tvBirthday.text.toString()
            accountNumber = binding.tvAccountNumber.text.toString()
            email = binding.tvEmail.text.toString()
            param.putString("name", name)
            param.putString("birthday", birthday)
            param.putString("accountNumber", accountNumber)
            param.putString("email", email)
            param.putInt("age", age)

            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtras(param)
            startActivity(intent)
        }
        else if (binding.tvName.text.isEmpty() || binding.tvBirthday.text.isEmpty() || binding.tvAccountNumber.text.isEmpty() || binding.tvEmail.text.isEmpty()){
            Toast.makeText(this@MainActivity, getString(R.string.toast_required_values), Toast.LENGTH_LONG)

            if (binding.tvName.text.isEmpty()) {
                binding.tvName.error = getString(R.string.name_required)
            }

            if (binding.tvBirthday.text.isEmpty()) {
                binding.tvBirthday.error = getString(R.string.birthday_required)
            }

            if (binding.tvAccountNumber.text.isEmpty()) {
                binding.tvAccountNumber.error = getString(R.string.an_required)
            }

            if (binding.tvEmail.text.isEmpty()) {
                binding.tvEmail.error = getString(R.string.email_required)
            }
        }

    }

    private fun showDatePickeDialog() {
        var datePicker = DatePickerFragment{day, month, year -> onDateSelected(day, (month+1), year)}

        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int){
        //binding.tvBirthday.setText("$day / $month / $year")
        binding.tvBirthday.setText(getString(R.string.ma_date_of_birth, day, month, year))

        var birthday = "$day/$month/$year"
        lateinit var yourBirthday: Date

        try {
            yourBirthday = SimpleDateFormat("dd/MM/yyyy").parse(birthday)
        }
        catch (e: Exception){
            println(e)
        }

        var today = Date(System.currentTimeMillis())
        var diffDate = today.getTime() - yourBirthday.getTime()
        var sec = diffDate/1000
        var minutes = sec/60
        var hours = minutes/60
        var days = hours/24

        age = (days/365).toInt()

        println("$age years old")
    }
}