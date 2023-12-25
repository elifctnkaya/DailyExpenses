package com.example.dailyexpenses.ui.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.dailyexpenses.R
import com.example.dailyexpenses.databinding.FragmentStatisticsBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
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


        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = tabNames[position]
            tab.view.setOnClickListener {
                when (position) {
                    0 -> showPieChart()
                    1 -> showPieChart()
                    2 -> showPieChart()

                }
            }
        }.attach()
    }
    private fun showPieChart() {
            val listPie = ArrayList<PieEntry>()
            val listColors = ArrayList<Int>()
            listPie.add(PieEntry(20F, "Pass"))
            listColors.add(resources.getColor(R.color.blue_1))
            listPie.add(PieEntry(50F, "Fail"))
            listColors.add(resources.getColor(R.color.blue_3))
            listPie.add(PieEntry(30F, "Unanswered"))
            listColors.add(resources.getColor(R.color.blue_4))

            val pieDataSet = PieDataSet(listPie, "")
            pieDataSet.colors = listColors

            val pieData = PieData(pieDataSet)
            pieData.setValueTextSize(14F)
            binding.pieChart.data = pieData

        binding.pieChart.setUsePercentValues(true)
        binding.pieChart.isDrawHoleEnabled = false
        binding.pieChart.description.isEnabled = false
        binding.pieChart.setEntryLabelColor(R.color.black)
        binding.pieChart.animateY(1400, Easing.EaseInOutQuad)
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
