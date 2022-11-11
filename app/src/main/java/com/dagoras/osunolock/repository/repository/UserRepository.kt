package com.dagoras.osunolock.repository.repository

import com.dagoras.osunolock.model.User
import com.dagoras.osunolock.repository.dao.UserDao

class UserRepository(private val userDao: UserDao) {

    suspend fun createNewUser(user: User) {
        userDao.createNewUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun getUserById(id: Int): User {
        return userDao.getUserById(id)
    }
}
