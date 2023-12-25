package com.example.dailyexpenses.common

import android.view.View
import android.widget.ProgressBar

class BaseCommon {
    fun showProgressBar(progressBar: ProgressBar, viewList: ArrayList<View>) {
        progressBar.visibility = View.VISIBLE
        viewList.map { it.visibility = View.GONE }
    }
}