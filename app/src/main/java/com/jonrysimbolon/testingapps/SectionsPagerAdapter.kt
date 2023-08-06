package com.jonrysimbolon.testingapps

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            else -> Fragment()
        }

    override fun getItemCount(): Int = 2
}