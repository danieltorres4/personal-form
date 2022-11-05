package com.outatime.personalform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import com.outatime.personalform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var name: String = ""
    var birthday: String = ""
    var accountNumber: String = ""
    var email: String = ""

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

        name = binding.tvName.text.toString()
        birthday = binding.tvBirthday.text.toString()
        accountNumber = binding.tvAccountNumber.text.toString()
        email = binding.tvEmail.text.toString()
        param.putString("name", name)
        param.putString("birthday", birthday)
        param.putString("accountNumber", accountNumber)
        param.putString("email", email)

        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.putExtras(param)
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