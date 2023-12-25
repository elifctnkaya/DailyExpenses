package com.example.dailyexpenses.ui.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dailyexpenses.R

class ChartsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab, container, false)

        // Burada her bir fragment için grafikleri oluşturabilirsiniz.
        // Grafik oluşturma işlemleri fragment içinde gerçekleştirilebilir.

        return view
    }
    companion object {
        fun newInstance(chartName: String): ChartsFragment {
            val fragment = ChartsFragment()
            val args = Bundle()
            args.putString("chartName", chartName)
            fragment.arguments = args
            return fragment
        }
    }
}
