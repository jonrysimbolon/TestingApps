package com.jonrysimbolon.testingapps.di

import androidx.fragment.app.Fragment
import com.jonrysimbolon.testingapps.HomeFragment
import com.jonrysimbolon.testingapps.SectionsPagerAdapter
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val homeModule = module {
    /*single {
        params -> SectionsPagerAdapter(fragment = params.get())
    }*/
    single {
        SectionsPagerAdapter(androidApplication() as Fragment)
    }
    fragment {
        HomeFragment(get())
    }
}