package com.dagoras.osunolock.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LockManager(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "id_lock")
    val id_lock: Int,
    @ColumnInfo(name = "id_user_root")
    val idUserRoot: Int,
    @ColumnInfo(name = "id_user")
    val idUser: Int,
    @ColumnInfo(name = "type_manager") //Type = 1 -> Admin (Share admin), type = 2 -> User (EKey)
    val typeManager: Int?,
    @ColumnInfo(name = "start_date")
    val startDate: String?,
    @ColumnInfo(name = "end_date") //If end date = null -> permanent
    val endDate: String?,
    @ColumnInfo(name = "counting_time")
    val countingTime: Int?,
    @ColumnInfo(name = "repeat_day") //If repeatDay = 2345 (monday, tuesday, wednesday, thursday)
    val repeatDayOfWeek: String?,
)