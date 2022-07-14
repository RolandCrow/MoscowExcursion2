package com.example.moscowexcursion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.moscowexcursion2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var navigationController: NavController

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  navigationController = Navigation.findNavController(this@MainActivity, R.id.fragment)
        navigationController = (supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navigationController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navigationController, null)
    }
}