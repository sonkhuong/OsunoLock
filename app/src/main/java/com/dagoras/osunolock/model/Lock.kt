package com.dagoras.osunolock.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lock(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "default_name")
    val defaultName: String,
    @ColumnInfo(name = "lock_name")
    val lockName: String?,
    @ColumnInfo(name = "mac_address")
    val macAddress: String,
    @ColumnInfo(name = "battery_lock")
    val batteryLock: Int,
    @ColumnInfo(name = "paired_lock")
    val pairedLock: Boolean,
)