package com.omarismayilov.advancednavigation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.omarismayilov.advancednavigation.R.id
import com.omarismayilov.advancednavigation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment =
            supportFragmentManager.findFragmentById(id.fragmentContainerView2) as NavHostFragment
        val navController = fragment.navController

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
        setSupportActionBar(binding.toolbar)
        binding.navView.setupWithNavController(navController)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.tabLayout.visibility =
                when (destination.id) {
                    id.AFragment -> View.GONE
                    id.CFragment -> View.GONE
                    id.DFragment -> View.GONE
                    else -> View.VISIBLE
                }
            binding.viewPager.visibility =
                when (destination.id) {
                    R.id.BFragment -> View.VISIBLE
                    else -> View.GONE
                }
        }

        val appBarConfiguration: AppBarConfiguration by lazy {
            AppBarConfiguration(setOf(id.AFragment), binding.drawerLayout)
        }

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        val tabTitles = listOf("Fragment E", "Fragment F")

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

}