package com.example.dailyexpenses

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.res.Resources
import android.os.Bundle
import com.example.dailyexpenses.interfaces.MainActivityInterface
import com.example.dailyexpenses.ui.activities.MainActivity


class MainApplication: Application() {
    var mMainActivity: MainActivity? = null
    val mainActivity get() = mMainActivity as? MainActivityInterface
    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic lateinit var instance: MainApplication private set

        val context get() = instance.applicationContext!!
        val resources: Resources get() = context.resources
        val activity get() = instance.mMainActivity
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
