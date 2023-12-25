package com.example.dailyexpenses.ui.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.dailyexpenses.R
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.Math.abs

class StatisticsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_statistics, container, false)

        rootView.findViewById<ViewPager2>(R.id.viewPager).setPageTransformer { page, position ->
            // Özel sayfa geçiş animasyonları ekleyebilirsiniz
            // Örneğin, sayfaları yatayda kaydırma animasyonu ekleyebilirsiniz
            page.translationX = -position * page.width
            page.alpha = 1 - abs(position)
        }

        val tabNames = listOf("Günlük", "Haftalık", "Aylık")

        rootView.findViewById<ViewPager2>(R.id.viewPager).adapter = StatisticsPagerAdapter(this)

        TabLayoutMediator(rootView.findViewById(R.id.tabLayout), rootView.findViewById(R.id.viewPager)) { tab, position ->
            tab.text = tabNames[position]
        }.attach()

        return rootView
    }

    companion object {
        fun newInstance(): StatisticsFragment {
            return StatisticsFragment()
        }
    }
}
