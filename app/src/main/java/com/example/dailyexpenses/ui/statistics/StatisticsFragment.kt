package com.example.dailyexpenses.ui.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.dailyexpenses.R
import com.example.dailyexpenses.databinding.FragmentStatisticsBinding
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.Math.abs

class StatisticsFragment : Fragment() {
    private val binding by lazy { FragmentStatisticsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tabNames = listOf("Günlük", "Haftalık", "Aylık")
        binding.viewPager2.adapter =StatisticsPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout,binding.viewPager2) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }
    override fun onPause() {
        super.onPause()
        binding.viewPager2?.adapter = null
    }
    override fun onStop() {
        super.onStop()
        binding.viewPager2?.adapter = null
    }

}
