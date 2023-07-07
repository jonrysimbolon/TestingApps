package com.jonrysimbolon.testingapps

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(
    activity: AppCompatActivity
) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            else -> Fragment()
        }

    override fun getItemCount(): Int = 2
}