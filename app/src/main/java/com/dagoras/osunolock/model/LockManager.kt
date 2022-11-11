package com.dagoras.osunolock.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LockManager(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "id_lock")
    val idLock: Int,
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(idLock)
        parcel.writeInt(idUserRoot)
        parcel.writeInt(idUser)
        parcel.writeValue(typeManager)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeValue(countingTime)
        parcel.writeString(repeatDayOfWeek)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LockManager> {
        override fun createFromParcel(parcel: Parcel): LockManager {
            return LockManager(parcel)
        }

        override fun newArray(size: Int): Array<LockManager?> {
            return arrayOfNulls(size)
        }
    }
}