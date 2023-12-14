package com.example.dailyexpenses.managers

import com.example.dailyexpenses.MainApplication
import com.example.dailyexpenses.interfaces.HandlerInterface
import com.example.dailyexpenses.interfaces.MainActivityInterface

open class BaseManager(override val mainActivity: MainActivityInterface) : HandlerInterface {
    val context = MainApplication.context
    val resources = MainApplication.resources
}