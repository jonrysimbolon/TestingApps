package com.jonrysimbolon.testingapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment(
    private val sectionsPagerAdapter: SectionsPagerAdapter
) : Fragment() {

    //private val sectionsPagerAdapter: SectionsPagerAdapter by inject { parametersOf(requireParentFragment()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialToolbar>(R.id.topAppBar).apply {
            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu2 -> {
                        findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
                        true
                    }

                    else -> false
                }
            }
        }

        view.findViewById<ViewPager2>(R.id.view_pager).adapter = sectionsPagerAdapter
        TabLayoutMediator(
            view.findViewById(R.id.tabs),
            view.findViewById(R.id.view_pager)
        ) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_1,
            R.string.tab_2
        )
    }
}