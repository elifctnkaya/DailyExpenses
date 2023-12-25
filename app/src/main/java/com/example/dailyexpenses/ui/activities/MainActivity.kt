package com.example.dailyexpenses.ui.activities

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.example.dailyexpenses.MainApplication
import com.example.dailyexpenses.R
import com.example.dailyexpenses.databinding.ActivityMainBinding
import com.example.dailyexpenses.databinding.FragmentStatisticsBinding
import com.example.dailyexpenses.interfaces.MainActivityInterface
import com.example.dailyexpenses.ui.statistics.StatisticsFragment
import com.example.dailyexpenses.ui.home.HomeFragment
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val home_fragment = HomeFragment()
    private val statistics_fragment = StatisticsFragment()

    private val viewLifecycleOwner: LifecycleOwner by lazy { this }

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
                R.id.navigation_statistics -> {
                    setCurrentFragment(statistics_fragment)
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
