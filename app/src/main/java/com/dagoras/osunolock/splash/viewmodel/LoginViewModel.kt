package com.dagoras.osunolock.splash.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dagoras.osunolock.model.Account
import com.dagoras.osunolock.repository.database.AccountDatabase
import com.dagoras.osunolock.repository.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LoginViewModel(app: Application) : AndroidViewModel(app) {
    private val repository: AccountRepository

    private val _listAccount = MutableLiveData<ArrayList<Account>>()
    val listAccount: LiveData<ArrayList<Account>>
        get() = _listAccount


    init {
        val accountDao = AccountDatabase.getDatabase(app).accountDao()
        repository = AccountRepository(accountDao)
    }

    fun createNewAccount(account: Account) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNewAccount(account)
        }
    }

//    fun getAllAccount() = runBlocking {
//        viewModelScope.launch(Dispatchers.IO) {
//            _listAccount.postValue(repository.getAllAccount())
//        }
//    }
}
