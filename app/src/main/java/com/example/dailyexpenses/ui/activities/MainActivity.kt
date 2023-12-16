package com.example.dailyexpenses.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.dailyexpenses.R
import com.example.dailyexpenses.databinding.ActivityMainBinding
import com.example.dailyexpenses.ui.expenses.ExpensesFragment
import com.example.dailyexpenses.ui.home.HomeFragment


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private val home_fragment = HomeFragment()
    private val history_fragment = ExpensesFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setCurrentFragment(home_fragment)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    setCurrentFragment(home_fragment)
                }
                R.id.navigation_expenses -> {
                    setCurrentFragment(history_fragment)
                }
                else -> {setCurrentFragment(home_fragment)}
            }
            true
        }
    }
    private fun setCurrentFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer,fragment)
            commit()
        }

    }

}
