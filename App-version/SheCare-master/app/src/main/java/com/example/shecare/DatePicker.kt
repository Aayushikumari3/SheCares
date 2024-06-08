package com.example.shecare

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView

import com.google.android.play.core.integrity.p
import java.util.*


class Calender : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datepicker)



        //Calender
        lateinit var pickDateBtn : Button
        lateinit var dateTv : TextView
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

        pickDateBtn=findViewById(R.id.pickDateBtn)
        dateTv=findViewById((R.id.dateTv))
                //button click to show DatePickerDialog
        pickDateBtn.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view : DatePicker, mYear: Int, mMonth: Int, mDay: Int->
             dateTv.setText(""+ mDay +"/"+ mMonth +"/"+ mYear)
                                       } , year, month,day)
        dpd.show()


        }
    }
}