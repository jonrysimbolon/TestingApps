package com.jonrysimbolon.testingapps

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import com.jonrysimbolon.testingapps.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> setStatusBarTextColorDark(true)
            Configuration.UI_MODE_NIGHT_YES -> setStatusBarTextColorDark(false)
            Configuration.UI_MODE_NIGHT_UNDEFINED -> setStatusBarTextColorDark(false)
        }
    }

    private fun setStatusBarTextColorDark(isTrue: Boolean){
        WindowInsetsControllerCompat(
            window,
            window.decorView
        ).isAppearanceLightStatusBars = isTrue
    }
}