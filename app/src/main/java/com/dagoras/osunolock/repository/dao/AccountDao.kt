package com.dagoras.osunolock.repository.dao

import androidx.room.*
import com.dagoras.osunolock.model.Account

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createNewAccount(account: Account)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAccount(account: Account)

    @Delete
    fun deleteAccount(account: Account)

//    @Query("select * from account ORDER BY id ASC")
//    fun getAllAccount(): ArrayList<Account>?
}