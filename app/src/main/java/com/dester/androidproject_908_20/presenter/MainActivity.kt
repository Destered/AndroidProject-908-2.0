package com.dester.androidproject_908_20.presenter

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dester.androidproject_908_20.R
import com.dester.androidproject_908_20.databinding.ActivityMainBinding
import com.dester.androidproject_908_20.presenter.data.UserInfo
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rbddevs.splashy.Splashy

class MainActivity: AppCompatActivity(R.layout.activity_main) {
    private lateinit var binding: ActivityMainBinding
    lateinit var userData: UserInfo

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Splashy(this)
            .setLogo(R.drawable.splash)
            .setTitle("PPAP")
            .setTime(2000)
            .setFullScreen(true)
            .setBackgroundResource(R.color.white)
            .show()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        navController = navHostFragment.navController
        setUpBottomNav(navController)
    }


    private fun navigateTo(@IdRes fragmentId: Int) {
        navController.navigate(fragmentId)
    }

    private fun setUpBottomNav(navController: NavController) {
        val bottomNav = binding.bottomNavView
        bottomNav.setupWithNavController(navController)
    }
}