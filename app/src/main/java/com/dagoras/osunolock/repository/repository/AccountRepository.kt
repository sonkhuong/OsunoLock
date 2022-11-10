package com.dagoras.osunolock.repository.repository

import com.dagoras.osunolock.model.Account
import com.dagoras.osunolock.repository.dao.AccountDao

class AccountRepository(private val accountDao: AccountDao) {

    suspend fun createNewAccount(account: Account) {
        accountDao.createNewAccount(account)
    }

    suspend fun updateAccount(account: Account) {
        accountDao.updateAccount(account)
    }

    suspend fun deleteAccount(account: Account) {
        accountDao.deleteAccount(account)
    }

//    suspend fun getAllAccount(): ArrayList<Account>? {
//        return accountDao.getAllAccount()
//    }
}
