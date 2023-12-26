package com.example.dailyexpenses.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expensesTable")
data class ExpenseDetailModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "expenseId")
    var expenseId : Int = 0,

    @ColumnInfo(name = "expenseName")
    var expenseName: String,

    @ColumnInfo(name = "expenseCategory")
    var expenseCategory: String,

    @ColumnInfo(name = "expensePrice")
    var expensePrice: String,

    @ColumnInfo(name = "expensePaymentType")
    var expensePaymentType: String,

    @ColumnInfo(name = "expenseDate")
    var expenseDate: String,
)