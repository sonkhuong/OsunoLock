package com.dagoras.osunolock.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dagoras.osunolock.model.Account
import com.dagoras.osunolock.repository.dao.AccountDao


@Database(entities = [Account::class], version = 1, exportSchema = false)
abstract class AccountDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao

    companion object {

        @Volatile
        private var INSTANCE: AccountDatabase? = null

        //Return TransactionDatabase instance
        fun getDatabase(context: Context): AccountDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AccountDatabase::class.java,
                    "account"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
