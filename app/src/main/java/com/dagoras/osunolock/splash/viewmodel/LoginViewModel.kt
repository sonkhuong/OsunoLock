package com.dagoras.osunolock.splash.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dagoras.osunolock.model.User
import com.dagoras.osunolock.repository.database.UserDatabase
import com.dagoras.osunolock.repository.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(app: Application) : AndroidViewModel(app) {
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(app).userDao()
        repository = UserRepository(userDao)
    }

    fun createNewUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createNewUser(user)
        }
    }

    fun getUserById(id: Int): User {
        var user: User? = null
        viewModelScope.launch(Dispatchers.IO) {
            user = repository.getUserById(id)
        }
        Log.d("TAGG", "${user?.id}")
        return user!!
    }
}
