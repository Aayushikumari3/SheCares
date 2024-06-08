package com.example.shecare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var sendButton: TextView
    private lateinit var datePicker: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        sendButton=findViewById(R.id.sendBtn)
        datePicker=findViewById(R.id.datePicker)
        val today=Calendar.getInstance()
        var year:String=today.get(Calendar.YEAR).toString()
        var month:String=(today.get(Calendar.MONTH)+1).toString()
        var day:String=today.get(Calendar.DAY_OF_MONTH).toString()
        datePicker.init(today.get(Calendar.YEAR),today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH)){ view, y, m, d ->
            year=y.toString()
            month=(m+1).toString()
            day=d.toString()

        }

        sendButton.setOnClickListener {
            val intent=Intent(this,ActionActivity::class.java)
            intent.putExtra("Year",year)
            intent.putExtra("Month",month)
            intent.putExtra("Day",day)
            startActivity(intent)
        }
    }

    }