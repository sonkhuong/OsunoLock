package com.dagoras.osunolock.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lock(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "default_name")
    val defaultName: String?,
    @ColumnInfo(name = "lock_name")
    val lockName: String?,
    @ColumnInfo(name = "mac_address")
    val macAddress: String?,
    @ColumnInfo(name = "battery_lock")
    val batteryLock: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(defaultName)
        parcel.writeString(lockName)
        parcel.writeString(macAddress)
        parcel.writeInt(batteryLock)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Lock> {
        override fun createFromParcel(parcel: Parcel): Lock {
            return Lock(parcel)
        }

        override fun newArray(size: Int): Array<Lock?> {
            return arrayOfNulls(size)
        }
    }
}