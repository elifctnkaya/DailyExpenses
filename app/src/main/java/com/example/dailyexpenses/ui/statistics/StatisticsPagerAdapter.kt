package com.example.dailyexpenses.ui.statistics

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class StatisticsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3  // 3 sayfa olduğunu varsayalım, gerektiğinde değiştirin

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabFragment.newInstance("Tab 1")
            1 -> TabFragment.newInstance("Tab 2")
            2 -> TabFragment.newInstance("Tab 3")
            else -> throw IllegalArgumentException("Geçersiz pozisyon: $position")
        }
    }
}

