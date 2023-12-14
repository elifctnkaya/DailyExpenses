package com.example.dailyexpenses

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.res.Resources
import android.os.Bundle
import com.example.dailyexpenses.interfaces.MainActivityInterface


class MainApplication: Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic lateinit var instance: MainApplication private set

        val context get() = instance.applicationContext!!
        val resources: Resources get() = context.resources

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
