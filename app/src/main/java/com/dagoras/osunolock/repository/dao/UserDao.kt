package com.dagoras.osunolock.repository.dao

import androidx.room.*
import com.dagoras.osunolock.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createNewUser(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM tbl_user WHERE id == :id")
    fun getUserById(id: Int): User
}