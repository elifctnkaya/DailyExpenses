package com.example.dailyexpenses.ui.expenseDetail

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.dailyexpenses.database.ExpenseDetailModel
import com.example.dailyexpenses.database.ExpensesDatabase
import com.example.dailyexpenses.databinding.FragmentExpenseDetailBinding
import com.example.dailyexpenses.util.getCurrentTime

class ExpenseDetailFragment : Fragment() {

    private val detailBinding by lazy { FragmentExpenseDetailBinding.inflate(layoutInflater) }
    private val categoryType: MutableList<String> = mutableListOf("seçiniz","yemek", "kahve", "tatlı", "sinema", "ulaşım")
    private val paymentType: MutableList<String> = mutableListOf("seçiniz","kredi kartı", "banka kartı", "nakit")
    private var paymentTypeText = ""
    private var categoryTypeText = ""
    private lateinit var  expensesDatabase: ExpensesDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        expensesDatabase = ExpensesDatabase.expensesDatabase(requireContext())!!
        fillSpinnerAdapter()
        clickable()
        return detailBinding.root
    }


    private fun clickable(){
        detailBinding.saveButton.setOnClickListener{
            val name = detailBinding.editExpenseName.text.toString()
            val expensePrice = detailBinding.editExpense.text.toString()
            expensesDatabase.ExpensesDao().addExpensesDetail(ExpenseDetailModel(0,name, categoryTypeText, expensePrice,paymentTypeText, getCurrentTime()))
        }
    }
    private fun fillSpinnerAdapter(){
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, paymentType)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        detailBinding.spinnerPayment.adapter= adapter
        detailBinding.spinnerPayment.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                paymentTypeText = paymentType[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val categoryAdapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, categoryType)
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        detailBinding.spinnerExpenseCategory.adapter= categoryAdapter
        detailBinding.spinnerExpenseCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                categoryTypeText = categoryType[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}