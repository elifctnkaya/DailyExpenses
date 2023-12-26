package com.example.dailyexpenses.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.dailyexpenses.databinding.FragmentHomeBinding
import com.example.dailyexpenses.ui.expenseDetail.ExpenseDetailFragment

class HomeFragment : Fragment() {

    private val homeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeBinding.expenseDetailEdit.setOnClickListener {
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val myFragment = ExpenseDetailFragment()
            transaction.replace(com.example.dailyexpenses.R.id.fragmentContainer, myFragment, "ExpenseDetailFragment")
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return homeBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }



}