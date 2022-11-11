package com.dagoras.osunolock.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Record(
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
    @ColumnInfo(name = "time_unlock")
    val unlockTime: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(idLock)
        parcel.writeInt(idUser)
        parcel.writeInt(typeUnlock)
        parcel.writeString(unlockName)
        parcel.writeString(unlockTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Record> {
        override fun createFromParcel(parcel: Parcel): Record {
            return Record(parcel)
        }

        override fun newArray(size: Int): Array<Record?> {
            return arrayOfNulls(size)
        }
    }
}