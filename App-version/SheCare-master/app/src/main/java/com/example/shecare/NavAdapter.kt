package com.example.shecare

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class NavAdapter(fragmentManager: FragmentManager,
                 lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position)
        {
            0->InsightsFragment()
            1->TrackerFragment()
            2->MythFragment()
            3->DiaryFragment()
            else -> InsightsFragment()
        }
    }
}