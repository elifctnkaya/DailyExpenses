package com.example.dailyexpenses.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getCurrentTime(): String {
    val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
    val date = Calendar.getInstance().time
    return formatter.format(date)
}