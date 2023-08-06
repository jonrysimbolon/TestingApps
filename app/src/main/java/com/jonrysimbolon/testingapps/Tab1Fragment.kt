package com.jonrysimbolon.testingapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class Tab1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chipGroup = view.findViewById<ChipGroup>(R.id.chipGroup)

        val chipList = arrayListOf(
            Person(
                123,
                "Android 10",
                43
            ),
            Person(
                124,
                "Android 8",
                48
            ),
            Person(
                122,
                "Android 9",
                41
            ),
            Person(
                120,
                "Android 12",
                44
            ),
            Person(
                113,
                "Android 11",
                47
            ),
        )

        chipList
            .forEach { data ->
                val chip = Chip(requireContext())
                chip.text = data.name
                chip.id = data.id
                chip.isCheckable = true
                chipGroup.addView(chip)
            }

        chipGroup.check(chipList.first().id)

        chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            checkedIds.forEach { checkedId ->
                val chips = group.findViewById<Chip>(checkedId)
                Toast.makeText(requireContext(), chips.id.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}

data class Person(
    val id: Int,
    val name: String,
    val age: Int
)