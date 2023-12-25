package com.example.dailyexpenses.base
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel>(private val bindingInflater: (layoutInflater: LayoutInflater) -> VB):
    Fragment() {
    private lateinit var _binding: VB
    lateinit var viewModel: VM

    abstract fun getViewModel():Class<VM>

    protected val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bindingInflater.invoke(inflater)
        viewModel = ViewModelProvider(this)[getViewModel()]
        return binding.root
    }
}