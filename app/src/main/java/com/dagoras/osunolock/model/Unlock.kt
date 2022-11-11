package com.dagoras.osunolock.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Unlock(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "id_lock")
    val idLock: Int,
    @ColumnInfo(name = "id_user")
    val idUser: Int,
    @ColumnInfo(name = "type_unlock") //Type = 0 -> Passcode, type = 1 -> Card, type = 2 -> FingerPrints, type = 3 -> Remote
    val typeUnlock: Int,
    @ColumnInfo(name = "unlock_name")
    val unlockName: String?,
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
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(idLock)
        parcel.writeInt(idUser)
        parcel.writeInt(typeUnlock)
        parcel.writeString(unlockName)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeValue(countingTime)
        parcel.writeString(repeatDayOfWeek)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Unlock> {
        override fun createFromParcel(parcel: Parcel): Unlock {
            return Unlock(parcel)
        }

        override fun newArray(size: Int): Array<Unlock?> {
            return arrayOfNulls(size)
        }
    }
}