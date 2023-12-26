package com.example.dailyexpenses.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [ExpenseDetailModel::class], version = 1)
abstract class ExpensesDatabase: RoomDatabase() {
    abstract fun ExpensesDao() : ExpensesDao
    companion object {
        private var collections: ExpensesDatabase? = null
        fun expensesDatabase(context: Context): ExpensesDatabase? {
            if (collections == null) {
                collections = Room
                    .databaseBuilder(context, ExpensesDatabase::class.java, "expenses.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return collections
        }
    }
}