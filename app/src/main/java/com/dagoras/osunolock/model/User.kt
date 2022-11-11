package com.dagoras.osunolock.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name="phone_number")
    val phoneNumber: String,
    @ColumnInfo(name="password")
    val password: String
)