package com.dester.androidproject_908_20.presenter

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.dester.androidproject_908_20.R
import com.dester.androidproject_908_20.databinding.ActivityLoginBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun navigateTo(@IdRes fragmentId: Int) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_auth) as NavHostFragment
        navHostFragment.navController.navigate(fragmentId)
    }
}