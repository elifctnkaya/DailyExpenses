package com.example.dailyexpenses.ui.statistics

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class StatisticsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabNames = listOf("Tab 1", "Tab 2", "Tab 3")

    override fun getItemCount(): Int = tabNames.size

    override fun createFragment(position: Int): Fragment {
        return TabFragment.newInstance(tabNames[position])
    }
}
