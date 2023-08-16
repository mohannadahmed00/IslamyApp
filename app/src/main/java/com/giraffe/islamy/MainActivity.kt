package com.giraffe.islamy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.giraffe.islamy.fragments.HadethFragment
import com.giraffe.islamy.fragments.QuranFragment
import com.giraffe.islamy.fragments.RadioFragment
import com.giraffe.islamy.fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        bottomNav = findViewById(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_quran -> {
                    pushFragment(QuranFragment())
                }
                R.id.nav_hadeth -> {
                    pushFragment(HadethFragment())

                }
                R.id.nav_sebha -> {
                    pushFragment(SebhaFragment())

                }
                else -> {
                    pushFragment(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        bottomNav.selectedItemId = R.id.nav_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }
}