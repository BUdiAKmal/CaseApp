package com.caseapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.caseapp.R
import com.caseapp.ui.adapters.ViewPagerAdapter
import com.caseapp.ui.fragments.MainTabFragment1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start - full screen
        val window = window
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ) // End - full screen

        setUpTabs() // Setup TabLayout

    } // End - OnCreate

    // Start - TabLayout
    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MainTabFragment1(), "MainTab1")
        adapter.addFragment(MainTabFragment1(), "MainTab2")
        viewPager_tabLayout.adapter = adapter
        tabs.setupWithViewPager(viewPager_tabLayout)
    } // End - TabLayout

} // End - Class