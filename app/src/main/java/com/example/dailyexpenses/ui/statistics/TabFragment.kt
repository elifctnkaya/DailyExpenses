package com.example.dailyexpenses.ui.statistics
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dailyexpenses.databinding.FragmentTabBinding

class TabFragment : Fragment() {
    private lateinit var binding: FragmentTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabBinding.inflate(inflater, container, false)
        val args = requireArguments()
        val tabName = args.getString(ARG_TAB_NAME, "")

        // Burada tab adını kullanarak gerekli işlemleri yapabilirsiniz

        return binding.root
    }

    companion object {
        private const val ARG_TAB_NAME = "tabName"

        fun newInstance(tabName: String): TabFragment {
            val fragment = TabFragment()
            val args = Bundle()
            args.putString(ARG_TAB_NAME, tabName)
            fragment.arguments = args
            return fragment
        }
    }
}
