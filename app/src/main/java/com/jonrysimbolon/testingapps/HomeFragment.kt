package com.jonrysimbolon.testingapps

import android.app.SearchManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MaterialToolbar>(R.id.topAppBar).apply {
            setNavigationOnClickListener {
                println("Back button click")
            }
            setOnCreateContextMenuListener { menu, _, _ ->
                val searchManager: SearchManager? = requireActivity().getSystemService()
                val searchView: SearchView = menu.findItem(R.id.search).actionView as SearchView
                searchConfig(searchManager!!, searchView)
            }
            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu1 -> {
                        requireActivity().supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, MenuFragment())
                            .addToBackStack(null)
                            .commit()
                        true
                    }

                    R.id.menu2 -> {
                        findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
                        true
                    }

                    else -> false
                }
            }
        }
    }

    private fun searchConfig(searchManager: SearchManager, searchView: SearchView) {
        searchView.apply {
            setQuery("jonry simbolon", false)
            setSearchableInfo(searchManager.getSearchableInfo(requireActivity().componentName))
            queryHint = resources.getString(R.string.search_hint)
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    searchView.clearFocus()
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return true
                }
            })
        }
    }
}