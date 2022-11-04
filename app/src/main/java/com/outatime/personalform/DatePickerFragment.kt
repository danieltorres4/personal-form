package com.outatime.personalform

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment(var listener: (day: Int, month: Int, year: Int) -> Unit): DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var c = Calendar.getInstance()
        var day = c.get(Calendar.DAY_OF_MONTH)
        var month = c.get(Calendar.MONTH) + 1
        var year = c.get(Calendar.YEAR)

        var picker = DatePickerDialog(activity as Context, this, year, month, day)

        picker.datePicker.maxDate = c.timeInMillis
        


        return picker
    }
}