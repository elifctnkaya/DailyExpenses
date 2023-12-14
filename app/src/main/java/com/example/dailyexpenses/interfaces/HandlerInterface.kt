package com.example.dailyexpenses.interfaces

interface HandlerInterface {
    val mainActivity: MainActivityInterface

    fun showProgress() = this.mainActivity.showProgress()


}