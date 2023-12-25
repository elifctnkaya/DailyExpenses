package com.example.dailyexpenses.base

import android.app.Application
import com.example.dailyexpenses.MainApplication
import com.example.dailyexpenses.interfaces.HandlerInterface

open class BaseHandler: HandlerInterface {

    override val mainActivity by lazy { MainApplication.instance.mainActivity!! }
}