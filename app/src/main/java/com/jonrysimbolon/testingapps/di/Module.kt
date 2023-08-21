package com.jonrysimbolon.testingapps.di

import com.jonrysimbolon.testingapps.SectionsPagerAdapter
import org.koin.dsl.module

val homeModule = module {
    single {
        params -> SectionsPagerAdapter(fragment = params.get())
    }
    /*single {
        SectionsPagerAdapter(androidApplication() as Fragment)
    }*/
    /*fragment {
        HomeFragment(get())
    }*/
}