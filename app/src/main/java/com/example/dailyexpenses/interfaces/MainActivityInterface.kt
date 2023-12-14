package com.example.dailyexpenses.interfaces

import androidx.fragment.app.FragmentManager

interface MainActivityInterface {
    val fragmentManager: FragmentManager
    val childFragmentManager: FragmentManager

    fun showProgress()

}