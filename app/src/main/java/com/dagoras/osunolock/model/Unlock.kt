package com.dagoras.osunolock.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Unlock(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "type_unlock") //Type = 0 -> Passcode, type = 1 -> Card, type = 2 -> FingerPrints, type = 3 -> Remote, type = 4 -> Record
    val typeUnlock: Int,
    @ColumnInfo(name = "unlock_name")
    val unlockName: String,
    @ColumnInfo(name = "start_date")
    val startDate: String?,
    @ColumnInfo(name = "end_date") //If end date = null -> permanent
    val endDate: String?,
    @ColumnInfo(name = "counting_time")
    val countingTime: Int?,
    @ColumnInfo(name = "repeat_day") //If repeatDay = 2345 (monday, tuesday, wednesday, thursday)
    val repeatDayOfWeek: String?,
)