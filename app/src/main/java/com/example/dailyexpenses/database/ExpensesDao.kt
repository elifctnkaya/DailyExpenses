package com.example.dailyexpenses.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface ExpensesDao {
    @Insert
    fun addExpensesDetail(ExpensesDetailModel: ExpenseDetailModel)
    @Delete
    fun deleteExpensesDetail(ExpensesDetailModel: ExpenseDetailModel)
    @Update
    fun updateExpensesDetail(ExpensesDetailModel: ExpenseDetailModel)
}