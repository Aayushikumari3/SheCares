package com.example.shecare

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActionActivity : AppCompatActivity() {
    private lateinit var viewPager:ViewPager2
    private lateinit var bottomNavBar:BottomNavigationView
    lateinit var year:String
    lateinit var month:String
    lateinit var day:String

    private fun changeFragment(index: Int): Boolean {
        viewPager.currentItem=index
        return true

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        viewPager=findViewById(R.id.ViewPager)
        val fragmentStateAdapter = NavAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter=fragmentStateAdapter
        viewPager.isUserInputEnabled=false
        viewPager.currentItem=1
        bottomNavBar=findViewById(R.id.bottomNavigationView)
        year=intent.getStringExtra("Year")!!
        month=intent.getStringExtra("Month")!!
        day=intent.getStringExtra("Day")!!
        bottomNavBar.menu.findItem(R.id.tracker).isChecked=true
        bottomNavBar.setOnItemSelectedListener {it->
            when(it.itemId)
            {
                R.id.insights -> changeFragment(0)
                R.id.tracker -> changeFragment(1)
                R.id.myths -> changeFragment(2)
                R.id.diary -> changeFragment(3)
                else -> changeFragment(1)
            }

        }


       /* fun sendYear():String
        {
            return year
        }
        fun sendMonth():String
        {return month}
        fun sendDay():String
        {return day}*/

    }
}