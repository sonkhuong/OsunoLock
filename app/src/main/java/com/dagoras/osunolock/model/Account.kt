package com.dagoras.osunolock.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Account")
data class Account(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val phoneNumber: String,
    val password: String
)